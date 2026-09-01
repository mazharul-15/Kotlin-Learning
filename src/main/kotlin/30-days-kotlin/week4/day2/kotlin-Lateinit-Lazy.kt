import java.sql.Connection
import javax.xml.crypto.Data

/*
    Kotlin Lateinit and Lazy

    lateinit var variable_name: dataType

    var variable_name by lazy {
        // code
    }
 */

// lateinit
class Student33 {
    lateinit var name: String

    fun printValue() {
        if(::name.isInitialized) {
            println(name)
        } else {
            println("Value not initialized yet!!!")
        }
    }
}

// lazy
class Database{
    lateinit var databaseConnection: Connection

    fun showInfo() {
        println("Database Connected")
    }
}

fun main() {
    // lateinit
    lateinit var name: String
    name = "Abir"

    val student = Student33()
    student.printValue()

    // lazy
    val age by lazy {
        //println("initialized")
        34
    }
    println(age)
    println(age)
    println(age)

    // lazy
    val database by lazy {
        Database()
    }
}