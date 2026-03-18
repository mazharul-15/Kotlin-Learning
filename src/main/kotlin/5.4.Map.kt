// Map: A Map stores data in key-value pairs

fun main() {
    mapDeclaration()
    mapAllOperations()
}

fun mapDeclaration() {
    val map1 = mapOf(1 to "A", 5 to "A", -1 to "ABC")
    val map2 = mapOf<Int, String>(12 to "Love", 34 to "Man")
    println("Map: $map1")

    val map3 = mapOf<String, Int>(
        "A" to 1234,
        "C" to 569
    )

    val map4 = mutableMapOf<Any, Any>(
        12 to "ABC",
        -9 to "BD",
        "M" to 45,
        "NHJK" to "Samnge"
    )

    val mapHash = hashMapOf<String, String>(
        "Name" to "Zahid",
        "Age" to "32",
        "Id" to "1802034",
        "Subject" to "CSE"
    )
}

fun mapAllOperations() {
    // adding value
    val map1 = mutableMapOf<Int, String>()
    map1.put(2, "A")
    map1[2]= "B"
    map1.putAll(mapOf(
        4 to "AB",
        6 to "CD"
    ))

    println("After adding value: $map1")

    // converting map

        // List to Map
    val  list = listOf<String>("A", "B", "C", "D")
    val map = list.associateWith{ it.length }
    println("List to Map: $map")
}