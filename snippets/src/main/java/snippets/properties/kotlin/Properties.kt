package snippets.properties.kotlin

import snippets.whenexpr.isEven
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class EvenOnlyProperty : ReadWriteProperty<Any, Int> {

  private var field = 0

  override fun getValue(thisRef: Any, property: KProperty<*>) = field

  override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
    if (value.isEven()) field = value
  }

}

class MyClass {

  val size: Int = 0

  //  val isEmpty get() = size == 0
  fun isEmpty() = size == 0

  // property with backing field
  var x = 0.0
    get() {
      println("x is accessed")
      return field
    }
    set(value) {
      println("x is set ($value)")
      field = value
    }

  // property without backing field
  val squaredX get() = x * x

  var delegatedProperty: Int by EvenOnlyProperty()
}

fun main(args: Array<String>) {
  val obj = MyClass()

  val value = obj.delegatedProperty
  obj.delegatedProperty = 41

}

