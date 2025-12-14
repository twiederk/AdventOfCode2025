class Day12(
    val shapes: List<Int>
) {

    fun fit(region: Region): Int {
        var requiredSpace = 0
        for (i in shapes.indices) {
            requiredSpace += shapes[i] * region.quantity[i]
        }
        if (region.size >= requiredSpace) {
            return 1
        }
        return 0
    }

    fun part1(regions: List<Region>): Int {
        return regions.sumOf { fit(it) }
    }

    companion object {
        fun readShapes(filename: String): List<Int> {
            val rawData = Resources.resourceAsText(filename)
            return rawData.split("\r\n\r\n")
                .dropLast(1)
                .map { present -> present.count { it == '#' } }
        }

        fun readRegions(filename: String): List<Region> {
            val rawData = Resources.resourceAsText(filename)
            val rawRegions = rawData.split("\r\n\r\n")
                .last()
                .split("\r\n")
            return rawRegions.map { line ->
                Region(
                    size = line.substringBefore("x").toInt() *
                            line.substringAfter("x").substringBefore(":").toInt(),
                    quantity = line.substringAfter(" ").split(" ").map { it.toInt() }
                )
            }
        }

    }
}

data class Region(
    val size: Int,
    val quantity: List<Int>
)
