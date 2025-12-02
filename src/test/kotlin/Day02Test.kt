import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Day02Test {

    @Test
    fun create_all_numbers() {
        // arrange

        // act
        val result = Day02().allNumbers("11-22")

        // assert
        assertThat(result).containsExactly(
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22
        )
        
    }
}