/*
    Kotlin Polymorphism
        1. Method Overriding
        2. Method Overloading

        same function but behaves different

        🧠 Real-Life Example

            Think of a person:

            As a teacher → teaches
            As a father → cares
            As a friend → jokes

            👉 Same person, different behavior
            👉 This is polymorphism
*/


// #Overriding
open class Animal {
    open fun sound() {
        println("This is sound of animals")
    }
}

class Dog: Animal() {
    override fun sound() {
        //super.sound()
        println("This the sound of Dog: Ghewowwww!!!")
    }
}

class Cat: Animal() {
    override fun sound() {
        //super.sound()
        println("This is the sound of Cat: Meoww!!!!!")
    }
}

class Cow: Animal() {
    override fun sound() {
        println("This is the sound of Cow: Hambaaaa!!!!!")
    }
}


fun main() {
    // Overriding
    val animal = Animal()
    animal.sound()
    val dog = Dog()
    dog.sound()
    val cat = Cat()
    cat.sound()
    val cow = Cow()
    cow.sound()

    // Overloading

}