package sorting

fun main(args: Array<String>) {
    val dataList =
        try {
            when {
                args.indexOf("line") != -1 -> ListLines("line")
                args.indexOf("word") != -1 -> ListWords("word")
                else -> ListLongs("line")
            }
        } catch (e: Exception) {
            ListWords("word")
        }
    dataList.showTotalElements()
    if (args.indexOf("-sortingType") != -1 && args.indexOf("byCount") != -1) {
        dataList.showSortByCount()
    } else dataList.showSortNatural()
}

/*
if (args.indexOf("-sortIntegers") != -1) {
    val list = ListLongs("long")
    list.showTotalElements()

} else {
*/

