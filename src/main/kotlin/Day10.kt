import java.util.*

class Day10 {

    // [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
    // start position [...]
    // target position [.##.]
    // next: (3) (1,3) (2) (2,3) (0,2) (0,1)
    // distance to target: target position - next position

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
                bitSet.set(index - 1)
            }
        }
        return bitSet
    }

    fun part1(lights: List<String>, buttons: List<List<List<Int>>>): Int {
        return lights.zip(buttons).sumOf { (light, button) ->
            dijkstra(toBitSet(light), button)
        }
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
