import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

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
}