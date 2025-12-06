import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun read_data() {

        // act
        val data: Pair<List<LongRange>, List<Long>> = Day05().readData("Day05_TestData.txt")

        // assert
        assertThat(data.first.size).isEqualTo(4)
        assertThat(data.second.size).isEqualTo(6)

    }
}