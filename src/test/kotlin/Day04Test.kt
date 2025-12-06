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

    @Test
    fun create_updated_grid() {
        // arrange
        val rolls = listOf(
            Point2D(x = 2, y = 0),
            Point2D(x = 3, y = 0),
            Point2D(x = 5, y = 0),
            Point2D(x = 6, y = 0),
            Point2D(x = 8, y = 0),
            Point2D(x = 0, y = 1),
            Point2D(x = 6, y = 2),
            Point2D(x = 0, y = 4),
            Point2D(x = 9, y = 4),
            Point2D(x = 0, y = 7),
            Point2D(x = 0, y = 9),
            Point2D(x = 2, y = 9),
            Point2D(x = 8, y = 9)
        )

        // act
        val updatedGrid = Day04().createUpdatedGrid(grid, rolls)

        // assert
        assertThat(updatedGrid).containsExactly(
            ".......@..",
            ".@@.@.@.@@",
            "@@@@@...@@",
            "@.@@@@..@.",
            ".@.@@@@.@.",
            ".@@@@@@@.@",
            ".@.@.@.@@@",
            "..@@@.@@@@",
            ".@@@@@@@@.",
            "....@@@...",
        )
    }

    @Test
    fun solve_part2() {

        // act
        val result = Day04().part2(grid)

        // assert
        assertThat(result).isEqualTo(43)
    }
}


