package snippets.applyuse

import javafx.scene.control.TextField
import java.io.File


fun computeFileName(): String = TODO()

fun usage() {

  // edit an object after creation
  val textField = TextField().apply { promptText = "enter your name" }

  // use the result of a function without creating a variable
  val file = computeFileName().let { File(it) }

  // try-with-resource
  file.reader().use {
    it.forEachLine(::println)
  }


}


data class Rectangle(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int
)

fun usage(list: List<Rectangle>) {

  val r1 = Rectangle(0, 0, 10, 10)
  val r2 = r1.copy(width = 30)
  val r3 = r2.copy(x = 100, y = 200)

  for ((x, y, w, h) in list) {
    println("$w x $h rectangle at ($x, $y)")
  }

  println("r3 width : ${r3.width}")
}