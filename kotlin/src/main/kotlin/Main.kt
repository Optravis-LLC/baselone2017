import com.google.gson.GsonBuilder
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path

class CaloriesVegan(val calories: Int, val isVegan: Boolean)

data class RestaurantDishKey(val restaurant: String, val dish: String)

/**
 *  map dish and restaurant to calories and vegan
 */
fun transform(path: Path): Map<RestaurantDishKey, CaloriesVegan> {
  return read<Array<Restaurant>>(path).asSequence()
      .flatMap { restaurant ->
        sequenceOf(restaurant.regularMenu, restaurant.gourmetMenu)
            .flatMap { menu -> menu?.dishes?.asSequence() ?: emptySequence<Dish>() }
            .filter { dish -> dish.calories != null && dish.vegan != null }
            .map { dish -> RestaurantDishKey(restaurant.name, dish.name) to CaloriesVegan(dish.calories!!, dish.vegan!!) }
      }
      .toMap()
}

private inline fun <reified T> read(input: Path): T {
  Files.newBufferedReader(input, Charset.forName("UTF-8")).use { reader ->
    return GsonBuilder().create().fromJson(reader, T::class.java)
  }
}

