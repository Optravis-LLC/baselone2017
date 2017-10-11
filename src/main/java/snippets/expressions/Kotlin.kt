package snippets.expressions

fun condition(): Boolean {
  return true
}

fun left(): Boolean {
  return true
}

fun right(): Boolean {
  return true
}


fun demoIf() {

  val result = if (condition()) {
    left()
  } else {
    right()
  }

}

fun demoException() {
  val str = ""

  val value = try {
    Integer.parseInt(str)
  } catch (e: NumberFormatException) {
    -1
  }

  val y: Int
//  val x = (y = 1)

}