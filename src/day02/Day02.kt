package day02

import day.Day
import measure
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var forward = 0
        var depth = 0

        input
            .map { it.split(" ") }
            .map { (a, b) -> a to b.toInt() }
            .forEach {
            when (it.first) {
                "down" -> depth += it.second
                "up" -> depth -= it.second
                "forward" -> forward += it.second
            }
        }

        return forward * depth
    }

    fun part2(input: List<String>): Int {
        var forward = 0
        var depth = 0
        var aim = 0

        input
            .map { it.split(" ") }
            .map { (a, b) -> a to b.toInt() }
            .forEach {
                when (it.first) {
                    "down" -> { aim += it.second }
                    "up" -> { aim -= it.second }
                    "forward" -> {
                        forward += it.second
                        depth += aim * it.second
                    }
                }
            }

        return forward * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(Day.TWOTEST)
    check(part2(testInput) == 900)

    // evaluate the official puzzle input
    val input = readInput(Day.TWO)

    measure {
        println("Solution part 1 -> ${part1(input)}")
        println("Solution part 2 -> ${part2(input)}")
    }
}