package snippets.expressions.java.json;

public class Restaurant {

  private String name;

  private Menu regularMenu;
  private Menu veganMenu;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Menu getRegularMenu() {
    return regularMenu;
  }

  public void setRegularMenu(final Menu regularMenu) {
    this.regularMenu = regularMenu;
  }

  public Menu getVeganMenu() {
    return veganMenu;
  }

  public void setVeganMenu(final Menu veganMenu) {
    this.veganMenu = veganMenu;
  }
}
