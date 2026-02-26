/*
#1. Main function : needs for every program because when program run it search
                    where is "main()" function if finds it start either not.
*/
fun main() {
    println("Hello World!!!")
    variableDeclaration()
    dataTypes()

}

/*
#2. Val & Var: variable like high school math variable that contains value.
    val = immutable: can not be changed-> constant value and immutable
    var = mutable: can be changed by defining various value or taking input from keyboard
*/

fun variableDeclaration() {
    val number = 5
    val number2: Float = 5.29f
    val number3 = 5.29f
    val number4: Double = 5.2345
    println("Integer Number is: " + number)
    println("Float Number are: "+number2+" "+number3)
    println("Double Number is: " + number4)
}

/*
#3. Data Type: Int, Float, Boolean, Character, String, Array

        Boolean = true or false
        Char = 'C'
        String = "I AM Programmer"
        Array = collection of same type of data or semi data type
 */

fun dataTypes() {
    var number: Int = 25
    println("Integer number is: $number")

    var bool: Boolean = true
    println("Boolean value is : $bool")
}