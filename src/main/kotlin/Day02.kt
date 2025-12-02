class Day02 {
    fun allNumbers(range: String): List<Int> {
        val start = range.substringBefore("-").toInt()
        val end = range.substringAfter("-").toInt()

        val allNumbers = mutableListOf<Int>()
        for (i in start..end) {
            allNumbers.add(i)
        }
        return allNumbers
    }

    fun chopNumberInHalf(number: Int): Pair<String, String> {
        val numberAsString = number.toString()
        val firstHalf = numberAsString.substring(0, numberAsString.length / 2)
        val secondHalf = numberAsString.substring(numberAsString.length / 2)
        return Pair(firstHalf, secondHalf)
    }
}

fun main() {

}