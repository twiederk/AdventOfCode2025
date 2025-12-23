class Day08 {

    fun readData(fileName: String): List<Point3D> {
        return Resources.resourceAsListOfString(fileName).map { line ->
            val parts = line.split(",")
            Point3D(parts[0].toInt(), parts[1].toInt(), parts[2].toInt())
        }
    }

}

class PointPair(
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