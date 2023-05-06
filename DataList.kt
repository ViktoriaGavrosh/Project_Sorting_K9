package sorting

import java.io.File
import kotlin.math.roundToInt

abstract class DataList(private val type: String, inputFileName: String, outputFileName: String) : SorterList {
    val list = this.fillList()
    internal var inputFile: File?
    internal var outputFile: File?
    init {
        inputFile = if (inputFileName != "") File(inputFileName) else null
        outputFile = if (outputFileName != "") File(outputFileName) else null
        outputFile?.writeText("")
    }

    abstract fun fillList(): MutableList<Any>

    override fun showSortByCount() {
        val map = fillSortMap()
        val sortMap = map.toList().sortedBy { (_, value) -> value }.toMap()
        for ((k, v) in sortMap) {
            val text = "$k: $v time(s), ${(100.0 / list.size * v).roundToInt()}%"
            if (outputFile != null) outputFile?.appendText("$text\n") else println(text)
        }
    }

    override fun showSortNatural() {
        val text = "Sorted data: ${this.sortValue().joinToString(" ")}"
        if (outputFile != null) outputFile?.appendText("$text\n") else println(text)
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
        val text = "Total ${if (type == "long") "number" else type}s: ${list.size}."
        if (outputFile != null) outputFile?.appendText("$text\n") else println(text)
    }
}