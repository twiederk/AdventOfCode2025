class Day06(
    private val numbers: List<List<Int>>,
    private val operators: List<Char>
) {
    fun calculateColumn(columnId: Int): Int {
        when (operators[columnId]) {
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
            else -> throw IllegalArgumentException("Unsupported operator: ${operators[columnId]}")
        }
    }

}