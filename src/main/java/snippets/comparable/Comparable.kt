package snippets.comparable


class FullName(
    val firstName: String,
    val lastName: String
) : Comparable<FullName> {

  override fun compareTo(other: FullName) = COMPARATOR.compare(this, other)

  companion object {
    val COMPARATOR = compareBy<FullName> { it.lastName }.thenBy { it.firstName }
  }
}

fun usage() {
  val user1 = FullName("Dmitry", "Jemerov")
  val user2 = FullName("Svetlana", "Isakova")

  if (user1 < user2 || user1 >= user1) //....
    TODO()
}
