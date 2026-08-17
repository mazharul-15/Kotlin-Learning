/*
    Lambda Expression

    lambda syntax:
    val variable_name = { parameter: Type -> body}

    OR

    val varibable_type: (type, type,..)->type = { parameter -> body }

 */

// lambda as a function parameter

fun lambdaAccepting(a: Int, b: Int, sum:(Int, Int)->Int) {

    println(sum(a,b))
}


fun main() {
    // lambda with no parameter
    val sayHello = {
        println("Hello I am lambda function!!!!")
    }
    sayHello()

    // lambda syntax
    val add = {a: Int, b: Int -> a + b}
    println("Sum: ${add(5, 6)}")

    val sub:(Int, Int) -> Int = {a, b -> a - b}
    println("Sun: ${sub(5, 10)}")

    // lambda with one parameter
    val square = {it: Int -> it*it}
    println("Square: ${square(5)}")

    // lambda with multiple line
    val sum = {a: Int, b: Int ->
        val result = a + b
        result
    }
    println("Summation: ${sum(34, 5)}")

    // lambda with return type
    val nameShow = {name: String -> println(name)}
    nameShow("Abir Rahman")

    val nameList = listOf("Abir", "Rahman", "Kamrul")
    val editList = {nameList: List<String> ->
        nameList.map {
            'R' + it.substring(1) +"Gazi"
        }
    }
    val newList: List<String> = editList(nameList)
    println(newList)


    // lambda as a parameter
    val addTwo = {a: Int, b: Int -> a + b}
    val result = lambdaAccepting(5, 8, addTwo)
    val resultAdd = lambdaAccepting(
        5,
        8,
        {a, b-> a + b}
    )
    val resultSub = lambdaAccepting(8, 5){
        a, b -> a - b
    }
    val resultMul = lambdaAccepting(8, 5){
        a, b -> a * b
    }
    val resultDiv = lambdaAccepting(8, 5){
        a, b -> a / b
    }


}