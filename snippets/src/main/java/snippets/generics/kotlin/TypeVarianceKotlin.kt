package snippets.generics.kotlin

// Produces Ts -> declaration-site variance annotation 'out'.
interface Producer<out T> {
  fun get(): T
}

// Consumes Ts -> use variance annotation 'in'.
interface Consumer<in T> {
  fun accept(t: T)
}

fun <T> copy(producer: Producer<T>, consumer: Consumer<T>) {
  consumer.accept(producer.get())
}

fun usage(producer: Producer<String>, consumer: Consumer<Any>) {
  copy(producer, consumer)
}

