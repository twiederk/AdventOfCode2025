import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.BitSet
import kotlin.test.Ignore

class Day10Test {

    @Test
    @Ignore
    fun solve_first_line() {
        // act
        val result = Day10().dijkstra(".##.", listOf(listOf(1, 3), listOf(2, 3), listOf(0, 2), listOf(0, 1)))

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun next_state() {
        // act
        val engineState = EngineState(BitSet(4), 0).next(listOf(1, 3))

        // assert
        val expectedEngineState = EngineState(BitSet(4).apply { set(1); set(3) }, 1)
        assertThat(engineState).isEqualTo(expectedEngineState)
    }
}