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

    fun dfsIterative2(graph: Map<String, List<String>>): List<List<String>> {
        val stack = ArrayDeque<String>()
        stack.addFirst("svr")
        val paths = mutableListOf<List<String>>()

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node == "out") {
                paths.add(listOf())
                continue
            }

            for (neighbor in graph[node] ?: emptyList()) {
                stack.addFirst(neighbor)
            }
        }
        return paths
    }

    fun part2(graph: Map<String, List<String>>): Int {
        val paths = dfsIterative2(graph)
        return paths.size
    }

}

fun main() {
    val day11 = Day11()
    val graph = day11.readData("Day11_InputData.txt")

    val part1 = day11.part1(graph)
    println("Part 1: $part1")
}