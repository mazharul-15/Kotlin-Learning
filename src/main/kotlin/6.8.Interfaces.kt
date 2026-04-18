/*
    Interface: a contract (rules) that a class must follow
 */

interface ClickListener {
    fun onClick()
}

class Button: ClickListener {
    override fun onClick() {
        println("Button Clicked")
    }
}

fun main() {
    val button = Button()
    button.onClick()
}