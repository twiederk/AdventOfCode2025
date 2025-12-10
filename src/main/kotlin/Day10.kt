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

        queue += Work(EngineState(BitSet(goal.size()), 0), goal.size())

        while (queue.isNotEmpty()) {
            val work = queue.poll()
            if (work.engineState.lights == goal) return work.engineState.steps

            work.engineState.nextStates(buttons)
                .filterNot { engineState -> engineState in seen }
                .forEach { engineState ->
                    queue += Work(engineState, work.engineState.steps + 1)
                    seen += engineState
                }
        }
        throw IllegalStateException("No route to goal")
    }
}

data class Work(
    val engineState: EngineState,
    val distance: Int
) : Comparable<Work> {
    override fun compareTo(other: Work): Int {
        val xor: BitSet = engineState.lights.clone() as BitSet
        xor.xor(other.engineState.lights)
        return xor.cardinality()
    }
}

data class EngineState(
    val lights: BitSet,
    val steps: Int
) {
    fun next(indexList: List<Int>): EngineState {
        val newBitset = lights.clone() as BitSet
        for (index in indexList) {
            newBitset.flip(index)
        }
        return EngineState(newBitset, steps + 1)
    }

    fun nextStates(buttons: List<List<Int>>): List<EngineState> {
        return buttons.map { next(it) }
    }
}
