package snippets.extensionfunc

infix fun <E> List<E>.intersect(other: List<E>): List<E> {
  val set = toSet()
  return other.filter(set::contains)
}


val result = listOf(1, 2, 3) intersect listOf(2, 3, 4)



