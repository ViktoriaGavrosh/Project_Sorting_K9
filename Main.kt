package sorting

import java.util.Scanner

fun main() {
    val list = fillList()
    println("Total numbers: ${list.size}.")
    val counter = Counter(list)
    val maxVal = counter.countMaxValue()
    println("The greatest number: ${maxVal["max"]} (${maxVal["countMax"]} time(s)).")
}

fun fillList(): MutableList<Any> {
    val scan = Scanner(System.`in`)
    val list = mutableListOf<Any>()
    while (scan.hasNext()) list.add(scan.next())
    return list
}

