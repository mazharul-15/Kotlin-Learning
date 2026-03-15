// Map: A Map stores data in key-value pairs

fun main() {
    mapDeclaration()
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
}