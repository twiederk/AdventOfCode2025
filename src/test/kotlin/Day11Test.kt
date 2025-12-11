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

    @Test
    fun solve_part1() {
        // arrange
        val graph = mapOf(
            "aaa" to listOf("you", "hhh"),
            "you" to listOf("bbb", "ccc"),
            "bbb" to listOf("ddd", "eee"),
            "ccc" to listOf("ddd", "eee",  "fff"),
            "ddd" to listOf("ggg"),
            "eee" to listOf("out"),
            "fff" to listOf("out"),
            "ggg" to listOf("out"),
            "hhh" to listOf("ccc", "fff", "iii"),
            "iii" to listOf("out"),
        )

        // act
        val paths = Day11().part1(graph)

        // assert
        assertThat(paths).isEqualTo(5)
    }

}