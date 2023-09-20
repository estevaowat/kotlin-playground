package pairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import java.time.Duration
import java.time.Instant
import kotlin.test.Test

class ElvesPairsTest {
    private val elvesPairs = ElvesPairs()

    @Test
    @DisplayName("Test using a simple input")
    fun testUsingSimpleInput() {
        val start = Instant.now()
        val items = listOf("2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6", "2-6,4-8")
        val total = elvesPairs.calculate(items)
        val expected = 2
        assertEquals(expected, total)
        println("time elapsed = ${Duration.between(start, Instant.now()).toMillis()}ms")
    }

    @Test
    @DisplayName("Test using a text file as input")
    fun testCalculateUsingFileAsInput() {
        val start = Instant.now()
        val fileName = "pairs.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        file.use {
            val total = elvesPairs.calculate(it?.lines()?.toList())
            val expected = 477
            assertEquals(expected, total)
        }
        println("time elapsed = ${Duration.between(start, Instant.now()).toMillis()}ms")
    }
}