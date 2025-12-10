import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class Day10Test {

    @Test
    fun next_state() {
        // act
        val engineState = EngineState(BitSet(4)).next(listOf(1, 3))

        // assert
        val expectedEngineState = EngineState(BitSet(4).apply { set(1); set(3) })
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
        val engineState = EngineState(BitSet(4)).nextStates(buttons)

        // assert
        val expectedEngineStates = listOf(
            EngineState(BitSet(4).apply { set(1); set(3) }),
            EngineState(BitSet(4).apply { set(2); set(3) }),
            EngineState(BitSet(4).apply { set(0); set(2) }),
            EngineState(BitSet(4).apply { set(0); set(1) })
        )
        assertThat(engineState).isEqualTo(expectedEngineStates)
    }

    @Test
    fun solve_line_1() {
        // [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1)

        // arrange
        val goal = BitSet(4).apply { set(1); set(2) }

        // act
        val result = Day10().dijkstra(goal, listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)))

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun solve_line_2() {
        // [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4)

        // arrange
        val goal = BitSet(5).apply { set(3) }

        // act
        val result = Day10().dijkstra(
            goal,
            listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4))
        )

        // assert
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun solve_line_3() {
        // [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}

        // arrange
        val goal = BitSet(6).apply { set(1); set(2); set(3); set(5) }

        // act
        val result = Day10().dijkstra(
            goal, listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2))
        )

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun to_bitset_0110() {
        // act
        val result = Day10().toBitSet(".##.")

        // assert
        assertThat(result).isEqualTo(BitSet(4).apply { set(1); set(2) })
    }

    @Test
    fun to_bitset_0101() {
        // act
        val result = Day10().toBitSet(".#.#")

        // assert
        assertThat(result).isEqualTo(BitSet(4).apply { set(1); set(3) })
        println(result)
    }

    @Test
    fun solve_part1() {
        // arrange
        val lights = listOf(
            ".##.",
            "...#.",
            ".###.#",
        )

        val buttons = listOf(
            listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)),
            listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4)),
            listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2)),
        )

        // act
        val result = Day10().part1(lights, buttons)

        // assert
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun read_data() {
        // act
        val (lights, buttons) = Day10().readData("Day10_TestData.txt")

        // assert
        assertThat(lights).isEqualTo(
            listOf(
                ".##.",
                "...#.",
                ".###.#",
            )
        )
        assertThat(buttons).isEqualTo(
            listOf(
                listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)),
                listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4)),
                listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2))
            )
        )

    }
}