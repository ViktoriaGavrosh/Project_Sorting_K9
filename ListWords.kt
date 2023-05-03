package sorting

import java.util.*

class ListWords(type: String) : DataList(type), MaxCounter, SorterList {

    override fun fillList(): MutableList<Any> {
        val scan = Scanner(System.`in`)
        val list = mutableListOf<Any>()
        while (scan.hasNext()) list.add(scan.next())
        return list
    }

    override fun countMaxValue(): Map<String, Any> {    // don`t use
        var max = ""
        val listMax = mutableSetOf<String>()
        var count = 0
        for (i in list) {
            val j = i.toString()
            if (j.length == max.length) {
                count++
                listMax.add(j)
            }
            if (j.length > max.length) {
                    max = j
                    count = 1
                    listMax.clear()
                    listMax.add(j)
            }
        }
        val maxVal = listMax.sorted().joinToString()
        return mutableMapOf("max" to maxVal, "countMax" to count, "percentage" to countPercentage(count, list.size))
    }

    override fun showMax() {     // don`t use
        val maxValue = countMaxValue()
        println("The longest word: ${maxValue["max"]} (${maxValue["countMax"]} time(s), ${maxValue["percentage"]}%).")
    }
}