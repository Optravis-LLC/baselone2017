package snippets.extensionfunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionHelper {

  private CollectionHelper() {}

  public static <E> List<E> intersect(List<E> list1, List<E> list2) {
    HashSet set = new HashSet(list1);
    List<E> result = new ArrayList<E>(); // here this is the first list
    return list2.stream()
        .filter(set::contains)
        .collect(Collectors.<E>toList());
  }

  public static void main(String... args) {
    List<Object> result = CollectionHelper.intersect(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 4));
  }
}
