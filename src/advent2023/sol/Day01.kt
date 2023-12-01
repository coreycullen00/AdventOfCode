package advent2023.sol

import advent2023.Utils.Companion.getInput
import advent2023.Utils.Companion.getTestInput
import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var count = 0
        input.forEach { string ->
            val s = string.filter { it.isDigit() }
            val num = "${s.first()}${s.last()}".toInt()
            count += num
        }
        return count
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputP1 = readInput(getTestInput("Day01P1"))
    check(part1(testInputP1) == 142)

    val input = readInput(getInput("Day01"))
    part1(input).println()
    part2(input).println()
}
