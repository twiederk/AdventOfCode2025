import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class Day10Test {

//    https://www.reddit.com/r/adventofcode/comments/1pity70/2025_day_10_solutions/
//    https://www.reddit.com/r/adventofcode/comments/1pk87hl/2025_day_10_part_2_bifurcate_your_way_to_victory/
//    https://github.com/ash42/adventofcode/tree/main/adventofcode2025/src/nl/michielgraat/adventofcode2025/day10
//    https://github.com/werner77/AdventOfCode/tree/master/src%2Fmain%2Fkotlin%2Fcom%2Fbehindmedia%2Fadventofcode

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
        val result =
            Day10().dijkstra(goal, listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)))

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
        val (lights, buttons, joltage) = Day10().readData("Day10_TestData.txt")

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

        assertThat(joltage).isEqualTo(
            listOf(
                listOf(3, 5, 4, 7),
                listOf(7, 5, 12, 7, 2),
                listOf(10, 11, 11, 5, 10, 5),
            )
        )
    }

    @Test
    fun joltageState_next() {
        // act
        val next = JoltageState(listOf(0, 1, 2, 3)).next(listOf(1, 3))

        // assert
        assertThat(next).isEqualTo(JoltageState(listOf(0, 2, 2, 4)))
    }

    @Test
    fun joltageState_nextStates() {
        // arrange
        val buttons = listOf(
            listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)
        )

        // act
        val nextStates = JoltageState(listOf(0, 0, 0, 0)).nextStates(buttons)

        // assert
        assertThat(nextStates).isEqualTo(
            listOf(
                JoltageState(listOf(0, 0, 0, 1)),
                JoltageState(listOf(0, 1, 0, 1)),
                JoltageState(listOf(0, 0, 1, 0)),
                JoltageState(listOf(0, 0, 1, 1)),
                JoltageState(listOf(1, 0, 1, 0)),
                JoltageState(listOf(1, 1, 0, 0)),
            )
        )
    }

    @Test
    fun solve_joltage_line_1() {
        // (0,2,3) (1,3) {11,10,11,21}

        // arrange
        val goal = listOf(3, 5, 4, 7)

        // act
        val result =
            Day10().dijkstraPart2(
                goal,
                listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1))
            )

        // assert
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun solve_joltage_line_2() {
        // (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}

        // arrange
        val goal = listOf(7, 5, 12, 7, 2)

        // act
        val result =
            Day10().dijkstraPart2(
                goal,
                listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4))
            )

        // assert
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun solve_joltage_line_3() {
        // (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}

        // arrange
        val goal = listOf(10, 11, 11, 5, 10, 5)

        // act
        val result =
            Day10().dijkstraPart2(
                goal,
                listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2))
            )

        // assert
        assertThat(result).isEqualTo(11)
    }

    @Test
    fun solve_part2_with_dijkstra() {
        // arrange
        val joltage = listOf(
            listOf(3, 5, 4, 7),
            listOf(7, 5, 12, 7, 2),
            listOf(10, 11, 11, 5, 10, 5),
        )

        val buttons = listOf(
            listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)),
            listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4)),
            listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2)),
        )

        // act
        val result = Day10().part2dijkstra(joltage, buttons)

        // assert
        assertThat(result).isEqualTo(33)
    }

    @Test
    fun solve_joltage_z3_line_1() {
        // (0,2,3) (1,3) {11,10,11,21}

        // arrange
        val goal = listOf(3, 5, 4, 7)

        // act
        val result =
            Day10().z3Part2(
                goal,
                listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1))
            )

        // assert
        assertThat(result).isEqualTo(10)
    }


    @Test
    fun solve_joltage_z3_line_2() {
        // (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}

        // arrange
        val goal = listOf(7, 5, 12, 7, 2)

        // act
        val result =
            Day10().z3Part2(
                goal,
                listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4))
            )

        // assert
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun solve_joltage_z3_line_3() {
        // (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}

        // arrange
        val goal = listOf(10, 11, 11, 5, 10, 5)

        // act
        val result =
            Day10().z3Part2(
                goal,
                listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2))
            )

        // assert
        assertThat(result).isEqualTo(11)
    }

    @Test
    fun solve_part2_with_z3() {
        // arrange
        val joltage = listOf(
            listOf(3, 5, 4, 7),
            listOf(7, 5, 12, 7, 2),
            listOf(10, 11, 11, 5, 10, 5),
        )

        val buttons = listOf(
            listOf(listOf(3), listOf(1, 3), listOf(2), listOf(2, 3), listOf(0, 2), listOf(0, 1)),
            listOf(listOf(0, 2, 3, 4), listOf(2, 3), listOf(0, 4), listOf(0, 1, 2), listOf(1, 2, 3, 4)),
            listOf(listOf(0, 1, 2, 3, 4), listOf(0, 3, 4), listOf(0, 1, 2, 4, 5), listOf(1, 2)),
        )

        // act
        val result = Day10().part2z3(joltage, buttons)

        // assert
        assertThat(result).isEqualTo(33)
    }


}