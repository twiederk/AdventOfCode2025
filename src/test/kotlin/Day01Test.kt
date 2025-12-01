import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun readData() {

        // act
        val rotations = Day01().readData("Day01_TestData.txt")

        // assert
        assertThat(rotations).containsExactly(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82",
        )

    }

    @Test
    fun dail_R8() {

        // act
        val result = Day01().dail(11, "R8")

        // assert
        assertThat(result).isEqualTo(19)
    }

    @Test
    fun dail_L11() {

        // act
        val result = Day01().dail(11, "L11")

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun dail_around_L10() {

        // act
        val result = Day01().dail(5, "L10")

        // assert
        assertThat(result).isEqualTo(95)
    }

    @Test
    fun dail_around_two_times_L110() {

        // act
        val result = Day01().dail(5, "L110")

        // assert
        assertThat(result).isEqualTo(95)
    }

    @Test
    fun dail_around_R5() {

        // act
        val result = Day01().dail(95, "R5")

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun normalizeDailPosition_negative_105() {
        // act
        val result = Day01().normalizeDailPosition(-105)

        // assert
        assertThat(result).isEqualTo(95)
    }

    @Test
    fun normalizeDailPosition_positive_210() {
        // act
        val result = Day01().normalizeDailPosition(210)

        // assert
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun part1_test_data() {
        // arrange
        val rotations: List<String> = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82",
        )

        // act
        val result = Day01().part1(rotations)

        // assert
        assertThat(result).isEqualTo(3)
    }
}