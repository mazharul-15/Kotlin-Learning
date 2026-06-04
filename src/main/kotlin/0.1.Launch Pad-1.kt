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

    var number15: Short = 13
    var number16: Byte = 1

    var bool: Boolean = true

}

fun operatorAll() {

}

fun controlFlow() {

}

fun functions() {
    //check admin
    val result = checkAdmin(
        userName = "admin",
        password = "Pi12aDmIn",
        email = "admin@gmail.com"
    )

    val result2 = checkAdmin(
        userName = "admin",
        password = "Pi12aDmIn",
        email = "admin@gmail.com"
    )

    if(result) {
        println("logged in succesfully!!")
    }
    else {
        println("log in information error!!")
    }

    // lambda functions
    lambdaFunctionsAllTypes()

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

fun namedArgument(userName: String,
                  password: String,
                  email: String,
                  username: String,
                  Password: String,
                  Email: String): Boolean {
    return (userName==username && password==Password && email==Email)
}

fun checkAdmin(userName: String, password: String, email: String): Boolean {
    return (userName == "admin" &&
            password == "Pi12aDmIn" &&
            email == "admin@gmail.com")
}

fun lambdaFunctionsAllTypes() {
    /*
       variableName = { parameter   ->  Body }

       variableName(parameter passing)
     */
    val result = {a: Int, b: Int -> a+b}
    val answer = result(3, 5)
    println("The answer of lambda functions: $answer")

    val add = {a: Int, b: Int -> a+b}
    val addAlt: (Int, Int)-> Int = {a, b -> a+b}

    val sub = {a: Int, b: Int -> a-b}
    val subAlt: (Int, Int) -> Int = {a, b -> a-b}

    val mul = {a: Int, b: Int -> a*b}
    val mulAlt: (Int, Int) -> Int = {a, b -> a*b}

    val div = {a: Int, b: Int -> a/b}
    val divAlt: (Int, Int) -> Int = {a, b -> a/b}

    // lambda with multiple line
    val lambdaMultiple = {a: Int, b: Int ->
        var res = 100
        var res1 = 102
        res1 = res + a + b
        res1
    }
    /*
        lambda with one parameter
     */
    val square = { it: Int -> it*it }
    val square2: (Int) -> Int = { it*it }

    /*
        lambda return character
     */
    val lambdaChar = {str: String -> str[0]}
    val lambdaCharAlt: (String) -> Char = {str -> str[0]}
    println("lambda return character: ${lambdaChar("ABC")}")

    // lambda return string
    val lambdaString = {str: String -> str+"Bangladesh"}
    val lambdaStringAlt: (String) -> String = {str -> str+"ABC"}
    println("Lambda return string: ${lambdaString("ABC")}")

    // lambda return Array
    val arr = intArrayOf(1, 3, 5, 6)
    val lambdaArray = { arr: IntArray -> arr.map{ it*2 }}
}

fun anonymousFunction() {
    /*
        anonymous = a function is like normal function but without a function name
        fun(parameters): returnType {
            ....
        }
     */
    val add = fun(a: Int, b: Int): Int {
        return a+b
    }

    println("The sum is: ${add(3, 4)}")
}

fun dataTypesPassAndReturn() {
    val res = passStringAndReturnString("bds")
    val res1= passListAndReturnList()
}

fun passStringAndReturnString(str: String): String {
    var str1 = str + "BD"
    return str1
}

fun passListAndReturnList() : List<String> {
    val ls: List<String> = listOf()
    return ls
}
