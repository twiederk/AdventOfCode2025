class Day07 {

    fun readData(filename: String): List<String> {
        return Resources.resourceAsListOfString(filename)
    }

    fun startingPosition(line: String): Int {
        return line.indexOf('S')
    }

}