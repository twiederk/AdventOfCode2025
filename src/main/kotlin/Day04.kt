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

}

fun main() {
    val day04 = Day04()
    val grid = day04.readData("Day04_InputData.txt")

    val part1 = day04.part1(grid)
    println("part 1 count: $part1")

}