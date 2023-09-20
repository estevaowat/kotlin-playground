package pairs

class ElvesPairs {

    fun calculate(items: List<String>?): Int {
        if (items == null) {
            return 0
        }

        return items.count { item ->
            val left = item.split(",")[0].split("-").map { Integer.parseInt(it) }
            val right = item.split(",")[1].split("-").map { Integer.parseInt(it) }
            left[0] <= right[0] && left[1] >= right[1] || right[0] <= left[0] && right[1] >= left[1]
        }
    }
}