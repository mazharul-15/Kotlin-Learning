# Kotlin Higher-Order Functions

## 1. Definition
A higher-order function (HOF) is a function that:
- takes another function as a parameter, or
- returns a function.

In simple words: **a function that works with another function.**

## 2. Function Type

```kotlin
(Int, Int) -> Int
```

Means: takes two `Int` values and returns an `Int`.

Other examples:

```kotlin
(String) -> Int
() -> Unit
(Student) -> Unit
```

## 3. Function as a Parameter

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
}
```

Using a lambda:

```kotlin
val result = calculate(10, 5) { x, y ->
    x + y
}

println(result) // 15
```

The same function can perform different operations:

```kotlin
calculate(10, 5) { x, y -> x + y } // 15
calculate(10, 5) { x, y -> x * y } // 50
calculate(10, 5) { x, y -> x - y } // 5
```

## 4. Lambda Expression

A lambda is an anonymous function.

```kotlin
val square = { number: Int ->
    number * number
}

println(square(5)) // 25
```

Basic structure:

```kotlin
{ parameters -> expression }
```

## 5. Function Reference `::`

You can pass an existing function using `::`.

```kotlin
fun multiply(a: Int, b: Int): Int {
    return a * b
}

val result = calculate(4, 5, ::multiply)

println(result) // 20
```

Think:

```text
::multiply -> reference to the function
```

## 6. Returning a Function

A higher-order function can return a function.

```kotlin
fun createMultiplier(factor: Int): (Int) -> Int {
    return { number ->
        number * factor
    }
}

val double = createMultiplier(2)
println(double(10)) // 20

val triple = createMultiplier(3)
println(triple(10)) // 30
```

Flow:

```text
createMultiplier(3)
       ↓
returns (Int) -> Int
       ↓
triple(10)
       ↓
30
```

## 7. Collection Functions Are HOFs

### forEach

```kotlin
val numbers = listOf(10, 20, 30)

numbers.forEach { number ->
    println(number)
}
```

### map

```kotlin
val numbers = listOf(1, 2, 3, 4)

val squares = numbers.map { number ->
    number * number
}

println(squares) // [1, 4, 9, 16]
```

### filter

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

val evenNumbers = numbers.filter { number ->
    number % 2 == 0
}

println(evenNumbers) // [2, 4, 6]
```

### find

```kotlin
val numbers = listOf(10, 20, 30, 40)

val result = numbers.find { number ->
    number > 25
}

println(result) // 30
```

## 8. `it` in Lambda

When a lambda has one parameter, Kotlin allows `it`.

Instead of:

```kotlin
numbers.filter { number ->
    number > 10
}
```

You can write:

```kotlin
numbers.filter {
    it > 10
}
```

`it` means the single lambda parameter.

## 9. Trailing Lambda

If the last parameter is a function, the lambda can be written outside `()`.

Instead of:

```kotlin
calculate(10, 5, { x, y -> x + y })
```

Write:

```kotlin
calculate(10, 5) { x, y ->
    x + y
}
```

This is called **trailing lambda syntax**.

## 10. `Unit` Function Type

```kotlin
(String) -> Unit
```

Means: takes a `String` and returns `Unit`.

Example:

```kotlin
fun greet(name: String, action: (String) -> Unit) {
    action(name)
}

greet("Rahim") { name ->
    println("Hello $name")
}
```

## 11. Student Management Example

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val age: Int
)

fun processStudents(
    students: List<Student>,
    action: (Student) -> Unit
) {
    students.forEach { student ->
        action(student)
    }
}
```

Different behavior can be passed:

```kotlin
processStudents(students) {
    println(it.name)
}

processStudents(students) {
    println("${it.name} - ${it.age}")
}
```

The structure stays the same; only the behavior changes.

## 12. Android Connection

Higher-order functions are very common in Android.

For example:

```kotlin
button.setOnClickListener {
    println("Button clicked")
}
```

The lambda is passed as behavior to `setOnClickListener()`.

They are also heavily used with:
- RecyclerView click listeners
- `map`
- `filter`
- `forEach`
- scope functions
- callbacks

## 13. Important Difference

```kotlin
operation
```

means the function value/reference.

```kotlin
operation()
```

means call/execute the function.

Example:

```kotlin
fun calculate(operation: () -> Int): Int {
    return operation()
}
```

## 14. Higher-Order Function vs Lambda

**Lambda:**

```kotlin
{ x: Int -> x * 2 }
```

An anonymous function.

**Higher-order function:**

```kotlin
fun process(operation: (Int) -> Int) {
    // uses operation
}
```

A function that accepts or returns a function.

Remember:

```text
Lambda = function value
Higher-order function = function that works with functions
```

## 15. Mental Model

```text
Higher-Order Function
        ↓
accepts function OR returns function
        ↓
Function Type
        ↓
(Int) -> Int
(String) -> Boolean
(Student) -> Unit
        ↓
Lambda / Function Reference
        ↓
{ x -> x * 2 }
::functionName
```

## 16. Practice

### Practice 1
Create:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int
```

Test addition, subtraction, multiplication, and division.

### Practice 2
Create:

```kotlin
fun processNumber(
    number: Int,
    operation: (Int) -> Int
): Int
```

Test:

```kotlin
processNumber(5) { it * 2 }
processNumber(5) { it * it }
```

### Practice 3
Given:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)
```

Use `filter`, `map`, and `forEach` to:
1. get even numbers,
2. square them,
3. print them.

Expected:

```text
4
16
36
```

## 17. Quick Revision

1. HOF accepts or returns a function.
2. `(Int) -> Int` is a function type.
3. Lambda is an anonymous function.
4. `::functionName` is a function reference.
5. `it` represents a single lambda parameter.
6. `map`, `filter`, `find`, and `forEach` use HOFs.
7. HOFs are important in Android development.
