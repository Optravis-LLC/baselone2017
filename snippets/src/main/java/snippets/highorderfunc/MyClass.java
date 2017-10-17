package snippets.highorderfunc;

public class MyClass {

  public void bar(SamInterface arg) {
    int result = arg.foo("a", "b", 0);
  }

  public void usage() {
    bar((s1, s2, i) -> i + s1.length() + s2.length());
  }
}
