package snippets.helloworld

fun main(args: Array<String>) {
  println("Hello BaselOne !")
}


class Vector (val x: Double, val y: Double) {

  fun scale(factor: Double) : Vector {
    return Vector(x*factor, y*factor)
  }

}