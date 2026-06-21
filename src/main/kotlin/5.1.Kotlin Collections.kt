/*
    Kotlin Collections: are a number of ways to store data.

    There are four types of collections:
       1. List: stores data in order and allow duplicates

       2. ArrayList: stores data in order, mutable, allow duplicate, size dynamic
                List and ArrayList almost same characteristics

       3. Set: stores data in unordered, not allow duplicate

       4. Map: store data in key-value pair
 */

fun main(agrs: Array<String>) {
    listCollection()
    arrayListCollection()
    setCollection()
    mapCollection()
}

fun listCollection() {
    var ls: List<String> = listOf()


    var ls2: MutableList<String> = mutableListOf()
    var studentList: List<Any> = listOf(1, "2", 1.2f, 3.4, 'A', "ABC")

    for(el in studentList) print("$el "); println("\n")
}

fun arrayListCollection() {
    var arrList: ArrayList<String> = arrayListOf()
    arrList.add("12")

    var arrList2: ArrayList<Any> = arrayListOf()
    arrList2.add(1)
    arrList2.add("A")
    arrList2.add(3)
    arrList2.add('A')

    for(el in arrList2) print("$el "); println("\n")
    arrList2.forEach { it -> print("$it ") }; println("\n")
}

fun setCollection() {

    var set1: Set<String> = setOf("A", "B", "ANDF")

    var set2: MutableSet<Any> = mutableSetOf()
    set2.add(1)
    set2.add("ART")

    for(el in set2) print("$el "); println("\n")

}

fun mapCollection() {

    var map1: Map<Int, String> = mapOf(
        1 to "Abc",
        2 to "CBC",
        3 to "DBC"

    )

    var map2: MutableMap<Any, Any> = mutableMapOf()

    map2.put(2, 23)
    map2.put("Abc", 123)

    for((key, value) in map1) {
        println("$key  -> $value")
    }
}