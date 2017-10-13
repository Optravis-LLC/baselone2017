package snippets.highorderfunc

data class Rectangle(var x: Int, var y: Int, var width: Int, var height: Int)

fun foo(funct: (String, String, Int) -> Int) {
  val result = funct("a", "b", 0)
}

fun usage() {
  foo { s1, s2, i -> i + s1.length + s2.length }
  foo(::bar)
}

fun bar(s1: String, s2: String, i: Int): Int = TODO()


class RectangleBuilder(
    var x: Int = 0,
    var y: Int = 0,
    var width: Int = 0,
    var height: Int = 0
) {

  fun build() = Rectangle(x, y, width, height)
}

fun rectangle(block: RectangleBuilder.() -> Unit): Rectangle {
//  return RectangleBuilder().apply(block).build()

  val builder = RectangleBuilder()
  block(builder)
  return builder.build()
}

val point = rectangle {
  x = 2
  y = 3
  width = 10
  height = 100
}
