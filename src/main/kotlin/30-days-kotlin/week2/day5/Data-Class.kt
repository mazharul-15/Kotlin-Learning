/*
    Data Class: Used to store data
 */

data class Student22(
    val name: String,
    val id: Int,
    val department: String
)

fun main() {

    val student1 = Student22("Abir", 102, "ECE")
    println(student1)

    // equals
    val student2 = Student22("Abir", 102, "ECE")
    println("${student1 == student2}")


    // copying
    val student3 = student1.copy()
    println(student3)

    val student4 = student1.copy(
        id = 105
    )
    println(student4)

    // destructing
    val(name, id) = student1
    println(name)
    println(id)

    // hashCode()
    val student6 = Student22("Rahman", 119, "CSE")
    println("Hash Code:" + student6.hashCode())

    val students = hashSetOf<Student22>()
    students.add(Student22("Fatah vai", 123, "BBS"))
    students.add(Student22("Karim", 234, "ECE"))

    for(student in students) {
        println("Students hash set: $student")
    }
}