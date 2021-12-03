package day03

import day.Day
import invertBinaryString
import measure
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val bitColumnIndexes = input.first().indices
        val bitCountByColumn = bitColumnIndexes.map { index -> input.groupingBy { it[index] }.eachCount() }

        val gamma = bitCountByColumn
            .joinToString("") { bitCount ->
                val bitMaxCount = bitCount.maxByOrNull { it.value }?.key?: error("Couldn't find a max.")
                bitMaxCount.toString()
            }


        return gamma.toInt(2) * gamma.invertBinaryString().toInt(2)
    }

    fun part2(input: List<String>): Int {

        return 1
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(Day.THREETEST)
    check(part2(testInput) == 1)

    // evaluate the official puzzle input
    val input = readInput(Day.THREETEST)

    // This measure lambda is just outputting the time of execution
    measure {
        println("Solution part 1 -> ${part1(input)}")
        println("Solution part 2 -> ${part2(input)}")
    }
}