# Week 1 - Day 1
# Kotlin Fundamentals Review

> Duration: 30 Minutes

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand `val` and `var`
- Use Kotlin primitive data types
- Perform arithmetic, comparison, and logical operations
- Write `if-else` and `when` expressions
- Use `for`, `while`, and `do-while` loops
- Write cleaner Kotlin code following best practices

---

# 1. Variables

Variables are used to store data in memory.

Kotlin provides two keywords for declaring variables:

- `val` → Read-only (Immutable)
- `var` → Mutable (Can be changed)

---

## val

A `val` variable can only be assigned once.

```kotlin
val name = "Mazharul"
```

❌ Invalid

```kotlin
val age = 25
age = 26
```

---

## var

A `var` variable can be modified.

```kotlin
var age = 25
age = 26
```

---

## Best Practice

Always prefer:

```kotlin
val
```

Use:

```kotlin
var
```

only when the value must change.

---

# 2. Data Types

Kotlin supports the following common data types:

| Data Type | Example |
|-----------|---------|
| Int | 10 |
| Long | 100000000L |
| Float | 3.14F |
| Double | 3.14159 |
| Boolean | true |
| Char | 'A' |
| String | "Hello" |

Example:

```kotlin
val age: Int = 24
val salary: Double = 35000.50
val grade: Char = 'A'
val isPassed: Boolean = true
val name: String = "Mazharul"
```

---

# Type Inference

Kotlin automatically detects the data type.

Instead of

```kotlin
val age: Int = 24
```

you can write

```kotlin
val age = 24
```

This feature is called **Type Inference**.

---

# 3. Operators

## Arithmetic Operators

```text
+
-
*
/
%
```

Example

```kotlin
val a = 10
val b = 3

println(a + b)
println(a - b)
println(a * b)
println(a / b)
println(a % b)
```

---

## Comparison Operators

```text
==
!=
>
<
>=
<=
```

Example

```kotlin
println(10 > 5)
```

---

## Logical Operators

```text
&&
||
!
```

Example

```kotlin
val age = 20

println(age >= 18 && age <= 30)
```

---

# 4. if-else

Used for decision making.

Example

```kotlin
val age = 20

if (age >= 18) {
    println("Adult")
} else {
    println("Minor")
}
```

---

## if as an Expression

Kotlin allows `if` to return a value.

```kotlin
val result = if (age >= 18) "Adult" else "Minor"
```

This is the preferred Kotlin style.

---

# 5. when Expression

`when` is Kotlin's replacement for long `if-else` chains and Java's `switch`.

Example

```kotlin
val day = 3

when (day) {
    1 -> println("Saturday")
    2 -> println("Sunday")
    3 -> println("Monday")
    else -> println("Invalid Day")
}
```

---

# 6. Loops

## for Loop

```kotlin
for (i in 1..5) {
    println(i)
}
```

Output

```text
1
2
3
4
5
```

---

## until

```kotlin
for (i in 1 until 5) {
    println(i)
}
```

Output

```text
1
2
3
4
```

---

## downTo

```kotlin
for (i in 5 downTo 1) {
    println(i)
}
```

Output

```text
5
4
3
2
1
```

---

## step

```kotlin
for (i in 0..10 step 2) {
    println(i)
}
```

Output

```text
0
2
4
6
8
10
```

---

## while Loop

```kotlin
var i = 1

while (i <= 5) {
    println(i)
    i++
}
```

---

## do-while Loop

```kotlin
var i = 1

do {
    println(i)
    i++
} while (i <= 5)
```

---

# Common Beginner Mistakes

## Mistake 1

Using `var` everywhere.

❌

```kotlin
var name = "Alex"
```

✅

```kotlin
val name = "Alex"
```

---

## Mistake 2

Writing unnecessary long `if-else` statements.

Prefer

```kotlin
when
```

whenever appropriate.

---

## Mistake 3

Ignoring Kotlin's Type Inference.

Instead of

```kotlin
val age: Int = 24
```

Write

```kotlin
val age = 24
```

---

# Android Connection

These concepts are used daily in Android development.

Examples:

- `val` for Buttons, TextViews, RecyclerViews, ViewModels
- `if` for input validation
- `when` for menu handling and UI state
- Loops for displaying lists
- Operators for calculations and conditions

---

# Key Takeaways

- Prefer `val` over `var`
- Kotlin supports Type Inference
- `if` is an expression
- `when` is more powerful than Java's `switch`
- Learn different loop ranges (`..`, `until`, `downTo`, `step`)
- Master these basics before moving to advanced Kotlin

---

# Homework

1. Print your name, age, and university.
2. Swap two numbers without using a third variable.
3. Check whether a number is even or odd.
4. Find the largest of three numbers.
5. Print numbers from 1 to 100.
6. Print only even numbers from 1 to 100.
7. Print numbers from 100 down to 1.
8. Print the multiplication table of a number.
9. Find the sum of numbers from 1 to `n`.
10. Count the vowels in a string.

---

# Quick Revision

- `val` → Immutable
- `var` → Mutable
- Kotlin uses Type Inference
- `if` returns a value
- `when` replaces long `if-else`
- Learn `for`, `while`, and `do-while`
- Prefer clean and concise Kotlin code

---

**Next Lesson:** Week 1 - Day 2 → Functions