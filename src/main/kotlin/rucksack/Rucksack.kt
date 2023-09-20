package rucksack

import java.time.Duration
import java.time.Instant

class Rucksack {

    private val delimiter: String = ""
    private val priorityMap = mutableMapOf<String, Int?>()

    init {
        createPriorityMap()
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

    fun calculate(items: List<String>?): Int? {
        if (items == null) {
            return 0
        }
        val start = Instant.now()
        val sameLetters = mutableListOf<String>()

        items.forEach { item ->
            run {
                val mid = item.length / 2
                val left = item.substring(0, mid).split(delimiter).drop(1).dropLast(1)
                val right = item.substring(mid, item.length).split(delimiter).drop(1).dropLast(1)
                val letters = left.filter { letter -> right.contains(letter) }.toMutableSet()
                sameLetters.addAll(letters)
            }
        }

        val total = sameLetters.map { letter -> priorityMap[letter] }
            .reduce { acc, value -> acc?.plus(value ?: 0) }

        println("time elapsed = ${Duration.between(start, Instant.now()).toMillis()}ms")
        return total
    }
}

