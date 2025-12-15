import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day06Test {

    private val numbers = listOf(
        listOf(123, 328, 51, 64),
        listOf(45, 64, 387, 23),
        listOf(6, 98, 215, 314),
    )

    private val operators = listOf('*', '+', '*', '+')

    @Test
    fun read_data() {
        // arrange

        // act
        val (numbers, operators) = Day06().readData("Day06_TestData_modified.txt")

        // assert
        assertThat(numbers).containsExactly(
            listOf(123, 328, 51, 64),
            listOf(45, 64, 387, 23),
            listOf(6, 98, 215, 314),
        )

        assertThat(operators).containsExactly('*', '+', '*', '+')
    }

    @Test
    fun calculate_column_0() {
        // act
        val result = Day06().calculateColumn(numbers, operators[0], 0)

        // assert
        assertThat(result).isEqualTo(33210)
    }

    @Test
    fun calculate_column_1() {
        // act
        val result = Day06().calculateColumn(numbers, operators[1], 1)

        // assert
        assertThat(result).isEqualTo(490)
    }

    @Test
    fun calculate_column_2() {
        // act
        val result = Day06().calculateColumn(numbers, operators[2], 2)

        // assert
        assertThat(result).isEqualTo(4243455)
    }

    @Test
    fun calculate_column_3() {
        // act
        val result = Day06().calculateColumn(numbers, operators[3], 3)

        // assert
        assertThat(result).isEqualTo(401)
    }

    @Test
    fun solve_part1() {

        // act
        val result = Day06().part1(numbers, operators)

        // assert
        assertThat(result).isEqualTo(4277556)
    }

}