package snippets.whenexpr;

public class SwitchUsage {

  public String dayOfWeek(int d) {
    String result;

    switch (d) {
      case 1:
        result = "monday";
        break;

      case 2:
        result = "tuesday";
        break;

      // etc.
      default:
        throw new IllegalArgumentException("Unexpected value : " + d);
    }

    return result;
  }
}
