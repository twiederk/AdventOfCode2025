import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day02Test {

    @Test
    fun read_data() {
        // arrange

        // act
        val ranges = Day02().readRanges("Day02_TestData.txt")

        // assert
        assertThat(ranges).containsExactly(
            "11-22",
            "95-115",
            "998-1012",
            "1188511880-1188511890",
            "222220-222224",
            "1698522-1698528",
            "446443-446449",
            "38593856-38593862",
            "565653-565659",
            "824824821-824824827",
            "2121212118-2121212124",
        )

    }

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

    @Test
    fun reject_halves_of_different_length() {
        // act
        val result = Day02().validate(Pair("", "1"))

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun reject_halves_of_different_content() {
        // act
        val result = Day02().validate(Pair("1", "2"))

        // assert
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun accept_halves_of_same_content() {

        // act
        val result = Day02().validate(Pair("11", "11"))

        // assert
        assertThat(result).isEqualTo(1111)
    }

    @Test
    fun solve_part1() {
        // arrange
        val ranges = listOf(
            "11-22",
            "95-115",
            "998-1012",
            "1188511880-1188511890",
            "222220-222224",
            "1698522-1698528",
            "446443-446449",
            "38593856-38593862",
            "565653-565659",
            "824824821-824824827",
            "2121212118-2121212124",
        )

        // act
        val result = Day02().part1(ranges)

        // assert
        assertThat(result).isEqualTo(1227775554)
    }

    @Test
    fun findPatterns_99() {

        // act
        val result = Day02().findPatterns(99)

        // assert
        assertThat(result).isEqualTo(99)
    }

    @Test
    fun findPatterns_999() {

        // act
        val result = Day02().findPatterns(999)

        // assert
        assertThat(result).isEqualTo(999)
    }

    @Test
    fun findPatterns_1010() {

        // act
        val result = Day02().findPatterns(1010)

        // assert
        assertThat(result).isEqualTo(1010)
    }

    @Test
    fun findPatterns_1188511885() {

        // act
        val result = Day02().findPatterns(1188511885)

        // assert
        assertThat(result).isEqualTo(1188511885)
    }

    @Test
    fun findPatterns_222222() {

        // act
        val result = Day02().findPatterns(222222)

        // assert
        assertThat(result).isEqualTo(222222)
    }

    @Test
    fun findPatterns_446446() {

        // act
        val result = Day02().findPatterns(446446)

        // assert
        assertThat(result).isEqualTo(446446)
    }

    @Test
    fun findPatterns_38593859() {

        // act
        val result = Day02().findPatterns(38593859)

        // assert
        assertThat(result).isEqualTo(38593859)
    }

    @Test
    fun findPatterns_565656() {

        // act
        val result = Day02().findPatterns(565656)

        // assert
        assertThat(result).isEqualTo(565656)
    }

    @Test
    fun findPatterns_824824824() {

        // act
        val result = Day02().findPatterns(824824824)

        // assert
        assertThat(result).isEqualTo(824824824)
    }

    @Test
    fun findPatterns_2121212121() {

        // act
        val result = Day02().findPatterns(2121212121)

        // assert
        assertThat(result).isEqualTo(2121212121)
    }

    @Test
    fun solve_part2() {
        // arrange
        val ranges = listOf(
            "11-22",
            "95-115",
            "998-1012",
            "1188511880-1188511890",
            "222220-222224",
            "1698522-1698528",
            "446443-446449",
            "38593856-38593862",
            "565653-565659",
            "824824821-824824827",
            "2121212118-2121212124",
        )

        // act
        val result = Day02().part2(ranges)

        // assert
        assertThat(result).isEqualTo(4174379265)
    }

}