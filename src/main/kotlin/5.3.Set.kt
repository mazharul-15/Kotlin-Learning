// Set: Set is a collection that does not allow duplicates

fun main() {
    setDeclaration()
    setAllOperations()
}

fun setDeclaration() {
    // immutable set
    val set1 = setOf("A", "A", "B", "B", "C")
    val set2 = setOf<String>("A", "A", "B", "B", "C")
    val set3: Set<String> = setOf("I", "Love", "I", "Love", "BD")
    val set4 = setOf<String>() // empty set

    println("Set1: $set1")
    println("Set2: $set2")
    println("Set3: $set3")
    println("Set4: $set4")

    // mutable set
    val setM1 = mutableSetOf("A", "X", "B", "A", "X")
    val setM2 = mutableSetOf<String>("I", "I", "Love", "BD")
    val setM3: MutableSet<String> = mutableSetOf("B", "C", "B", "C", "D", "E")
    val setM4 = mutableSetOf<String>() // empty mutable set

    println("SetM1: $setM1")
    println("SetM2: $setM2")
    println("SetM3: $setM3")
    println("SetM4: $setM4")

    // hash set
    val hashSet1 = hashSetOf<String>("AA", "BB", "CC", "DD", "AA", "1", "1")
    val hashSet2 = hashSetOf("A", "B", "C", "D")

    println("Hash Set1: $hashSet1")
    println("Hash Set2: $hashSet2")
}

fun setAllOperations() {
    // adding element into set
    val setM1 = mutableSetOf<String>("A", "1", "A")
    setM1.add("B")
    setM1.add("B")
    println("After adding: $setM1")
    setM1.addAll(listOf("D", "D", "E", "F"))
    println("After adding all: $setM1")

    // removing element from set & clear
    val setM2 = mutableSetOf<String>("A", "B", "A", "C", "D", "E", "F")
    println("Before removing: $setM2")
    setM2.remove("A")
    println("After removing: $setM2")
    setM2.removeAll(listOf("A", "B", "C"))
    println("After removing all: $setM2")
    setM2.clear()
}