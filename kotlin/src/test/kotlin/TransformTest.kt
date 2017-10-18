import org.junit.jupiter.api.Test

import java.io.IOException
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TransformTest {

  @Test
  @Throws(IOException::class)
  fun testMenuTransform() {

    val map = transform(Paths.get("../restaurants.json"))

    map[RestaurantDishKey("Cheval Blanc", "Risotto")]!!.apply {
      assertEquals(450, calories)
      assertTrue(isVegan)
    }
  }
}
