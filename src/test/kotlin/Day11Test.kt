import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day11Test {

    @Test
    fun read_data() {
        // act
        val graph = Day11().readData("Day11_TestData.txt")

        // assert
        assertThat(graph.size).isEqualTo(10)
    }

}