# Kotlin Generics — Basics

## 1. What Are Generics?

Generics allow us to write code that can work with **different data types** while maintaining type safety.

Examples:

```kotlin
val names: List<String>
val ages: List<Int>
val students: List<Student>
```

The type inside `< >` is called a **type argument**.

---

## 2. Why Do We Need Generics?

Without generics, we might write separate functions for different types:

```kotlin
fun printNumber(number: Int) {
    println(number)
}

fun printText(text: String) {
    println(text)
}
```

With generics:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

Now one function works with different types:

```kotlin
printValue(100)
printValue("Hello")
printValue(25.5)
printValue(true)
```

---

## 3. What Does `<T>` Mean?

In:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

`T` is a **type parameter**.

Think of:

```text
T = some type
```

For:

```kotlin
printValue(100)
```

Kotlin infers:

```text
T = Int
```

For:

```kotlin
printValue("Hello")
```

Kotlin infers:

```text
T = String
```

So:

```text
printValue(100)
       ↓
T = Int

printValue("Hello")
       ↓
T = String
```

---

## 4. `T` Is a Type Parameter

`T` is not a special data type.

You could technically write:

```kotlin
fun <X> printValue(value: X) {
    println(value)
}
```

But Kotlin conventions normally use:

```text
T → Type
E → Element
K → Key
V → Value
R → Return type
```

Usually:

```kotlin
<T>
```

is the standard choice when the type has no more specific meaning.

---

# Generic Functions

## 5. Basic Generic Function

Syntax:

```kotlin
fun <T> functionName(parameter: T) {
    // code
}
```

Example:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

Usage:

```kotlin
printValue(10)
printValue("Mazharul")
printValue(10.5)
```

---

## 6. Type Inference

Kotlin usually knows what `T` is automatically.

```kotlin
printValue(10)
```

means:

```text
T = Int
```

And:

```kotlin
printValue("Mazharul")
```

means:

```text
T = String
```

This is called **type inference**.

---

## 7. Explicitly Providing the Type

You can specify the type manually:

```kotlin
printValue<Int>(100)
```

or:

```kotlin
printValue<String>("Hello")
```

Usually this is unnecessary because Kotlin can infer the type.

---

## 8. Generic Function Returning a Value

A generic function can return `T`:

```kotlin
fun <T> getValue(value: T): T {
    return value
}
```

Usage:

```kotlin
val number = getValue(100)
val name = getValue("Mazharul")
```

Kotlin understands:

```text
number → Int
name → String
```

---

## 9. Generic Function With Two Types

A function can have multiple type parameters:

```kotlin
fun <T, R> createPair(first: T, second: R): Pair<T, R> {
    return Pair(first, second)
}
```

Usage:

```kotlin
val result = createPair("Mazharul", 25)
```

The type becomes:

```text
Pair<String, Int>
```

Here:

```text
T = String
R = Int
```

---

# Generic Classes

## 10. Basic Generic Class

Generics can also be used with classes.

```kotlin
class Box<T>(
    val value: T
)
```

Create objects:

```kotlin
val intBox = Box(100)
val stringBox = Box("Hello")
```

Kotlin infers:

```text
intBox → Box<Int>
stringBox → Box<String>
```

---

## 11. Understanding `Box<T>`

Consider:

```kotlin
class Box<T>(
    val value: T
)
```

`T` is a type parameter.

If:

```kotlin
Box(100)
```

then:

```text
T = Int
```

So conceptually:

```text
Box<Int>
```

If:

```kotlin
Box("Hello")
```

then:

```text
T = String
```

So:

```text
Box<String>
```

Think of:

```text
Box<T>
   ↓
Template

Box<Int>
   ↓
T becomes Int

Box<String>
   ↓
T becomes String
```

---

## 12. Generic Class With a Function

```kotlin
class Box<T>(
    private val value: T
) {

    fun getValue(): T {
        return value
    }
}
```

Usage:

```kotlin
val box = Box("Hello")

println(box.getValue())
```

Here:

```text
T = String
```

Therefore:

```text
getValue(): String
```

---

## 13. Generic Class With Different Types

```kotlin
val numberBox = Box(100)

val nameBox = Box("Mazharul")

val studentBox = Box(Student("Rahim", 25))
```

The same class can store:

```text
Int
String
Student
```

without creating separate classes.

---

# Generics in Collections

## 14. Generic Collections

You have already been using generics.

For example:

```kotlin
val names: List<String>
```

Here:

```text
List = generic type
String = type argument
```

Similarly:

```kotlin
val ages: List<Int>
```

means:

```text
List of Int
```

And:

```kotlin
val students: List<Student>
```

means:

```text
List of Student
```

---

## 15. `MutableList<T>`

Example:

```kotlin
val names = mutableListOf<String>()
```

Here:

```text
String
```

is the type argument.

You can add:

```kotlin
names.add("Rahim")
names.add("Karim")
```

But:

```kotlin
names.add(100)
```

causes a type error.

This is **type safety**.

---

## 16. Generic `Map`

Maps use two generic types:

```kotlin
val students: Map<Int, String>
```

Here:

```text
Int → Key
String → Value
```

Example:

```kotlin
val students = mapOf(
    1 to "Rahim",
    2 to "Karim"
)
```

The type is approximately:

```text
Map<Int, String>
```

---

## 17. `Pair<T, R>`

Kotlin's `Pair` is generic.

```kotlin
val student = Pair("Mazharul", 25)
```

Its type is:

```text
Pair<String, Int>
```

Access:

```kotlin
println(student.first)
println(student.second)
```

---

## 18. `Triple`

Kotlin also has `Triple`:

```kotlin
val student = Triple(
    "Mazharul",
    25,
    "CSE"
)
```

Type:

```text
Triple<String, Int, String>
```

Access:

```kotlin
println(student.first)
println(student.second)
println(student.third)
```

---

# Generic Constraints

## 19. Generic Function With a Constraint

Sometimes we don't want to accept every type.

Example:

```kotlin
fun <T : Number> printNumber(value: T) {
    println(value)
}
```

Here:

```text
T must be Number or a subtype of Number
```

Allowed:

```kotlin
printNumber(10)
printNumber(10.5)
printNumber(100L)
```

Not allowed:

```kotlin
printNumber("Hello")
```

because `String` is not a subtype of `Number`.

---

## 20. Understanding `<T : Number>`

This:

```kotlin
<T : Number>
```

means:

```text
T must be Number or a subtype of Number
```

Conceptually:

```text
Number
├── Int
├── Double
├── Float
└── Long
```

So:

```kotlin
fun <T : Number> printNumber(value: T)
```

accepts numeric types.

---

## 21. Multiple Generic Parameters With Constraints

You can have multiple constrained type parameters:

```kotlin
fun <T : Number, R : Number> printNumbers(
    first: T,
    second: R
) {
    println(first)
    println(second)
}
```

Both types must be numeric.

This is more advanced; for now, understand the syntax.

---

# Generics and Android

## 22. Why Generics Matter in Android

You will see generics everywhere in Android development.

Examples:

```kotlin
List<Student>
```

```kotlin
MutableList<User>
```

```kotlin
Map<Int, String>
```

```kotlin
LiveData<Student>
```

```kotlin
StateFlow<UiState>
```

```kotlin
Response<User>
```

```kotlin
Repository<Student>
```

The important idea is:

```text
Generic = reusable code that works with different types
```

---

## 23. Generic Repository

Example:

```kotlin
class Repository<T> {

    fun save(data: T) {
        println("Saving: $data")
    }
}
```

Create:

```kotlin
val studentRepository = Repository<Student>()
```

or:

```kotlin
val userRepository = Repository<User>()
```

The same repository structure can work with different types.

---

## 24. Generic Repository With a List

```kotlin
class Repository<T> {

    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }
}
```

Create:

```kotlin
val repository = Repository<Student>()
```

Then:

```kotlin
repository.add(
    Student("Rahim", 20)
)

repository.add(
    Student("Karim", 22)
)
```

This repository only accepts `Student` because:

```kotlin
Repository<Student>
```

---

## 25. Same Repository for Users

The same class can work with users:

```kotlin
val repository = Repository<User>()
```

Now it accepts:

```text
User
```

The same `Repository` class can work with:

```text
Student
User
Product
Order
Message
```

This is the power of generics.

---

# Generics vs Normal Functions

## 26. Without Generics

```kotlin
fun printString(value: String) {
    println(value)
}

fun printInt(value: Int) {
    println(value)
}
```

You need separate functions.

With generics:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

One function works with multiple types.

---

# Type Safety

## 27. Generics Preserve Type Safety

Generics do not mean:

```text
Everything is allowed everywhere.
```

They mean:

```text
Write reusable code while keeping the correct type.
```

Example:

```kotlin
val names: MutableList<String> = mutableListOf()

names.add("Rahim")
names.add("Karim")
```

But:

```kotlin
names.add(100)
```

is rejected.

This is one of the biggest benefits of generics.

---

# Generic vs `Any`

## 28. Why Not Just Use `Any`?

You might write:

```kotlin
fun printValue(value: Any) {
    println(value)
}
```

This accepts many types.

But generics preserve type relationships.

Consider:

```kotlin
fun <T> getValue(value: T): T {
    return value
}
```

Then:

```kotlin
val name = getValue("Mazharul")
```

Kotlin knows:

```text
name is String
```

With:

```kotlin
fun getValue(value: Any): Any {
    return value
}
```

the return type is only:

```text
Any
```

Generics therefore provide stronger type information.

---

# Generic Type Naming

## 29. Common Conventions

```text
T → Type
E → Element
K → Key
V → Value
R → Return type
```

Examples:

```kotlin
class Box<T>
```

```kotlin
class Result<T>
```

```kotlin
fun <T> getData(): T
```

Map:

```kotlin
Map<K, V>
```

---

# Generic Mental Model

## 30. Think of Generics as a Template

When you see:

```kotlin
class Box<T>
```

think:

```text
T is a placeholder for a type.
```

You haven't decided what `T` is yet.

Later:

```kotlin
Box<Int>
```

means:

```text
T = Int
```

And:

```kotlin
Box<String>
```

means:

```text
T = String
```

So:

```text
Box<T>
   ↓
Template

Box<Int>
   ↓
T becomes Int

Box<String>
   ↓
T becomes String
```

---

# Practice Tasks

## 31. Practice 1 — Generic Function

Create:

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

Test:

```kotlin
printValue(100)
printValue("Hello")
printValue(25.5)
printValue(true)
```

Observe that one function works with all of them.

---

## 32. Practice 2 — Generic Return

Create:

```kotlin
fun <T> getValue(value: T): T {
    return value
}
```

Test:

```kotlin
val number = getValue(100)
val name = getValue("Mazharul")
val isStudent = getValue(true)
```

Understand what type Kotlin assigns to each variable.

---

## 33. Practice 3 — Generic Class

Create:

```kotlin
class Box<T>(
    val value: T
)
```

Then:

```kotlin
val intBox = Box(100)
val stringBox = Box("Hello")
```

Print both values.

---

## 34. Practice 4 — Generic Repository

Create:

```kotlin
class Repository<T> {

    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> {
        return items
    }
}
```

Then create:

```kotlin
val studentRepository = Repository<Student>()
```

Add three students and print the list.

---

## 35. Practice 5 — Generic Constraint

Create:

```kotlin
fun <T : Number> printNumber(number: T) {
    println(number)
}
```

Test:

```kotlin
printNumber(10)
printNumber(10.5)
printNumber(100L)
```

Then try:

```kotlin
printNumber("Hello")
```

Understand why it doesn't compile.

---

# What You Should Understand Today

By the end of Day 1, you should understand:

```text
✓ What generics are
✓ Why generics are useful
✓ Type parameter T
✓ Generic functions
✓ Generic classes
✓ Generic collections
✓ Multiple type parameters
✓ Generic constraints
✓ Type safety
✓ Generic vs Any
✓ Basic Android examples
```

You do not need to learn these today:

```text
out
in
variance
reified
star projection
advanced generic constraints
```

Those are later topics.

---

# Final Cheat Sheet

## Generic Function

```kotlin
fun <T> printValue(value: T) {
    println(value)
}
```

## Generic Return Type

```kotlin
fun <T> getValue(value: T): T {
    return value
}
```

## Generic Class

```kotlin
class Box<T>(
    val value: T
)
```

## Generic Collection

```kotlin
List<String>
List<Int>
List<Student>
```

## Multiple Generic Types

```kotlin
Map<Int, String>
```

## Generic Constraint

```kotlin
fun <T : Number> printNumber(value: T) {
    println(value)
}
```

---

# Most Important Idea

When you see:

```kotlin
<T>
```

think:

> **The caller will decide what type `T` is.**

Example:

```kotlin
val box = Box(100)
```

means:

```text
T = Int
```

while:

```kotlin
val box = Box("Hello")
```

means:

```text
T = String
```

And when you see:

```kotlin
List<Student>
```

think:

> **This is a List whose element type is Student.**

Generics give Kotlin:

```text
Reusable code
      +
Type safety
      +
Strong type information
```
