package sorting

fun main(args: Array<String>) {
    val dataList =
    try {
        DataList(args[1])
    } catch (e: Exception) {
        DataList("word")
    }
    dataList.showTotalElements()
    val counter = Counter(dataList)
    counter.showMax()
}





