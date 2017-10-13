package snippets.interoperability

class Interoperability {
  companion object {
    // equivalent to public static final String MESSAGE = "Hello World"
    @JvmStatic fun create() : Interoperability {
      return Interoperability();
    }
  }

  // creates four overloads
  @JvmOverloads
  fun foo(x: Int = 0, y: Int = 0, z: Int = 0) {
  }
}

