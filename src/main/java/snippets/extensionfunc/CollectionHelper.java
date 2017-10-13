package snippets.extensionfunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionHelper {
  public static <E> List<E> intersect(List<E> list1, List<E> list2) {
    Set<E> set = new HashSet<>(list1);
    return list2.stream()
        .filter(set::contains)
        .collect(Collectors.<E>toList());
  }
}
