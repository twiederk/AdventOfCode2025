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
}

class Region(
    val size: Int,
    val quantity: List<Int>
)
