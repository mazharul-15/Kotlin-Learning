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

// multiple interfaces
interface Flyable {
    fun fly()
}

interface Swimmable {
    fun swim()
}

class Duck: Flyable, Swimmable {
    override fun fly() {
        println("Duck can Swim!!!")
    }

    override fun swim() {
        println("Duck can Fly!!!")
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


    // multiple interface
    val duck = Duck()
    duck.fly()
    duck.swim()
}