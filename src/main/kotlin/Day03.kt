class Day03 {

    fun readData(fileName: String): List<String> = Resources.resourceAsListOfString(fileName)

    fun findHighestDigitInString(bank: String): Char {
        return bank.maxOrNull() ?: throw IllegalArgumentException("Cannot find highest digit in empty string")
    }

    fun substringAfterHighestDigit(maxDigit: Char, bank: String): String {
        val index = bank.indexOf(maxDigit)
        return bank.substring(index + 1)
    }

    fun joltage(bank: String): Int {
        val firstDigit = findHighestDigitInString(bank.dropLast(1))
        val remainingBank = substringAfterHighestDigit(firstDigit, bank)
        val secondDigit = findHighestDigitInString(remainingBank)
        val joltage = "${firstDigit}${secondDigit}".toInt()
        return joltage
    }

    fun totalJoltage(joltageList: List<String>): Int {
        return joltageList.sumOf { Day03().joltage(it) }
    }

    fun joltage12(bank: String): Long {
        var joltage = ""
        var remainingBank = bank

        for (i in 11 downTo 0) {
            val digit = findHighestDigitInString(remainingBank.dropLast(i))
            remainingBank = substringAfterHighestDigit(digit, bank)
            joltage += digit
        }
        return joltage.toLong()
    }

}

fun main() {
    val data = Day03().readData("Day03_InputData.txt")
    val part1 = Day03().totalJoltage(data)
    println("Part 1: $part1")
}