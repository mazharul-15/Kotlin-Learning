/*

 */

fun main() {
    doWhileLoop()
}

fun doWhileLoop() {

    //finding factorial of a number
    do {
        var factorial = 1
        var number: Int
        print("Enter a number: ")
        number = readLine()!!.toInt()

        do {
            factorial *= number
            number--
        }while(number > 0)

        println("The factorial is:  $factorial")
    }while(true)
}