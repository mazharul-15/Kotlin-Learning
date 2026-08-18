/*
    My define lambda function, passing as a parameter
 */


fun myDefinedMap(numbers: List<Int>, action: (List<Int>)-> List<Int>): List<Int> {
    return action(numbers)
}

// my click function
fun onClick() {
        println("Button Clicked")
}

fun myDefinedLambda(action: ()-> Unit) {
    action()
}
        
        
fun main() {
    val numbers = listOf<Int>(1, 2, 3, 4, 5)

    val result = myDefinedMap(numbers){ numbers ->
        val newList = mutableListOf<Int>()
        for(number in numbers) {
            newList.add(number*2)
        }
        newList
    }

    println(result.joinToString())

    // my click function
    myDefinedLambda {
        onClick()
    }
}