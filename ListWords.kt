package sorting

import java.util.*

class ListWords(type: String, inputFileName: String, outputFileName: String) : DataList(type, inputFileName, outputFileName), SorterList {

    override fun fillList(): MutableList<Any> {
        val scan = if (inputFile != null) Scanner(inputFile) else Scanner(System.`in`)
        val list = mutableListOf<Any>()
        while (scan.hasNext()) list.add(scan.next())
        return list
    }
}