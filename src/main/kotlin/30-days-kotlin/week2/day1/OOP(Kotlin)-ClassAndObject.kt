/*
    OOP in Kotlin : Class and Object
 */

// 1.Class
class Students(
    val name: String,
    val university: String,
    val department: String,
    val cgpa: Double
) {
    init {
        require(cgpa in 0.0  .. 4.00)
        "cgpa must be between 0.0 to 4.00"
        validate(name)
    }


    fun printInfo() {
        println("Name: ${this.name}")
        println("University: ${this.university}")
        println("Department: ${this.cgpa}")
    }
}

fun validate(name: String): Boolean {
    return name[0].isUpperCase()
}


// 3.Object Communication

class Address(
    val city: String
)

class Department(
    val section: String
)

class Salary(
    val wage: Double
)

class Employee(
    val name: String,
    val address: Address,
    val department: Department,
    val salary: Salary
) {
    fun printInfo() {
        println("Name: ${this.name}")
        println("Address: ${this.address.city}")
        println("Department: ${this.department.section}")
        println("Salary: ${this.salary.wage}")
    }
}

fun main() {

    // 2.Object
    val student = Students(
        "Abir Rahman",
        "HSTU",
        "CSE",
        3.54
    )

    student.printInfo()

    // 3.Object Communication
    val address = Address("Khulna")
    val department = Department("Engineering")
    val salary = Salary(56000.00)

    val employee = Employee(
        "Rashed",
        address,
        department,
        salary
    )
    println("Name: ${employee.name}")
    println("Address: ${employee.address.city}")
    println("Department: ${employee.department.section}")
    println("Salary: ${employee.salary.wage}")
}