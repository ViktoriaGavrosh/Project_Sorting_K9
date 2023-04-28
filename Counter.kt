package sorting

import java.lang.ClassCastException
import kotlin.math.roundToInt

class Counter(private val dataList: DataList) {

    internal fun showMax() {

        val text =
            when(dataList.type) {
                "long" -> "greatest number"
                "line" -> "longest line"
                else -> "longest word"
            }
        println("The $text: ")

        /*val maxVal = counter.countMaxValue()
    println("The greatest number: ${maxVal["max"]} (${maxVal["countMax"]} time(s)).")*/
    }

    private fun countMaxValue(): Map<String, Any> {
        var max = Integer.MIN_VALUE
        var count = 0
        var valueInt: Int
        for (i in dataList.list) {
            val j = i.toString()
            try {
                valueInt = j.toInt()
            } catch (e: ClassCastException) {
                continue
            }
            when {
                valueInt > max -> {
                    max = valueInt
                    count = 1
                }
                valueInt == max -> count++
            }
        }
        return mutableMapOf("max" to max, "countMax" to count, "percentage" to countPercentage(count))
    }

    private fun countPercentage(countMax: Int) = (100.0 / dataList.list.size * countMax).roundToInt()
}