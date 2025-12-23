typealias Circuit = Set<Point3D>

class Day08 {

    fun readData(fileName: String): List<Point3D> {
        return Resources.resourceAsListOfString(fileName).map { line ->
            val parts = line.split(",")
            Point3D(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
        }
    }

    fun pointPairsSorted(points: List<Point3D>): List<PointPair> {
        val pairs = mutableListOf<PointPair>()
        for (i in points.indices) {
            for (j in i + 1 until points.size) {
                pairs.add(PointPair(points[i], points[j]))
            }
        }
        return pairs.sorted()
    }

    fun findCircuit(allCircuits: List<Circuit>, point3D: Point3D): Circuit? {
        return allCircuits.find { circuit ->
            circuit.contains(point3D)
        }
    }

    fun connect(allCircuits: MutableList<Circuit>, pointPair: PointPair): MutableList<Circuit> {
        val circuitA = findCircuit(allCircuits, pointPair.pointA)
        val circuitB = findCircuit(allCircuits, pointPair.pointB)
        return when {
            circuitA != null && circuitB != null && circuitA != circuitB -> {
                // both points are in different circuits, merge them
                allCircuits.remove(circuitA)
                allCircuits.remove(circuitB)
                val mergedCircuit = circuitA.union(circuitB)
                allCircuits.add(mergedCircuit)
                allCircuits
            }
            circuitA != null && circuitB == null -> {
                // pointA is in a circuit, add pointB to it
                allCircuits.remove(circuitA)
                val expandedCircuit = circuitA.plus(pointPair.pointB)
                allCircuits.add(expandedCircuit)
                allCircuits
            }
            circuitA == null && circuitB != null -> {
                // pointB is in a circuit, add pointA to it
                allCircuits.remove(circuitB)
                val expandedCircuit = circuitB.plus(pointPair.pointA)
                allCircuits.add(expandedCircuit)
                allCircuits
            }
            circuitA == null && circuitB == null -> {
                // neither point is in a circuit, create a new one
                val newCircuit = setOf(pointPair.pointA, pointPair.pointB)
                allCircuits.add(newCircuit)
                allCircuits
            }
            else -> {
                // both points are already in the same circuit, do nothing
                allCircuits
            }
        }
    }

    fun multiplyThreeLargestCircuits(allCircuits: List<Circuit>): Int {
        allCircuits.sortedBy { it.size }.takeLast(3).let {
            return it[0].size * it[1].size * it[2].size
        }
    }

    fun part1(allPoints: List<Point3D>, maxConnections: Int): Int {
        var allCircuits = mutableListOf<Circuit>()
        val pointPairs = pointPairsSorted(allPoints)
        for (index in 0 until maxConnections) {
            allCircuits = connect(allCircuits, pointPairs[index])
        }
        return multiplyThreeLargestCircuits(allCircuits)
    }

}

data class PointPair(
    val pointA: Point3D,
    val pointB: Point3D
) : Comparable<PointPair> {
    val distance: Double by lazy {
        pointA.straightLineDistance(pointB)
    }

    override fun compareTo(other: PointPair): Int {
        return this.distance.compareTo(other.distance)
    }
}

fun main() {
    val allPoints = Day08().readData("Day08_InputData.txt")
    val part1 = Day08().part1(allPoints, 1000)
    println("Part 1: $part1")
}