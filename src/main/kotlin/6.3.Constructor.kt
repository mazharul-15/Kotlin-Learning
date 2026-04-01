// Constructor

// Primary Constructor
class Person2 constructor(var a: Int, var b: Int) {
    fun getInfo() {
        println("$a and $b")
    }
}

class Student2(var name: String, var Id: Int, var age: Int) {
    fun getInfo() {
        println("Name: $name")
        println("Id: $Id")
        println("Age: $age")
    }
}

// init block



// Secondary Constructor

fun main() {
    val p1 = Person2(4, 5)
    p1.getInfo()

    val student1 = Student2("Zahir", 1203044, 32)
    student1.getInfo()
}