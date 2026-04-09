// Kotlin Inheritance

open class Animal {
    open fun sound() {
        println("This is sound of animals")
    }
}

class Dog: Animal() {
    override fun sound() {
        //super.sound()
        println("This the sound of Dog")
    }
}

class Cat: Animal() {
    override fun sound() {
        //super.sound()
        println("This is the sound of Cat")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()
    val cat = Cat()
    cat.sound()
    val animal = Animal()
    animal.sound()
}