package sorting

class Sorting(args: Array<String>) {
    private var dataType: String? = null
    private var sortingType: String? = null
    private var isException = false
    private val listDataType = listOf("line", "long", "word")
    private val listSortingType = listOf("natural", "byCount")
    init {
        for (i in args.indices) {
            when (args[i]) {
                "-dataType" -> {
                    try {
                        dataType = checkType(args[i + 1], listDataType)
                    } catch (e: Exception) {
                        println("No data type defined!")
                        isException = true
                        break
                    }
                }
                "-sortingType" -> {
                    try {
                        sortingType = checkType(args[i + 1], listSortingType)
                    } catch (e: Exception) {
                        println("No sorting type defined!")
                        isException = true
                        break
                    }
                }
                in listDataType -> continue
                in listSortingType -> continue
                else -> println("\"${args[i]}\" is not a valid parameter. It will be skipped.")
            }
        }
    }

    fun sortingStart() {
        if (!isException) sortList()
    }

    private fun sortList() {
        val data = dataType ?: "word"
        val sorting = sortingType ?: "natural"
        val dataList =
            when (data){
                "line" -> ListLines("line")
                "word" -> ListWords("word")
                else -> ListLongs("long")
            }
        dataList.showTotalElements()
        if (sorting == "byCount") dataList.showSortByCount() else dataList.showSortNatural()
    }

    private fun checkType(type: String, listType: List<String>): String {
        if (type in listType) return type else throw Exception()
    }
}