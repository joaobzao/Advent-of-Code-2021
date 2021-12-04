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
        val oxyGenRating = input.filterColumnsForCharacter(input) { zeroes, ones ->
            if (zeroes > ones) '0' else '1'
        }

        val co2ScrubberRating = input.filterColumnsForCharacter(input) { zeroes, ones ->
            if (zeroes > ones) '1' else '0'
        }

        return oxyGenRating.toInt(2) * co2ScrubberRating.toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput(Day.THREETEST)
    check(part2(testInput) == 230)

    // evaluate the official puzzle input
    val input = readInput(Day.THREE)

    // This measure lambda is just outputting the time of execution
    measure {
        println("Solution part 1 -> ${part1(input)}")
        println("Solution part 2 -> ${part2(input)}")
    }
}

fun List<String>.filterColumnsForCharacter(input: List<String>, desiredCharacterByFrequency: (zeroes: Int, ones: Int) -> Char): String {
    var candidateList = this
    for (column in input.first().indices) {
        val charFrequencyByColumn = candidateList.groupingBy { it[column] }.eachCount()
        val zeroes = charFrequencyByColumn['0'] ?: 0
        val ones = charFrequencyByColumn['1'] ?: 0
        candidateList = candidateList.filter { it[column] == desiredCharacterByFrequency(zeroes, ones) }
        if (candidateList.size == 1) break
    }
    return candidateList.single()
}