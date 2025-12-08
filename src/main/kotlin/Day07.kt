class Day07 {

    fun readData(filename: String): List<String> {
        return Resources.resourceAsListOfString(filename)
    }

    fun startingPosition(line: String): Int {
        return line.indexOf('S')
    }

    fun downward(grid: List<String>, beams: Set<Int>, row: Int): Set<Int> {
        val newBeams = mutableSetOf<Int>()
        val line = grid[row]
        for (beam in beams) {
            if (line[beam] == '^') {
                newBeams.add(beam - 1)
                newBeams.add(beam + 1)
            } else {
                newBeams.add(beam)
            }
        }
        return newBeams
    }

}