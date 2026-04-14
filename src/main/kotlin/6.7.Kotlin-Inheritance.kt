/*

    Inheritance:
 */
// Inheritance basics
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

// Inheritance properties and methods
open class User {
    var username: String = ""
    var userpassword: String = ""
    fun show(name: String) {
        println("$name logged in succesfully")
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


fun main() {
    // inheritance basics
    val child = Child()

    // inheritance properties and methods
    val normalUser = NormalUser()
    normalUser.username = "mazhar"
    normalUser.userpassword = "123Maz"
    normalUser.loggedIN("mazhar", "123Maz")
}