
class Day05 {

    fun readData(fileName: String): Pair<List<LongRange>, List<Long>> {
        val lines = Resources.resourceAsListOfString(fileName)
        val ranges = mutableListOf<LongRange>()
        val numbers = mutableListOf<Long>()
        var readingRanges = true
        for (line in lines) {
            if (line.isBlank()) {
                readingRanges = false
                continue
            }
            if (readingRanges) {
                val parts = line.split("-")
                val start = parts[0].toLong()
                val end = parts[1].toLong()
                ranges.add(LongRange(start, end))
            } else {
                numbers.add(line.toLong())
            }
        }
        return Pair(ranges, numbers)
    }

    fun solvePart1(ranges: List<LongRange>, ids: List<Long>): Int {
        var count = 0
        for (id in ids) {
            for (range in ranges) {
                if (id in range) {
                    count++
                    break
                }
            }
        }
        return count
    }

    fun solvePart2(ranges: List<LongRange>): Long {
        val combinedRanges = ranges.combineRanges()
        return combinedRanges.sumOf { it.last - it.first + 1 }
    }


}

fun main() {
    val day05 = Day05()
    val (ranges, ids) = day05.readData("Day05_InputData.txt")

    val part1 = day05.solvePart1(ranges, ids)
    println("Part 1 Result: $part1")

    val part2 = day05.solvePart2(ranges)
    println("Part 2 Result: $part2")
}