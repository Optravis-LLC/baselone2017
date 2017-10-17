package snippets.nullsafety


fun foo(string: String) {}


fun main(args: Array<String>) {
  val string: String? = null

  // nullability check at compile time
//  println(string.length) // compilation error

  // smart cast
  if (string != null) {
    println(string.length) // compile without any error
  }

  // safe method call
  val length: Int? = string?.length

  // elvis operator
  val orDefault: String = string ?: "default"
  val orFail: String = string ?: throw Exception("no value")
  val orReturn: String = string ?: return
}

