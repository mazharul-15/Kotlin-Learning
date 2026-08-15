/*
    Exception: an unexpected problem that happens while a program is running
 */

fun checkAge(age: Int) {
    if(age < 18) {
        throw Exception("You must be 18 or older")
    }
}

fun main() {

    // try
    try {
        val result = 100 / 0
    } catch (e: Exception) {
        println(e)
        println(e.message)
    }

    // NumberFormatException


   try {
       val answer = "abc".toInt()
   } catch (e: Exception) {
       println(e.message)
   }

    // multiple catch blocks
    try {
        val number = "abc".toInt()
        println(number)
    } catch (e: NumberFormatException) {
        println("Invalid Number")
    } catch (e: ArithmeticException) {
        println("Arithmetic Error")
    } catch (e: Exception) {
        println("Something else went error")
    }

    // finally
    try {
        val number = "bfd".toFloat()
        println(number)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("Programmed Finished")
    }

    // try is an expression
    val number = try {
        "100".toInt()
    } catch (e: NumberFormatException) {
        0
    }

    println(number)

    // throw
    try {
        checkAge(15)
    } catch (e: Exception) {
        println(e.message)
    }

}