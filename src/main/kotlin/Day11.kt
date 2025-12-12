class Day11 {
    fun readData(fileName: String): Map<String, List<String>> {
        val rawData = Resources.resourceAsListOfString(fileName)
        return rawData.associate { string ->
            val key = string.substringBefore(':')
            val values = string.substringAfter(": ").split(' ')
            key to values
        }
    }

    fun part1(graph: Map<String, List<String>>): Int {
        return dfsIterative(graph)
    }

    fun dfsIterative(graph: Map<String, List<String>>): Int {
        val stack = ArrayDeque<String>()
        stack.addFirst("you")
        var paths = 0

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node == "out") {
                paths++
                continue
            }

            for (neighbor in graph[node] ?: emptyList()) {
                stack.addFirst(neighbor)
            }
        }
        return paths
    }

    fun dfsIterative2(graph: Map<String, List<String>>): List<Int> {
        val stack = ArrayDeque<CableWork>()
        stack.addFirst(CableWork("svr"))
        val paths = mutableListOf<Int>()

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node.key == "fft" || node.key == "dac") {
                node.count += 1
            }
            if (node.key == "out") {
                paths.add(node.count)
                continue
            }

            for (neighbor in graph[node.key] ?: emptyList()) {
                val cableWork = CableWork(neighbor)
                cableWork.count = node.count
                stack.addFirst(cableWork)
            }
        }
        return paths
    }

    fun part2(graph: Map<String, List<String>>): Int {
        val paths = dfsIterative2(graph)
        return paths.count { it == 2 }
    }

}

data class CableWork(val key: String) {
    var count: Int = 0
}

fun main() {
    val day11 = Day11()
    val graph = day11.readData("Day11_InputData.txt")

    val part1 = day11.part1(graph)
    println("Part 1: $part1")

    val part2 = day11.part2(graph)
    println("Part 2: $part2")
}