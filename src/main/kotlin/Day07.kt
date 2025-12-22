class Day07 {

    fun readData(filename: String): List<String> {
        return Resources.resourceAsListOfString(filename)
    }

    fun startingPosition(line: String): Int {
        return line.indexOf('S')
    }

    fun downward(grid: List<String>, beams: Set<Int>, row: Int): Pair<Set<Int>, Int> {
        var split = 0
        val newBeams = mutableSetOf<Int>()
        val line = grid[row]
        for (beam in beams) {
            if (line[beam] == '^') {
                newBeams.add(beam - 1)
                newBeams.add(beam + 1)
                split++
            } else {
                newBeams.add(beam)
            }
        }
        return Pair(newBeams, split)
    }

    fun part1(grid: List<String>): Int {
        var totalSplits = 0
        var beams = setOf(startingPosition(grid[0]))
        for (row in 2 until grid.size step 2) {
            val (result, split) = downward(grid, beams, row)
            beams = result
            totalSplits += split
        }
        return totalSplits
    }


    fun downwardTimeline(grid: List<String>, beams: Map<Int,Long>, row: Int): Map<Int,Long> {
        val newBeams = mutableMapOf<Int,Long>()
        val line = grid[row]

        for (beam in beams) {
            if (line[beam.key] == '^') {
                val countLeft = newBeams.getOrElse(beam.key - 1) { 0L }
                newBeams[beam.key - 1] = countLeft + beam.value

                val countRight = newBeams.getOrElse(beam.key + 1) { 0L }
                newBeams[beam.key + 1] = countRight + beam.value
            } else {
                val count = newBeams.getOrElse(beam.key) { 0L }
                newBeams[beam.key] = count + beam.value
            }
        }
        return newBeams
    }



    fun part2(grid: List<String>): Long {
        var beams = mapOf(startingPosition(grid[0]) to 1L)
        for (row in 2 until grid.size step 2) {
            beams = downwardTimeline(grid, beams, row)
        }
        val totalBeams = beams.values.sum()
        return totalBeams
    }

}

fun main() {
    val grid = Day07().readData("Day07_InputData.txt")

    val part1 = Day07().part1(grid)
    println("Part 1: $part1")

    val part2 = Day07().part2(grid)
    println("Part 2: $part2")
}