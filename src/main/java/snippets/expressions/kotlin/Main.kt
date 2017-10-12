
import com.google.gson.GsonBuilder
import snippets.expressions.kotlin.Restaurant
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


object Main {

  fun main(args: Array<String>) {

    read(Paths.get("restaurants.json"), Array<Restaurant>::class.java)
        .asSequence()
        .map { it.name!! to listOf(*it.regularMenu?.dishes ?: emptyArray(), *it.gourmetMenu?.dishes ?: emptyArray()) }
        .flatMap { (restaurant, dishes) ->
          dishes.map { DishRestaurantWrapper(restaurant, it.name!!) to CaloriesVeganWrapper(it.calories!!, it.vegan!!) }.asSequence()
        }.toMap()

  }

  private data class DishRestaurantWrapper(val restaurant: String, val dish: String)
  private class CaloriesVeganWrapper(val calories: Int, val isVegan: Boolean)

  fun <T> read(path: Path, type: Class<T>): T {
    Files.newBufferedReader(path, Charset.forName("UTF-8")).use {
      return GsonBuilder().create().fromJson(it, type)
    }
  }

}
