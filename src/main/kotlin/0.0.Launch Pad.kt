/*
    This is a Launch Pad = I will practice here the code
    which I have learned yesterday.....
 */

class Student {
    var name: String? = null
}

fun main(args: Array<String>) {
    basics()
    controlFlow()
    array()
    string()
    functions()
    collections()
    objectOrientedConcept()
    exceptionHandling()
    nullSafetyConcept()
    regexAndRanges()
    javaInteroperability()
    miscellaneous()
}

fun basics() {
    dataType()
}

fun array() {

}

fun string() {

}

fun functions() {

}

fun collections() {

}

fun objectOrientedConcept() {

}

fun exceptionHandling() {

}

fun nullSafetyConcept() {

}

fun regexAndRanges() {

}

fun javaInteroperability() {

}

fun miscellaneous() {

}

fun dataType() {
    //Decimal: Byte(8), Short(16), Int(32), Long(64), Float(32), Double(64)
    //Text: Character(16), String
    //Sequence: Array
    //val = immutable -- read only variable can't change value
    //var = mutable -- can be changed

    val numberInt: Int ? = null
    var num: Int? = null
    println("Number value: $num")


    var name: String? = "Kotlin"
    name = null
    //println("The length: " + name!!.length)
    val number2: Int
    number2 = 100
    println("The number: " + number2)

}

fun variableDeclare() {

    val number: Int?
    number = null
    var number2: Int? = null
    var fnum: Float? = null
    //fnum = readLine()!!.toFloat()
    println("The value: $fnum")
}

fun controlFlow() {
    println("//Now We are in controlFlow function//")
    // way 1
    val result: Int
    print("Enter your result: ")
    result = readLine()!!.toInt()
    if(0<result && result<33) println("Grade: F")
    else if(32<result && result<40) println("Grade: D")
    else if(39<result && result<50) println("Grade: C")
    else if(49<result && result<60) println("Grade: B")
    else if(59<result && result<70) println("Grade: A-")
    else if(69<result && result<80) println("Grade: A")
    else if(79< result && result<101) println("Grade: A+")
    else println("Grade: You have entered Invalid Number")

    // way 2
    print("Enter result: ")
    val result2 = readLine()!!.toInt()
    if(result2 in 0..32) println("Grade: F")
    else if(result2 in 33..39) println("Grade: D")
    else if(result2 in 40..49) println("Grade: C")
    else if(result2 in 50..59) println("Grade: B")
    else if(result2 in 60..69) println("Grade: A-")
    else if(result2 in 70..79) println("Grade: A")
    else if(result2 in 80..100) println("Grade: A+")
    else println("Invalid Number")

    // Way 3
    print("Enter your result: ")
    val result3 = readLine()?.toIntOrNull()
    print("Grade Point: ")
    result3?.let {
        if(it in 0..32) println("F")
        else if(it in 33..39) println("D")
        else if(it in 40..49) println("C")
        else if(it in 50..59) println("B")
        else if(it in 60..69) println("A-")
        else if(it in 70..79) println("A")
        else if(it in 80..100) println("A+")
        else print("Invalid Number")
    }?: println("You have entered NULL Value")

    // way 4
    print("Enter your result: ")
    val result4 = readLine()?.toIntOrNull()
    print("Grade: ")
    when(result4) {
        null -> println("You entered NULL???? value")
        in 0..32 -> println("F")
        in 33..39 -> println("D")
        in 40..49 -> println("C")
        in 50..59 -> println("B")
        in 60..69 -> println("A-")
        in 70..79 -> println("A")
        in 80..100 -> println("A+")
        else -> println("Invalid Number Entered")
    }
}