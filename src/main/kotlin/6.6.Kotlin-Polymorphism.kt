/*
    Kotlin Polymorphism
        1. Method Overriding = same function name, different behavior
        2. Method Overloading = same function name, different parameters

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

// #Overloading
class Calculate {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
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
    val cal = Calculate()
    val result = cal.add(2, 4)
    val result2 = cal.add(3, 5, 6)
    println("Result: $result and $result2")
}