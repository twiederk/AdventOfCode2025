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
}

fun main() {

}