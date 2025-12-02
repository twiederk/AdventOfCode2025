import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day02Test {

    @Test
    fun create_all_numbers() {

        // act
        val result = Day02().allNumbers("11-22")

        // assert
        assertThat(result).containsExactly(
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22
        )
    }

    @Test
    fun chop_number_in_half_1() {

        // act
        val result = Day02().chopNumberInHalf(1)

        // assert
        assertThat(result).isEqualTo(Pair("", "1"))
    }

    @Test
    fun chop_number_in_half_11() {

        // act
        val result = Day02().chopNumberInHalf(11)

        // assert
        assertThat(result).isEqualTo(Pair("1", "1"))
    }

    @Test
    fun chop_number_in_half_111() {

        // act
        val result = Day02().chopNumberInHalf(111)

        // assert
        assertThat(result).isEqualTo(Pair("1", "11"))
    }

    @Test
    fun chop_number_in_half_1111() {
        // act
        val result = Day02().chopNumberInHalf(1111)

        // assert
        assertThat(result).isEqualTo(Pair("11", "11"))
    }

}