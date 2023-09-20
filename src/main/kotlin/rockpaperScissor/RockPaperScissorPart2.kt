package rockpaperScissor

import java.time.Duration
import java.time.Instant
import java.util.stream.Stream

class RockPaperScissorPart2 {
    private val lose: Short = 0
    private val win: Short = 6
    private val draw: Short = 3
    private val rock: Short = 1
    private val paper: Short = 2
    private val scissor: Short = 3
    private val delimiter: String = " "
    private val paperDraw = 1
    private val rockLose = 0
    private val scissorWin = 2


    fun calculate(plays: Stream<String>?): Int {
        if (plays == null) {
            return 0
        }
        val start: Instant = Instant.now()

        var points = 0
        plays.forEach { play ->
            run {
                val opponent = play.split(delimiter)[0]
                val newPlay = changeMyPlay(play)
                val myPlayPoints = definePointsOfMyPlay(newPlay)
                val roundPoints = definePointsOfRound("$opponent $newPlay")
                points += roundPoints + myPlayPoints
            }
        }

        println("Time elapsed = ${Duration.between(start, Instant.now()).toMillis()}ms")
        return points
    }

    private fun changeMyPlay(play: String): String? {
        val playSplitted = play.split(delimiter)
        val oponent = playSplitted[0]
        val myPlay = playSplitted[1]

        val plays = mutableMapOf<String, List<String>>()
        plays["A"] = listOf("Z", "X", "Y")
        plays["B"] = listOf("X", "Y", "Z")
        plays["C"] = listOf("Y", "Z", "X")

        return when (myPlay) {
            "X" -> plays[oponent]?.get(rockLose)
            "Y" -> plays[oponent]?.get(paperDraw)
            "Z" -> plays[oponent]?.get(scissorWin)
            else -> ""
        }
    }

    private fun definePointsOfMyPlay(play: String?): Short {
        val playValue = mutableMapOf<String, Short>()

        playValue["X"] = rock
        playValue["Y"] = paper
        playValue["Z"] = scissor

        if (play == null) {
            return 0
        }

        return playValue[play] ?: return 0
    }

    private fun definePointsOfRound(play: String): Short {
        return when (play) {
            "A X" -> draw
            "A Y" -> win
            "A Z" -> lose
            "B X" -> lose
            "B Y" -> draw
            "B Z" -> win
            "C X" -> win
            "C Y" -> lose
            "C Z" -> draw
            else -> lose
        }
    }
}