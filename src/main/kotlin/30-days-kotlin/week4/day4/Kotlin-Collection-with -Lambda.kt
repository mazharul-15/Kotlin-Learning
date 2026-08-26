/*
    Kotlin Collection with Lambdas
 */

data class StudentHstu(
    val id: Int,
    val name: String,
    val age: Int,
    val department: String
)

fun main() {
    val list = listOf<Int>(20, 13, 14, 15, 16, 8, 9, 4, 3, 99, 33)

    // count
    val result1 = list.count{
        it % 2 == 1
    }
    println("Result = $result1")

    // all
    val result2 = list.all {
        it % 2 == 0
    }
    println("Result = $result2")

    // any
    val result3 = list.any{
        it > 15
    }
    println("Result: $result3")

    // find
    val result4 = list.find {
        it > 14
    }
    println("Result: $result4")

    // collection + lambdas
    val studentHstu = listOf<StudentHstu>(
        StudentHstu(1502001, "Abir", 22, "CSE"),
        StudentHstu(1501004, "Rayan", 23, "ECE"),
        StudentHstu(1501005, "Kamrul", 24, "ECE"),
        StudentHstu(1502004, "Joy", 22, "CSE"),
        StudentHstu(1502005, "Rana", 24, "CSE"),
        StudentHstu(1500134, "Zahid", 24, "ECE")
    )

    // find cse student
    val result5 = studentHstu.filter {
        it.department == "CSE"
    }
    result5.forEach {
        println("${it.id} ${it.name} ${it.age} ${it.department}")
    }

    // find name of only cse students
    studentHstu
        .filter { it.department == "CSE" }
        .map { it.name }
        .forEach { print("$it ") }
    println()

    // find name of only cse students and return to result
    val result6 = studentHstu
        .filter { it.department == "CSE" }
        .map { it.name }

    result6.forEach { print("$it ") }; println()
}