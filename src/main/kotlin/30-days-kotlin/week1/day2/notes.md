# Week 1 - Day 2
# Kotlin Functions

> Duration: 30 Minutes

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand what a function is
- Write Kotlin functions
- Pass parameters to functions
- Return values from functions
- Use `Unit`
- Use default arguments
- Use named arguments
- Write expression body functions
- Create local functions
- Understand function overloading

---

# 1. What is a Function?

A **function** is a reusable block of code that performs a specific task.

Instead of writing the same code multiple times, write it once and call it whenever needed.

Example

```kotlin
fun sayHello() {
    println("Hello")
}

sayHello()
sayHello()
sayHello()
```

Output

```text
Hello
Hello
Hello
```

---

# Why Use Functions?

- Reuse code
- Reduce duplication
- Improve readability
- Make programs easier to maintain
- Break large problems into smaller tasks

---

# Function Syntax

```kotlin
fun functionName(parameters): ReturnType {
    // code
}
```

Example

```kotlin
fun greet() {
    println("Welcome to Kotlin!")
}
```

Calling a function

```kotlin
greet()
```

---

# 2. Parameters

Parameters allow data to be passed into a function.

Example

```kotlin
fun greet(name: String) {
    println("Hello $name")
}

greet("Mazharul")
greet("Alex")
```

Output

```text
Hello Mazharul
Hello Alex
```

---

## Multiple Parameters

```kotlin
fun add(a: Int, b: Int) {
    println(a + b)
}

add(10, 20)
```

Output

```text
30
```

---

# Parameter vs Argument

## Parameter

A variable declared in the function definition.

```kotlin
fun greet(name: String)
```

Here,

```text
name
```

is the **parameter**.

---

## Argument

The actual value passed to the function.

```kotlin
greet("Mazharul")
```

Here,

```text
"Mazharul"
```

is the **argument**.

---

# 3. Return Values

Functions can return a value using the `return` keyword.

Example

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

Using the returned value

```kotlin
val result = add(5, 7)

println(result)
```

Output

```text
12
```

---

# 4. Unit Return Type

If a function does not return a value, Kotlin uses `Unit`.

These two functions are equivalent.

```kotlin
fun display() {
    println("Hello")
}
```

```kotlin
fun display(): Unit {
    println("Hello")
}
```

Usually, `Unit` is omitted.

---

# 5. Default Arguments

Parameters can have default values.

```kotlin
fun greet(name: String = "Guest") {
    println("Hello $name")
}
```

Usage

```kotlin
greet()

greet("Mazharul")
```

Output

```text
Hello Guest
Hello Mazharul
```

---

# Advantages of Default Arguments

- Less code
- Fewer overloaded functions
- Cleaner API

---

# 6. Named Arguments

Instead of passing values by position, pass them by parameter name.

```kotlin
fun student(name: String, age: Int) {
    println("$name is $age years old.")
}

student(age = 24, name = "Mazharul")
```

Output

```text
Mazharul is 24 years old.
```

Benefits

- Improves readability
- Avoids parameter order mistakes

---

# 7. Expression Body Functions

If a function has only one expression, use the shorter syntax.

Instead of

```kotlin
fun square(x: Int): Int {
    return x * x
}
```

Write

```kotlin
fun square(x: Int) = x * x
```

or

```kotlin
fun square(x: Int): Int = x * x
```

This is the preferred Kotlin style for simple functions.

---

# 8. Local Functions

A function can be declared inside another function.

```kotlin
fun outer() {

    fun inner() {
        println("Inner Function")
    }

    inner()
}

outer()
```

Use local functions when they are needed only inside one function.

---

# 9. Function Overloading

Multiple functions can have the same name if their parameter lists are different.

Example

```kotlin
fun add(a: Int, b: Int) = a + b

fun add(a: Double, b: Double) = a + b

fun add(a: Int, b: Int, c: Int) = a + b + c
```

Kotlin automatically calls the correct function.

---

# Android Connection

Functions are used everywhere in Android.

Examples

Input validation

```kotlin
fun validateInput(text: String): Boolean {
    return text.isNotBlank()
}
```

Price calculation

```kotlin
fun calculateTotal(price: Double, quantity: Int): Double {
    return price * quantity
}
```

Activity lifecycle

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
}
```

---

# Best Practices

## Use meaningful function names

✅ Good

```kotlin
fun calculateSalary()
```

❌ Bad

```kotlin
fun abc()
```

---

## One Function = One Responsibility

Good

```kotlin
fun calculateTax()
```

Bad

```kotlin
fun calculateTaxAndPrintAndSaveDatabase()
```

---

## Prefer Expression Body Functions

Instead of

```kotlin
fun cube(x: Int): Int {
    return x * x * x
}
```

Use

```kotlin
fun cube(x: Int) = x * x * x
```

---

# Common Beginner Mistakes

## Forgetting to Call the Function

```kotlin
fun hello() {
    println("Hello")
}
```

Nothing happens until

```kotlin
hello()
```

---

## Confusing Parameters and Arguments

Parameter

```kotlin
fun greet(name: String)
```

Argument

```kotlin
greet("Mazharul")
```

---

## Returning the Wrong Type

❌

```kotlin
fun add(a: Int, b: Int): Int {
    return "10"
}
```

The return type must match the function declaration.

---

# Interview Questions

1. What is a function?
2. Why do we use functions?
3. What is the difference between a parameter and an argument?
4. What is the default return type of a Kotlin function?
5. What are default arguments?
6. What are named arguments?
7. What is a local function?
8. What is function overloading?
9. What is an expression body function?
10. When should you use expression body functions?

---

# Key Takeaways

- Functions help reuse code.
- Parameters receive data; arguments provide data.
- Functions can return values using `return`.
- Functions that return nothing use `Unit`.
- Default arguments reduce unnecessary overloads.
- Named arguments improve readability.
- Expression body functions make simple functions concise.
- Local functions improve code organization.
- Function overloading allows multiple functions with the same name but different parameter lists.

---

# Homework

Create functions to:

1. Print `"Hello, Kotlin!"`
2. Add two integers.
3. Find the maximum of two numbers.
4. Find the maximum of three numbers.
5. Check whether a number is even.
6. Calculate the area of a rectangle.
7. Calculate the area of a circle.
8. Calculate the factorial of a number.
9. Reverse a string.
10. Count vowels in a string.
11. Create a function with a default argument.
12. Create a function using named arguments.
13. Write an expression body function to square a number.
14. Overload a function named `multiply()`.
15. Create a local function inside another function.

---

# Mini Challenge

Create a **Student Result System** using functions.

Required Functions

- `studentInfo()`
- `calculateAverage()`
- `calculateGrade()`
- `isPassed()`

Expected Output

```text
Name : Mazharul
Average : 82
Grade : A
Passed : Yes
```

---

# Quick Revision

- Function = Reusable block of code
- Parameter = Variable in function definition
- Argument = Value passed to function
- `Unit` = No return value
- Use `return` to return values
- Default arguments reduce code
- Named arguments improve readability
- Expression body functions are preferred for simple functions
- Local functions exist inside another function
- Function overloading = Same name, different parameter list

---

## Next Lesson

**Week 1 - Day 3: Null Safety**

Topics:

- Nullable vs Non-nullable Types
- Safe Call Operator (`?.`)
- Elvis Operator (`?:`)
- Not-null Assertion (`!!`)
- Safe Cast (`as?`)
- NullPointerException
- Android Examples