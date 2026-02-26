/*
    for loop:
        1. Range using for loop
        2. Array using for loop
        3. String using for loop
        4. Collections using for loop

*/

fun main() {
    rangeUsingForLoop()
    arrayUsingForLoop()
    stringUsingForLoop()
    collectionUsingForLoop()
}

fun rangeUsingForLoop() {
    for(i in 1..6) {
        print("$i ")
    }
    print("\n")
    for(i in 0..6) {
        print("$i ")
    }
    print("\n")
    for(i in -3..5) {
        print("$i ")
    }
    print("\n")
    // iterate through a range to jump using step n
    for(i in 1 .. 10 step 2) {
        print("$i ")
    }
    print("\n")
    // iterate through a range to down ward using downTo
    for(i in 10 downTo 1) {
        print("$i ")
    }
    print("\n")
    for(i in 10 downTo 1 step 2) {
        print("$i ")
    }
    print("\n")
}

fun arrayUsingForLoop() {
    // traversing an array without using index property
    val arr = arrayOf(10, 23, 45, 78, 100, 12)
    for(num in arr) {
        print("$num ")
    }
    print("\n")

    // traversing an array using index property
    val arr2 = arrayOf("Alice", "Bob", "Topu", "Zohir")
    for(i in arr2.indices) {
        print(arr2[i])
        print(" ")
    }
    print("\n")

    // traversing an array using withIndex() Library function
    for((index, value) in arr2.withIndex()) {
        println("Value: $index and index: $value")
    }
    print("\n")

}

fun stringUsingForLoop(){
    val str: String = "Geeeks"
    val str2: String = "GeeksforGeeks"

    for(chr in str) {
        print("$chr ")
    }
    print("\n")

    for(i in str.indices) {
        print(str[i])
        print(" ")
    }
    print("\n")

    for((index, value) in str2.withIndex()) {
        println("$index -> $value")
    }
}

fun collectionUsingForLoop() {
    val nameList = listOf(1, 3, "Momu", "Alice", "Bob", "Peter", 34, 56.7f, "BD")
    for(element in nameList) {
        print("$element ")
    }
    print("\n")
}