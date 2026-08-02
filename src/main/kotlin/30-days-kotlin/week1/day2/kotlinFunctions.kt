/*
    Kotlin Functions
 */

fun main() {
        // simple function
    sayHello()
    greet()

        // paratermeter passing
    addTwoNumbers(10, 56)  // here 10 and 56 are agruments
    val result = addAndReturnResult(34, 25)
    println("The result is: $result")

        // Default Arguments
    sayWelcome("Hello everybody!!!")

        // Named Arguments
    val isChecked: Boolean = logIN("abc@gmail.com", "admin")
    println("The result: $isChecked")

        // Expression Body Functions
    val areaCircle = circlearea(34.0, 56.0)

        // Local functions
    outer()

        // Naming of funcitons
    studentInfo()
    calculateAverage()
    calculateGrade()
    isPassed()

    calculateSalary()
    calculateTax()
    calculateVat()

    validateInput()
    calculateTotal()
}

fun sayHello() {
    println("This is simple funciton")
}

fun greet() {
    println("Welcome to kotlin!")
}

fun addTwoNumbers(number1: Int, number2: Int) {     // here number1 and number2 are parameters
    val result = number1 + number2
    println("The result: $result")
}

fun addAndReturnResult(number1: Int, number2: Int): Int {
    return (number1 + number2)
}

fun sayWelcome(greeting: String = "Hello buddy!!!") {
    println("The greeting is: $greeting")
}

fun logIN(email: String, password: String): Boolean {
    return (email=="abc@gmail.com" && password=="admin")
}

fun circlearea(base: Double, height: Double) = base * height
//fun circlearea(base: Double, height: Double):Double = base * height

fun outer() {

    fun inner() {
        println("Hello I am inner functions")
    }

    inner()
}

fun studentInfo() {}
fun calculateAverage() {}
fun calculateGrade() {}
fun isPassed() {}

fun calculateTax() {}
fun calculateVat() {}
fun calculateSalary() {}

fun validateInput() {}
fun calculateTotal() {}