

import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TransformTest {

  @Test
  fun testMenuTransform() {

    val map = transform(Paths.get("../restaurants.json"))

    map[RestaurantDishKey("Cheval Blanc", "Risotto")]!!.apply {
      assertEquals(450, calories)
      assertTrue(isVegan)
    }
  }
}
