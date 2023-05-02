package sorting

import java.util.*

class ListLongs(type: String) : DataList(type), MaxCounter, SorterList {
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

    override fun sortValue(): List<String> {
        val sortList = list.map { it.toString().toLong() }.sorted()
        return sortList.map { it.toString() }
    }

    override fun fillSortMap(): MutableMap<String, Int> {
        val mapElements = mutableMapOf<Long, Int>()
        for (i in list) {
            val j = i.toString().toLong()
            if (j in mapElements.keys) {
                mapElements[j] = (mapElements[j] ?: 0) + 1
            } else mapElements[j] = 1
        }
        val sortMap = mapElements.toSortedMap()
        val mapString = mutableMapOf<String, Int>()
        for ((k, v) in sortMap) mapString[k.toString()] = v
        return mapString
    }
}