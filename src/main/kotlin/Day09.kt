class Day09 {

    fun readData(string: String): List<Point2D> {
        val rawData = Resources.resourceAsListOfString(string)
        return rawData.map {
            val parts = it.split(",")
            Point2D(parts[0].toInt(), parts[1].toInt())
        }
    }

}