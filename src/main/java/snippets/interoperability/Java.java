package snippets.interoperability;

public class Java {

  public void usage() {
    // access static method
    Interoperability inter = Interoperability.create();

    // use overloads
    inter.foo();
    inter.foo(1,2,3);
  }
}
