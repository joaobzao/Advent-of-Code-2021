import java.io.File

enum class Day(val description: String) {
    ONE("day01"),
    TWO("day02")
}

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String, day: Day) = File("src/${day.description}", "$name.txt").readLines()

/**
 * Converts list of ints into a list of strings
 */
fun List<Int>.toStringList(): List<String> = this.map(Int::toString)

/**
 * Converts list of strings into a list of ints
 */
fun List<String>.toIntList(): List<Int> = this.map(String::toInt)