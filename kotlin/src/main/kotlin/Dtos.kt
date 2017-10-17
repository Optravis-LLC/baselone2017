
class Restaurant {
  lateinit var name: String
  var regularMenu: Menu? = null
  var gourmetMenu: Menu? = null
}

class Menu {
  var dishes: Array<Dish> = emptyArray()
}

class Dish {
  lateinit var name: String
  var calories: Int? = null
  var vegan: Boolean? = null
}