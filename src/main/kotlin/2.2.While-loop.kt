/*

 */

fun main() {
    whileLoop()
    factorialUsingWhileLoop()
    arrayPrintingUsingWhileLoop()
}

fun whileLoop() {
    var i = 0

    while (i <= 10) {
        println("Programming is like a habit!!!!")
        i++
    }
}

fun factorialUsingWhileLoop() {

    while(true) {
        var factorial = 1
        var number: Int
        print("Enter a number: ")
        number = readLine()!!.toInt()

        while(number > 0) {
            factorial *= number
            number--
        }
        println("The factorial is: $factorial")
    }
}

fun arrayPrintingUsingWhileLoop() {
    val arr = arrayOf("Programming", "is", "Like", "building", "a", "habit")
    var index = 0

    while(index < arr.size) {
        println(arr[index])
        index++
    }
}