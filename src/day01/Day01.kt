package day01

import day.Day
import measure
import readInput
import toIntList

fun main() {
    fun part1(input: List<Int>): Int =
        input
            .zipWithNext()
            .count { it.first < it.second }

    fun part2(input: List<Int>): Int = part1(input.windowed(3, 1) { it.sum() })

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(Day.ONETEST).toIntList()
    check(part2(testInput) == 5)

    // evaluate the official puzzle input
    val input = readInput(Day.ONE).toIntList()

    // This measure lambda is just outputting the time of execution
    measure {
        println("Solution part 1 -> ${part1(input)}")
        println("Solution part 2 -> ${part2(input)}")
    }
}