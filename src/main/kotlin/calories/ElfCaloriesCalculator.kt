package calories

import java.util.stream.Stream

class ElfCaloriesCalculator {
    fun calculateTotalCalories(calories: Stream<String>?): Int {
        if (calories == null) {
            return 0
        }

        val elfTotalCalories = HashMap<Int, Int>()
        var elf = 1

        calories.forEach { calorie ->
            if (calorie == "") {
                elf++
                return@forEach
            }

            var elfCalories: Int? = elfTotalCalories[elf]

            if (elfCalories == null) {
                elfCalories = 0
            }

            elfTotalCalories[elf] = elfCalories + Integer.parseInt(calorie)
        }


        if (elfTotalCalories.isEmpty()) {
            return 0
        }

        return elfTotalCalories.values.max()
    }

    fun calculateSumOfElvesWithMostCaloriesDesceding(calories: Stream<String>?, size: Long): Int {
        if (calories == null) {
            return 0
        }

        val elfTotalCalories = HashMap<Int, Int>()
        var elf = 1

        calories.forEach { calorie ->
            if (calorie == "") {
                elf++
                return@forEach
            }

            var elfCalories: Int? = elfTotalCalories[elf]

            if (elfCalories == null) {
                elfCalories = 0
            }

            elfTotalCalories[elf] = elfCalories + Integer.parseInt(calorie)
        }


        if (elfTotalCalories.isEmpty()) {
            return 0
        }

        val caloriesSorted = elfTotalCalories.values.sortedDescending()

        return caloriesSorted.stream().limit(size)
            .reduce(0) { accumulator, cur -> accumulator + cur }
    }
}