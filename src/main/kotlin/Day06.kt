class Day06 {
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
        return Pair(numbers, operators)
    }

    fun part1(numbers: List<List<Int>>, operators: List<Char>): Long {
        var finalResult = 0L
        for (columnId in operators.indices) {
            finalResult += calculateColumn(numbers, operators[columnId], columnId)
        }
        return finalResult
    }

    fun readIndices(fileName: String): List<Int> {
        val rawData = Resources.resourceAsListOfString(fileName)
        val indices = mutableListOf<Int>()
        val line = rawData.last()
        for ((index, operator) in line.withIndex()) {
            if (operator != ' ') {
                indices.add(index)
            }
        }
        return indices
    }

    fun readOperators(rawData: String, indices: List<Int>): List<Char> {
        val operators = mutableListOf<Char>()
        for (index in indices) {
            operators.add(rawData[index])
        }
        return operators
    }

    fun readNumbers(rawData: List<String>, indices: List<Int>): List<List<Int>> {
        val allNumbers = mutableListOf<List<Int>>()
        indices.windowed(2, 1, true).forEach {
            val numbers = mutableListOf<Int>()
            val start = it[0]
            val end = if (it.size == 1) rawData[0].length - 1 else it[1] - 2
            for (index in start..end) {
                var numberStr = ""
                for (row in rawData.indices) {
                    val char = rawData[row][index]
                    if (char != ' ') {
                        numberStr += char
                    }
                }
                numbers.add(numberStr.toInt())
            }
            allNumbers.add(numbers.toList())
        }
        return allNumbers
    }

}

fun main() {
    val (numbers, operators) = Day06().readData("Day06_InputData_modified.txt")

    val part1 = Day06().part1(numbers, operators)
    println("Result part1: $part1")
}