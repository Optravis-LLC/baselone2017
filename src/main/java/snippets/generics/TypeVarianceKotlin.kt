package snippets.generics

/**
 * Produces Ts -> use variance annotation 'out'.
 */
interface KotlinProducer<out T> {

  fun get(): T
}

/**
 * Consumes Ts -> use variance annotation 'in'.
 */
interface KotlinConsumer<in T> {

  fun accept(t: T)
}

/**
 * Covariant because of declaration-site variance annotations.
 */
fun <T> copy(producer: KotlinProducer<T>, consumer: KotlinConsumer<T>) {
  consumer.accept(producer.get())
}


fun usage(producer: KotlinProducer<String>, consumer: KotlinConsumer<Any>) {
  copy(producer, consumer)
}

