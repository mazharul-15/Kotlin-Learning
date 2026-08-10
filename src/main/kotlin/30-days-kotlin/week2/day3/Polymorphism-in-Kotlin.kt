/*
    Polymorphism in Kotlin

    poly = many
    morph = forms
 */

open class Animal99() {
    open fun sound() {
        println("Animal should have a sound!!!")
    }
}

class Dog99: Animal99() {
    override fun sound() {
        println("Dog sound is : bark")
    }

    fun bark() {
        println("This is dog sound!!")
    }
}

class Cat99: Animal99() {
    override fun sound() {
        println("Cat sound is: Meow")
    }

    fun meow() {
        println("This is cat sound!!")
    }
}


fun main() {
    // Inheritance and polymorphism
    val dog = Dog99()
    dog.sound()

    val cat = Cat99()
    cat.sound()

    // very important topic: Runtime Polymorphism
    val dog2: Animal99 = Dog99()
    dog2.sound()

    val cat2: Animal99 = Cat99()
    cat2.sound()

    // polymorphism with multiple object
    println("\nPolymorphism with multiple object:")
    val animals: List<Animal99> = listOf(
        Dog99(),
        Cat99(),
        Dog99(),
        Cat99()
    )

    for(animal in animals) {
        animal.sound()
    }
}