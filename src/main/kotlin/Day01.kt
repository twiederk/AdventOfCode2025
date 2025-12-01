class Day01 {

    fun dail(position: Int, dailer: String): Int {
        // R means clockwise, L means counter-clockwise
        val direction = dailer[0]
        val distance = dailer.substring(1).toInt()

        val newPosition = position + if (direction == 'R') distance else -distance
        return normalizeDailPosition(newPosition)


    }

    fun normalizeDailPosition(position: Int): Int {
        return ((position % 100) + 100) % 100
    }

}

fun main() {
}
