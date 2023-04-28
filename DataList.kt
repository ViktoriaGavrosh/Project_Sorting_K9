package sorting

import java.util.*

class DataList(internal val type: String) {
    internal val list = fillList()

    internal fun showTotalElements() {
        println("Total ${if (type == "long") "number" else type}s: ${list.size}.")
    }

    private fun fillList(): MutableList<Any> {
        val scan = Scanner(System.`in`)
        val list = mutableListOf<Any>()
        when(type) {
            "long" -> while (scan.hasNextLong()) list.add(scan.nextLong())
            "line" -> while (scan.hasNextLine()) list.add(scan.nextLine())
            else -> while (scan.hasNext()) list.add(scan.next())
        }
        return list
    }
}