/*
    Extension Function:
 */

// extension function on a custom class
class Student88(
    val name: String
    val age: Int
)

fun Student88.showInfo() {
    println(this.name)
    println(this.age)
}

fun main() {
    // normal extension functions
    "Abir".sayHello()
    "Ibrahim".sayHello()
    println(5.isEven())
    println(0.45.toPercentage())

    // extension function on a custom class
    val student = Student88("Abir", 23)
    student.showInfo()

}

    // normal extension functions
fun String.sayHello() {
    println("Hello $this")
}

fun Int.isEven(): Boolean {
    return this%2 == 0
}

fun Double.toPercentage(): String {
    return "${this*100}%"
}


