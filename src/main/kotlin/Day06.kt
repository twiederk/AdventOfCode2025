class Day06() {
    fun calculateColumn(numbers: List<List<Int>>, operator: Char, columnId: Int): Int {
        when (operator) {
            '+' -> {
                var sum = 0
                for (i in numbers.indices) {
                    sum += numbers[i][columnId]
                }
                return sum
            }
            '*' -> {
                var product = 1
                for (i in numbers.indices) {
                    product *= numbers[i][columnId]
                }
                return product
            }
            else -> throw IllegalArgumentException("Unsupported operator: $operator")
        }
    }

    fun readData(fileName: String): Pair<List<List<Int>>, List<Char>> {
        val rawData = Resources.resourceAsListOfString(fileName)
        val numbers = rawData.dropLast(1).map { line ->
            line.split(",").map { it.toInt() }
        }
        val operators = rawData[rawData.lastIndex].split(",")
            .map { it[0] }
        return Pair(numbers,    operators)
    }

}