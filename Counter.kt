package sorting

import kotlin.math.roundToInt

class Counter(private val dataList: DataList) {

    internal fun showMax() {
        val maxValue = countMaxValue()
        val text =
            when(dataList.type) {
                "long" -> "greatest number"
                "line" -> "longest line"
                else -> "longest word"
            }
        println("The $text: ${maxValue["max"]} (${maxValue["countMax"]} time(s), ${maxValue["percentage"]}%).")
    }

    private fun countMaxValue(): Map<String, Any> {
        var max = 0L
        var maxLine = ""
        var count = 0
        if (dataList.type == "long") {
            max = dataList.list[0].toString().toLong()
            for (i in 1..dataList.list.lastIndex) {
                val j = dataList.list[i].toString().toLong()
                when {
                    j > max -> {
                        max = j
                        count = 1
                    }
                    j == max -> count++
                }
            }
        } else {
            for (i in dataList.list) {
                val j = i.toString()
                when {
                    j.length > maxLine.length -> {
                        maxLine = j
                        count = 1
                    }
                    j.length == maxLine.length -> count++
                }
            }
        }
        val maxVal = if (dataList.type == "long") max else maxLine
        return mutableMapOf("max" to maxVal, "countMax" to count, "percentage" to countPercentage(count))
    }

    private fun countPercentage(countMax: Int) = (100.0 / dataList.list.size * countMax).roundToInt()
}