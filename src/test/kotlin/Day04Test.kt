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
    fun solve_part1_count() {

        // act
        val result = Day04().part1Count(grid)

        // assert
        assertThat(result).isEqualTo(13)
    }

    @Test
    fun collect_neighbors_0_0() {
        // act
        val neighbors: List<Point2D> = Day04().collectNeighbors(Point2D(0, 0), grid)

        // assert
        assertThat(neighbors).isEmpty()
    }

    @Test
    fun collect_neighbors_1_1() {
        // act
        val neighbors = Day04().collectNeighbors(Point2D(1, 1), grid)

        // assert
        assertThat(neighbors).hasSize(6)
    }

    @Test
    fun collect_neighbors_0_9() {
        // act
        val count = Day04().collectNeighbors(Point2D(0, 9), grid)

        // assert
        assertThat(count).hasSize(1)
    }


    @Test
    fun solve_part1_collect() {

        // act
        val result = Day04().part1Collect(grid)

        // assert
        assertThat(result).isEqualTo(13)
    }
}


