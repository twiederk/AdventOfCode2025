import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day09Test {

    @Test
    fun read_data() {
        // act
        val result: List<Point2D> = Day09().readData("Day09_TestData.txt")

        // assert
        assertThat(result).containsExactly(
            Point2D(7, 1),
            Point2D(11, 1),
            Point2D(11, 7),
            Point2D(9, 7),
            Point2D(9, 5),
            Point2D(2, 5),
            Point2D(2, 3),
            Point2D(7, 3)
        )
    }

    @Test
    fun solve_part1() {
        // arrange
        val tiles = listOf(
            Point2D(7, 1),
            Point2D(11, 1),
            Point2D(11, 7),
            Point2D(9, 7),
            Point2D(9, 5),
            Point2D(2, 5),
            Point2D(2, 3),
            Point2D(7, 3)
        )

        // act
        val largestArea = Day09().part1(tiles)

        // assert
        assertThat(largestArea).isEqualTo(50L)
    }

    @Test
    fun area_2_5_to_11_1() {
        // arrange
        val start = Point2D(2, 5)
        val end = Point2D(11, 1)

        // act
        val area = Day09().area(start, end)

        // assert
        assertThat(area).isEqualTo(50)
    }

}