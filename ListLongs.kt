package sorting

import java.util.*

class ListLongs(type: String, inputFileName: String, outputFileName: String) : DataList(type, inputFileName, outputFileName), SorterList {
    override fun fillList(): MutableList<Any> {
        val scan = if (inputFile != null) Scanner(inputFile!!) else Scanner(System.`in`)
        val list = mutableListOf<Any>()
        val listTexts = mutableListOf<String>()
        while (scan.hasNext()) {
            val i = scan.next()
            try {
                list.add(i.toLong())
            } catch (e: Exception) {
                listTexts.add("\"$i\" is not a long. It will be skipped.")
            }
        }
        println(listTexts.joinToString("\n"))
        return list
    }

    override fun sortValue(): List<String> {
        val sortList = list.map { it.toString().toLong() }.sorted()
        return sortList.map { it.toString() }
    }

    override fun fillSortMap(): MutableMap<String, Int> {
        val mapElements = mutableMapOf<Long, Int>()
        for (i in list) {
            val j = i.toString().toLong()
            if (j in mapElements.keys) {
                mapElements[j] = (mapElements[j] ?: 0) + 1
            } else mapElements[j] = 1
        }
        val sortMap = mapElements.toSortedMap()
        val mapString = mutableMapOf<String, Int>()
        for ((k, v) in sortMap) mapString[k.toString()] = v
        return mapString
    }
}