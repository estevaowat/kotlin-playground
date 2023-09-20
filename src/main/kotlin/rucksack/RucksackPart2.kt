package rucksack

import java.time.Duration
import java.time.Instant

class RucksackPart2 {
    private val priorityMap = mutableMapOf<String, Int?>()

    init {
        createPriorityMap()
    }

    fun calculate(items: List<String>?): Int? {
        if (items == null) {
            return 0
        }
        val start = Instant.now()


        val delimiter = ""
        val priorities = mutableListOf<String>()
        val step = 3

        for (i in items.indices step step) {
            val last = i + step - 1
            var letters = items[last].split(delimiter).drop(1).dropLast(1).toMutableSet()

            for (j in last - 1 downTo i) {
                val priority = items[j].split(delimiter).drop(1).dropLast(1).toMutableSet()
                letters = priority.filter { letters.contains(it) }.toMutableSet()
            }
            priorities.addAll(letters)
        }

        val total = priorities.map { letter -> priorityMap[letter] }
            .reduce { acc, value -> acc?.plus(value ?: 0) }

        println("time elapsed = ${Duration.between(start, Instant.now()).toMillis()}ms")

        return total
    }

    private fun createPriorityMap() {
        for (letter in 'a'..'z') {
            val priority = letter - 'a' + 1
            priorityMap[letter.toString()] = priority
        }

        for (letter in 'A'..'Z') {
            val priority = letter - 'A' + 27
            priorityMap[letter.toString()] = priority
        }
    }

}