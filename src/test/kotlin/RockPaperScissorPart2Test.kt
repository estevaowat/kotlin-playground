import org.junit.jupiter.api.DisplayName
import rockpaperScissor.RockPaperScissorPart1
import rockpaperScissor.RockPaperScissorPart2
import kotlin.test.Test
import kotlin.test.assertEquals

class RockPaperScissorPart2Test {
    private val gamePart1 = RockPaperScissorPart1()
    private val gamePart2 = RockPaperScissorPart2()

    @Test
    @DisplayName("given a list of plays should calculate game points")
    fun givenAListOfPlaysShouldCalculateGamePoints() {
        val fileName = "plays.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        val expectedPoints = 12535

        file.use {
            assertEquals(expectedPoints, gamePart1.calculate(it?.lines()))
        }
    }

    @Test
    @DisplayName("given a list of plays should calculate game points using new strategy")
    fun givenListOfPlaysShouldCalculateGamePointsUsingNewStrategy() {
        val fileName = "plays.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        val expectedPoints = 15457

        file.use {
            assertEquals(expectedPoints, gamePart2.calculate(it?.lines()))
        }
    }
}