import org.junit.jupiter.api.Assertions.assertEquals
import rucksack.Rucksack
import kotlin.test.Test

class RucksackTest {
    private val rucksack: Rucksack = Rucksack()
    private val fileName = "rucksack.txt"

    @Test
    fun firstInputCalculate() {
        val expected = 157
        val input = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

        val total = rucksack.calculate(input)
        assertEquals(expected, total)
    }

    @Test
    fun testCalculateUsingFileAsInput() {
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        file.use {
            val total = rucksack.calculate(it?.lines()?.toList())
            val expected = 7967
            assertEquals(expected, total)
        }
    }
}