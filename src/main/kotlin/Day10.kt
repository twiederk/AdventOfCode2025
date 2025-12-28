import com.microsoft.z3.Context
import com.microsoft.z3.IntExpr
import com.microsoft.z3.IntNum
import com.microsoft.z3.Status
import java.util.*

class Day10 {

    fun dijkstra(goal: BitSet, buttons: List<List<Int>>): Int {
        val seen = mutableSetOf<EngineState>()
        val queue = PriorityQueue<EngineWork>()

        queue += EngineWork(EngineState(BitSet(goal.size())), 0)

        while (queue.isNotEmpty()) {
            val work = queue.poll()
            if (work.engineState.lights == goal) return work.steps

            work.engineState.nextStates(buttons)
                .filterNot { engineState -> engineState in seen }
                .forEach { engineState ->
                    queue += EngineWork(engineState, work.steps + 1)
                    seen += engineState
                }
        }
        throw IllegalStateException("No route to goal")
    }

    fun toBitSet(lights: String): BitSet {
        val bitSet = BitSet(lights.length)
        lights.forEachIndexed { index, c ->
            if (c == '#') {
                bitSet.set(index)
            }
        }
        return bitSet
    }

    fun part1(lights: List<String>, buttons: List<List<List<Int>>>): Int {
        return lights.zip(buttons).sumOf { (light, button) ->
            dijkstra(toBitSet(light), button)
        }
    }

    fun part2dijkstra(joltage: List<List<Int>>, buttons: List<List<List<Int>>>): Int {
        return joltage.zip(buttons).sumOf { (jolt, button) ->
            dijkstraPart2(jolt, button)
        }
    }

    fun part2z3(joltage: List<List<Int>>, buttons: List<List<List<Int>>>): Int {
        return joltage.zip(buttons).sumOf { (jolt, button) ->
            z3Part2(jolt, button)
        }
    }

    fun readData(filename: String): Triple<List<String>, List<List<List<Int>>>, List<List<Int>>> {
        val rawData = Resources.resourceAsListOfString(filename)
        val lights = mutableListOf<String>()
        val buttons = mutableListOf<List<List<Int>>>()
        val joltage = mutableListOf<List<Int>>()

        for (line in rawData) {
            lights.add(line.substringAfter('[').substringBefore(']'))

            val buttonStrings = line.substringAfter("] (").substringBefore(") {")
            buttons.add(
                buttonStrings.split(") (")
                    .map { list ->
                        list.split(',')
                            .map { number -> number.toInt() }
                    })

            joltage.add(
                line.substringAfter(") {").substringBefore("}")
                    .split(',')
                    .map { it.toInt() })
        }
        return Triple(lights, buttons, joltage)
    }

    fun dijkstraPart2(goal: List<Int>, buttons: List<List<Int>>): Int {
        val seen = mutableSetOf<JoltageState>()
        val queue = PriorityQueue<JoltageWork>()

        queue += JoltageWork(JoltageState(List(goal.size) { 0 }), 0)

        while (queue.isNotEmpty()) {
            val work = queue.poll()
            if (work.joltageState.joltage == goal) return work.steps

            work.joltageState.nextStates(buttons)
                .filterNot { joltageState -> joltageState in seen }
                .forEach { engineState ->
                    queue += JoltageWork(engineState, work.steps + 1)
                    seen += engineState
                }
        }
        throw IllegalStateException("No route to goal")
    }

    fun z3Part2(joltage: List<Int>, buttons: List<List<Int>>): Int {
        val ctx = Context()
        val solver = ctx.mkOptimize()
        val zero = ctx.mkInt(0)

        // Counts number of presses for each button, and ensures it is positive.
        val z3buttons = buttons.indices
            .map { ctx.mkIntConst("button#$it") }
            .onEach { button -> solver.Add(ctx.mkGe(button, zero)) }
            .toTypedArray()

        // For each joltage counter, require that the sum of presses of all buttons that increment it is equal to the
        // target value specified in the config.
        joltage.forEachIndexed { counter, targetValue ->
            val buttonsThatIncrement = buttons
                .withIndex()
                .filter { (_, counters) -> counter in counters }
                .map { z3buttons[it.index] }
                .toTypedArray()
            val target = ctx.mkInt(targetValue)

            val sumOfPresses = ctx.mkAdd(*buttonsThatIncrement) as IntExpr
            solver.Add(ctx.mkEq(sumOfPresses, target))
        }

        val presses = ctx.mkIntConst("presses")
        solver.Add(ctx.mkEq(presses, ctx.mkAdd(*z3buttons)))
        solver.MkMinimize(presses)

        if (solver.Check() != Status.SATISFIABLE) error("No solution found for machine: $buttons $joltage.")
        return solver.model.evaluate(presses, false).let { it as IntNum }.int
    }
}

data class EngineWork(
    val engineState: EngineState,
    val steps: Int
) : Comparable<EngineWork> {

    override fun compareTo(other: EngineWork): Int {
        return steps.compareTo(other.steps)
    }

}

data class EngineState(
    val lights: BitSet
) {
    fun next(indexList: List<Int>): EngineState {
        val newBitset = lights.clone() as BitSet
        for (index in indexList) {
            newBitset.flip(index)
        }
        return EngineState(newBitset)
    }

    fun nextStates(buttons: List<List<Int>>): List<EngineState> {
        return buttons.map { next(it) }
    }
}


data class JoltageWork(
    val joltageState: JoltageState,
    val steps: Int
) : Comparable<JoltageWork> {

    override fun compareTo(other: JoltageWork): Int {
        return steps.compareTo(other.steps)
    }

}


data class JoltageState(
    val joltage: List<Int>
) {
    fun next(indexList: List<Int>): JoltageState {
        val newJoltageList = joltage.toMutableList()
        for (index in indexList) {
            newJoltageList[index] += 1
        }
        return JoltageState(newJoltageList)
    }

    fun nextStates(buttons: List<List<Int>>): List<JoltageState> {
        return buttons.map { next(it) }
    }
}

fun main() {
    val day10 = Day10()
    val (lights, buttons, joltage) = day10.readData("Day10_InputData.txt")

    val part1 = day10.part1(lights, buttons)
    println("Part 1: $part1")

    val part2 = day10.part2z3(joltage, buttons)
    println("Part 2: $part2")
}

