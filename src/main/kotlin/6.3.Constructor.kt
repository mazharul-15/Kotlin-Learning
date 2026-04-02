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

class Student5{
    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun getInfo() {
        println("Name = $name and Age = $age")
    }
}

class Student6{  // multiple secondary constructor
    var name: String
    var age: Int
    var id: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
    constructor(name: String, age: Int, id: Int) {
        this.name = name
        this.age = age
        this.id = id
    }
}

// nested class & inner class
class Utils{
    class Validator{
        fun isValidEmail(email: String): Boolean {
            return email.contains("@")
        }
    }
}

fun main() {
    // primary constructor
    val p1 = Person2(4, 5)
    p1.getInfo()

    val student2 = Student2("Zahir", 1203044, 32)
    student2.getInfo()

    val student3 = Student3("Ammir", 101)

    val student4 = Student4()
    student4.getinfo()

    // secondary constructor
    val student5 = Student5("Axim", 1304566)
    student5.getInfo()
    // secondaty mutiple consturctor
    val student6 = Student6("Axio", 34)
    val student61 = Student6("Axio1", 45, 123)

    // nested class
    //val utils = Utils() // this will give error to acces nested class 's member
    val utils = Utils.Validator()
    println(utils.isValidEmail("azhr123@gmail.com"))
}