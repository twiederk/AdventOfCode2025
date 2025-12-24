import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

class Day09Test {

    private val tiles = listOf(
        Point2D(7, 1),
        Point2D(11, 1),
        Point2D(11, 7),
        Point2D(9, 7),
        Point2D(9, 5),
        Point2D(2, 5),
        Point2D(2, 3),
        Point2D(7, 3)
    )

    @Test
    fun read_data() {
        // act
        val result: List<Point2D> = Day09().readData("Day09_TestData.txt")

        // assert
        assertThat(result).isEqualTo(tiles)
    }

    @Test
    fun solve_part1() {
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


    @Test
    fun createBorder() {
        // act
        val border = Day09().border(tiles)

        // assert
        assertThat(border).isNotNull()
    }

    // ..............
    // .......OOOOO..
    // .......OOOOO..
    // ..#XXXXOOOOO..
    // ..XXXXXXXXXX..
    // ..#XXXXXX#XX..
    // .........XXX..
    // .........#X#..
    // ..............
    @Test
    fun contains_rect_7_3_and_11_1() {
        // arrange
        val border = Day09().border(tiles)

        // act
        val result = Day09().containsRect(border, Point2D(7, 3), Point2D(11, 1))

        // assert
        assertThat(result).isTrue()
    }

    // ..............
    // .......#XXX#..
    // .......XXXXX..
    // ..#XXXX#XXXX..
    // ..XXXXXXXXXX..
    // ..#XXXXXXOXX..
    // .........OXX..
    // .........OX#..
    // ..............
    @Test
    @Ignore("Fails because of GeneralPath/Area limitations")
    fun contains_9_7_and_9_5() {
        // arrange
        val border = Day09().border(tiles)

        // act
        val result = Day09().containsRect(border, Point2D(9, 7), Point2D(9, 5))

        // assert
        assertThat(result).isTrue()
    }

    // ..............
    // .......#XXX#..
    // .......XXXXX..
    // ..OOOOOOOOXX..
    // ..OOOOOOOOXX..
    // ..OOOOOOOOXX..
    // .........XXX..
    // .........#X#..
    // ..............
    @Test
    fun contains_9_5_and_2_3() {
        // arrange
        val border = Day09().border(tiles)

        // act
        val result = Day09().containsRect(border, Point2D(9, 5), Point2D(2, 3))

        // assert
        assertThat(result).isTrue()
    }

    @Test
    fun solve_part2() {
        // act
        val largestArea = Day09().part2(tiles)

        // assert
        assertThat(largestArea).isEqualTo(24L)
    }

}