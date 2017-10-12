package snippets.expressions.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import snippets.expressions.java.json.Dish;
import snippets.expressions.java.json.Menu;
import snippets.expressions.java.json.Restaurant;
import util.JsonUtil;

public class Main {


  public static void main(String args[]) {

    // read restaurants in
    final Restaurant[] restaurants = JsonUtil.read("restaurants.json", Restaurant[].class);

    final Map<DishRestaurantWrapper, CaloriesVeganWrapper> map = new HashMap<>();
    Arrays.stream(restaurants)
        .forEach(restaurant -> {
          final Menu regularMenu = restaurant.getRegularMenu();
          if (regularMenu != null) {
            final Dish[] dishes = regularMenu.getDishes();
            if (dishes != null) {
              for (final Dish dish : dishes) {

              }
            }
          }


        });

    // map dish and restaurant to calories and vegan

  }

  private static class DishRestaurantWrapper {

    private String restaurant;
    private String dish;

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
  }

  private static class CaloriesVeganWrapper {

    private int calories;
    private boolean vegan;

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
