/*
    Data Class: we create class just to hold data
*/

data class Teacher(val name: String, val age: Int, val salary: Double)

fun main() {
    val teacher = Teacher("Azhar", 34, 43500.45)
    println(teacher)

    println(teacher.name)
}