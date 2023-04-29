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
        val space = if (dataList.type == "line") "" else " "
        println("The $text: ${maxValue["max"]}$space(${maxValue["countMax"]} time(s), ${maxValue["percentage"]}%).")
    }

    private fun countMaxValue(): Map<String, Any> {
        var max = 0L
        var maxLine = ""
        val listMax = mutableSetOf<String>()
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
                        listMax.clear()
                        listMax.add(j)
                    }
                    j.length == maxLine.length -> {
                        count++
                        listMax.add(j)
                    }
                }
            }
        }
        val maxVal =
            when (dataList.type) {
                "long" -> max
                "word" -> listMax.sorted().joinToString()
                else -> "\n${listMax.sorted().joinToString("\n")}\n"
            }
        return mutableMapOf("max" to maxVal, "countMax" to count, "percentage" to countPercentage(count))
    }

    private fun countPercentage(countMax: Int) = (100.0 / dataList.list.size * countMax).roundToInt()
}