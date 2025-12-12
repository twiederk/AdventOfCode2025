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
        return dfsIterative(graph,)
    }

    fun dfsIterative(graph: Map<String, List<String>>, start: String = "you", target: String = "out"): Int {
        val stack = ArrayDeque<String>()
        stack.addFirst(start)
        var paths = 0

        while (stack.isNotEmpty()) {
            val node = stack.removeFirst()
            if (node == target) {
                paths++
                continue
            }

            for (neighbor in graph[node] ?: emptyList()) {
                stack.addFirst(neighbor)
            }
        }
        return paths
    }


    fun part2(graph: Map<String, List<String>>): Int {
        val svr_to_dac = dfsIterative(graph, "svr", "dac")
        println("svr_to_dac = $svr_to_dac")
        val dac_to_fft = dfsIterative(graph, "dac", "fft")
        println("dac_to_fft = $dac_to_fft")
        val fft_to_out = dfsIterative(graph, "fft", "out")
        println("fft_to_out = $fft_to_out")
        val svr_to_fft = dfsIterative(graph, "svr", "fft")
        println("svr_to_fft = $svr_to_fft")
        val fft_to_dac = dfsIterative(graph, "fft", "dac")
        println("fft_to_dac = $fft_to_dac")
        val dac_to_out = dfsIterative(graph, "dac", "out")
        println("dac_to_out = $dac_to_out")

        return svr_to_dac * dac_to_fft * fft_to_out +
               svr_to_fft * fft_to_dac * dac_to_out
    }

}


fun main() {
    val day11 = Day11()
    val graph = day11.readData("Day11_InputData.txt")

    val part1 = day11.part1(graph)
    println("Part 1: $part1")

    val part2 = day11.part2(graph)
    println("Part 2: $part2")
}