package day01

import readInput
import toIntList

val currentDay = Day.ONE

fun main() {
    fun part1(input: List<Int>): Int =
        input
            .zipWithNext()
            .count { it.first < it.second }

    fun part2(input: List<Int>): Int = part1(input.windowed(3, 1) { it.sum() })

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test", currentDay).toIntList()
    check(part2(testInput) == 5)

    // evaluate the official puzzle input
    val input = readInput("day01", currentDay).toIntList()
    println("Solution part 1 -> ${part1(input)}")
    println("Solution part 2 -> ${part2(input)}")
}
