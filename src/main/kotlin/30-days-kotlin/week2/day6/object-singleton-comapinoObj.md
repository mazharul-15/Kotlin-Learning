# Object, Companion Object & Singleton in Kotlin

## 1. Overview

Kotlin provides `object` and `companion object` to work with objects that do not need to be created repeatedly.

The three important concepts are:

- `object`
- `companion object`
- Singleton

A simple way to remember:

```text
object
→ I need one shared object.

companion object
→ I need members associated with a class.

Singleton
→ I want only one instance.
```

---

# 2. What Is an Object?

Normally, we create a class:

```kotlin
class Student(
    val name: String
)
```

Then we create objects from that class:

```kotlin
val student1 = Student("Mazharul")
val student2 = Student("Rahim")
```

Here:

```text
Student
   ↓
Class / Blueprint
   ↓
 ┌──────────────┐
 │ student1     │
 │ Mazharul     │
 └──────────────┘

 ┌──────────────┐
 │ student2     │
 │ Rahim        │
 └──────────────┘
```

There can be many objects.

But sometimes we need only **one object**.

For that, Kotlin provides an `object` declaration.

---

# 3. Object Declaration

Example:

```kotlin
object DatabaseManager {

    fun connect() {
        println("Database connected")
    }
}
```

We can directly use it:

```kotlin
DatabaseManager.connect()
```

We don't write:

```kotlin
val database = DatabaseManager()
```

because `DatabaseManager` is already an object.

---

# 4. Object Can Have Properties

An `object` can contain properties.

```kotlin
object AppConfig {

    val appName = "My Android App"
    val version = 1
}
```

Use:

```kotlin
println(AppConfig.appName)
println(AppConfig.version)
```

Output:

```text
My Android App
1
```

---

# 5. Object Can Have Functions

An object can also contain functions.

```kotlin
object Calculator {

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }
}
```

Use:

```kotlin
println(Calculator.add(10, 20))
println(Calculator.multiply(5, 4))
```

Output:

```text
30
20
```

Notice that we don't create:

```kotlin
val calculator = Calculator()
```

We directly use:

```kotlin
Calculator.add(...)
```

---

# 6. Class vs Object

Normal class:

```kotlin
class Calculator {

    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

We need to create an instance:

```kotlin
val calculator = Calculator()

calculator.add(10, 20)
```

Object:

```kotlin
object Calculator {

    fun add(a: Int, b: Int): Int {
        return a + b
    }
}
```

We directly use:

```kotlin
Calculator.add(10, 20)
```

The main difference:

```text
class
→ blueprint
→ create objects from it

object
→ already-created object
→ directly use it
```

---

# 7. What Is a Singleton?

A Singleton means:

> There is only one instance of a particular object throughout the application.

For example, suppose we have:

```text
DatabaseManager
```

We may want only one shared manager:

```text
Application
     |
     ↓
DatabaseManager
     |
     ↓
one instance
```

Instead of:

```text
DatabaseManager 1
DatabaseManager 2
DatabaseManager 3
```

we want:

```text
DatabaseManager
       |
       ↓
one shared instance
```

---

# 8. Kotlin Object as Singleton

Kotlin makes Singleton creation very easy.

Simply use:

```kotlin
object DatabaseManager {

    fun connect() {
        println("Connected")
    }
}
```

Now:

```kotlin
DatabaseManager.connect()
```

The `DatabaseManager` object is shared.

You don't manually create multiple instances.

---

# 9. Singleton Example: Logger

```kotlin
object Logger {

    fun log(message: String) {
        println("LOG: $message")
    }
}
```

Use it from different places:

```kotlin
Logger.log("Application started")
```

Another place:

```kotlin
Logger.log("User logged in")
```

Output:

```text
LOG: Application started
LOG: User logged in
```

We don't need:

```kotlin
val logger1 = Logger()
val logger2 = Logger()
```

---

# 10. Why Use Singleton?

A Singleton can be useful when we need one shared instance of something.

Examples:

```text
Logger
Configuration
Shared manager
Some application-wide services
```

For example:

```kotlin
object AppConfig {

    const val APP_NAME = "Student App"
    const val VERSION = 1
}
```

Use:

```kotlin
println(AppConfig.APP_NAME)
```

---

# 11. Important Warning About Singleton

Don't use Singleton for everything.

For example, don't make every class:

```kotlin
object UserManager
object StudentManager
object ProductManager
object MessageManager
object ScreenManager
object DataManager
```

just because you can.

Too much shared global state can make an application:

- harder to understand
- harder to test
- harder to maintain

Use a Singleton when having one shared instance actually makes sense.

---

# 12. Companion Object

Now let's learn:

```kotlin
companion object
```

Suppose we have:

```kotlin
class Student(
    val name: String
)
```

Normally, we create:

```kotlin
val student = Student("Mazharul")
```

Then:

```kotlin
student.name
```

But sometimes we want a function or property associated with the **class itself**, rather than an individual student.

For example:

```text
Student
   |
   +── createStudent()
   |
   +── UNIVERSITY
```

These don't need a particular student object.

That's where `companion object` is useful.

---

# 13. Basic Companion Object

```kotlin
class Student {

    companion object {

        fun createStudent() {
            println("Creating student")
        }
    }
}
```

We can call:

```kotlin
Student.createStudent()
```

We don't need:

```kotlin
val student = Student()
```

---

# 14. Companion Object with a Property

```kotlin
class Student {

    companion object {

        val university = "HSTU"
    }
}
```

Use:

```kotlin
println(Student.university)
```

Output:

```text
HSTU
```

---

# 15. Companion Object with a Function

```kotlin
class Calculator {

    companion object {

        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}
```

Use:

```kotlin
val result = Calculator.add(10, 20)

println(result)
```

Output:

```text
30
```

---

# 16. Why Do We Need Companion Object?

Suppose we have:

```kotlin
class Student(
    val name: String
)
```

Each student has individual data:

```text
student.name
```

For example:

```kotlin
val student = Student("Mazharul")

println(student.name)
```

But something like:

```text
universityName
createGuestStudent()
```

doesn't depend on one particular student.

So we can put them in:

```kotlin
companion object
```

Example:

```kotlin
class Student(
    val name: String
) {

    companion object {

        const val UNIVERSITY = "HSTU"

        fun createGuest(): Student {
            return Student("Guest")
        }
    }
}
```

Use:

```kotlin
println(Student.UNIVERSITY)

val student = Student.createGuest()
```

---

# 17. Instance Member vs Companion Member

Consider:

```kotlin
class Student(
    val name: String
) {

    fun study() {
        println("$name is studying")
    }

    companion object {

        fun universityName() {
            println("HSTU")
        }
    }
}
```

Now create a student:

```kotlin
val student = Student("Mazharul")
```

Instance function:

```kotlin
student.study()
```

Companion function:

```kotlin
Student.universityName()
```

Think:

```text
student.study()
       ↑
belongs to one Student object


Student.universityName()
       ↑
belongs to the class/companion
```

---

# 18. Full Example

```kotlin
class User(
    val name: String
) {

    fun showName() {
        println("Name: $name")
    }

    companion object {

        const val DEFAULT_NAME = "Guest"

        fun createGuest(): User {
            return User(DEFAULT_NAME)
        }
    }
}
```

Usage:

```kotlin
fun main() {

    val user = User.createGuest()

    user.showName()

    println(User.DEFAULT_NAME)
}
```

Output:

```text
Name: Guest
Guest
```

---

# 19. Factory Function

A companion object is commonly used to create objects.

Example:

```kotlin
class User(
    val name: String,
    val age: Int
) {

    companion object {

        fun createGuest(): User {
            return User(
                name = "Guest",
                age = 0
            )
        }
    }
}
```

Now:

```kotlin
val user = User.createGuest()
```

Here:

```kotlin
createGuest()
```

is a factory function.

It creates and returns a `User`.

---

# 20. What Is a Factory Function?

A factory function is a function that creates and returns an object.

Example:

```kotlin
fun createStudent(): Student {
    return Student(
        name = "Guest"
    )
}
```

Inside a companion object:

```kotlin
class Student(
    val name: String
) {

    companion object {

        fun createGuest(): Student {
            return Student("Guest")
        }
    }
}
```

Use:

```kotlin
val student = Student.createGuest()
```

This pattern is very common in Kotlin and Android.

---

# 21. Companion Object and `const val`

You will often see:

```kotlin
class MainActivity {

    companion object {

        const val TAG = "MainActivity"
    }
}
```

Then:

```kotlin
Log.d(MainActivity.TAG, "Activity started")
```

`TAG` is a constant associated with the class.

---

# 22. Android Example: Intent Extra

Suppose we have:

```kotlin
class StudentActivity {

    companion object {

        const val EXTRA_STUDENT_ID = "student_id"
    }
}
```

Then:

```kotlin
intent.putExtra(
    StudentActivity.EXTRA_STUDENT_ID,
    101
)
```

Instead of repeatedly writing:

```kotlin
"student_id"
```

we use:

```kotlin
StudentActivity.EXTRA_STUDENT_ID
```

This reduces hard-coded strings and makes the code easier to maintain.

---

# 23. Object for Constants

We can also use an object:

```kotlin
object AppConstants {

    const val APP_NAME = "Student App"
    const val VERSION = 1
}
```

Use:

```kotlin
println(AppConstants.APP_NAME)
println(AppConstants.VERSION)
```

This is an object declaration.

---

# 24. `object` vs `companion object`

## Object

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

Usage:

```kotlin
Logger.log("Hello")
```

`Logger` itself is the singleton object.

---

## Companion Object

```kotlin
class Student {

    companion object {

        fun create(): Student {
            return Student()
        }
    }
}
```

Usage:

```kotlin
Student.create()
```

Here:

```text
Student
   ↓
normal class

Student.Companion
   ↓
companion object
```

The class can still have instances:

```kotlin
val student1 = Student()
val student2 = Student()
```

---

# 25. Important Difference

### `object`

```kotlin
object DatabaseManager
```

means:

> This declaration itself represents one object.

### `companion object`

```kotlin
class Database {

    companion object {

    }
}
```

means:

> This is a special object associated with the `Database` class.

So:

```text
object
→ standalone singleton object

companion object
→ object associated with a class
```

---

# 26. Object vs Companion Object vs Normal Class

| Feature | Normal Class | `object` | `companion object` |
|---|---|---|---|
| Is it a class? | Yes | No | Special object inside class |
| Create instances | Yes | No | The containing class can |
| Direct access | No | Yes | Yes |
| Singleton behavior | No | Yes | Companion itself is one object |
| Common use | General objects | Shared singleton | Class-level functions/constants |
| Example | `Student()` | `Logger` | `Student.create()` |

---

# 27. Simple Mental Model

Remember:

```text
class Student
      ↓
Blueprint

Student()
      ↓
Creates an object


object Logger
      ↓
Already one object


class Student {

    companion object {
        ...
    }
}
      ↓
Special object associated with Student
```

---

# 28. Object Declaration Example

```kotlin
object Calculator {

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }
}

fun main() {

    println(Calculator.add(10, 5))
    println(Calculator.subtract(10, 5))
}
```

Output:

```text
15
5
```

---

# 29. Companion Object Example

```kotlin
class Student(
    val name: String,
    val id: Int
) {

    fun showInfo() {
        println("$id - $name")
    }

    companion object {

        const val UNIVERSITY = "HSTU"

        fun createGuest(): Student {
            return Student(
                name = "Guest",
                id = 0
            )
        }
    }
}
```

Usage:

```kotlin
fun main() {

    val student = Student.createGuest()

    student.showInfo()

    println(Student.UNIVERSITY)
}
```

Output:

```text
0 - Guest
HSTU
```

---

# 30. Object Declaration vs Object Expression

Kotlin has two related concepts.

## Object declaration

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

This creates a named singleton object.

---

## Object expression

Example:

```kotlin
val student = object {

    val name = "Mazharul"

    fun study() {
        println("Studying")
    }
}
```

This creates an anonymous object.

For now, focus mainly on **object declarations**. Object expressions can be studied later when needed.

---

# 31. Singleton in Android

A Singleton may be useful for something that should have one shared instance.

For example:

```kotlin
object AppConfig {

    const val BASE_URL = "https://example.com"
}
```

Use:

```kotlin
AppConfig.BASE_URL
```

Another example:

```kotlin
object Logger {

    fun log(message: String) {
        println("LOG: $message")
    }
}
```

Use:

```kotlin
Logger.log("Application started")
```

However, modern Android development often uses dependency injection rather than manually creating many global Singleton objects.

So understand the concept, but don't use `object` everywhere.

---

# 32. Practical Android Example

Imagine you have:

```text
MainActivity
StudentActivity
ProfileActivity
```

All three need a common application configuration.

You could have:

```kotlin
object AppConfig {

    const val APP_NAME = "Student App"
    const val VERSION = 1
}
```

Then:

```kotlin
println(AppConfig.APP_NAME)
```

from different parts of the application.

---

# 33. Another Android Example

A class can have constants and factory functions:

```kotlin
class StudentActivity {

    companion object {

        const val EXTRA_ID = "student_id"

        fun createIntent(
            context: Context,
            studentId: Int
        ): Intent {

            return Intent(
                context,
                StudentActivity::class.java
            ).apply {
                putExtra(EXTRA_ID, studentId)
            }
        }
    }
}
```

Then another Activity can use:

```kotlin
val intent = StudentActivity.createIntent(
    this,
    101
)
```

This is a pattern you will encounter in Android development.

---

# 34. Practice Task 1 — Singleton Logger

Create:

```kotlin
object Logger {

    fun log(message: String) {
        println("LOG: $message")
    }
}
```

Test:

```kotlin
fun main() {

    Logger.log("Application started")
    Logger.log("User logged in")
    Logger.log("Application finished")
}
```

Expected:

```text
LOG: Application started
LOG: User logged in
LOG: Application finished
```

---

# 35. Practice Task 2 — Companion Object

Create:

```kotlin
class Student(
    val name: String,
    val id: Int
) {

    companion object {

        const val UNIVERSITY = "HSTU"

        fun createGuest(): Student {
            return Student(
                name = "Guest",
                id = 0
            )
        }
    }

    fun showInfo() {
        println("$id - $name")
    }
}
```

Then:

```kotlin
fun main() {

    val student = Student.createGuest()

    student.showInfo()

    println(Student.UNIVERSITY)
}
```

---

# 36. Practice Task 3 — Calculator Object

Create:

```kotlin
object Calculator {

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }
}
```

Test:

```kotlin
fun main() {

    println(Calculator.add(10, 5))
    println(Calculator.subtract(10, 5))
    println(Calculator.multiply(10, 5))
    println(Calculator.divide(10, 5))
}
```

---

# 37. Practice Task 4 — Factory Function

Create:

```kotlin
class User(
    val name: String,
    val age: Int
) {

    companion object {

        fun createGuest(): User {
            return User(
                name = "Guest",
                age = 0
            )
        }

        fun createAdmin(): User {
            return User(
                name = "Admin",
                age = 30
            )
        }
    }
}
```

Then:

```kotlin
fun main() {

    val guest = User.createGuest()
    val admin = User.createAdmin()

    println(guest.name)
    println(admin.name)
}
```

Output:

```text
Guest
Admin
```

---

# 38. Quick Quiz

Try answering these without looking at the notes.

1. What is an `object` declaration?
2. Why don't we write `()` when accessing an object declaration?
3. What is a Singleton?
4. How does Kotlin make Singleton creation easy?
5. What is a `companion object`?
6. Why do we use a companion object?
7. What is the difference between `object` and `companion object`?
8. What is the difference between:
   ```kotlin
   student.study()
   ```
   and:
   ```kotlin
   Student.create()
   ```
9. Why are constants often placed inside a companion object?
10. What is a factory function?
11. Can a class containing a companion object still have multiple instances?
12. Is an `object` declaration itself a Singleton?

---

# 39. Quick Revision

## Object

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

Use:

```kotlin
Logger.log("Hello")
```

Think:

```text
object
→ one shared object
```

---

## Companion Object

```kotlin
class Student {

    companion object {

        const val UNIVERSITY = "HSTU"

        fun create(): Student {
            return Student()
        }
    }
}
```

Use:

```kotlin
Student.UNIVERSITY
Student.create()
```

Think:

```text
companion object
→ members associated with a class
```

---

## Singleton

```text
Singleton
→ only one instance
```

Kotlin:

```kotlin
object DatabaseManager
```

is a convenient way to create a Singleton.

---

# 40. Final Comparison

```text
                    Kotlin
                       |
          ┌────────────┴────────────┐
          ↓                         ↓
       object                 companion object
          |                         |
          ↓                         ↓
   One shared object       Object associated
                           with a class
          |                         |
          ↓                         ↓
      Singleton          Class-level functionality
```

### Example

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

```kotlin
class Student(
    val name: String
) {

    companion object {

        const val UNIVERSITY = "HSTU"

        fun createGuest(): Student {
            return Student("Guest")
        }
    }
}
```

Usage:

```kotlin
Logger.log("Hello")

println(Student.UNIVERSITY)

val student = Student.createGuest()

println(student.name)
```

---

# Summary

## `object`

Use `object` when you want one shared object.

```kotlin
object Logger {

    fun log(message: String) {
        println(message)
    }
}
```

Use:

```kotlin
Logger.log("Hello")
```

---

## Singleton

A Singleton means only one instance exists.

Kotlin's:

```kotlin
object
```

is a simple way to create a Singleton.

---

## `companion object`

Use a companion object when you want functions or properties associated with a class.

```kotlin
class Student {

    companion object {

        const val UNIVERSITY = "HSTU"

        fun createGuest(): Student {
            return Student()
        }
    }
}
```

Use:

```kotlin
Student.UNIVERSITY
Student.createGuest()
```

---

# Most Important Things to Remember

```text
object
→ creates a single shared object

Singleton
→ only one instance

companion object
→ special object associated with a class

factory function
→ function that creates and returns an object
```

The three most important examples are:

```kotlin
// Singleton
object Logger {
    fun log(message: String) {
        println(message)
    }
}
```

```kotlin
// Companion object
class Student {

    companion object {

        fun createGuest(): Student {
            return Student()
        }
    }
}
```

```kotlin
// Constant in companion object
class MainActivity {

    companion object {

        const val TAG = "MainActivity"
    }
}
```

These concepts will become useful later in Android when working with **constants, Intent keys, factory functions, managers, logging, repositories, and application-level shared functionality**.