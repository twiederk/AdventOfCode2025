import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.BitSet

class Day10Test {

    @Test
    fun next_state() {
        // act
        val engineState = EngineState(BitSet(4), 0).next(listOf(1, 3))

        // assert
        val expectedEngineState = EngineState(BitSet(4).apply { set(1); set(3) }, 1)
        assertThat(engineState).isEqualTo(expectedEngineState)
    }

    @Test
    fun next_states() {
        // arrange
        val buttons = listOf(
            listOf(1, 3),
            listOf(2, 3),
            listOf(0, 2),
            listOf(0, 1)
        )

        // act
        val engineState = EngineState(BitSet(4), 0).nextStates(buttons)

        // assert
        val expectedEngineStates = listOf(
            EngineState(BitSet(4).apply { set(1); set(3) }, 1),
            EngineState(BitSet(4).apply { set(2); set(3) }, 1),
            EngineState(BitSet(4).apply { set(0); set(2) }, 1),
            EngineState(BitSet(4).apply { set(0); set(1) }, 1)
        )
        assertThat(engineState).isEqualTo(expectedEngineStates)
    }

    @Test
    fun solve_line_1() {
        // [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1)

        // arrange
        val goal = BitSet(4).apply { set(1); set(2) }

        // act
        val result = Day10().dijkstra(goal, listOf(listOf(1, 3), listOf(2, 3), listOf(0, 2), listOf(0, 1)))

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun solve_line_2() {
        // [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4)

        // arrange
        val goal = BitSet(5).apply { set(3) }

        // act
        val result = Day10().dijkstra(goal, listOf(listOf(0,2,3,4), listOf(2,3), listOf (0,4), listOf (0,1,2), listOf (1,2,3,4)))

        // assert
        assertThat(result).isEqualTo(3)
    }

}