package sorting

import kotlin.math.roundToInt

abstract class DataList(private val type: String) : SorterList {
    val list = this.fillList()

    abstract fun fillList(): MutableList<Any>

    override fun showSortByCount() {
        val map = fillSortMap()
        val sortMap = map.toList().sortedBy { (_, value) -> value }.toMap()
        for ((k, v) in sortMap) {
            println("$k: $v time(s), ${(100.0 / list.size * v).roundToInt()}%")
        }
    }

    override fun showSortNatural() {
        println("Sorted data: ${this.sortValue().joinToString(" ")}")
    }

    internal open fun fillSortMap(): MutableMap<String, Int> {
        val mapElements = mutableMapOf<String, Int>()
        for (i in list) {
            val j = i.toString()
            if (j in mapElements.keys) {
                mapElements[j] = (mapElements[j] ?: 0) + 1
            } else mapElements[j] = 1
        }
        return mapElements.toSortedMap()
    }

    internal open fun sortValue(): List<String> {
        return list.map { it.toString() }.sorted()
    }

    fun showTotalElements() {
        println("Total ${if (type == "long") "number" else type}s: ${list.size}.")
    }
}