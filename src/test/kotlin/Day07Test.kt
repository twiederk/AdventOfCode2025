import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day07Test {

    private val grid = listOf(
        ".......S.......",
        "...............",
        ".......^.......",
        "...............",
        "......^.^......",
        "...............",
        ".....^.^.^.....",
        "...............",
        "....^.^...^....",
        "...............",
        "...^.^...^.^...",
        "...............",
        "..^...^.....^..",
        "...............",
        ".^.^.^.^.^...^.",
        "...............",
    )

    @Test
    fun read_data() {
        // act
        val grid = Day07().readData("Day07_TestData.txt")

        // assert
        assertThat(grid).containsExactly(
            ".......S.......",
            "...............",
            ".......^.......",
            "...............",
            "......^.^......",
            "...............",
            ".....^.^.^.....",
            "...............",
            "....^.^...^....",
            "...............",
            "...^.^...^.^...",
            "...............",
            "..^...^.....^..",
            "...............",
            ".^.^.^.^.^...^.",
            "...............",
        )
    }

    @Test
    fun starting_position() {
        // act
        val startingPosition: Int = Day07().startingPosition(".......S.......")

        // assert
        assertThat(startingPosition).isEqualTo(7)
    }

    @Test
    fun downward_row_2() {
        // arrange
        val beams = setOf(7)

        // act
        val (result, splits) = Day07().downward(grid, beams, 2)

        // assert
        assertThat(result).containsExactly(6, 8)
        assertThat(splits).isEqualTo(1)
    }

    @Test
    fun downward_row_4() {
        // arrange
        val beams = setOf(6, 8)

        // act
        val (result, splits) = Day07().downward(grid, beams, 4)

        // assert
        assertThat(result).containsExactly(5, 7, 9)
        assertThat(splits).isEqualTo(2)
    }

    @Test
    fun downward_row_8() {
        // arrange
        val beams = setOf(4, 6, 8, 10)

        // act
        val (result, splits) = Day07().downward(grid, beams, 8)

        // assert
        assertThat(result).containsExactly(3, 5, 7, 8, 9, 11)
        assertThat(splits).isEqualTo(3)
    }

    @Test
    fun solve_part1() {
        // act
        val result: Int = Day07().part1(grid)

        // assert
        assertThat(result).isEqualTo(21)
    }

}