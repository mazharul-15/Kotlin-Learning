/*
    Object:

    Singleton:

    CompanionObject:

    AnonymousObject:

 */

// Object
object Database {
    val databaseName = "Student"
    fun connect() {
        println("Database connected")
    }
}


// Singleton
object DatabaseManger {
    val adminName = "Admin"
    fun connect() {
        println("Database Connected")
    }
}


// Companion Object
class Student44(
    val name: String,
    val id: Int
){
    fun show() {
        println("${this.name} \n ${this.id}")
    }

    companion object {
        val university = "HSTU"
        fun creatingStudent() {
            println("Creating Student")
        }
    }
}


fun main() {

    // Object
    Database.connect()

    // Singleton
    DatabaseManger.connect()

    // Companion Student
    Student44.creatingStudent()

    // Anonymous Object
    val user = object {
        val name = "Shamim"
        fun showInfo() {
            println("The the info")
        }
    }
    user.showInfo()
}