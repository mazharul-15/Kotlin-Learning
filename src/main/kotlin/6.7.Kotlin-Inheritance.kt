/*

    Inheritance:
 */

open class Base {
    open fun show() {
        println("Hello I am Base class!!!")
    }
}

class Child: Base(){
    override fun show() {
        println("Hello I am Child class!!!")
    }
}

fun main() {
    val child = Child()
}