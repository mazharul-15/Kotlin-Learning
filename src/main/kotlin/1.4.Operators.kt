/*

    Arithmetic Operators = are used to perform arithmetic or mathematical operations on the operands
    Relational Operators = are used to compare the values of two operands
    Assignment Operators = are used to assign a value to a variable
    Unary Operators = are used to increment or decrement a value
    Logical Operators = are used to combine two or more conditions or constraints,
                        or to complement the evaluation of the original condition in consideration

    Bitwise Operators =
        signed shift left  = a.shl(bit number)
        signed shift right = a.shr(bit number)
        unsigned shift right = a.ushr(bit number)
        bitwise and = a.and(b)
        bitwise or = a.or(b)
        bitwise xor = a.xor(b)
        bitwise inverse = a.inv()
 */

fun main() {
    arithmeticOperators()
    relationalOperators()
    assignmentOperators()
    unaryOperators()
    logicalOperators()
    bitwiseOperators()
}

fun arithmeticOperators() {
    var num1: Int
    var num2: Int
    println("Enter two integer number:")
    num1 = readLine()!!.toInt()
    num2 = readLine()!!.toInt()

    println("Addition of two numbers: ${num1 + num2}")
    println("Subtraction of two numbers: ${num1 - num2}")
    println("Multiplication of two numbers: ${num1 * num2}")
    println("Division of two numbers: ${num1 / num2}")
    println("Modulus of two numbers: ${num1 % num2}")
}

fun relationalOperators() {

}

fun assignmentOperators() {

}

fun unaryOperators() {

}

fun logicalOperators() {

}

fun bitwiseOperators() {

}