// Lambda Function

fun main() {
    lambdaFunction1()
    lambdaFunctionCallingStyle()
    lambdaFunctionWithOneParameter()
    lambdaFunctionWithoutParameterAndReturn()
    lambdaFunctionWithReturnType()

    anonymousFunctionAndLambdaFunction()

    inlineFunction()
}

fun lambdaFunction1() {
    val add = {a: Int, b: Int -> a + b}
    val add2: (Int, Int) -> Int = {a, b -> a*b}

    println("The value of lambda function: ${add(2, 3)}")
    println("The value of lambda function: ${add2(2, 3)}")

    val namePrint = {println("I am Lambda Function!!!")}
    val namePrint1: () -> Unit = {println("I am Lambda Function!!!")}

    println("The value of lambda function: ${namePrint()}")
    println("The value of lambda function: ${namePrint1()}")

}

fun lambdaFunctionCallingStyle() {
    val sum = {a: Int, b: Int -> a + b}

    val result = sum(4,5)
    val result2 = sum.invoke(4,5)

    println("The value of lambda function: $result and $result2")
}

fun lambdaFunctionWithOneParameter() {
    val multiply: (Int) -> Int = {it * it}
    println("The value of lambda function: ${multiply(4)}")
}

fun lambdaFunctionWithoutParameterAndReturn() {
    val myName = {println("Mazharul Islam")}
    val myName2: () -> Unit = { println("I am a Software Engineer!!!")}

    println("The value of lambda function: ${myName()}")
    println("The value of lambda function: ${myName2()}")
}

fun lambdaFunctionWithReturnType() {
    // lambda returning character
    val charValue = {str: String -> str[0]}
    val charValue2: (String) -> Char = {str -> str[0]}

    println("The value of lambda function: ${charValue("Bangladesh")} and ${charValue2("Bangldesh")}")

    // lambda returning string
    val stringValue = {str: String -> str+"Bangldesh"}
    val stringValue2: (String) -> String = {str -> str + "Bangladesh"}
    println("The value of lambda function: ${stringValue("Hello")} and ${stringValue2("Hello")}")

    // lambda returning array
    val arr = intArrayOf(10, 5, 21, 10)
    val newArr = {arr: IntArray -> arr.map { it*2 }}
    println("The value of lambda function: " + newArr(arr))

    val arr2 = arrayOf(3, 4, 6, 8)
    val newArr2 = {arr: Array<Int> -> arr.map{it * 2}}
    val newArr3: (Array<Int>) -> Array<Int> = {arr -> arr.map{it *2}.toTypedArray()}

    println("The value of lambda function: " + newArr2(arr2))

    // lambda returning list
    val ls = listOf<Int>(11, 13, 17, 19)
    val newLs = {ls: List<Int> -> ls.map{it*3}}
    val newLs2: (List<Int>) -> List<Int> = {ls -> ls.map{it*3}}
    println("The value of lambda function: " + newLs(ls))
    println("The value of lambda function: " + newLs2(ls))
}

fun anonymousFunctionAndLambdaFunction() {
    val sum = fun(a: Int, b: Int): Int {
        return a + b
    }

    println("The value of anonymous function: ${sum(10, 45)}")

}

fun inlineFunction() {

}