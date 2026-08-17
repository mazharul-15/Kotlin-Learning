# Kotlin Lambda Expressions

## What is a Lambda?

A Lambda Expression is an anonymous function (a function without a name).

Normal Function:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

Lambda:

```kotlin
val add = { a: Int, b: Int ->
    a + b
}
```

Usage:

```kotlin
println(add(10, 20))
```

Output:

```text
30
```

---

# Why Do We Need Lambdas?

Lambdas allow us to:

- Write shorter code
- Pass functions as parameters
- Work efficiently with collections
- Handle click events in Android
- Use higher-order functions

Example:

```kotlin
button.setOnClickListener {
    println("Button clicked")
}
```

The code inside `{}` is a lambda.

---

# Lambda Syntax

General Syntax:

```kotlin
{ parameters -> body }
```

Example:

```kotlin
{ a: Int, b: Int ->
    a + b
}
```

Structure:

```text
{ parameters -> body }
```

The arrow (`->`) separates:

```text
Parameters → Body
```

---

# Lambda With No Parameters

```kotlin
val sayHello = {
    println("Hello Kotlin")
}
```

Usage:

```kotlin
sayHello()
```

Output:

```text
Hello Kotlin
```

---

# Lambda With One Parameter

```kotlin
val square = { number: Int ->
    number * number
}
```

Usage:

```kotlin
println(square(5))
```

Output:

```text
25
```

---

# Lambda With Multiple Parameters

```kotlin
val add = { a: Int, b: Int ->
    a + b
}
```

Usage:

```kotlin
println(add(10, 20))
```

Output:

```text
30
```

---

# Return Value of Lambda

The last expression becomes the return value.

Example:

```kotlin
val square = { number: Int ->
    number * number
}
```

Here:

```kotlin
number * number
```

is automatically returned.

Usage:

```kotlin
val result = square(6)

println(result)
```

Output:

```text
36
```

No need to write:

```kotlin
return
```

inside a lambda.

---

# Lambda Type

Every lambda has a type.

Example:

```kotlin
val add: (Int, Int) -> Int = { a, b ->
    a + b
}
```

Meaning:

```text
(Int, Int) -> Int

Input:
Int, Int

Output:
Int
```

---

# Another Lambda Type Example

```kotlin
val greet: (String) -> String = { name ->
    "Hello $name"
}
```

Meaning:

```text
Input:
String

Output:
String
```

Usage:

```kotlin
println(greet("Mazharul"))
```

Output:

```text
Hello Mazharul
```

---

# Lambda Returning Boolean

```kotlin
val isAdult: (Int) -> Boolean = { age ->
    age >= 18
}
```

Usage:

```kotlin
println(isAdult(25))
```

Output:

```text
true
```

---

# Unit Type

If a lambda returns nothing useful:

```kotlin
val printName: (String) -> Unit = { name ->
    println(name)
}
```

Usage:

```kotlin
printName("Mazharul")
```

Output:

```text
Mazharul
```

`Unit` is similar to Java's `void`.

---

# Type Inference

Kotlin can often infer types automatically.

Instead of:

```kotlin
val add: (Int, Int) -> Int = { a: Int, b: Int ->
    a + b
}
```

Write:

```kotlin
val add: (Int, Int) -> Int = { a, b ->
    a + b
}
```

Kotlin already knows:

```text
a = Int
b = Int
```

---

# Lambda Stored in a Variable

```kotlin
val square = { number: Int ->
    number * number
}
```

The lambda is stored inside:

```text
square
```

Usage:

```kotlin
println(square(10))
```

Output:

```text
100
```

---

# Higher-Order Function

A function that:

- Accepts another function
- Returns another function

is called a Higher-Order Function.

Example:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
}
```

Here:

```kotlin
operation
```

is a function parameter.

---

# Passing Lambda as Parameter

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
}
```

Usage:

```kotlin
val result = calculate(10, 5) { x, y ->
    x + y
}

println(result)
```

Output:

```text
15
```

---

# Different Operations Using Same Function

Addition:

```kotlin
calculate(10, 5) { a, b ->
    a + b
}
```

Subtraction:

```kotlin
calculate(10, 5) { a, b ->
    a - b
}
```

Multiplication:

```kotlin
calculate(10, 5) { a, b ->
    a * b
}
```

This makes functions reusable.

---

# Trailing Lambda

When the last parameter is a lambda:

Instead of:

```kotlin
calculate(
    10,
    20,
    { a, b ->
        a + b
    }
)
```

We write:

```kotlin
calculate(10, 20) { a, b ->
    a + b
}
```

This is called:

```text
Trailing Lambda Syntax
```

Very common in Android.

---

# The `it` Keyword

If a lambda has only one parameter:

Instead of:

```kotlin
numbers.forEach { number ->
    println(number)
}
```

We can write:

```kotlin
numbers.forEach {
    println(it)
}
```

Here:

```text
it
↓
current item
```

---

# forEach

Executes code for every element.

```kotlin
val numbers = listOf(1, 2, 3)

numbers.forEach {
    println(it)
}
```

Output:

```text
1
2
3
```

---

# map

Transforms each item.

```kotlin
val numbers = listOf(1, 2, 3, 4)

val squares = numbers.map {
    it * it
}
```

Result:

```text
[1, 4, 9, 16]
```

---

# filter

Keeps items that satisfy a condition.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

val evenNumbers = numbers.filter {
    it % 2 == 0
}
```

Result:

```text
[2, 4, 6]
```

---

# find

Returns the first matching item.

```kotlin
val numbers = listOf(10, 20, 30, 40)

val result = numbers.find {
    it > 20
}

println(result)
```

Output:

```text
30
```

If not found:

```text
null
```

---

# any

Checks whether at least one item matches.

```kotlin
val numbers = listOf(1, 3, 5, 8)

println(
    numbers.any {
        it % 2 == 0
    }
)
```

Output:

```text
true
```

---

# all

Checks whether all items match.

```kotlin
val numbers = listOf(2, 4, 6)

println(
    numbers.all {
        it % 2 == 0
    }
)
```

Output:

```text
true
```

---

# none

Checks whether no items match.

```kotlin
val numbers = listOf(1, 3, 5)

println(
    numbers.none {
        it % 2 == 0
    }
)
```

Output:

```text
true
```

---

# Combining Collection Functions

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)
```

Get even numbers:

```kotlin
val result = numbers
    .filter { it % 2 == 0 }
    .map { it * 10 }
```

Result:

```text
[20, 40, 60]
```

Flow:

```text
[1,2,3,4,5,6]
        ↓
filter even
        ↓
[2,4,6]
        ↓
map ×10
        ↓
[20,40,60]
```

---

# Lambda With Multiple Statements

```kotlin
val calculate = { a: Int, b: Int ->

    val sum = a + b

    val result = sum * 2

    result
}
```

The last expression:

```kotlin
result
```

becomes the return value.

---

# Function Reference (::)

Normal Function:

```kotlin
fun square(number: Int): Int {
    return number * number
}
```

Function Reference:

```kotlin
val operation = ::square
```

Usage:

```kotlin
println(operation(5))
```

Output:

```text
25
```

---

# Android Example 1: Click Listener

```kotlin
binding.btnLogin.setOnClickListener {
    println("Login clicked")
}
```

The code inside `{}` is a lambda.

---

# Android Example 2: Toast

```kotlin
binding.btnLogin.setOnClickListener {

    Toast.makeText(
        this,
        "Login Clicked",
        Toast.LENGTH_SHORT
    ).show()
}
```

When user clicks:

```text
Button Click
      ↓
Lambda Executes
      ↓
Toast Shows
```

---

# Android Example 3: RecyclerView

Adapter:

```kotlin
class StudentAdapter(
    val onItemClick: (Student) -> Unit
)
```

Usage:

```kotlin
StudentAdapter { student ->
    println(student.name)
}
```

When a student item is clicked:

```text
Student Click
      ↓
Lambda Executes
```

---

# Common Mistake 1

Function:

```kotlin
fun sayHello() {
    println("Hello")
}
```

Lambda:

```kotlin
val sayHello = {
    println("Hello")
}
```

These are not the same thing.

---

# Common Mistake 2

Creating Lambda:

```kotlin
val add = { a: Int, b: Int ->
    a + b
}
```

Executing Lambda:

```kotlin
add(10, 20)
```

Remember:

```text
Create
↓
Store Lambda

Execute
↓
Call Lambda
```

---

# Interview Questions

### What is a Lambda?

An anonymous function stored in a variable or passed as an argument.

---

### What is a Higher-Order Function?

A function that accepts or returns another function.

---

### What is Trailing Lambda?

Moving the lambda outside parentheses when it is the last parameter.

Example:

```kotlin
calculate(10, 20) { a, b ->
    a + b
}
```

---

### What is `it`?

The default name for a single lambda parameter.

Example:

```kotlin
numbers.forEach {
    println(it)
}
```

---

# Android Interview Point

You will use lambdas in:

- Click Listeners
- RecyclerView
- Coroutines
- Flow
- LiveData
- StateFlow
- Room
- Retrofit Callbacks
- Jetpack Compose

---

# Quick Revision

Lambda:

```kotlin
val square = { number: Int ->
    number * number
}
```

Function Type:

```kotlin
(Int) -> Int
```

Higher-Order Function:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int
```

Trailing Lambda:

```kotlin
calculate(10, 20) { a, b ->
    a + b
}
```

it:

```kotlin
numbers.forEach {
    println(it)
}
```

map:

```kotlin
numbers.map {
    it * 2
}
```

filter:

```kotlin
numbers.filter {
    it % 2 == 0
}
```

Android:

```kotlin
binding.btnLogin.setOnClickListener {
    // lambda
}
```

---

# Summary

- Lambda = Anonymous Function
- Syntax = `{ parameters -> body }`
- Last expression is returned automatically
- Lambdas can be stored in variables
- Lambdas can be passed to functions
- Higher-Order Functions accept or return functions
- `it` is the default name for a single parameter
- `map`, `filter`, `forEach` heavily use lambdas
- Android uses lambdas everywhere (ClickListener, RecyclerView, Coroutines, Compose)

The most important syntax to remember:

```kotlin
{ parameters -> body }
```

Example:

```kotlin
val add = { a: Int, b: Int ->
    a + b
}
```