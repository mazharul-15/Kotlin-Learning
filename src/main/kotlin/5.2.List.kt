// List of Kotlin Collections

fun main(args: Array<String>) {
    listCration()
    allOperatonOfList()
    //immutableList()
    //mutableList()
}

fun listCration() {

    // immutable list creation
    val immutableList = listOf<String>() // empty list
    val immutableList2: List<String> = listOf()  // empty list
    val immutableList3 = listOf<String>("I", "Love", "My", "Country")

    // mutable list creation
    val list = mutableListOf("I", "Love", "My", "Bangladesh")
    val newList = mutableListOf<String>("I", "Love", "My", "Bangladesh")
    val newList2: MutableList<String> = mutableListOf("I", "Love", "My", "Bangladesh")
    val newEmptyList = mutableListOf<String>() // empty list
    val newEmptyList2: MutableList<String> = mutableListOf() // empty list
}

fun allOperatonOfList() {

    // list declaration & taking input from keyboard
    var listV = listOf<String>()

    listV = readLine()!!
        .split(" ")
    println(listV)

    var listV2 = mutableListOf<String>()
    listV2 = readLine()!!
        .split(" ")
        .toMutableList()
    println(listV2)

    listV2.add("Love my Country Bangldesh!!")
    listV2.add("I love my University!!!!")
    println("After adding the list: " + listV2)

    // Empty list declaration
    val list = listOf<String>()
    val listMutable = mutableListOf<String>()

    // adding to empty list
    listMutable.add("This")
    listMutable.addAll(listOf("is the Mutable list"))
    println("Empty List: " + listMutable)

    // removing item for the list
    val allList = mutableListOf<String>("A", "B", "C", "D", "E", "F")

    allList.remove("B")
    println("After removing the list: " + allList)
    allList.removeAt(3)
    println("After removing the list: " + allList)
    allList.removeAll(listOf("A", "E", "F"))
    println("After removing the list: " + allList)
    allList.clear()
    if(allList.isEmpty()) println("YES the list is empty!!!")

    // accessing & updating the elemnet
    val allList2 = mutableListOf<String>("A", "B", "C", "D", "E", "F")
    println("Accessng the list: ${allList2[1]} and ${allList2.get(1)} and ${allList2.first()} and ${allList2.last()} and ${allList2.elementAt(2)}")
    allList2[1] = "New Value"
    allList2.set(1, "New Value2")
    println("The list value: " + allList2)

    // size & checking
    val allList3 = mutableListOf<String>("A", "B", "C", "D", "E", "F")


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