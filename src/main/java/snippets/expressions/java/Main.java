package snippets.expressions.java;

import java.util.HashMap;
import java.util.Map;

import snippets.expressions.java.json.Dish;
import snippets.expressions.java.json.Menu;
import snippets.expressions.java.json.Restaurant;
import util.JsonUtil;

public class Main {


  public static void main(String args[]) {

    // map dish and restaurant to calories and vegan
    final Map<DishRestaurantWrapper, CaloriesVeganWrapper> map = new HashMap<>();

    // read restaurants in
    for (final Restaurant restaurant : JsonUtil.read("restaurants.json", Restaurant[].class)) {
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

  private static void mapDishes(final Map<DishRestaurantWrapper, CaloriesVeganWrapper> map,
                                final Restaurant restaurant,
                                final Menu regularMenu) {
    final Dish[] dishes = regularMenu.getDishes();
    if (dishes != null) {
      for (final Dish dish : dishes) {
        map.put(new DishRestaurantWrapper(dish.getName(), restaurant.getName()), new CaloriesVeganWrapper(dish.getCalories(), dish.getVegan()));
      }
    }
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

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      final DishRestaurantWrapper that = (DishRestaurantWrapper) o;

      if (restaurant != null ? !restaurant.equals(that.restaurant) : that.restaurant != null) {
        return false;
      }
      return dish != null ? dish.equals(that.dish) : that.dish == null;
    }

    @Override
    public int hashCode() {
      int result = restaurant != null ? restaurant.hashCode() : 0;
      result = 31 * result + (dish != null ? dish.hashCode() : 0);
      return result;
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
