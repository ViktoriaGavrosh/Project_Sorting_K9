package sorting

abstract class DataList(private val type: String) {
    val list = this.fillList()

    fun showTotalElements() {
        println("Total ${if (type == "long") "number" else type}s: ${list.size}.")
    }

    abstract fun fillList(): MutableList<Any>
}