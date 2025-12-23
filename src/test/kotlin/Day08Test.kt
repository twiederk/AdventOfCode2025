import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day08Test  {

    @Test
    fun read_data() {
        // act
        val data = Day08().readData("Day08_TestData.txt")

        // assert
        Assertions.assertThat(data).hasSize(20)
    }

}