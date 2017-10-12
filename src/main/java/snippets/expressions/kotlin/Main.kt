package snippets.expressions.kotlin

import com.google.gson.GsonBuilder
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun main(args: Array<String>) {

  val map = read(Paths.get("restaurants.json"), Array<Restaurant>::class.java)
      .asSequence()
      .map { it.name to it.regularMenu?.dishes?.toList().orEmpty() + it.gourmetMenu?.dishes?.toList().orEmpty() }
      .flatMap { (restaurant, dishes) ->
        dishes.asSequence()
            .filter { it.calories != null && it.vegan != null }
            .map { DishRestaurantWrapper(restaurant!!, it.name!!) to CaloriesVeganWrapper(it.calories!!, it.vegan!!) }
      }.toMap()

  print(map)

}

/**
 * data class, so it implements equals and hashcode
 */
private data class DishRestaurantWrapper(val restaurant: String, val dish: String)

/**
 * regular immutable wrapper
 */
private class CaloriesVeganWrapper(val calories: Int, val isVegan: Boolean)

private fun <T> read(path: Path, type: Class<T>): T {
  return Files.newBufferedReader(path, Charset.forName("UTF-8")).use {
     GsonBuilder().create().fromJson(it, type)
  }
}
