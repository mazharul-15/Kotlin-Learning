# Data Class in Kotlin

## 1. What is a Data Class?

A **data class** is a class whose main purpose is to **hold data**.

Syntax:

```kotlin
data class Student(
    val name: String,
    val id: Int
)
```

Compared with a normal class:

```kotlin
class Student(
    val name: String,
    val id: Int
)
```

The important difference is:

```kotlin
data class
```

Kotlin automatically provides several useful functions for a data class.

---

# 2. Why Do We Need Data Classes?

Suppose we want to represent a student:

```kotlin
data class Student(
    val name: String,
    val id: Int
)
```

We mainly want to store:

```text
name
id
```

We don't want to write a lot of boilerplate code for comparing, printing, and copying objects.

Kotlin automatically generates useful functionality.

A data class automatically provides:

```text
toString()
equals()
hashCode()
copy()
componentN()
```

---

# 3. Basic Example

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student = Student(
        name = "Mazharul",
        id = 101
    )

    println(student)
}
```

Output:

```text
Student(name=Mazharul, id=101)
```

---

# 4. `toString()`

A data class automatically provides a useful `toString()`.

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student = Student("Mazharul", 101)

    println(student)
}
```

Output:

```text
Student(name=Mazharul, id=101)
```

This is useful for:

- Debugging
- Logcat
- Checking API data
- Checking objects during development

You can also explicitly call:

```kotlin
println(student.toString())
```

Both produce the same type of output.

---

# 5. `equals()`

Data classes compare objects based on their data.

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student1 = Student("Mazharul", 101)
    val student2 = Student("Mazharul", 101)

    println(student1 == student2)
}
```

Output:

```text
true
```

Why?

Because:

```text
student1
name = Mazharul
id = 101

student2
name = Mazharul
id = 101
```

The data is the same.

Therefore:

```kotlin
student1 == student2
```

is:

```text
true
```

---

# 6. `==` vs `===`

This is important.

## `==`

Checks **structural equality**.

In other words:

> Do these objects contain equal data?

Example:

```kotlin
val student1 = Student("Mazharul", 101)
val student2 = Student("Mazharul", 101)

println(student1 == student2)
```

Result:

```text
true
```

---

## `===`

Checks **referential equality**.

In other words:

> Are these two references pointing to the exact same object?

Example:

```kotlin
val student1 = Student("Mazharul", 101)
val student2 = Student("Mazharul", 101)

println(student1 === student2)
```

Result:

```text
false
```

They contain the same data, but they are two different objects.

---

# 7. `hashCode()`

A data class automatically generates a `hashCode()`.

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student = Student("Mazharul", 101)

    println(student.hashCode())
}
```

The exact number is not important.

The important idea is that `hashCode()` is generated based on the properties used by the data class.

It is especially important when objects are used in:

```text
HashSet
HashMap
```

---

# 8. Relationship Between `equals()` and `hashCode()`

Suppose:

```kotlin
val student1 = Student("Mazharul", 101)
val student2 = Student("Mazharul", 101)
```

Because:

```kotlin
student1 == student2
```

is:

```text
true
```

their hash codes are also expected to be equal.

Conceptually:

```text
Same data
    ↓
equals() = true
    ↓
same hashCode()
```

This is important when using objects in hash-based collections.

---

# 9. `copy()`

A data class automatically provides:

```kotlin
copy()
```

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student1 = Student("Mazharul", 101)

    val student2 = student1.copy()

    println(student1)
    println(student2)
}
```

Output:

```text
Student(name=Mazharul, id=101)
Student(name=Mazharul, id=101)
```

---

# 10. Copy and Change One Property

This is one of the most useful features.

```kotlin
data class Student(
    val name: String,
    val id: Int
)

fun main() {

    val student1 = Student("Mazharul", 101)

    val student2 = student1.copy(
        id = 102
    )

    println(student1)
    println(student2)
}
```

Output:

```text
Student(name=Mazharul, id=101)
Student(name=Mazharul, id=102)
```

The original object is unchanged.

---

# 11. Why `copy()` Is Useful

Suppose:

```kotlin
data class User(
    val name: String,
    val age: Int
)
```

We have:

```kotlin
val user = User(
    name = "Mazharul",
    age = 25
)
```

We want another version with age 26.

Instead of changing the original object:

```kotlin
val updatedUser = user.copy(
    age = 26
)
```

Now:

```text
user
age = 25

updatedUser
age = 26
```

This is very useful when working with immutable data.

---

# 12. `val` and `copy()`

You will commonly see:

```kotlin
data class User(
    val name: String,
    val age: Int
)
```

Because the properties are `val`, you cannot directly change them:

```kotlin
user.age = 26
```

This is not allowed.

Instead:

```kotlin
val updatedUser = user.copy(
    age = 26
)
```

This creates a new object.

---

# 13. Destructuring

Data classes support destructuring.

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int
)
```

Create an object:

```kotlin
val student = Student(
    "Mazharul",
    101
)
```

You can write:

```kotlin
val (name, id) = student
```

Now:

```kotlin
println(name)
println(id)
```

Output:

```text
Mazharul
101
```

---

# 14. How Destructuring Works

This:

```kotlin
val (name, id) = student
```

is supported by generated component functions.

Conceptually:

```text
component1() → name
component2() → id
```

So:

```kotlin
val (name, id) = student
```

roughly represents:

```kotlin
val name = student.component1()
val id = student.component2()
```

Normally, you don't need to call `component1()` yourself.

---

# 15. Multiple Properties and Destructuring

Example:

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val department: String
)
```

Object:

```kotlin
val student = Student(
    101,
    "Mazharul",
    "CSE"
)
```

Destructure:

```kotlin
val (id, name, department) = student
```

Now:

```text
id → 101
name → Mazharul
department → CSE
```

---

# 16. Ignoring a Property

You can ignore a value using `_`.

Example:

```kotlin
val (id, _, department) = student
```

Here:

```text
id → used
name → ignored
department → used
```

---

# 17. Primary Constructor Properties

For a data class:

```kotlin
data class Student(
    val name: String,
    val id: Int
)
```

These properties participate in generated functions:

```text
equals()
hashCode()
toString()
copy()
componentN()
```

So:

```text
name
id
```

are important to the data class.

---

# 18. Property Outside the Primary Constructor

Consider:

```kotlin
data class Student(
    val name: String,
    val id: Int
) {
    var age: Int = 0
}
```

Here:

```text
name
id
```

are in the primary constructor.

But:

```text
age
```

is not.

Therefore `age` does not participate in the generated `equals()`, `hashCode()`, `toString()`, `copy()`, and `componentN()` in the same way as constructor properties.

Example:

```kotlin
val student1 = Student("Mazharul", 101)
val student2 = Student("Mazharul", 101)

student1.age = 20
student2.age = 30

println(student1 == student2)
```

Output:

```text
true
```

Why?

Because `age` isn't part of the primary constructor.

---

# 19. Data Class Can Have Functions

A data class can contain functions.

Example:

```kotlin
data class Student(
    val name: String,
    val marks: Int
) {

    fun isPassed(): Boolean {
        return marks >= 40
    }
}
```

Usage:

```kotlin
val student = Student(
    "Mazharul",
    80
)

println(student.isPassed())
```

Output:

```text
true
```

A data class can have behavior, but its main purpose should still be representing data.

---

# 20. Data Class Can Have Default Values

Example:

```kotlin
data class Student(
    val name: String,
    val id: Int = 0,
    val department: String = "CSE"
)
```

Now:

```kotlin
val student = Student(
    name = "Mazharul"
)
```

The values are:

```text
name = Mazharul
id = 0
department = CSE
```

---

# 21. Data Class Can Have Nullable Properties

Example:

```kotlin
data class User(
    val name: String,
    val email: String?
)
```

Now:

```kotlin
val user = User(
    name = "Mazharul",
    email = null
)
```

This is completely valid.

You can then use Kotlin null-safety:

```kotlin
println(user.email?.uppercase())
```

---

# 22. Data Class Requirements

A data class must have at least one primary constructor parameter.

Valid:

```kotlin
data class Student(
    val name: String
)
```

Invalid:

```kotlin
data class Student()
```

Primary constructor parameters must be declared using:

```kotlin
val
```

or:

```kotlin
var
```

Example:

```kotlin
data class Student(
    val name: String
)
```

---

# 23. Data Class with `var`

You can use `var`:

```kotlin
data class Student(
    var name: String,
    var id: Int
)
```

Then you can change the values:

```kotlin
val student = Student(
    "Mazharul",
    101
)

student.name = "Rahim"
```

But in modern Android development, you will often see immutable:

```kotlin
val
```

and then use:

```kotlin
copy()
```

to create updated objects.

---

# 24. Data Class Example: User

```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)

fun main() {

    val user = User(
        id = 101,
        name = "Mazharul",
        email = "mazharul@example.com"
    )

    println(user)

    val updatedUser = user.copy(
        name = "Rahim"
    )

    println(updatedUser)
}
```

Output:

```text
User(id=101, name=Mazharul, email=mazharul@example.com)

User(id=101, name=Rahim, email=mazharul@example.com)
```

---

# 25. Data Class Example: Student

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val department: String,
    val marks: Int
)

fun main() {

    val student = Student(
        id = 101,
        name = "Mazharul",
        department = "CSE",
        marks = 85
    )

    println(student)

    val updatedStudent = student.copy(
        marks = 90
    )

    println(updatedStudent)
}
```

---

# 26. Data Class with a List

Data classes are frequently used inside collections.

```kotlin
data class Student(
    val id: Int,
    val name: String
)
```

Create a list:

```kotlin
val students = listOf(
    Student(101, "Mazharul"),
    Student(102, "Rahim"),
    Student(103, "Karim")
)
```

Loop:

```kotlin
for (student in students) {
    println(student)
}
```

Output:

```text
Student(id=101, name=Mazharul)
Student(id=102, name=Rahim)
Student(id=103, name=Karim)
```

---

# 27. Data Class and Android

Data classes are extremely common in Android development.

You will see them used for:

```text
API Models
Database Models
RecyclerView Items
User Data
Messages
Products
Weather Data
UI State
```

For example:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

Each `Product` object represents one product.

---

# 28. Data Class and API

Suppose an API returns:

```json
{
    "id": 101,
    "name": "Mazharul",
    "email": "mazharul@example.com"
}
```

You can represent it as:

```kotlin
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

Later, when you learn Retrofit and JSON parsing, you'll use this concept frequently.

---

# 29. Data Class and RecyclerView

Suppose you have a student list:

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val department: String
)
```

Then:

```kotlin
val students = listOf(
    Student(101, "Mazharul", "CSE"),
    Student(102, "Rahim", "EEE"),
    Student(103, "Karim", "CSE")
)
```

A RecyclerView adapter can receive:

```kotlin
List<Student>
```

Conceptually:

```text
List<Student>
      ↓
RecyclerView Adapter
      ↓
Student
Student
Student
      ↓
UI rows
```

---

# 30. Data Class and UI State

This is particularly important for Android.

You may later create:

```kotlin
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
```

Suppose:

```kotlin
val state = LoginUiState()
```

You want:

```text
isLoading = true
```

You can create a new state:

```kotlin
val updatedState = state.copy(
    isLoading = true
)
```

This pattern is common with:

```text
ViewModel
StateFlow
MVVM
UI State
Jetpack Compose
```

---

# 31. Data Class vs Normal Class

| Feature | Normal Class | Data Class |
|---|---|---|
| Can hold data | Yes | Yes |
| Useful `toString()` generated | No | Yes |
| `equals()` generated | No | Yes |
| `hashCode()` generated | No | Yes |
| `copy()` generated | No | Yes |
| `componentN()` generated | No | Yes |
| Main purpose | General object | Represent data |

---

# 32. When Should You Use a Data Class?

Use a data class when the object mainly represents data.

Good examples:

```text
Student
User
Product
Book
Message
Weather
Employee
ApiResponse
LoginUiState
```

Example:

```kotlin
data class Product(
    val id: Int,
    val name: String,
    val price: Double
)
```

---

# 33. When Should You Use a Normal Class?

Don't make every class a data class.

For example:

```kotlin
class BankAccount {

    fun deposit(amount: Double) {
        // ...
    }

    fun withdraw(amount: Double) {
        // ...
    }
}
```

The main purpose here is behavior.

So:

```text
Data class
→ Primarily represents data

Normal class
→ General-purpose object
```

---

# 34. Important Example: `equals()` and `hashCode()`

Consider:

```kotlin
data class Student(
    val id: Int,
    val name: String
)

val student1 = Student(101, "Mazharul")
val student2 = Student(101, "Mazharul")
```

Then:

```kotlin
student1 == student2
```

is:

```text
true
```

And:

```kotlin
student1.hashCode() == student2.hashCode()
```

is also:

```text
true
```

This relationship is important for collections such as:

```text
HashSet
HashMap
```

---

# 35. Mini Example

```kotlin
data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val price: Double
)

fun main() {

    val book1 = Book(
        id = 1,
        title = "Kotlin Basics",
        author = "John",
        price = 500.0
    )

    val book2 = Book(
        id = 1,
        title = "Kotlin Basics",
        author = "John",
        price = 500.0
    )

    println(book1)
    println(book1 == book2)

    val book3 = book1.copy(
        price = 600.0
    )

    println(book3)

    val (id, title, author, price) = book1

    println(id)
    println(title)
    println(author)
    println(price)
}
```

---

# 36. Practice

Create:

```kotlin
data class Employee(
    val id: Int,
    val name: String,
    val position: String,
    val salary: Double
)
```

Then create three employees.

### Task 1

Print every employee.

### Task 2

Compare two employees using:

```kotlin
==
```

### Task 3

Create an updated employee using:

```kotlin
copy()
```

### Task 4

Destructure one employee:

```kotlin
val (id, name, position, salary) = employee
```

### Task 5

Print:

```kotlin
employee.hashCode()
```

---

# 37. Quick Quiz

Answer these without looking at the notes:

1. What is a data class?
2. Why do we use data classes?
3. Which functions does Kotlin automatically generate?
4. What does `toString()` do?
5. How does `equals()` work in a data class?
6. What is `hashCode()` used for?
7. What does `copy()` do?
8. Why is `copy()` useful with `val` properties?
9. What is destructuring?
10. What are `component1()` and `component2()`?
11. Which properties participate in generated `equals()`?
12. Can a data class have functions?
13. Can a data class have nullable properties?
14. Why are data classes useful in Android?
15. What is the difference between `==` and `===`?

---

# 38. Quick Revision

```text
DATA CLASS
│
├── Primarily holds data
│
├── toString()
│
├── equals()
│
├── hashCode()
│
├── copy()
│
└── componentN()
       ↓
   Destructuring
```

Example:

```kotlin
data class Student(
    val id: Int,
    val name: String
)
```

Compare:

```kotlin
student1 == student2
```

Copy:

```kotlin
val updated = student.copy(
    name = "Rahim"
)
```

Destructure:

```kotlin
val (id, name) = student
```

Print:

```kotlin
println(student)
```

---

# 39. Most Important Points

Remember these five things:

### 1. Data class represents data

```kotlin
data class Student(
    val id: Int,
    val name: String
)
```

### 2. `toString()`

```kotlin
println(student)
```

### 3. `equals()`

```kotlin
student1 == student2
```

compares their data.

### 4. `copy()`

```kotlin
val updated = student.copy(
    name = "Rahim"
)
```

creates a new object with selected values changed.

### 5. Destructuring

```kotlin
val (id, name) = student
```

extracts the values.

---

# Summary

A **data class** is a Kotlin class primarily designed to represent data.

Kotlin automatically generates:

```text
toString()
equals()
hashCode()
copy()
componentN()
```

For Android development, data classes are especially important for:

```text
API Models
Database Models
RecyclerView Items
UI State
User Data
Messages
Products
```

The most important example to remember is:

```kotlin
data class Student(
    val id: Int,
    val name: String
)
```

Then:

```kotlin
println(student)
```

uses `toString()`.

```kotlin
student1 == student2
```

uses structural equality.

```kotlin
student.copy(name = "Rahim")
```

creates a modified copy.

```kotlin
val (id, name) = student
```

uses destructuring.

And:

```kotlin
student.hashCode()
```

returns the hash code generated from the data-class constructor properties.