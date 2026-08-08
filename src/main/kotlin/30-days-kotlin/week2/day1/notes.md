# Week 2 - Day 1
# Object-Oriented Programming (OOP) in Kotlin

> Duration: 30 Minutes

Object-Oriented Programming (OOP) is a programming approach where we organize code around **objects**.

OOP is extremely important in Kotlin and Android development because Android applications are heavily based on classes and objects.

---

# Learning Objectives

After completing this lesson, you should understand:

- What is OOP?
- What is a Class?
- What is an Object?
- What are Properties?
- What are Member Functions?
- What is a Constructor?
- What is a Primary Constructor?
- What is an `init` block?
- What is `this`?
- Difference between `val` and `var` in classes
- Constructor parameters vs Properties
- How classes and objects work together

---

# 1. What is OOP?

**OOP = Object-Oriented Programming**

It is a programming paradigm where programs are organized around **objects**.

An object usually contains:

```text
Data + Behavior
```

For example, a Student can have:

```text
Data:
    Name
    Department
    CGPA

Behavior:
    Print information
    Change department
```

In Kotlin:

```kotlin
class Student(
    val name: String,
    var department: String,
    val cgpa: Double
) {

    fun printInfo() {
        println("Name: $name")
        println("Department: $department")
        println("CGPA: $cgpa")
    }
}
```

---

# 2. Class

A **class is a blueprint or template for creating objects**.

Example:

```kotlin
class Student(
    val name: String,
    val department: String,
    val cgpa: Double
)
```

The class defines what information a Student object should contain.

Think of it like a blueprint:

```text
Student Class
│
├── name
├── department
└── cgpa
```

The class itself is not a specific student.

---

# 3. Object

An **object is an instance of a class**.

Example:

```kotlin
val student1 = Student(
    "Mazharul",
    "CSE",
    3.31
)
```

Another object:

```kotlin
val student2 = Student(
    "Rahim",
    "EEE",
    3.50
)
```

Now:

```text
Student Class
      │
      ├── student1
      │     ├── Mazharul
      │     ├── CSE
      │     └── 3.31
      │
      └── student2
            ├── Rahim
            ├── EEE
            └── 3.50
```

Both objects come from the same class but contain different data.

---

# 4. Class vs Object

| Class | Object |
|-------|--------|
| Blueprint | Actual instance |
| Defines structure | Contains actual data |
| Does not represent one specific student | Represents a specific student |
| Used to create objects | Created from a class |

Example:

```text
Class  → Student
Object → student1
Object → student2
```

---

# 5. Properties

Variables declared inside a class are called **properties**.

Example:

```kotlin
class Student(
    val name: String,
    val age: Int,
    val cgpa: Double
)
```

Here:

```text
name → Property
age  → Property
cgpa → Property
```

Access properties through an object:

```kotlin
val student = Student(
    "Mazharul",
    24,
    3.31
)

println(student.name)
println(student.age)
println(student.cgpa)
```

Output:

```text
Mazharul
24
3.31
```

---

# 6. `val` vs `var` in Classes

## `val`

A `val` property cannot be reassigned after initialization.

```kotlin
class Student(
    val name: String
)
```

This is not allowed:

```kotlin
student.name = "Rahim"
```

---

## `var`

A `var` property can be changed.

```kotlin
class Student(
    var name: String
)
```

Now:

```kotlin
student.name = "Rahim"
```

is valid.

---

## Simple Rule

```text
val → Cannot be reassigned
var → Can be reassigned
```

Use `val` by default unless the property actually needs to change.

---

# 7. Member Functions

A function declared inside a class is called a **member function**.

Example:

```kotlin
class Student(
    val name: String,
    val cgpa: Double
) {

    fun printInfo() {
        println("Name: $name")
        println("CGPA: $cgpa")
    }
}
```

Create an object:

```kotlin
val student = Student(
    "Mazharul",
    3.31
)
```

Call the function:

```kotlin
student.printInfo()
```

Output:

```text
Name: Mazharul
CGPA: 3.31
```

---

# 8. Data + Behavior

A class can contain both:

```text
Data
+
Behavior
```

Example:

```kotlin
class Calculator(
    val number1: Int,
    val number2: Int
) {

    fun add(): Int {
        return number1 + number2
    }

    fun multiply(): Int {
        return number1 * number2
    }
}
```

Usage:

```kotlin
val calculator = Calculator(10, 20)

println(calculator.add())
println(calculator.multiply())
```

Output:

```text
30
200
```

---

# 9. Constructor

A constructor is used to initialize an object when it is created.

Example:

```kotlin
class Student(
    val name: String,
    val age: Int
)
```

When creating an object:

```kotlin
val student = Student(
    "Mazharul",
    24
)
```

The values are passed through the constructor.

---

# 10. Primary Constructor

The constructor written directly in the class declaration is called the **primary constructor**.

Example:

```kotlin
class Student(
    val name: String,
    val age: Int
)
```

This part is the primary constructor:

```kotlin
(
    val name: String,
    val age: Int
)
```

---

# 11. Constructor Parameters vs Properties

Consider:

```kotlin
class Student(
    name: String,
    age: Int
)
```

Here `name` and `age` are constructor parameters.

They are NOT properties.

Therefore this will not work:

```kotlin
student.name
```

---

Now:

```kotlin
class Student(
    val name: String,
    val age: Int
)
```

Here `name` and `age` are both:

```text
Constructor parameters
+
Properties
```

Therefore:

```kotlin
student.name
student.age
```

works.

---

# 12. `init` Block

The `init` block runs automatically when an object is created.

Example:

```kotlin
class Student(
    val name: String,
    val age: Int
) {

    init {
        println("Student object created")
    }
}
```

Creating the object:

```kotlin
val student = Student(
    "Mazharul",
    24
)
```

Output:

```text
Student object created
```

---

# 13. Using `init` for Validation

`init` can be used to validate values during object creation.

Example:

```kotlin
class Student(
    val name: String,
    val cgpa: Double
) {

    init {
        require(cgpa in 0.0..4.0)
    }
}
```

Valid:

```kotlin
val student = Student(
    "Mazharul",
    3.31
)
```

Invalid:

```kotlin
val student = Student(
    "Mazharul",
    5.0
)
```

The second example throws an exception because CGPA must be between `0.0` and `4.0`.

---

# 14. `this` Keyword

`this` refers to the **current object**.

Example:

```kotlin
class Student(
    val name: String
) {

    fun printName() {
        println(this.name)
    }
}
```

Here:

```kotlin
this.name
```

means:

> The `name` property belonging to the current object.

---

# 15. `this` with Same Names

Consider:

```kotlin
class Student(
    name: String
) {

    val name = name
}
```

This can be confusing because both are called `name`.

You can use `this` to make the distinction clear:

```kotlin
class Student(
    name: String
) {

    val name: String

    init {
        this.name = name
    }
}
```

Here:

```text
this.name
    ↓
Class property

name
    ↓
Constructor parameter
```

---

# 16. Complete OOP Example

```kotlin
class Student(
    val name: String,
    var department: String,
    val cgpa: Double
) {

    init {
        require(cgpa in 0.0..4.0)
    }

    fun printInfo() {
        println("Name       : $name")
        println("Department : $department")
        println("CGPA       : $cgpa")
    }

    fun changeDepartment(newDepartment: String) {
        department = newDepartment
    }
}
```

Create object:

```kotlin
val student = Student(
    "Mazharul",
    "CSE",
    3.31
)
```

Call function:

```kotlin
student.printInfo()
```

Change department:

```kotlin
student.changeDepartment(
    "Software Engineering"
)
```

Print again:

```kotlin
student.printInfo()
```

---

# 17. Multiple Objects

A single class can create many objects.

```kotlin
val student1 = Student(
    "Mazharul",
    "CSE",
    3.31
)

val student2 = Student(
    "Rahim",
    "EEE",
    3.50
)

val student3 = Student(
    "Karim",
    "BBA",
    3.20
)
```

Each object has its own data.

```text
Student
   │
   ├── student1
   │     name = Mazharul
   │     cgpa = 3.31
   │
   ├── student2
   │     name = Rahim
   │     cgpa = 3.50
   │
   └── student3
         name = Karim
         cgpa = 3.20
```

---

# 18. Object Communication

One object can contain another object.

Example:

```kotlin
class Address(
    val city: String
)

class Student(
    val name: String,
    val address: Address
)
```

Create an Address:

```kotlin
val address = Address("Dhaka")
```

Create a Student:

```kotlin
val student = Student(
    "Mazharul",
    address
)
```

Access:

```kotlin
println(student.name)
println(student.address.city)
```

Output:

```text
Mazharul
Dhaka
```

This is called **object composition** and will become important later.

---

# 19. OOP in Android

Android code heavily uses classes and objects.

Example:

```kotlin
class MainActivity : AppCompatActivity()
```

`MainActivity` is a class.

Another example:

```kotlin
class UserViewModel : ViewModel()
```

`UserViewModel` is also a class.

Other Android concepts commonly represented by classes include:

```text
Activity
Fragment
ViewModel
Repository
User
Product
Message
Database Entity
```

Understanding OOP is therefore essential for Android development.

---

# 20. Four Major OOP Concepts

Kotlin OOP has four major concepts:

```text
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction
```

We are starting with the foundation:

```text
Class
Object
Property
Function
Constructor
```

The remaining OOP concepts will be covered in the upcoming lessons.

---

# Best Practices

### 1. Prefer `val`

Use:

```kotlin
val name: String
```

instead of:

```kotlin
var name: String
```

when the value doesn't need to change.

---

### 2. Keep classes focused

A class should have a clear responsibility.

Avoid creating one huge class that does everything.

---

### 3. Use meaningful names

Good:

```kotlin
class Student
class BankAccount
class UserRepository
```

Avoid:

```kotlin
class A
class Test1
class X
```

---

### 4. Keep validation close to the data

For example:

```kotlin
class Student(
    val name: String,
    val cgpa: Double
) {

    init {
        require(cgpa in 0.0..4.0)
    }
}
```

This ensures an invalid `Student` object cannot be created.

---

# Common Beginner Mistakes

## Mistake 1: Confusing Class and Object

Incorrect understanding:

```text
Student = Mazharul
```

Correct:

```text
Student = Class

student1 = Object
student2 = Object
```

---

## Mistake 2: Forgetting `val` or `var`

```kotlin
class Student(
    name: String
)
```

`name` is only a constructor parameter.

If you want it to become a property:

```kotlin
class Student(
    val name: String
)
```

---

## Mistake 3: Making Everything `var`

Don't automatically use:

```kotlin
var
```

Prefer:

```kotlin
val
```

when the value doesn't need to change.

---

# Interview Questions

1. What is OOP?
2. What is a class?
3. What is an object?
4. Difference between a class and an object?
5. What is a property?
6. What is a member function?
7. What is a constructor?
8. What is a primary constructor?
9. Difference between a constructor parameter and a property?
10. What is the purpose of `init`?
11. What does `this` refer to?
12. Difference between `val` and `var`?
13. What are the four major concepts of OOP?

---

# Practice

## Exercise 1 — Book

Create a `Book` class with:

```text
title
author
price
```

Add:

```kotlin
printInfo()
```

Example:

```kotlin
val book = Book(
    "Clean Code",
    "Robert C. Martin",
    500.0
)
```

Expected:

```text
Title  : Clean Code
Author : Robert C. Martin
Price  : 500.0
```

---

## Exercise 2 — BankAccount

Create:

```kotlin
class BankAccount(
    val accountHolder: String,
    var balance: Double
)
```

Add:

```text
deposit()
withdraw()
showBalance()
```

Requirements:

- Deposit money
- Withdraw money
- Don't allow withdrawal greater than balance
- Display current balance

---

# Mini Challenge

Create a `MobilePhone` class.

Properties:

```text
brand
model
price
```

Functions:

```text
printInfo()
applyDiscount()
```

Example:

```kotlin
val phone = MobilePhone(
    "Samsung",
    "Galaxy A55",
    45000.0
)
```

Expected:

```text
Brand : Samsung
Model : Galaxy A55
Price : 45000.0
```

Then apply a discount and display the new price.

---

# Quick Revision

```text
OOP
│
├── Class
│     └── Blueprint
│
├── Object
│     └── Instance of a class
│
├── Property
│     └── Data
│
├── Member Function
│     └── Behavior
│
├── Constructor
│     └── Initializes object
│
├── init
│     └── Runs during initialization
│
└── this
      └── Current object
```

---

# Key Takeaways

- A **class** is a blueprint.
- An **object** is an instance of a class.
- Properties represent the object's data.
- Member functions represent the object's behavior.
- The primary constructor initializes the object.
- `val` creates a read-only property.
- `var` creates a mutable property.
- `init` runs when the object is initialized.
- `this` refers to the current object.
- One class can create many independent objects.
- OOP is fundamental to Android development.

---

# Next Lesson

## Week 2 - Day 2: Inheritance

Topics:

- Inheritance
- Parent class
- Child class
- `open`
- `super`
- `override`
- Method overriding
- `final`
- Android inheritance exampleSS