package snippets.example.kotlin

import com.google.gson.GsonBuilder
import java.io.IOException
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

private class CaloriesVegan(val calories: Int, val isVegan: Boolean)

private data class DishRestaurantKey(val restaurant: String, val dish: String)

fun main(args: Array<String>) {

  // map dish and restaurant to calories and vegan
  val map: Map<DishRestaurantKey, CaloriesVegan> = read(Paths.get("restaurants.json"), Array<Restaurant>::class.java).asSequence()
      .flatMap { restaurant ->
        sequenceOf(restaurant.regularMenu, restaurant.gourmetMenu)
            .flatMap { menu -> menu?.dishes?.asSequence() ?: emptySequence<Dish>() }
            .filter { dish -> dish.calories != null && dish.vegan != null }
            .map { dish -> DishRestaurantKey(restaurant.name, dish.name) to CaloriesVegan(dish.calories!!, dish.vegan!!) }
      }
      .toMap()

  println(map)
}

@Throws(IOException::class)
private fun <T> read(path: Path, type: Class<T>): T {
  Files.newBufferedReader(path, Charset.forName("UTF-8")).use { reader ->
    return GsonBuilder().create().fromJson(reader, type)
  }
}

