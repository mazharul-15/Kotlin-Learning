/*
    This is a Launch Pad = I will practice here the code
    which I have learned yesterday.....
 */

class Student {
    var name: String? = null

}

fun main(args: Array<String>) {
        dataType()
        varibaleDeclaration()
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

fun varibaleDeclaration() {

}