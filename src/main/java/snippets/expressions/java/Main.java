package snippets.expressions.java;

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

import snippets.expressions.java.json.Dish;
import snippets.expressions.java.json.Menu;
import snippets.expressions.java.json.Restaurant;

public class Main {


  public static void main(String args[]) throws IOException {

    // map dish and restaurant to calories and vegan
    final Map<DishRestaurantWrapper, CaloriesVeganWrapper> map = new HashMap<>();

    // read restaurants in
    for (final Restaurant restaurant : read(Paths.get("restaurants.json"), Restaurant[].class)) {
      final Menu regularMenu = restaurant.getRegularMenu();
      if (regularMenu != null) {
        mapDishes(map, restaurant, regularMenu);
      }

      final Menu gourmetMenu = restaurant.getGourmetMenu();
      if (gourmetMenu != null) {
        mapDishes(map, restaurant, gourmetMenu);
      }
    }

  }

  private static void mapDishes(@NotNull final Map<DishRestaurantWrapper, CaloriesVeganWrapper> map,
                                @NotNull final Restaurant restaurant,
                                @NotNull final Menu menu) {
    final Dish[] dishes = menu.getDishes();
    if (dishes != null) {
      for (final Dish dish : dishes) {
        map.put(new DishRestaurantWrapper(dish.getName(), restaurant.getName()), new CaloriesVeganWrapper(dish.getCalories(), dish.getVegan()));
      }
    }
  }

  private static <T> T read(Path path, Class<T> type) throws IOException {
    try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
      Gson gson = new GsonBuilder().create();
      return gson.fromJson(reader, type);
    }
  }

  private static class DishRestaurantWrapper {

    private final String restaurant;
    private final String dish;

    private DishRestaurantWrapper(final String restaurant, final String dish) {
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
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final DishRestaurantWrapper that = (DishRestaurantWrapper) o;

      return (restaurant != null ? restaurant.equals(that.restaurant) : that.restaurant == null) && (dish != null ? dish.equals(that.dish) : that.dish == null);
    }

    @Override
    public int hashCode() {
      int result = restaurant != null ? restaurant.hashCode() : 0;
      result = 31 * result + (dish != null ? dish.hashCode() : 0);
      return result;
    }
  }

  private static class CaloriesVeganWrapper {

    private final int calories;
    private final boolean vegan;

    private CaloriesVeganWrapper(final int calories, final boolean vegan) {
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

}
