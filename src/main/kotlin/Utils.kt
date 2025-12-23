import java.io.File
import java.net.URI
import kotlin.math.abs


/**
 * Check if IntRanges overlap
 */
infix fun IntRange.overlaps(other: IntRange): Boolean = first <= other.last && other.first <= last

/**
 * Check if InRanges overlap fully
 */
infix fun IntRange.fullyOverlaps(other: IntRange): Boolean = first <= other.first && last >= other.last

/**
 * Check if IntRanges overlap
 */
infix fun LongRange.overlaps(other: LongRange): Boolean = first <= other.last && other.first <= last

/**
 * Check if InRanges overlap fully
 */
infix fun LongRange.fullyOverlaps(other: LongRange): Boolean = first <= other.first && last >= other.last


fun Iterable<LongRange>.combineRanges(): List<LongRange> =
    buildList {
        this@combineRanges.sortedBy { it.first }
            .fold(null as LongRange?) { previous, current ->
                when {
                    previous == null -> current
                    current.first > previous.last + 1 -> {
                        add(previous)
                        current
                    }
                    else -> previous.first .. maxOf(previous.last, current.last)
                }
            }?.let { add(it) }
    }


internal object Resources {
    fun resourceAsString(fileName: String, delimiter: String = ""): String =
        resourceAsListOfString(fileName).reduce { a, b -> "$a$delimiter$b" }

    fun resourceAsText(fileName: String): String =
        File(fileName.toURI()).readText()

    fun resourceAsListOfString(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String): List<Int> =
        resourceAsListOfString(fileName).map { it.toInt() }

    fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsListOfString(fileName).map { it.toLong() }

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI()
            ?: throw IllegalArgumentException("Cannot find Resource: $this")
}

fun <T> List<T>.nth(n: Int): T =
    this[n % size]

fun String.nth(n: Int): Char =
    this[n % length]

data class Point2D(
    val x: Int,
    val y: Int
) {

    companion object {
        val NORTH_WEST = Point2D(-1, -1)
        val NORTH = Point2D(0, -1)
        val NORTH_EAST = Point2D(1, -1)
        val EAST = Point2D(1, 0)
        val SOUTH_EAST = Point2D(1, 1)
        val SOUTH = Point2D(0, 1)
        val SOUTH_WEST = Point2D(-1, 1)
        val WEST = Point2D(-1, 0)
    }

    fun cardinalNeighbors(grid: List<String>): List<Point2D> {
        val neighbors = mutableListOf<Point2D>()
        // north
        if (y - 1 >= 0) neighbors.add(this + NORTH)
        // south
        if (y + 1 < grid.size) neighbors.add(this + SOUTH)
        // west
        if (x - 1 >= 0) neighbors.add(this + WEST)
        // east
        if (x + 1 < grid[0].length) neighbors.add(this + EAST)
        return neighbors
    }

    fun cardinalNeighbors(): List<Point2D> {
        val neighbors = mutableListOf<Point2D>()
        // north
        neighbors.add(this + NORTH)
        // south
        neighbors.add(this + SOUTH)
        // west
        neighbors.add(this + WEST)
        // east
        neighbors.add(this + EAST)
        return neighbors
    }

    fun allNeighbors(grid: List<String>): List<Point2D> {
        val neighbors = cardinalNeighbors(grid).toMutableList()
        // north_east
        if (y - 1 >= 0 && x + 1 < grid[0].length) neighbors.add(this + NORTH_EAST)
        // north_west
        if (y - 1 >= 0 && x - 1 >= 0) neighbors.add(this + NORTH_WEST)
        // south_east
        if (y + 1 < grid.size && x + 1 < grid[0].length) neighbors.add(this + SOUTH_EAST)
        // south_west
        if (y + 1 < grid.size && x - 1  >= 0) neighbors.add(this + SOUTH_WEST)
        return neighbors
    }


    operator fun minus(other: Point2D): Point2D =
        Point2D(x - other.x, y - other.y)

    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    fun manhattenDistance(other: Point2D): Int =
        abs(x - other.x) + abs(y - other.y)

    fun distanceSquared(other: Point2D): Int {
        val dx = x - other.x
        val dy = y - other.y
        return dx * dx + dy * dy
    }

}

data class Point2DL(
    val x: Long,
    val y: Long
)

data class Point3D(
    val x: Int,
    val y: Int,
    val z: Int,
)
