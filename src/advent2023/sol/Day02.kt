package advent2023.sol

import advent2023.Utils.Companion.getInput
import advent2023.Utils.Companion.getTestInput
import println
import readInput

val validBag = Bag(14, 12, 13)
fun main() {

    fun String.getSubset(): Bag {
        val balls = this.trim().replace(" ", "").replace(" ", "").split(",")
        var red = 0
        var blue = 0
        var green = 0
        balls.forEach {
            with(it) {
                when {
                    contains("red") -> red = removeSuffix("red").toInt()
                    contains("blue") -> blue = removeSuffix("blue").toInt()
                    contains("green") -> green = removeSuffix("green").toInt()
                    else -> {}
                }
            }
        }
        return Bag(blue, red, green)
    }

    fun String.getSubsets(): List<Bag> {
        val subsets: ArrayList<Bag> = ArrayList()
        val rawSubsets = this.trim().replace(" ", "").split(";")
        rawSubsets.forEach { subsets.add(it.getSubset()) }
        return subsets
    }

    fun String.toGame(): Game {
        val row = this.split(":")
        val rawGameId = row[0]
        val rawSubset = row[1]

        val id = rawGameId.removePrefix("Game ").toInt()
        val subsets = rawSubset.getSubsets()
        return Game(id, subsets)
    }

    fun List<String>.getGames(): List<Game> {
        val games: ArrayList<Game> = ArrayList()
        this.forEach { games.add(it.toGame()) }
        return games
    }

    fun part1(input: List<String>): Int {
        val games = input.getGames()

        return games.sumOf { if (it.isValid()) it.id else 0 }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInputP1 = readInput(getTestInput("Day02P1"))
    println("TEST1: ${part1(testInputP1)}")
    check(part1(testInputP1) == 8)

//    val testInputP2 = readInput(getTestInput("Day02P2"))
//    check(part2(testInputP2) == 281)

    val input = readInput(getInput("Day02"))
    part1(input).println()
//    part2(input).println()
}

data class Game(
    val id: Int,
    val subsets: List<Bag>
) {
    fun isValid(): Boolean {
        this.subsets.forEach { subset ->
            if (subset.blue > validBag.blue ||
                subset.red > validBag.red ||
                subset.green > validBag.green
            ) {
                return false
            }
        }
        return true
    }
}

data class Bag(
    val blue: Int,
    val red: Int,
    val green: Int
)