/*
    Kotlin fundamental review: Variables, Data-Types, Operators, Control Flow, Loops)
 */

fun main() {
        // Variables
    // 1. val(Read Only)
    var number = 12

    // 2. var(Mutable)
    var student = "Akash Tah"
    println("$number and $student")

        // Data Types
    val age: Int = 23
    val salary: Double = 33000.23
    val grade: Char = 'A'
    val isPassed: Boolean = true
    val name: String = "Ibrahim Molla"

    println("$age and $salary and $grade and $isPassed and $name")

        // Operators
    val number1 = 5
    val number2 = 4
    val sum = number1 + number2
    println("Add of two numbers: $sum")


        // Control Flow
    if(age >= 34) {
        println("The man is old")
    } else {
        println("The man is young")
    }

    val result = if(age >= 35) "Adult" else "Young"
    println("$result")

    val day = 3
    when(day) {
        1 -> println("saturday")
        2 -> println("sunday")
        3 -> println("monday")
        4 -> println("tuesday")
        else -> println("Invalid")
    }

    val output = when(day) {
        1 -> "saturday"
        2 -> "sunday"
        3 -> "monday"
        4 -> "tuesday"
        5 -> "wednesday"
        6 -> "thursday"
        7 -> "friday"
        else -> "invalid"
    }

    println("$output")


        // loops
    for(i in 1..5){
        println("$i")
    }

    for(i in 1 until 5){
        println("$i")
    }

    for(i in 5 downTo 1){
        println("$i")
    }

    for(i in 1..5 step 2){
        println("$i")
    }

    var i = 1
    while(i < 5){
        println("while:$i")
        i++
    }

    var j = 1
    do{
        println("do: $j")
        j++
    }while(j<5)
}