package snippets.nullsafety


fun foo(string: String) {}


fun main(args: Array<String>) {

  val firstName: String = "John" // non-null
  val middleName: String? = null // nullable

  // does not compile
//  println(middleName.length)

  // smart cast
  if (middleName != null) {
    println(middleName.length)
  }

  // safe method call
  val length: Int? = middleName?.length

  // safe method call with elvis operator
//  val length: Int = middleName?.length ?: 0

}

fun getGourmetDishCount(restaurant: Restaurant) : Int {
  return restaurant.gourmetMenu?.dishes?.size ?: 0
}
