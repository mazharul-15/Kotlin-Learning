// List of Kotlin Collections

fun main(args: Array<String>) {
    //immutableList()
    mutableList()
}

fun immutableList() {
    val ls = listOf("Hajee", "Mohammad", "Danesh", "Science", "and", "Technology", "University")
    val lsNew = listOf<String>("I", "Love", "Bangladesh", "Bro")
    val lsNew2: List<String> = listOf("Android", "Engineer", "Remote","Work from Home-Office")
}

fun mutableList() {
    val ls = mutableListOf("A", "B", "c", "D")
    val lsNew = mutableListOf<String>("Hajee", "Mohammad", "Danesh", "Science", "and", "Technology", "University")
    val lsNew2: MutableList<String> = mutableListOf("I", "Love", "Bangladesh")

    println(lsNew[0])
    println(lsNew.get(1))
}