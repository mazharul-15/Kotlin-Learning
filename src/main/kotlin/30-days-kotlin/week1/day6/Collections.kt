/*
    Collection: is a container that stores multiple objects
 */

fun main() {

        // 1. List
    val list = listOf("ABC", "BCD", "DCM")
    val list2 = mutableListOf("BND", "GVN", "BDY")
    list2.add("HBM")

        // 2. Set
    val set = setOf("Kotlin", "Ruby", "Python")
    val mutableSet  = mutableSetOf("Aminul", "Kamrul", "Boni", "Boni")
    mutableSet.add("Rahman")

        // 3. Map
    val map = mapOf(
        1 to "Apple",
        2 to "Apple",
        3 to "Mango"
    )

    val mutableMap = mutableMapOf(
        1 to "Grow",
        2 to "Apple"
    )
    mutableMap[4] = "Grape"
}