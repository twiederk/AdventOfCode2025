import kotlin.math.abs

class Day09 {

    fun readData(string: String): List<Point2D> {
        val rawData = Resources.resourceAsListOfString(string)
        return rawData.map {
            val parts = it.split(",")
            Point2D(parts[0].toInt(), parts[1].toInt())
        }
    }

    fun part1(tiles: List<Point2D>): Long {
        var maxDistance = 0
        var start = Point2D(0, 0)
        var end = Point2D(0, 0)
        for (i in tiles.indices) {
            for (j in tiles.indices) {
                if (i != j) {
                    val distance = tiles[i].manhattenDistance(tiles[j])
                    if (distance > maxDistance) {
                        maxDistance = distance
                        start = tiles[i]
                        end = tiles[j]
                    }
                }
            }
        }
        return area(start, end)
    }

    fun area(start: Point2D, end: Point2D): Long {
        val width = abs(end.x.toLong() - start.x.toLong()) + 1L
        val height = abs(end.y.toLong() - start.y.toLong()) + 1L
        return width * height
    }
}

fun main() {
    val day = Day09()
    val data = day.readData("Day09_InputData.txt")

    val resultPart1 = day.part1(data)
    println("Part 1: $resultPart1")
}