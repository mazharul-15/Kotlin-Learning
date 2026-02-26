//In Kotlin, the helper function can be used to explicitly convert one data type to another data type
/*

    toByte()
    toShort()
    toInt()
    toLong()
    toFloat()
    toDouble()
    toChar()

    There is No helper function available to convert into boolean type.
 */

fun main() {
    typeCastingFunction()
}

fun typeCastingFunction() {
    var num: Int = 100
    var numL: Long = 98799999999999922
    num = numL.toInt()
    println("After type casting: $num")
    numL = num.toLong()

    var digit: Int = 65
    var ch: Char = digit.toChar()
    println("After type casting: $ch")
}