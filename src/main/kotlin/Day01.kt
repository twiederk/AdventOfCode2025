class Day01 {

    fun readData(fileName: String): List<String> {
        return Resources.resourceAsListOfString(fileName)
    }

    fun dail(position: Int, dailer: String): Int {
        // R means clockwise, L means counter-clockwise
        val direction = dailer[0]
        val distance = dailer.substring(1).toInt()

        val newPosition = position + if (direction == 'R') distance else -distance
        return normalizeDailPosition(newPosition)
    }

    fun distance(dailer: String): Int {
        // R means clockwise, L means counter-clockwise
        val direction = dailer[0]
        val distance = dailer.substring(1).toInt()

        return if (direction == 'R') distance else -distance
    }

    fun normalizeDailPosition(position: Int): Int {
        return ((position % 100) + 100) % 100
    }

    fun part1(rotations: List<String>): Int {
        var position = 50
        var counter = 0
        for (rotation in rotations) {
            position = dail(position, rotation)
            if (position == 0) {
                counter++
            }
        }
        return counter
    }

    fun part2(rotations: List<String>): Int {
        var dial = 50
        var counter = 0
        for (rotation in rotations) {
            // count how many times we passed 0
            counter += countRounds(dial, distance(rotation))
            dial = dail(dial, rotation)
            println("After dailing $rotation, position is $dial with $counter rounds")
        }
        return counter
    }

    fun countRounds(dail: Int, rotation: Int): Int {
        return if (rotation > 0) {
            (dail + rotation) / 100
        } else when(dail) {
            0 -> -rotation / 100
            else -> (-rotation - dail + 100) / 100
        }
    }

}

fun main() {
    val day01 = Day01()
    val data = day01.readData("Day01_InputData.txt")

    val resultPart1 = day01.part1(data)
    println("Day01 - Part1: $resultPart1")

    val resultPart2 = day01.part2(data)
    println("Day01 - Part2: $resultPart2")
}
