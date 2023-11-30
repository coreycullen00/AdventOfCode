package advent2022.sol

import advent2022.Utils.Companion.getInput
import println
import readInput

fun main() {

    fun calculateOutcome(game: Game): Outcome =
        when (game.second) {
            Weapon.ROCK -> when (game.first) {
                Weapon.ROCK -> Outcome.DRAW
                Weapon.PAPER -> Outcome.LOSS
                Weapon.SCISSORS -> Outcome.WIN
                Weapon.UNKNOWN -> Outcome.ERROR
            }

            Weapon.PAPER -> when (game.first) {
                Weapon.ROCK -> Outcome.WIN
                Weapon.PAPER -> Outcome.DRAW
                Weapon.SCISSORS -> Outcome.LOSS
                Weapon.UNKNOWN -> Outcome.ERROR
            }

            Weapon.SCISSORS -> when (game.first) {
                Weapon.ROCK -> Outcome.LOSS
                Weapon.PAPER -> Outcome.WIN
                Weapon.SCISSORS -> Outcome.DRAW
                Weapon.UNKNOWN -> Outcome.ERROR
            }

            Weapon.UNKNOWN -> Outcome.ERROR
        }

    fun getWeapon(s: String): Weapon =
        when (s) {
            "A", "X" -> Weapon.ROCK
            "B", "Y" -> Weapon.PAPER
            "C", "Z" -> Weapon.SCISSORS
            else -> {
                Weapon.UNKNOWN
            }
        }


    fun String.toGame(): Game {
        val s = this.split(" ")
        return Game(first = getWeapon(s[0]), second = getWeapon(s[1]))

    }

    fun List<String>.getGames(): List<Game> {
        val games: ArrayList<Game> = ArrayList()
        this.forEach { games.add(it.toGame()) }
        return games
    }

    fun calculateScore(weapon: Weapon, outcome: Outcome): Int {
        val weaponScore = when (weapon) {
            Weapon.ROCK -> 1
            Weapon.PAPER -> 2
            Weapon.SCISSORS -> 3
            Weapon.UNKNOWN -> throw Exception("Cannot compute score of weapon UNKNOWN")
        }

        val outcomeScore = when (outcome) {
            Outcome.LOSS -> 0
            Outcome.DRAW -> 3
            Outcome.WIN -> 6
            Outcome.ERROR -> throw Exception("Cannot compute score of outcome ERROR")
        }

        return weaponScore + outcomeScore
    }

    fun part1(input: List<String>): Int {
        val games = input.getGames()
        var score: Int = 0
        games.forEach { score += calculateScore(it.second, calculateOutcome(it)) }
        return score
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput(getInput("Day02"))
    part1(input).println()
    part2(input).println()
}


enum class Outcome {
    WIN, DRAW, LOSS, ERROR
}

enum class Weapon {
    ROCK, PAPER, SCISSORS, UNKNOWN
}

typealias Game = Pair<Weapon, Weapon>


