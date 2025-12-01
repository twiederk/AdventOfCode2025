class Day01 {

    fun dail(position: Int, dailer: String): Int {
        // R means clockwise, L means counter-clockwise
        val direction = dailer[0]
        val distance = dailer.substring(1).toInt()
        return position + if (direction == 'R') distance else -distance
    }

}

fun main() {
}
