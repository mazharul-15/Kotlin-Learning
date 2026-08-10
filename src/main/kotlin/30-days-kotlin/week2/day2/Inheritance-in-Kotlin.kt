/*
    Inheritance in Kotlin
 */

        //1. Inheritance
open class Animal5(val color: String) {
    open fun eat() {
        println("Eatting habit id different than human")
    }
}

class Dog5(color: String): Animal5(color) {
    override fun eat() {
        super.eat()
        println("Dog eats: meat, etc")
    }

    fun bark() {
        println("Dog's sound is: Ghewo Ghewo")
    }
}

class Cat5(color: String): Animal5(color) {
    override fun eat() {
        super.eat()
        println("Cat eats: meat, rat, etc")
    }

    fun mewo() {
        println("Cat's sound is: Mewo")
    }
}


        //2.Composition
class Address5(
    val village: String,
    val post: String,
    val upazila: String,
    val distric: String
)

class User5(
    val name: String,
    val address: Address5,
)

class Employee(
    val name: String,
    val address5: Address5
)

fun main() {

    val dog = Dog5("White")
    val cat = Cat5("Black")
    println("Dogs property:")
    println("Color: ${dog.color}")
    println("Eat: ${dog.eat()}")
    println("Sound: ${dog.bark()}")

    // composition
    val address = Address5(
        "Aminpur",
        "Paikgachha",
        "Paikgachha",
        "Khulna"
        )
    val user = User5("Shamim", address)

    println("Name: ${user.name}")
    println("RaodNo: ${user.address.village}")
    println("City: ${user.address.post}")
    println("City: ${user.address.upazila}")
    println("City: ${user.address.distric}")

    val employee = Employee(
        "Amin",
        address
    )
}