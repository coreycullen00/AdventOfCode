package advent2024.sol

import Utils.getInput
import Utils.getTestInput
import Utils.println
import Utils.readInput
import kotlin.math.abs

fun main() {

    fun part1(input: List<String>): Int {
        val pairs: List<Pair<String, String>> = input.map { it.replace("\\s+".toRegex(), ",").split(",") }.map { Pair(it[0], it[1]) }
        val lefts = pairs.map { it.first }.sortedDescending().reversed()
        val rights = pairs.map { it.second }.sortedDescending().reversed()
        var count = 0
        lefts.forEachIndexed { ind, left ->
            val ab = abs(left.toInt() - rights[ind].toInt())
            count += ab
        }

        return count
    }

    fun part2(input: List<String>): Int {
        val pairs: List<Pair<String, String>> = input.map { it.replace("\\s+".toRegex(), ",").split(",") }.map { Pair(it[0], it[1]) }
        val lefts = pairs.map { it.first }
        val rights = pairs.map { it.second }
        var count = 0
        lefts.forEach { count += (it.toInt() * rights.count { right -> right == it }) }
        return count
    }

    val testInput = readInput(getTestInput("Day01P1"))
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)
    val input = readInput((getInput("Day01")))
    part1(input).println()
    part2(input).println()
}
