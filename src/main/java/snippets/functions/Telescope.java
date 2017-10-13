package snippets.functions;

public class Telescope {

  public int foo(int i) {
    return foo(i, "", true);
  }

  public int foo(int i, boolean b) {
    return foo(i, "", b);
  }

  public int foo(int i, String s, boolean b) {
   // ..
    return 0;
  }
}
