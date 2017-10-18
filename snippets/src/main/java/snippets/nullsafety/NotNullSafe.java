package snippets.nullsafety;

public class NotNullSafe {

  public int getGourmetDishCount(Restaurant restaurant) {
    final Menu gourmetMenu = restaurant.getGourmetMenu();
    if (gourmetMenu == null) {
      return 0;
    }

    final Dish[] gourmetDishes = gourmetMenu.getDishes();
    return gourmetDishes == null ? 0 : gourmetDishes.length;
  }
}
