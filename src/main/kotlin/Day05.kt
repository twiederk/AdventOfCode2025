
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
}