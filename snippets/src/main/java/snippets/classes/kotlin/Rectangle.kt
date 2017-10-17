package snippets.classes.kotlin

class Rectangle(var x: Int, var y: Int, var width: Int, var height: Int) {
  val area get() = width * height
  val perimeter get() = width * 2 + height * 2
}

val rectangle = Rectangle(0, 0, 10, 20)
