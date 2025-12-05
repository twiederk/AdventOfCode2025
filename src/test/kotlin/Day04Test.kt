import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day04Test {

    private val grid = listOf(
        "..@@.@@@@.",
        "@@@.@.@.@@",
        "@@@@@.@.@@",
        "@.@@@@..@.",
        "@@.@@@@.@@",
        ".@@@@@@@.@",
        ".@.@.@.@@@",
        "@.@@@.@@@@",
        ".@@@@@@@@.",
        "@.@.@@@.@.",
    )

    @Test
    fun read_data() {
        // act
        val grid = Day04().readData("Day04_TestData.txt")

        // assert
        assertThat(grid.size).isEqualTo(10)
    }

    @Test
    fun count_neighbors_0_0() {
        // act
        val count = Day04().neighborsCount(Point2D(0, 0), grid)

        // assert
        assertThat(count).isEqualTo(-1)
    }

    @Test
    fun count_neighbors_1_1() {
        // act
        val count = Day04().neighborsCount(Point2D(1, 1), grid)

        // assert
        assertThat(count).isEqualTo(6)
    }

    @Test
    fun count_neighbors_9_0() {
        // act
        val count = Day04().neighborsCount(Point2D(9, 0), grid)

        // assert
        assertThat(count).isEqualTo(-1)
    }

    @Test
    fun count_neighbors_0_9() {
        // act
        val count = Day04().neighborsCount(Point2D(0, 9), grid)

        // assert
        assertThat(count).isEqualTo(1)
    }

    @Test
    fun solve_part1() {

        // act
        val result = Day04().part1(grid)

        // assert
        assertThat(result).isEqualTo(13)
    }

}


