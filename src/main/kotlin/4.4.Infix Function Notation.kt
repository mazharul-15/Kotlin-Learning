// infix function notation

class Math{
    // user-defined infix member function
    infix fun square(n: Int): Int {
        val num = n * n
        return num
    }
}

fun main() {
    //standard library infix function
    standardLibraryInfixFunction()

    //user-defined infix function notation
    userDefinedInfixFunction()
}

fun standardLibraryInfixFunction(){
    var a = 15
    var b = 12
    var c = 11

    // not using infix notation
    var result = (a>b).and(a>c)

    // call using infix notaion
    var result2 = (a>b) and (a>c)

    println("Value of both ways: $result and $result2")
}

fun userDefinedInfixFunction() {
    val obj = Math()
    val result = obj square 9
    println("The result is: $result")
}