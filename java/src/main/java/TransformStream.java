import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dto.Restaurant;


@SuppressWarnings("Duplicates")
public class TransformStream {

  /**
   * map dish and restaurant to calories and vegan
   */
  public static Map<RestaurantDishKey, CaloriesVegan> run() throws IOException {

    return Stream.of(readJson(Paths.get("../restaurants.json"), Restaurant[].class))
        .flatMap(restaurant ->
                     Stream.of(restaurant.getRegularMenu(), restaurant.getGourmetMenu())
                         .filter(Objects::nonNull)
                         .flatMap(menu -> Stream.of(menu.getDishes()))
                         .filter(dish -> dish.getCalories() != null && dish.getVegan() != null)
                         .map(dish -> new AbstractMap.SimpleEntry<>(new RestaurantDishKey(restaurant.getName(), dish.getName()),
                                                                    new CaloriesVegan(dish.getCalories(), dish.getVegan())))
        )
        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
  }

  private static <T> T readJson(Path path, Class<T> type) throws IOException {
    try (Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
      Gson gson = new GsonBuilder().create();
      return gson.fromJson(reader, type);
    }
  }

}

