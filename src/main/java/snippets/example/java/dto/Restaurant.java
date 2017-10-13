package snippets.example.java.dto;

public class Restaurant {

  private String name;
  private Menu regularMenu;
  private Menu gourmetMenu;

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

  public Menu getGourmetMenu() {
    return gourmetMenu;
  }

  public void setGourmetMenu(final Menu gourmetMenu) {
    this.gourmetMenu = gourmetMenu;
  }
}
