import java.util.*

class Day10 {

    // [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
    // start position [...]
    // target position [.##.]
    // next: (3) (1,3) (2) (2,3) (0,2) (0,1)
    // distance to target: target position - next position

    fun dijkstra(goal: String, buttons: List<List<Int>>): Int {
        val seen = mutableSetOf<EngineState>()
        val queue = PriorityQueue<Work>()
        return 0
    }
}

class Work {

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
}
