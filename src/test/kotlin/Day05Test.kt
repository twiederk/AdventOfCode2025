import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun read_data() {

        // act
        val data: Pair<List<LongRange>, List<Long>> = Day05().readData("Day05_TestData.txt")

        // assert
        assertThat(data.first.size).isEqualTo(4)
        assertThat(data.second.size).isEqualTo(6)
    }

    @Test
    fun solve_part1() {
        // arrange
        val ranges: List<LongRange> = listOf(
            LongRange(3, 5),
            LongRange(10, 14),
            LongRange(16, 20),
            LongRange(12, 18)
        )

        val ingredientIds: List<Long> = listOf(1, 5, 8, 11, 17, 32)

        // act
        val result: Int = Day05().solvePart1(ranges, ingredientIds)

        // assert
        assertThat(result).isEqualTo(3)
    }

}