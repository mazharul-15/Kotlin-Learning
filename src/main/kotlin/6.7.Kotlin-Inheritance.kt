/*

    Inheritance:

 */
// Inheritance basics
open class Base {
    var name: String = ""
    var age: Int =0
    open fun show() {
        println("Hello I am Base class!!!")
    }
}

class Child: Base(){

    fun displayData() {
        //println("Name: ${super.name} and Age: ${super.age}")
    }
    override fun show() {
        println("Hello I am Child class!!!")
    }
}

// Inheritance properties and methods
open class User {
    var username: String = ""
    var userpassword: String = ""
    fun show(name: String) {
        println("$name logged in successfully")
    }
}

class Admin: User() {
    fun loggedIN(name: String, password: String) {
        if(super.username == name && super.userpassword == password) {
            super.show(name)
        }
    }
}

class NormalUser: User() {
    fun loggedIN(name: String, password: String) {
        if(super.username == name && super.userpassword == password) {
            super.show(name)
        }
    }
}

// kotlin inheritance primary constructor
open class Shape(var name: String, var color: String, var dimension: Int) {
    fun getData() {
        println("Name: $name\n Color: $color\n Dimension: $dimension")
    }
}

class Circle(val radius: Double, name: String, color: String, dimension: Int): Shape(name, color, dimension) {

}


// kotlin inheritance secondary constructor
open class BaseCamp{
    var name: String = ""
    var address: String = ""
    var telPhone: String = ""

    constructor(name: String, address: String, telPhone: String) {
        this.name = name
        this.address = address
        this.telPhone = telPhone
    }

    fun show() {
        println("Name: $name and Address: $address and Telephone: $telPhone")
    }
}

class Camp: BaseCamp {
    constructor(name: String, address: String, telPhone: String): super(name, address, telPhone) {
        println("Saved Data")
    }
}


// Overriding member properties and functions
open class Geometry {
    open var name: String = "Geomertry"
    open var shape: String = "3d"

    open fun show() {}
}

class Triangle: Geometry( ){
    override var name: String = "Triangle"
    override var shape: String = "2d"

    override fun show() {
        println("$name And $shape")
    }
}


// Calling the super class implementation
open class Phone {
    var color: String = "red"
    fun display() {
        println("Color: $color")
    }
}

class iPhone: Phone() {
    fun show() {
        println("The color is: " + super.color)
        super.display()
    }
}

fun main() {
    // inheritance basics
    val child = Child()
    child.name = "Monir"
    child.age = 12
    child.displayData()

    // inheritance properties and methods
    val normalUser = NormalUser()
    normalUser.username = "mazhar"
    normalUser.userpassword = "123Maz"
    normalUser.loggedIN("mazhar", "123Maz")

    // Kotlin inheritance primary constructor
    val circle = Circle(4.5, "Circle", "Red", 0)
    circle.getData()

}