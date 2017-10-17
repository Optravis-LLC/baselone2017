package snippets.whenexpr;

public class SwitchUsage {

  public String dayOfWeek(int d) {
    switch (d) {
      case 1:
        return "monday";
      case 2:
        return "tuesday";
      default:
        throw new IllegalArgumentException("Unexpected value : " + d);
    }
  }
}
