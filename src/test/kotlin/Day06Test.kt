import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day06Test {

    private val numbers = listOf(
        listOf(123,328,51,64),
        listOf(45,64,387,23),
        listOf(6,98,215,314),
    )

    private val operators = listOf('*','+','*','+')

    @Test
    fun calculate_column_0() {
        // act
        val result = Day06(numbers, operators).calculateColumn(0)

        // assert
        assertThat(result).isEqualTo(33210)
    }

    @Test
    fun calculate_column_1() {
        // act
        val result = Day06(numbers, operators).calculateColumn(1)

        // assert
        assertThat(result).isEqualTo(490)
    }

    @Test
    fun calculate_column_2() {
        // act
        val result = Day06(numbers, operators).calculateColumn(2)

        // assert
        assertThat(result).isEqualTo(4243455)
    }

    @Test
    fun calculate_column_3() {
        // act
        val result = Day06(numbers, operators).calculateColumn(3)

        // assert
        assertThat(result).isEqualTo(401)
    }

}