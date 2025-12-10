import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day09Test {

    @Test
    fun read_data() {
        // act
        val result: List<Point2D> = Day09().readData("Day09_TestData.txt")

        // assert
        Assertions.assertThat(result).containsExactly(
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

}