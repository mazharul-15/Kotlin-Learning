/*
   Data Type:
            Int, Float, Double
            Char, String
            Boolean
 */

fun main(args: Array<String>) {
    DataTypeAndVariable()
    operatorAll()
    controlFlow()
    functions()
    arrayAll()
    stringAll()

}

fun DataTypeAndVariable() {
    val number12: Int = 12
    var number13: Int = readLine()!!.toInt()
    var number14 = readLine()?.toInt()

}

fun operatorAll() {

}

fun controlFlow() {

}

fun functions() {

}

fun arrayAll() {

}

fun stringAll() {

}

// functions
fun addTwo(num1: Int, num2: Int): Int = num1 + num2

fun addTwo2(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun namedArgument(userName: String, password: String, email: String, username: String, Password: String, Email: String): Boolean {
    return (userName==username && password==Password && email==Email)
}

fun checkAdmin(userName: String, password: String, email: String): Boolean {
    return (userName == "Admin" &&
            password == "Pi12aDmIn" &&
            email == "admin@gmail.com")
}