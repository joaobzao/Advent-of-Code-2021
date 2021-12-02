import java.io.File

enum class Day(val folder: String, val file: String) {
    ONE("day01", "Day01"),
    ONETEST("day01", "Day01_test"),
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: Day) = File("src/${day.folder}", "${day.file}.txt").readLines()

/**
 * Converts list of ints into a list of strings
 */
fun List<Int>.toStringList(): List<String> = this.map(Int::toString)

/**
 * Converts list of strings into a list of ints
 */
fun List<String>.toIntList(): List<Int> = this.map(String::toInt)