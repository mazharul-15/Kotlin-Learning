/*
    Strings in kotlin
    Strings are the most frequently used data types in Android Development
        - User Input
        - Form Validation
        - UI Text
        - File Name
        - API responses
        - JSON parsing
        - Logging
 */

fun main() {
        //  1. String
    val studentName: String = "Md. Abir Hussain Gazi Binte Abdul"
    println("Student Name: $studentName")

        // 2. Declaring String
            // 1. Type Inference
    val teacherName = "Mominul Sardar"

            // 2. Explicit Type
    val socialWorkOfficerName: String = "Md Fatah Rahman"

        // 3. String Templates
            // 1. Multiple Variables
    val age: Int = 34
    val salary: Double = 34000.00

    println("Age: $age and Salary: $salary")

            // 2. Expression
    val numberOne: Int = 34
    val numberTwo: Int = 12
    var sum: Int

    println("The sum is: ${numberOne + numberTwo}")

    // 4. Common Functions in String
    println("kotLin".uppercase())
    println("KOTLIN".lowercase())

    println(" Kotlin ".trim())
    println("kotlin@gmail.com".split("@"))

    println("Java is a programming language".replace("Java", "Kotlin"))
    println("Kotlin is a programming language".contains("programming"))
    println("Kotlin is a programming language".substring(14, 19))

    println("Kotlin is a programming language".startsWith("Kot"))
    println("Kotlin is a programming language".endsWith("uage"))

    println("".isEmpty())       // contains not any character at all
    println("    ".isBlank())   // Empty or Whitespace

    println("${"Kotlin"=="Kotlin"}")

    val rawString = """
        Kotlin
        is a
        programming
        language
    """.trimIndent()
    println("Raw String: $rawString")
}