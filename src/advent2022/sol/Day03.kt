package advent2022.sol

import advent2022.Utils.Companion.getInput
import advent2022.Utils.Companion.getTestInput
import println
import readInput

fun main() {

    fun String.splitAtIndex(index: Int) = take(index) to substring(index)

    fun getRucksack(s: String): Rucksack {
        val compartments = s.splitAtIndex(s.length / 2)
        return Rucksack(compartments.first, compartments.second)
    }

    fun calculateValue(c: Char): Int {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) + 1
    }

    fun getPriority(rucksack: Rucksack): Int {
        for (c in rucksack.compartment1) {
            if (rucksack.compartment2.contains(c)) {
                return calculateValue(c)
            }
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        val rucksacks: ArrayList<Rucksack> = ArrayList()
        input.forEach { rucksacks.add(getRucksack(it)) }
        return rucksacks.sumOf { getPriority(it) }
    }

    fun part2(input: List<String>): Int {
        return input.size

    }

    val testInputP1 = readInput(getTestInput("Day03P1"))
    check(part1(testInputP1) == 157)

//    val testInputP2 = readInput(getTestInput("Day03P2"))
//    check(part2(testInputP2) == 2286)

    val input = readInput(getInput("Day03"))
    part1(input).println()
//    part2(input).println()
}

data class Rucksack(
    val compartment1: String,
    val compartment2: String
)