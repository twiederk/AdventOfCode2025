class Day11 {
    fun readData(fileName: String): Map<String, List<String>> {
        val rawData = Resources.resourceAsListOfString(fileName)
        return rawData.associate { string ->
            val key = string.substringBefore(':')
            val values = string.substringAfter(": ").split(' ')
            key to values
        }
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

        // Iterative DFS mit Stack
        fun dfsIterative(graph: Map<Int, List<Int>>, start: Int) {
            val visited = mutableSetOf<Int>()
            val stack = ArrayDeque<Int>()
            stack.addFirst(start)
            while (stack.isNotEmpty()) {
                val node = stack.removeFirst()
                if (node in visited) continue
                visited.add(node)
                process(node)
                // Nachbarn auf den Stack legen (Reihenfolge entscheidet Traversal)
                for (neighbor in graph[node] ?: emptyList()) {
                    if (neighbor !in visited) stack.addFirst(neighbor)
                }
            }
        }

     */

}