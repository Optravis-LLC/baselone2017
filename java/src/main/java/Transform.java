import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
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

    // read restaurants in and transform
    for (final Restaurant restaurant : readJson(Transform.class.getResourceAsStream("restaurants.json"), Restaurant[].class)) {

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

  private static <T> T readJson(InputStream input, Class<T> type) throws IOException {
    try (Reader reader = new InputStreamReader(input, Charset.forName("UTF-8")) {
    }) {
      Gson gson = new GsonBuilder().create();
      return gson.fromJson(reader, type);
    }
  }

  static class CaloriesVegan {

    private final int calories;
    private final boolean vegan;

    @Override
    public String toString() {
      return "CaloriesVegan{" +
             "calories=" + calories +
             ", vegan=" + vegan +
             '}';
    }

    public CaloriesVegan(final int calories, final boolean vegan) {
      this.calories = calories;
      this.vegan = vegan;
    }

    public int getCalories() {
      return calories;
    }

    public boolean isVegan() {
      return vegan;
    }
  }

  static class DishRestaurantKey {

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


}
