// function :

fun main() {
    normalFunction()
    //lambdaFunction()

}

fun normalFunction() {
    val result = sum(4,5)
    println("The sum is : $result")

    // function return type based
    functionReturnType1()
    println("Function returns String: ${functionReturnType2()}")
    println("Function return type shortform1: ${functionReturnTypeShortForm1()}")
    println("Function return type shortform2: ${functionReturnTypeShortForm2(3,4)}")

    namedArgumentsFunction(password = "$%1243", userName = "admin")

    println("Function with when: ${functionWithWhen(24)}")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun functionReturnType1(): Unit {
    println("I am Happy in my city")
}

fun functionReturnType2(): String {
    val str: String = "Hello! Bangladesh......"
    return str
}

fun functionReturnTypeShortForm1(): String = "I Love my Bangladesh!!!"
fun functionReturnTypeShortForm2(a: Int, b: Int): Int = a + b

fun namedArgumentsFunction(userName: String, password: String) {
    println("Username: $userName and Password: $password")
}

fun functionWithWhen(age: Int): String {
    return when{
        (age < 18) -> "minor"
        (age >= 18) -> "Adult"
        else -> "Senior"
    }
}

fun lambdaFunction() {
    var result = {num1: Int, num2: Int -> (num1+num2)}
}