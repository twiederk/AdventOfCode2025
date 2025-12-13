import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day03Test {

    @Test
    fun read_data() {
        // arrange

        // act
        val data = Day03().readData("Day03_TestData.txt")

        // assert
        assertThat(data).containsExactly(
            "987654321111111",
            "811111111111119",
            "234234234234278",
            "818181911112111",
        )
    }

    @Test
    fun find_highest_digit_in_string() {

        // act
        val result = Day03().findHighestDigitInString("987654321111111")

        // assert
        assertThat(result).isEqualTo('9')
    }

    @Test
    fun substringAfterHighestDigit() {

        // act
        val result = Day03().substringAfterHighestDigit('9', "987654321111111")

        // assert
        assertThat(result).isEqualTo("87654321111111")
    }

    @Test
    fun joltage_987654321111111() {
        // act
        val joltage = Day03().joltage("987654321111111")

        // assert
        assertThat(joltage).isEqualTo(98)

    }

    @Test
    fun joltage_811111111111119() {
        // act
        val joltage = Day03().joltage("811111111111119")

        // assert
        assertThat(joltage).isEqualTo(89)
    }

    @Test
    fun joltage_234234234234278() {
        // act
        val joltage = Day03().joltage("234234234234278")

        // assert
        assertThat(joltage).isEqualTo(78)
    }

    @Test
    fun joltage_818181911112111() {
        // act
        val joltage = Day03().joltage("818181911112111")

        // assert
        assertThat(joltage).isEqualTo(92)
    }

    @Test
    fun solve_part1() {
        // arrange
        val data = Day03().readData("Day03_TestData.txt")

        // act
        val totalJoltage = Day03().totalJoltage(data)

        // assert
        assertThat(totalJoltage).isEqualTo(357)
    }

    @Test
    fun joltage12_987654321111111() {
        // act
        val joltage = Day03().joltage12("987654321111111")

        // assert
        assertThat(joltage).isEqualTo(987654321111L)
    }

    @Test
    fun joltage12_811111111111119() {
        // act
        val joltage = Day03().joltage12("811111111111119")

        // assert
        assertThat(joltage).isEqualTo(811111111119L)
    }

    @Test
    fun joltage12_234234234234278() {
        // act
        val joltage = Day03().joltage12("234234234234278")

        // assert
        assertThat(joltage).isEqualTo(434234234278L)
    }
    @Test
    fun joltage12_818181911112111() {
        // act
        val joltage = Day03().joltage12("888911112111")

        // assert
        assertThat(joltage).isEqualTo(888911112111L)
    }

    @Test
    fun solve_part2() {
        // arrange
        val data = Day03().readData("Day03_TestData.txt")

        // act
        val totalJoltage = Day03().totalJoltage12(data)

        // assert
        assertThat(totalJoltage).isEqualTo(3121910778619)
    }
}

