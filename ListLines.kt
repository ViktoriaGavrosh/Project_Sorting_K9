package sorting

import java.util.*

class ListLines(type: String, inputFileName: String, outputFileName: String) : DataList(type, inputFileName, outputFileName), MaxCounter, SorterList {
    override fun fillList(): MutableList<Any> {
        val scan = if (inputFile != null) Scanner(inputFile) else Scanner(System.`in`)
        val list = mutableListOf<Any>()
        while (scan.hasNextLine()) list.add(scan.nextLine())
        return list
    }

    override fun countMaxValue(): Map<String, Any> {    // don`t use
        var maxLine = ""
        val listMax = mutableSetOf<String>()
        var count = 0
        for (i in list) {
            val j = i.toString()
            if (j.length == maxLine.length) {
                count++
                listMax.add(j)
            }
            if (j.length > maxLine.length) {
                maxLine = j
                count = 1
                listMax.clear()
                listMax.add(j)
            }
        }
        val maxVal = "\n${listMax.sorted().joinToString("\n")}\n"
        return mutableMapOf("max" to maxVal, "countMax" to count, "percentage" to countPercentage(count, list.size))
    }

    override fun showMax() {      // don`t use
        val maxValue = countMaxValue()
        println("The longest line: ${maxValue["max"]}(${maxValue["countMax"]} time(s), ${maxValue["percentage"]}%).")
    }

    override fun showSortNatural() {
        val text = "Sorted data:\n${sortValue().joinToString("\n")}"
        if (outputFile != null) outputFile?.appendText("$text\n") else println(text)
    }
}