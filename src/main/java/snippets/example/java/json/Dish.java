package snippets.example.java.json;

public class Dish {

  private String name;
  private Integer calories;
  private Boolean vegan;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Integer getCalories() {
    return calories;
  }

  public void setCalories(final Integer calories) {
    this.calories = calories;
  }

  public Boolean getVegan() {
    return vegan;
  }

  public void setVegan(final Boolean vegan) {
    this.vegan = vegan;
  }
}
