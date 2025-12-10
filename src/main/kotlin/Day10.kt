import java.util.*

class Day10 {

    fun dijkstra(goal: BitSet, buttons: List<List<Int>>): Int {
        val seen = mutableSetOf<EngineState>()
        val queue = PriorityQueue<Work>()

        queue += Work(EngineState(BitSet(goal.size())), 0)

        while (queue.isNotEmpty()) {
            val work = queue.poll()
            if (work.engineState.lights == goal) return work.steps

            work.engineState.nextStates(buttons)
                .filterNot { engineState -> engineState in seen }
                .forEach { engineState ->
                    queue += Work(engineState, work.steps + 1)
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

            joltage.add(line.substringAfter(") {").substringBefore("}")
                .split(',')
                .map { it.toInt() } )
        }
        return Triple(lights, buttons, joltage)
    }
}

data class Work(
    val engineState: EngineState,
    val steps: Int
) : Comparable<Work> {

    override fun compareTo(other: Work): Int {
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

fun main() {
    val day10 = Day10()
    val (lights, buttons) = day10.readData("Day10_InputData.txt")

    val part1 = day10.part1(lights, buttons)
    println("Part 1: $part1")
}