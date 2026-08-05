/*
    Arrays in Kotlin
    Array is a collection of elements stored in contiguous memory location
    Array is not dynamic. It is fixed size
 */

fun main() {
        // 1. primitive array creating
    val numbers = arrayOf(34, 12, 9, 0, -11, 32)
    val names =arrayOf(
        "Abdul",
        "karim",
        "Mahbub",
        "kamal"
    )

    val ageList = IntArray(10)
    val salaryList = intArrayOf(12200, 45000, 23400, 50000)

    println(numbers.contentToString())

        // 2. explicit type
    val numbersList: Array<Int> = arrayOf(13, 10, 45, 0, -99, 34, 76)
    println(numbersList.contentToString())

        // 3. upadating array
    numbers.set(2, -9999)
    numbers[5] = -9876542
    println("After set -9999: ${numbers.contentToString()}")

        // 4. array size
    println("Numbers array size: ${numbers.size}")

        // 5. iterating array
    for(element in numbers) {
        print("$element ")

    }
    println()

    for(i in numbers.indices) {
        print("${numbers[i]} ")
    }
    println()

    for((index, value) in numbers.withIndex()) {
        println("$index ->. $value")
    }

    numbers.forEach { print("$it ") }
    println()

        // 6. common array function
    println("Contain specific value: ${numbers.contains(34)}")
    println("Sorted Array: ${numbers.sortedArray().contentToString()}")
}