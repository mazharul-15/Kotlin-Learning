// List of Kotlin Collections

fun main(args: Array<String>) {
    listCreation()
    allOperatonOfList()
    //immutableList()
    //mutableList()
}

fun listCreation() {

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

    // list with any type
    val listAny = mutableListOf<Any>(1, "A", "c", true, 45)
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

    var anyTypeList: List<Any> = listOf(1, "1", 'A', 1.2f, "BD", 1.3)
    for(el in  anyTypeList) print("$el ")
    println("\n")
    anyTypeList.forEach { it -> print("$it ") }
    println("\n")

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
    println("The size of list: " + allList3.size)
    println("The empty function: " + allList3.isEmpty())
    println("The not empty function: " + allList3.isNotEmpty())
    println("The contains function: " + allList3.contains("C"))
    println("The all contains function: " + allList3.containsAll(listOf("A", "D", "E")))


    // loop operations
    val allList4 = mutableListOf<String>("A", "B", "C", "D", "E", "F")
    for (item in allList4) { print(allList4 + " ") }; println()
    allList4.forEach { print(it + " ")}
    allList4.forEachIndexed { index, value -> println("$index -> $value") }


    // transformation operations (very important)
    val allList5 = mutableListOf<String>("A", "B", "C", "D", "E", "F")
    allList5.map{ it + "X"}
    println("After applying map: $allList5")

    // filtering operation
    val allList6 = mutableListOf<String>("A", "B", "C", "D", "E", "F")
    val newFilteredList = allList6.filter{ it == "A"}
    println("After filtering list: $newFilteredList")

    val notFilteredList = allList6.filterNot { it != "A"}
    println("After not filtering list: $notFilteredList")

    val filterIndexedlist = allList6.filterIndexed { index, value -> index%2 == 0 }
    println("After filterIndexed List: $filterIndexedlist")


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