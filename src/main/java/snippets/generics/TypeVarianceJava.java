package snippets.generics;

interface JavaProducer<T> {

  T get();
}

interface JavaConsumer<T> {

  void accept(T t);
}


public class TypeVarianceJava {

  /**
   * Invariant.
   */
  public <T> void copyInvariant(JavaProducer<T> producer, JavaConsumer<T> consumer) {
    consumer.accept(producer.get());
  }

  /**
   * Use-Site variance.
   */
  public <T> void copyCovariant(JavaProducer<? extends T> producer, JavaConsumer<? super T> consumer) {
    consumer.accept(producer.get());
  }

  public void usage(JavaProducer<String> producer, JavaConsumer<Object> consumer) {
//     copyInvariant(producer, consumer); COMPILATION ERROR
    copyCovariant(producer, consumer);
  }

}
