package snippets.strings

import java.time.LocalDate

fun greetings(name: String) {
  println("Hello $name")
  println("The current date is : ${LocalDate.now()}")
}
