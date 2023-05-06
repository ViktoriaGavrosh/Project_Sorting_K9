package sorting

import java.util.*

class ListLines(type: String, inputFileName: String, outputFileName: String) : DataList(type, inputFileName, outputFileName), SorterList {
    override fun fillList(): MutableList<Any> {
        val scan = if (inputFile != null) Scanner(inputFile!!) else Scanner(System.`in`)
        val list = mutableListOf<Any>()
        while (scan.hasNextLine()) list.add(scan.nextLine())
        return list
    }

    override fun showSortNatural() {
        val text = "Sorted data:\n${sortValue().joinToString("\n")}"
        if (outputFile != null) outputFile?.appendText("$text\n") else println(text)
    }
}