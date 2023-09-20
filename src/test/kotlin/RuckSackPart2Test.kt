import org.junit.jupiter.api.Assertions
import rucksack.RucksackPart2
import kotlin.test.Test
import kotlin.test.assertEquals

class RuckSackPart2Test {
    private val rucksack: RucksackPart2 = RucksackPart2()
    private val fileName = "rucksack.txt"

    @Test
    fun firstInputCalculateTest() {
        val items = listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
        )

        val total = rucksack.calculate(items)
        assertEquals(70, total)
    }

    @Test
    fun textInputCalculateTest() {
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        file.use {
            val total = rucksack.calculate(it?.lines()?.toList())
            val expected = 2716
            Assertions.assertEquals(expected, total)
        }
    }

}