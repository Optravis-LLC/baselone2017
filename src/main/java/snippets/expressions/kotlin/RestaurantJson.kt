package snippets.expressions.kotlin

class Restaurant {
  lateinit var name: String

  var regularMenu: Menu? = null
  var gourmetMenu: Menu? = null
}

class Menu {
  var dishes: Array<Dish>? = null
}

class Dish {
  lateinit var name: String

  // primitive types
  var calories: Int? = null
  var vegan: Boolean? = null
}