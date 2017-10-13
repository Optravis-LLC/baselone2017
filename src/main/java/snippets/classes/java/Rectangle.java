package snippets.classes.java;

public class Rectangle {

  private int x;
  private int y;
  private int width;
  private int height;

  Rectangle(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  // getters
  // setters
  // hashcode / equals

  public int getArea() {
    return width * height;
  }

  public int getPerimeter() {
    return width * 2 + height * 2;
  }

  public static void main(String[] args) {
    Rectangle rectangle = new Rectangle(0, 0, 10, 20);
  }
}
