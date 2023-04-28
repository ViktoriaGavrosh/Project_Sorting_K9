package sorting

import java.util.Scanner

fun main(args: Array<String>) {
    val list =
        try {
            fillList(args[3])
        } catch (e: Exception) {
            fillList("word")
        }
    println("Total numbers: ${list.size}.")
    /*val counter = Counter(list)
    val maxVal = counter.countMaxValue()
    println("The greatest number: ${maxVal["max"]} (${maxVal["countMax"]} time(s)).")*/
}

fun fillList(type: String): MutableList<Any> {
    val scan = Scanner(System.`in`)
    val list = mutableListOf<Any>()
    when(type) {
        "long" -> while (scan.hasNextLong()) list.add(scan.nextLong())
        "line" -> while (scan.hasNextLine()) list.add(scan.nextLine())
        else -> while (scan.hasNext()) list.add(scan.next())
    }
    return list
}

