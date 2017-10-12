package snippets.expressions.kotlin

class Restaurant {
  var name: String? = null

  var regularMenu: Menu? = null
  var gourmetMenu: Menu? = null
}

class Menu {
  var dishes: Array<Dish>? = null
}

class Dish {
  var name: String? = null

  // primitive types
  var calories: Int? = null
  var vegan: Boolean? = null
}