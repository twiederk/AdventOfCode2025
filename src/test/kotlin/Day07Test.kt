import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day07Test {

    @Test
    fun read_data() {
        // arrange

        // act
        val grid: List<String> = Day07().readData("Day07_TestData.txt")

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
        // arrange

        // act
        val startingPosition: Int = Day07().startingPosition(".......S.......")

        // assert
        assertThat(startingPosition).isEqualTo(7)
    }
}