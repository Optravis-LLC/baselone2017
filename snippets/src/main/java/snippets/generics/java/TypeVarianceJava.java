package snippets.generics.java;

interface Producer<T> {
  T get();
}

interface Consumer<T> {
  void accept(T t);
}

public class TypeVarianceJava {
  // Use-Site variance.
  public <T> void copy(Producer<? extends T> producer,
                       Consumer<? super T> consumer) {
    consumer.accept(producer.get());
  }

  public void usage(Producer<String> producer,
                    Consumer<Object> consumer) {
    copy(producer, consumer);
  }
}
