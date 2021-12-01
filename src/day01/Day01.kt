package day01

import readInput
import toIntList
import toStringList

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .filterIndexed { index, element -> index > 0 && element.toInt() > input[index - 1].toInt() }
            .count()
    }

    fun part2(input: List<String>): Int {
        val chunkSize = 3
        val inputChunksSum = input
            .withIndex()
            .takeWhile { indexedValue -> input.count() >= indexedValue.index + chunkSize }
            .map { indexedValue -> input.toIntList().drop(indexedValue.index).take(chunkSize).sum() }

        return part1(inputChunksSum.toStringList())
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 5)

    // evaluate the official puzzle input
    val input = readInput("day01")
    println("Solution part 1 -> ${part1(input)}")
    println("Solution part 2 -> ${part2(input)}")
}
