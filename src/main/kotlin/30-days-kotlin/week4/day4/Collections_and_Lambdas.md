# Week 4 Day 4 — Practice: Collections and Lambdas

## Goal

Practice combining Kotlin Collections and Lambda expressions.

```kotlin
students
    .filter { it.age >= 18 }
    .map { it.name }
    .forEach { println(it) }
```

---

## 1. Collection Review

### List

```kotlin
val numbers = listOf(10, 20, 30, 40)
println(numbers[0])
```

### MutableList

```kotlin
val numbers = mutableListOf(10, 20, 30)
numbers.add(40)
numbers.remove(20)
```

### Set

A `Set` does not keep duplicate elements.

```kotlin
val numbers = setOf(10, 20, 20, 30)
```

Result:

```text
[10, 20, 30]
```

### Map

A `Map` stores key-value pairs.

```kotlin
val students = mapOf(
    101 to "Rahim",
    102 to "Karim",
    103 to "Hasan"
)

println(students[101])
```

---

## 2. Lambda Review

Normal function:

```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```

Lambda:

```kotlin
val add = { a: Int, b: Int -> a + b }
println(add(10, 20))
```

For one parameter, Kotlin provides `it`:

```kotlin
numbers.filter { it > 10 }
```

instead of:

```kotlin
numbers.filter { number -> number > 10 }
```

---

## 3. `forEach`

Performs an action for every element.

```kotlin
val numbers = listOf(10, 20, 30, 40)

numbers.forEach {
    println(it)
}
```

Think:

```text
forEach → Do something with every element
```

---

## 4. `filter`

Keeps elements that satisfy a condition.

```kotlin
val numbers = listOf(5, 10, 15, 20, 25)

val result = numbers.filter {
    it > 15
}
```

Result:

```text
[20, 25]
```

Even numbers:

```kotlin
val evenNumbers = numbers.filter {
    it % 2 == 0
}
```

Think:

```text
filter → Choose / keep matching elements
```

---

## 5. `map`

Transforms every element.

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

Think:

```text
map → Transform every element
```

### `filter` vs `map`

```text
filter → choose
map    → transform
```

---

## 6. `find`

Returns the first element that matches.

```kotlin
val numbers = listOf(10, 20, 30, 40)

val result = numbers.find {
    it > 25
}
```

Result:

```text
30
```

If nothing matches:

```kotlin
val result = numbers.find {
    it > 100
}
```

Result:

```text
null
```

---

## 7. `any`

Checks whether at least one element matches.

```kotlin
val numbers = listOf(1, 3, 5, 8)

val result = numbers.any {
    it % 2 == 0
}
```

Result:

```text
true
```

Think:

```text
any → At least one?
```

---

## 8. `all`

Checks whether every element matches.

```kotlin
val numbers = listOf(2, 4, 6, 8)

val result = numbers.all {
    it % 2 == 0
}
```

Result:

```text
true
```

Think:

```text
any → at least one
all → every one
```

---

## 9. `count`

Counts elements matching a condition.

```kotlin
val numbers = listOf(10, 15, 20, 25, 30)

val count = numbers.count {
    it >= 20
}
```

Result:

```text
3
```

---

# 10. Student Practice

Create:

```kotlin
data class Student(
    val id: Int,
    val name: String,
    val age: Int,
    val department: String
)
```

Data:

```kotlin
val students = listOf(
    Student(1, "Rahim", 20, "CSE"),
    Student(2, "Karim", 22, "EEE"),
    Student(3, "Hasan", 19, "CSE"),
    Student(4, "Sakib", 24, "BBA"),
    Student(5, "Nayeem", 21, "CSE")
)
```

## Print all names

```kotlin
students.forEach {
    println(it.name)
}
```

## Find CSE students

```kotlin
val cseStudents = students.filter {
    it.department == "CSE"
}
```

## Get only CSE names

```kotlin
val cseNames = students
    .filter { it.department == "CSE" }
    .map { it.name }
```

## Print CSE names

```kotlin
students
    .filter { it.department == "CSE" }
    .map { it.name }
    .forEach {
        println(it)
    }
```

Read this as:

```text
students
   ↓
keep CSE students
   ↓
take their names
   ↓
print each name
```

---

## Find a student

```kotlin
val student = students.find {
    it.id == 3
}
```

## Find by name

```kotlin
val student = students.find {
    it.name == "Sakib"
}

student?.let {
    println(it.name)
}
```

## Students older than 20

```kotlin
val studentsAbove20 = students.filter {
    it.age > 20
}
```

## Get ages

```kotlin
val ages = students.map {
    it.age
}
```

## Uppercase names

```kotlin
val names = students.map {
    it.name.uppercase()
}
```

---

# 11. Combining Collection Functions

Find names of CSE students above 20:

```kotlin
val result = students
    .filter {
        it.department == "CSE" && it.age > 20
    }
    .map {
        it.name
    }
```

Result:

```text
[Nayeem]
```

Count CSE students:

```kotlin
val count = students.count {
    it.department == "CSE"
}
```

Check whether any student is under 18:

```kotlin
val hasMinor = students.any {
    it.age < 18
}
```

Check whether all students are adults:

```kotlin
val allAdults = students.all {
    it.age >= 18
}
```

---

# 12. Sorting

Sort by age:

```kotlin
val sortedStudents = students.sortedBy {
    it.age
}
```

Oldest first:

```kotlin
val sortedStudents = students.sortedByDescending {
    it.age
}
```

Sort by name:

```kotlin
val sortedStudents = students.sortedBy {
    it.name
}
```

---

# 13. Find Oldest / Youngest

Oldest:

```kotlin
val oldest = students.maxByOrNull {
    it.age
}

oldest?.let {
    println(it.name)
}
```

Youngest:

```kotlin
val youngest = students.minByOrNull {
    it.age
}
```

---

# 14. Android-Style Example

Suppose an Android app receives:

```kotlin
val students: List<Student>
```

from Room or an API.

Show only CSE students:

```kotlin
val cseStudents = students.filter {
    it.department == "CSE"
}
```

Get their names:

```kotlin
val names = cseStudents.map {
    it.name
}
```

Process/display them:

```kotlin
names.forEach {
    println(it)
}
```

Or chain everything:

```kotlin
students
    .filter { it.department == "CSE" }
    .map { it.name }
    .forEach { println(it) }
```

---

# 15. Practice Exercises

Given:

```kotlin
val numbers = listOf(
    5, 10, 15, 20, 25, 30, 35, 40
)
```

1. Get all numbers greater than `20` using `filter`.
2. Get the square of every number using `map`.
3. Find the first number greater than `30` using `find`.
4. Count even numbers using `count`.
5. Check whether any number is greater than `50` using `any`.

### Student Exercises

Using the `students` list:

1. Print all names.
2. Get all CSE students.
3. Get only CSE student names.
4. Find the student whose ID is `4`.
5. Get all students older than `20`.
6. Count CSE students.
7. Check whether any student is younger than `18`.
8. Check whether all students are at least `18`.
9. Sort students by age.
10. Get the oldest student.

---

# 16. Challenge

Find the names of all CSE students older than 20, sort alphabetically, and print them.

```kotlin
students
    .filter {
        it.department == "CSE" && it.age > 20
    }
    .map {
        it.name
    }
    .sorted()
    .forEach {
        println(it)
    }
```

Expected:

```text
Nayeem
```

---

# 17. Important Functions

| Function | Purpose |
|---|---|
| `forEach` | Do something with every element |
| `filter` | Keep matching elements |
| `map` | Transform elements |
| `find` | Find first matching element |
| `count` | Count matching elements |
| `any` | At least one matches? |
| `all` | Every element matches? |
| `sortedBy` | Sort ascending |
| `sortedByDescending` | Sort descending |
| `maxByOrNull` | Find maximum |
| `minByOrNull` | Find minimum |

---

# 18. Three Functions to Master First

### `filter`

```kotlin
students.filter {
    it.age > 20
}
```

Think:

> Which elements should I keep?

### `map`

```kotlin
students.map {
    it.name
}
```

Think:

> What should each element become?

### `forEach`

```kotlin
students.forEach {
    println(it)
}
```

Think:

> What should I do with each element?

Together:

```kotlin
students
    .filter { it.age > 20 }
    .map { it.name }
    .forEach { println(it) }
```

Read it as:

> Keep students older than 20 → get their names → print each name.

---

# 19. Final Mental Model

```text
filter
   ↓
Which ones should stay?

map
   ↓
What should each one become?

forEach
   ↓
What should I do with each one?

find
   ↓
Give me the first one that matches.

any
   ↓
Does at least one match?

all
   ↓
Do all of them match?
```

## Key Pattern

```kotlin
collection
    .filter { condition }
    .map { transformation }
    .forEach { action }
```

Practice this pattern until it feels natural.
