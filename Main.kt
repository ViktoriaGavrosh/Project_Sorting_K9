package sorting

fun main(args: Array<String>) {
    val dataList =
    try {
        when(args[1]) {
            "line" -> ListLines(args[1])
            "word" -> ListWords(args[1])
            else -> ListLongs(args[1])
        }
    } catch (e: Exception) {
        ListWords("word")
    }
    dataList.showTotalElements()
    dataList.showMax()
}





