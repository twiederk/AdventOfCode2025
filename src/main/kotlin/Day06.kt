class Day06() {
    fun calculateColumn(numbers: List<List<Int>>, operator: Char, columnId: Int): Long {
        when (operator) {
            '+' -> {
                var sum = 0L
                for (i in numbers.indices) {
                    sum += numbers[i][columnId]
                }
                return sum
            }
            '*' -> {
                var product = 1L
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

    fun part1(numbers: List<List<Int>>, operators: List<Char>): Long {
        var finalResult = 0L
        for (columnId in operators.indices) {
            finalResult += calculateColumn(numbers, operators[columnId], columnId)
        }
        return finalResult
    }

}

fun main() {
    val (numbers, operators) = Day06().readData("Day06_InputData.txt")

    val part1 = Day06().part1(numbers, operators)
    println("Result part1: $part1")
}