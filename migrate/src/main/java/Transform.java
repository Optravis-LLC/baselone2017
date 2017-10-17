import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import dto.Dish;
import dto.Menu;
import dto.Restaurant;


@SuppressWarnings("Duplicates")
public class Transform {


  public static Map<DishRestaurantKey, CaloriesVegan> run() throws IOException {

    // map dish and restaurant to calories and vegan
    final Map<DishRestaurantKey, CaloriesVegan> result = new HashMap<>();

    System.out.println(Paths.get("../restaurants.json").toFile().getCanonicalFile().getAbsolutePath());

    // read restaurants in and transform
    for (final Restaurant restaurant : readJson(Paths.get("../restaurants.json"), Restaurant[].class)) {

      final Menu regularMenu = restaurant.getRegularMenu();
      if (regularMenu != null) {
        addDishes(restaurant, regularMenu, result);
      }

      final Menu gourmetMenu = restaurant.getGourmetMenu();
      if (gourmetMenu != null) {
        addDishes(restaurant, gourmetMenu, result);
      }
    }

    return result;
  }

  private static void addDishes(@NotNull final Restaurant restaurant,
                                @NotNull final Menu menu,
                                @NotNull final Map<DishRestaurantKey, CaloriesVegan> map) {
    final Dish[] dishes = menu.getDishes();
    if (dishes != null) {
      for (final Dish dish : dishes) {
        if (dish.getCalories() != null && dish.getVegan() != null) {
          map.put(new DishRestaurantKey(restaurant.getName(), dish.getName()), new CaloriesVegan(dish.getCalories(), dish.getVegan()));
        }
      }
    }
  }

  private static <T> T readJson(Path path, Class<T> type) throws IOException {
    try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
      Gson gson = new GsonBuilder().create();
      return gson.fromJson(reader, type);
    }
  }

}

class CaloriesVegan {

  private final int calories;
  private final boolean vegan;

  public CaloriesVegan(final int calories, final boolean vegan) {
    this.calories = calories;
    this.vegan = vegan;
  }

  @Override
  public String toString() {
    return "CaloriesVegan{" +
           "calories=" + calories +
           ", vegan=" + vegan +
           '}';
  }

  public int getCalories() {
    return calories;
  }

  public boolean isVegan() {
    return vegan;
  }
}

class DishRestaurantKey {

  private final String restaurant;
  private final String dish;

  public DishRestaurantKey(final String restaurant, final String dish) {
    this.restaurant = restaurant;
    this.dish = dish;
  }

  public String getRestaurant() {
    return restaurant;
  }

  public String getDish() {
    return dish;
  }

  @Override
  public String toString() {
    return "DishRestaurantKey{" +
           "restaurant='" + restaurant + '\'' +
           ", dish='" + dish + '\'' +
           '}';
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final DishRestaurantKey that = (DishRestaurantKey) o;

    return (restaurant != null ? restaurant.equals(that.restaurant) : that.restaurant == null) && (dish != null ? dish.equals(that.dish) : that.dish == null);
  }

  @Override
  public int hashCode() {
    int result = restaurant != null ? restaurant.hashCode() : 0;
    result = 31 * result + (dish != null ? dish.hashCode() : 0);
    return result;
  }
}
