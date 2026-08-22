/*
    Kotlin Generics
 */

// generic function
fun <T> printValue(value: T) {
    println("The value is : $value")
}

// generic function returning a value
fun <T> getValue(value: T): T {
    return value
}

// generic with two types
fun <T, R> createPair(first: T, second: R): Pair<T, R> {
    return Pair(first, second)
}

// generic classes
class Box<T>(
    val value: T
)


fun main() {
    // generic function
    printValue(100)
    printValue("Abir")
    printValue(23.4)
    printValue(true)
    printValue('C')
    printValue(12.09f)

    // generic function returning a value
    val name = getValue("Mazharul")
    val age = getValue(31)
    println("The name: $name and age: $age")

    // generic with two types
    val result = createPair("Abir", 123)
    println(result.first)
    println(result.second)

    // generic classes
    val intBox = Box(100)
    val stringBox = Box("Abir")
    println("Value: ${intBox.value}")
}