import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun dail_R8() {
        // arrange

        // act
        val result = Day01().dail("R8")

        // assert
        assertThat(result).isEqualTo(19)

    }
}