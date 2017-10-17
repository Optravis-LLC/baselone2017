import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransformTest {

  @Test
  public void testMenuTransform() throws IOException {
    final Map<Transform.DishRestaurantKey, Transform.CaloriesVegan> map = Transform.run();

    final Transform.CaloriesVegan actual = map.get(new Transform.DishRestaurantKey("Cheval Blanc", "Risotto"));
    assertEquals(450, actual.getCalories());
    assertTrue(actual.isVegan());
  }
}
