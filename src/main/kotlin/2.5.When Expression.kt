// when expression

fun main() {
    whenAsStatementWithElse()
    whenAsStatementWithoutElse()
    whenAsExpression()
    combineMultipleBranchesUsingComma()
    checkIntegerValueWithinARangeOrNot()
    checkingVariableType()
    replaceIfElseChain()
    checkingStringContainsSuffixOrPrefix()
}

fun whenAsStatementWithElse() {
    println("Enter the name of planet:")
    var name: String = readLine()!!

    when(name) {
        "mars" -> println("This is a mars planet!!!")
        "moon" -> println("This is a moon planet!!!")
        "sun" -> println("This is a sun planet!!!")
        else -> println("I don't know the planet name!!!")
    }
}

fun whenAsStatementWithoutElse() {
    println("Enter the name of plane:")
    var name = readLine()!!.toString()

    when(name) {
        "mars" -> println("This is a mars planet!!!!")
        "moon" -> println("This is a moon planet!!!!")
        "sun" -> println("This is sun planet!!!!")
    }
}

fun whenAsExpression() {
    println("Enter the a number from 1 to 7:")
    var number = readLine()!!.toInt()

    var day = when(number) {
        1-> "Saturday"
        2-> "Sunday"
        3-> "Monday"
        4-> "Tuesday"
        5-> "Wednesday"
        6-> "Thursday"
        7-> "Friday"
        else-> "This is not a week day" // else is mandatory
    }

    println("The week day is: $day")
}

fun combineMultipleBranchesUsingComma() {

}

fun checkIntegerValueWithinARangeOrNot() {

}

fun checkingVariableType() {

}

fun replaceIfElseChain() {

}

fun checkingStringContainsSuffixOrPrefix() {

}
