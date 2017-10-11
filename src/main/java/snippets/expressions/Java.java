package snippets.expressions;

public class Java {
  public void demoException() {
    final String str = "";

    int value;

    try{
      value = Integer.parseInt(str);
    } catch(NumberFormatException e) {
      value = -1;
    }

  }
}
