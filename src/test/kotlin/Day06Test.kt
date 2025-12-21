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

    @Test
    fun read_indices() {
        // act
        val indices = Day06().readIndices("Day06_TestData.txt")

        // assert
        assertThat(indices).containsExactly(0, 4, 8, 12)
    }


    @Test
    fun readOperators() {
        // arrange
        val rawData = "*   +   *   +"
        val indices = listOf(0, 4, 8, 12)

        // act
        val operators = Day06().readOperators(rawData, indices)

        // assert
        assertThat(operators).containsExactly('*', '+', '*', '+')
    }

    @Test
    fun readNumbers() {
        // arrange
        val rawData = listOf(
            "123 328  51 640",
            " 45 64  387 230",
            "  6 98  215 314",
        )
        val indices = listOf(0, 4, 8, 12)

        // act
        val numbers: List<List<Int>> = Day06().readNumbers(rawData, indices)

        // assert
        assertThat(numbers).hasSize(4)
        assertThat(numbers[0]).containsExactly(1, 24, 356)
        assertThat(numbers[1]).containsExactly(369, 248, 8)
        assertThat(numbers[2]).containsExactly(32, 581, 175)
        assertThat(numbers[3]).containsExactly(623, 431, 4)
    }

}