/*
    Interface: a contract (rules) that a class must follow
    when every class must have common properties and methods then interface use
 */

interface ClickListener {
    fun onClick()
}

class Button: ClickListener {
    override fun onClick() {
        println("Button Clicked")
    }
}

interface Animal2 {
    fun sound()
}

class Dog2: Animal2 {
    override fun sound() {
        println("The Dog sound: Gheu Gheu!!!")
    }
}

class Cat2: Animal2 {
    override fun sound() {
        println("The Cat sound: Mewo Mewo!!!")
    }
}

class Cow2: Animal2 {
    override fun sound() {
        println("The Cow sound: Hamba Hamba!!!")
    }
}


fun main() {
    val button = Button()
    button.onClick()

    val dog = Dog2()
    dog.sound()

    val cat = Cat2()
    cat.sound()

    val cow = Cow2()
    cow.sound()
}