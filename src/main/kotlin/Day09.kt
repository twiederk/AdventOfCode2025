import java.awt.Rectangle
import java.awt.geom.Area
import java.awt.geom.GeneralPath
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

    fun border(tiles: List<Point2D>): Area {
        val path = GeneralPath()
        path.moveTo(tiles[0].x.toFloat(), tiles[0].y.toFloat())
        for (i in 1 until tiles.size) {
            path.lineTo(tiles[i].x.toFloat(), tiles[i].y.toFloat())
        }
        return Area(path)
    }

    fun containsRect(area: Area, pointA: Point2D, pointB: Point2D): Boolean {
        val rect = Rectangle(
            minOf(pointA.x, pointB.x),
            minOf(pointA.y, pointB.y),
            abs(pointB.x - pointA.x),
            abs(pointB.y - pointA.y)
        )
        return area.contains(rect)
    }

    fun part2(tiles: List<Point2D>): Long {
        val border = border(tiles)
        var maxDistance = 0
        var start = Point2D(0, 0)
        var end = Point2D(0, 0)
        for (i in tiles.indices) {
            for (j in tiles.indices) {
                if (i != j) {
                    if (containsRect(border, tiles[i], tiles[j])) {
                        val distance = tiles[i].manhattenDistance(tiles[j])
                        if (distance > maxDistance) {
                            maxDistance = distance
                            start = tiles[i]
                            end = tiles[j]
                        }
                    }
                }
            }
        }
        return area(start, end)
    }
}

fun main() {
    val day = Day09()
    val data = day.readData("Day09_InputData.txt")

    val part1 = day.part1(data)
    println("Part 1: $part1")

    val part2 = day.part2(data)
    println("Part 2: $part2")
}