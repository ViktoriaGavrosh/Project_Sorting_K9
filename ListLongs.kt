package sorting

import java.util.*

class ListLongs(type: String) : DataList(type), MaxCounter{
    override fun fillList(): MutableList<Any> {
        val scan = Scanner(System.`in`)
        val list = mutableListOf<Any>()
        while (scan.hasNextLong()) list.add(scan.nextLong())
        return list
    }

    override fun countMaxValue(): Map<String, Any> {
        var max = list[0].toString().toLong()
        var count = 0
        for (i in 1..list.lastIndex) {
            val j = list[i].toString().toLong()
            if (j == max) count++
            if (j > max) {
                    max = j
                    count = 1
            }
        }
        return mutableMapOf("max" to max, "countMax" to count, "percentage" to countPercentage(count, list.size))
    }

    override fun showMax() {
        val maxValue = countMaxValue()
        println("The greatest number: ${maxValue["max"]} (${maxValue["countMax"]} time(s), ${maxValue["percentage"]}%).")
    }

    internal fun sortValue(): List<Long> {
        return list.map { it.toString().toLong() }.sorted()
    }
}