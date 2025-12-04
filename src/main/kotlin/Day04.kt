class Day04 {

    fun readData(fileName: String) : List<String> {
        return Resources.resourceAsListOfString(fileName)
    }

    fun neighborsCount(point2D: Point2D, grid: List<String>): Int {
        if (grid[point2D.y][point2D.x] != '@') return 0
        return point2D.allNeighbors(grid)
            .count { neighbor ->
                grid[neighbor.y][neighbor.x] == '@'
            }
    }

    fun part1(grid: List<String>): Int {
        var count = 0
        for (y in grid.indices) {
            for (x in grid[0].indices) {
                if (neighborsCount(Point2D(x, y), grid) in 1..3) {
                    count++
                }
            }
        }
        return count
    }

}

fun main() {
    val day04 = Day04()
    val grid = day04.readData("Day04_InputData.txt")
    val part1 = day04.part1(grid)
    println("part 1: $part1")
}