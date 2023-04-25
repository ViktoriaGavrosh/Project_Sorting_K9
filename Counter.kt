package sorting

import java.lang.ClassCastException

class Counter(private val list: MutableList<Any>) {
    fun countMaxValue(): Map<String, Any> {
        var max = Integer.MIN_VALUE
        var count = 0
        var valueInt: Int
        for (i in list) {
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
        return mutableMapOf("max" to max, "countMax" to count)
    }
}