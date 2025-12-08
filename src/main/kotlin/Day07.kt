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

}

fun main() {
    val grid = Day07().readData("Day07_InputData.txt")

    val part1 = Day07().part1(grid)
    println("Part 1: $part1")
}