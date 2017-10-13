package snippets.classes.kotlin

interface IFactory<out T> {
  fun create(): T
}

class CompanionExample {

  companion object : IFactory<CompanionExample> {

    // implement from IFactory
    override fun create() = CompanionExample()

    // equivalent to public static final String MESSAGE = ..
    const val MESSAGE = "Hello World"
  }

}
