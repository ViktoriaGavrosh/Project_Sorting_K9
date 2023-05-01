package sorting

import kotlin.math.roundToInt

interface MaxCounter {
    fun countMaxValue(): Map<String, Any>

    fun showMax()

    fun countPercentage(countMax: Int, listSize: Int) = (100.0 / listSize * countMax).roundToInt()
}