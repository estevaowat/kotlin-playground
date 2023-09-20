package rockpaperScissor

import java.time.Duration
import java.time.Instant
import java.util.stream.Stream

class RockPaperScissorPart1 {
    private val lose: Short = 0
    private val win: Short = 6
    private val draw: Short = 3
    private val rock: Short = 1
    private val paper: Short = 2
    private val scissor: Short = 3
    private val delimiter: String = " "


    fun calculate(plays: Stream<String>?): Int {
        if (plays == null) {
            return 0
        }
        val start: Instant = Instant.now()
        val resultPlay = mutableMapOf<String, Int>()

        var result = 0
        plays.forEach { play ->
            run {
                var cachedResult = resultPlay[play]
                if (cachedResult == null) {
                    cachedResult = calculatePlay(play)
                    resultPlay[play] = cachedResult
                }

                result += cachedResult
            }
        }

        println("Time elapsed ${Duration.between(start, Instant.now()).toMillis()}ms")
        return result
    }

    private fun calculatePlay(play: String): Int {
        val myPlay = play.split(delimiter)[1]
        val myPlayPoints = definePointsOfMyPlay(myPlay)
        val roundPoints = definePointsOfRound(play)
        return myPlayPoints + roundPoints

    }

    private fun definePlayerPoints(): Map<String, Short> {
        val playValue = mutableMapOf<String, Short>()

        playValue["X"] = rock
        playValue["Y"] = paper
        playValue["Z"] = scissor
        return playValue;

    }

    private fun definePointsOfMyPlay(play: String?): Short {
        val playerPoints = definePlayerPoints()

        if (play == null) {
            return 0
        }

        return playerPoints[play] ?: return 0
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