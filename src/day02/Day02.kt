package day02

import day.Day
import measure
import readInput

data class Instruction(val keyword: String, val value: Int)

fun main() {
    fun part1(input: List<Instruction>): Int {
        var forward = 0
        var depth = 0

        input
            .forEach {
            when (it.keyword) {
                "down" -> depth += it.value
                "up" -> depth -= it.value
                "forward" -> forward += it.value
            }
        }

        return forward * depth
    }

    fun part2(input: List<Instruction>): Int {
        var forward = 0
        var depth = 0
        var aim = 0

        input
            .forEach {
                when (it.keyword) {
                    "down" -> { aim += it.value }
                    "up" -> { aim -= it.value }
                    "forward" -> {
                        forward += it.value
                        depth += aim * it.value
                    }
                }
            }

        return forward * depth
    }

    fun createInstruction(rawInstruction: String): Instruction {
        val (keyword, value) = rawInstruction.split(" ")
        return Instruction(keyword, value.toInt())
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(Day.TWOTEST)
        .map(::createInstruction)
    check(part2(testInput) == 900)

    // evaluate the official puzzle input
    val input = readInput(Day.TWO)
        .map(::createInstruction)

    // This measure lambda is just outputting the time of execution
    measure {
        println("Solution part 1 -> ${part1(input)}")
        println("Solution part 2 -> ${part2(input)}")
    }
}