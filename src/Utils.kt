import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Converts list of ints into a list of strings
 */
fun List<Int>.toStringList(): List<String> = this.map { it.toString() }

/**
 * Converts list of strings into a list of ints
 */
fun List<String>.toIntList(): List<Int> = this.map { it.toInt() }