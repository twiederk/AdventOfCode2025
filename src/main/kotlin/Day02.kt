class Day02 {
    fun allNumbers(range: String): List<Long> {
        val start = range.substringBefore("-").toLong()
        val end = range.substringAfter("-").toLong()

        val allNumbers = mutableListOf<Long>()
        for (i in start..end) {
            allNumbers.add(i)
        }
        return allNumbers
    }

    fun chopNumberInHalf(number: Long): Pair<String, String> {
        val numberAsString = number.toString()
        val firstHalf = numberAsString.take(numberAsString.length / 2)
        val secondHalf = numberAsString.substring(numberAsString.length / 2)
        return Pair(firstHalf, secondHalf)
    }

    fun validate(number: Pair<String, String>): Long {
        if (number.first.length != number.second.length
            || number.first != number.second
        ) {
            return 0
        }
        return (number.first + number.second).toLong()
    }

    fun readRanges(filename: String): List<String> {
        val rawData = Resources.resourceAsText(filename)
        return rawData.split(",")
    }

    fun part1(ranges: List<String>): Long {
        var sumOfInvalidIds = 0L
        for (range in ranges) {
            val allNumbers = allNumbers(range)
            for (number in allNumbers) {
                val chopped = chopNumberInHalf(number)
                sumOfInvalidIds += validate(chopped)
            }
        }
        return sumOfInvalidIds
    }

}

fun main() {
    val day02 = Day02()
    val ranges = day02.readRanges("Day02_InputData.txt")
    val part1 = day02.part1(ranges)
    println("Day 02 - Part 1: $part1")


}