import calories.ElfCaloriesCalculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class ElfCaloriesCalculatorTest {
    private val elfCaloriesCalculator = ElfCaloriesCalculator()

    @Test
    @DisplayName("Given a list with calories should calculate total of calories")
    fun givenAListWithCaloriesByElfsShouldCalculateTotalOfCaloriesThatAElfNeeds() {
        val fileName = "calories.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        var totalOfCalories: Int
        file.use {
            totalOfCalories = elfCaloriesCalculator.calculateTotalCalories(file?.lines())
        }
        val caloriesExpected = 71300
        Assertions.assertEquals(caloriesExpected, totalOfCalories)

    }


    @Test
    @DisplayName("When file is empty should return 0 calories")
    fun whenFileIsEmptyShouldReturn0Calories() {
        val fileName = "empty_file.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        var totalOfCalories: Int

        file.use {
            totalOfCalories = elfCaloriesCalculator.calculateTotalCalories(it?.lines())
        }

        val caloriesExpected = 0
        Assertions.assertEquals(caloriesExpected, totalOfCalories)


    }


    @Test
    @DisplayName("calculateSumOf3ElvesWithMostCalories")
    fun calculateSumOf3ElvesWithMostCalories() {
        val fileName = "calories.txt"
        val file = this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()
        var totalOfCalories: Int
        file.use {
            totalOfCalories = elfCaloriesCalculator.calculateSumOfElvesWithMostCaloriesDesceding(file?.lines(), 3)
        }
        val caloriesExpected = 209691
        Assertions.assertEquals(caloriesExpected, totalOfCalories)
    }
}