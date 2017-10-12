package snippets.whenexpr


fun dayOfWeek(d: Int): String {
  return when (d) {
    1 -> "monday"
    2 -> "tuesday"

  // etc.

    else -> throw IllegalArgumentException("Unexpected value : $d")
  }
}


fun process(v: Any) {

  synchronized(v) {

  }
  when (v) {
    42 -> println("answer found")
    "friday" -> println("weekend is coming")
    is Int -> println("2v = ${2 * v}")
    is String -> println("v length is ${v.length}")
    else -> println("unable to process $v")
  }
}
