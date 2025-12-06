class Day04 {

    fun readData(fileName: String) : List<String> {
        return Resources.resourceAsListOfString(fileName)
    }

    fun neighborsCount(point2D: Point2D, grid: List<String>): Int {
        if (grid[point2D.y][point2D.x] != '@') return -1
        return point2D.allNeighbors(grid)
            .count { neighbor ->
                grid[neighbor.y][neighbor.x] == '@'
            }
    }

    fun part1(grid: List<String>): Int {
        val rolls = mutableListOf<Point2D>()
        for (y in grid.indices) {
            for (x in grid[0].indices) {
                if (neighborsCount(Point2D(x, y), grid) in 0..3) {
                    rolls.add(Point2D(x, y))
                }
            }
        }
        return rolls.size
    }

    fun createUpdatedGrid(grid: List<String>, rolls: List<Point2D>): List<String> {
        val newGrid = mutableListOf<String>()
        for ((row, line) in grid.withIndex()) {
            val newLine = line.toCharArray()
            for (col in line.indices) {
                if (rolls.contains(Point2D(col, row))) {
                    newLine[col] = '.'
                }
            }
            newGrid.add(String(newLine))
        }
        return newGrid
    }

    fun part2(grid: List<String>): Int {
        var currentGrid = grid
        var totalRolls = 0
        while (true) {
            val rolls = mutableListOf<Point2D>()
            for (y in currentGrid.indices) {
                for (x in currentGrid[0].indices) {
                    if (neighborsCount(Point2D(x, y), currentGrid) in 0..3) {
                        rolls.add(Point2D(x, y))
                    }
                }
            }
            if (rolls.isEmpty()) {
                break
            }
            totalRolls += rolls.size
            currentGrid = createUpdatedGrid(currentGrid, rolls)
        }
        return totalRolls
    }

}

fun main() {
    val day04 = Day04()
    val grid = day04.readData("Day04_InputData.txt")

    val part1 = day04.part1(grid)
    println("part 1 count: $part1")

    val part2 = day04.part2(grid)
    println("part 2 count: $part2")

}