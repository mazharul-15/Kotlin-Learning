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
class Student3(var name: String, var id: Int) {

    init {
        println("Object is created with the name of : $name and Id: $id")
    }
    fun getInfo() {
        println("Name: $name and Id: $id")
    }
}


// default parameter values in primary constructor
class Student4(val name: String = "Khairul Basar", val age: Int = 35) {
    fun getinfo() {
        println("Name: $name and Age: $age")
    }
}


// Secondary Constructor

fun main() {
    val p1 = Person2(4, 5)
    p1.getInfo()

    val student2 = Student2("Zahir", 1203044, 32)
    student2.getInfo()

    val student3 = Student3("Ammir", 101)

    val student4 = Student4()
    student4.getinfo()
}