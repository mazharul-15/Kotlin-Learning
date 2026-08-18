/*
    Higher Order Function
 */
fun <T> myFunction(value: T) {
    println(value)
}

fun myFunciton2(value: Any) {
    println(value)
}

fun main() {
    // <T> type function
    myFunction("Abir")
    myFunction(123)
    myFunction('A')
    myFunction(456.234)

    // Any type funciton
    myFunciton2("Abir")
    myFunciton2(123)
    myFunciton2('A')
    myFunciton2(456.234)
}