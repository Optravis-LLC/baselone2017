package snippets.operator


data class Vector2D(val x: Int = 0, val y: Int = 0) {
  operator fun plus(other: Vector2D) = Vector2D(x + other.x, y + other.y)
}

operator fun Vector2D.times(scalar: Int) = Vector2D(x * scalar, y * scalar)

fun usage() {
  var v1 = Vector2D()
  val v2 = v1 + Vector2D(3, 4)
  v1 += v2 // v1 = v1 + v2
  v1 *= 3 // v1 = v1 * 3
}


