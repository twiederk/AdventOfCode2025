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

    // Iterative DFS mit Stack
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
    /*
        // Rekursive DFS
        fun dfsRecursive(graph: Map<Int, List<Int>>, start: Int, visited: MutableSet<Int> = mutableSetOf()) {
            if (start in visited) return
            visited.add(start)
            process(start) // Aktion beim Besuch, z.B. print oder prüfen
            for (neighbor in graph[start] ?: emptyList()) {
                dfsRecursive(graph, neighbor, visited)
            }
        }

     */

}

fun main() {
    val day11 = Day11()
    val graph = day11.readData("Day11_InputData.txt")

    val part1 = day11.part1(graph)
    println("Part 1: $part1")
}