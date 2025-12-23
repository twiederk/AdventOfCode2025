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