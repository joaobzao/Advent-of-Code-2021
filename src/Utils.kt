import day.Day
import java.io.File

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

/**
 * Prints the time of execution inside the block in milliseconds
 */
fun measure(block: () -> Unit) {
    val start = System.currentTimeMillis()

    block()

    println("Took ${System.currentTimeMillis() - start} milliseconds")
}