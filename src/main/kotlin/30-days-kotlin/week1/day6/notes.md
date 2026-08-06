# Week 1 - Day 6
# Collections in Kotlin

> Duration: 30 Minutes

Collections are one of the most important topics in Kotlin and Android development. They allow you to store and manage groups of objects efficiently.

Unlike Arrays, most Kotlin Collections are dynamic, making them ideal for real-world Android applications.

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand Collections
- Use List and MutableList
- Use Set and MutableSet
- Use Map and MutableMap
- Iterate through Collections
- Use common Collection functions
- Know when to use each Collection
- Apply Collections in Android development

---

# 1. What is a Collection?

A Collection is a container that stores multiple objects.

Instead of writing

```kotlin
val student1 = "Mazharul"
val student2 = "Rahim"
val student3 = "Karim"
```

You can write

```kotlin
val students = listOf(
    "Mazharul",
    "Rahim",
    "Karim"
)
```

Collections make code cleaner, more organized, and easier to maintain.

---

# 2. List

A **List** is an ordered collection.

Characteristics

- Ordered
- Read-only
- Allows duplicate elements
- Elements are accessed using an index

Example

```kotlin
val fruits = listOf(
    "Apple",
    "Banana",
    "Orange"
)
```

Access Elements

```kotlin
println(fruits[0])

println(fruits.get(1))
```

Output

```text
Apple
Banana
```

Size

```kotlin
println(fruits.size)
```

Output

```text
3
```

---

# 3. MutableList

A **MutableList** is a List whose elements can be changed.

Example

```kotlin
val fruits = mutableListOf(
    "Apple",
    "Banana"
)
```

Add

```kotlin
fruits.add("Orange")
```

Remove

```kotlin
fruits.remove("Banana")
```

Update

```kotlin
fruits[0] = "Mango"
```

Output

```text
[Mango, Orange]
```

---

# List vs MutableList

| List | MutableList |
|------|-------------|
| Read-only | Read and Write |
| Cannot add elements | Can add elements |
| Cannot remove elements | Can remove elements |
| Safer | More flexible |

---

# 4. Set

A **Set** stores unique elements.

Characteristics

- No duplicate values
- Order is not guaranteed
- Read-only

Example

```kotlin
val numbers = setOf(
    10,
    20,
    20,
    30,
    30
)
```

Output

```text
[10, 20, 30]
```

Duplicate values are automatically removed.

---

# 5. MutableSet

MutableSet allows modifications.

Example

```kotlin
val numbers = mutableSetOf(
    10,
    20
)

numbers.add(30)

numbers.remove(10)
```

Output

```text
[20, 30]
```

---

# List vs Set

| List | Set |
|------|-----|
| Allows duplicates | Does not allow duplicates |
| Ordered | Order is not guaranteed |
| Index-based | No index access |

---

# 6. Map

A **Map** stores data as **Key → Value** pairs.

Example

```kotlin
val student = mapOf(
    "Name" to "Mazharul",
    "University" to "HSTU",
    "CGPA" to "3.31"
)
```

Access

```kotlin
println(student["Name"])
```

Output

```text
Mazharul
```

---

# 7. MutableMap

MutableMap allows adding, updating, and removing entries.

Example

```kotlin
val student = mutableMapOf(
    "Name" to "Mazharul"
)

student["University"] = "HSTU"

student["CGPA"] = "3.31"

student["Name"] = "Alex"

student.remove("CGPA")
```

---

# Map vs MutableMap

| Map | MutableMap |
|------|------------|
| Read-only | Read and Write |
| Cannot modify | Can modify |
| Fixed entries | Dynamic entries |

---

# 8. Iterating Through Collections

## List

```kotlin
for (fruit in fruits) {
    println(fruit)
}
```

---

## List with Index

```kotlin
for ((index, fruit) in fruits.withIndex()) {
    println("$index -> $fruit")
}
```

Output

```text
0 -> Apple
1 -> Banana
2 -> Orange
```

---

## Map

```kotlin
for ((key, value) in student) {
    println("$key : $value")
}
```

Output

```text
Name : Mazharul
University : HSTU
CGPA : 3.31
```

---

# 9. Common Collection Functions

## size

```kotlin
println(fruits.size)
```

---

## contains()

```kotlin
println(fruits.contains("Apple"))
```

Output

```text
true
```

---

## first()

```kotlin
println(fruits.first())
```

---

## last()

```kotlin
println(fruits.last())
```

---

## isEmpty()

```kotlin
println(fruits.isEmpty())
```

---

## isNotEmpty()

```kotlin
println(fruits.isNotEmpty())
```

---

## sorted()

```kotlin
val numbers = listOf(5, 2, 8, 1)

println(numbers.sorted())
```

Output

```text
[1, 2, 5, 8]
```

---

## reversed()

```kotlin
println(numbers.reversed())
```

Output

```text
[1, 8, 2, 5]
```

---

## filter()

Returns elements matching a condition.

```kotlin
val evenNumbers = numbers.filter {
    it % 2 == 0
}

println(evenNumbers)
```

Output

```text
[2, 8]
```

---

## map()

Transforms each element.

```kotlin
val doubled = numbers.map {
    it * 2
}

println(doubled)
```

Output

```text
[10, 4, 16, 2]
```

---

## forEach()

```kotlin
numbers.forEach {
    println(it)
}
```

---

# 10. Arrays vs Collections

| Array | Collection |
|--------|------------|
| Fixed size | Dynamic size |
| Less flexible | More flexible |
| Mostly used in DSA | Mostly used in Android |
| Primitive arrays available | Rich utility functions |

---

# 11. Android Examples

## RecyclerView

```kotlin
val students = mutableListOf<Student>()
```

---

## API Response

```kotlin
val users = mutableListOf<User>()
```

---

## Spinner Items

```kotlin
val countries = listOf(
    "Bangladesh",
    "USA",
    "Canada"
)
```

---

## Firebase Chat

```kotlin
val messages = mutableListOf<Message>()
```

---

## User Information

```kotlin
val user = mapOf(
    "Name" to "Mazharul",
    "Country" to "Bangladesh"
)
```

---

# Which Collection Should I Use?

| Situation | Collection |
|-----------|------------|
| Fixed data | List |
| Data changes | MutableList |
| Unique values | Set |
| Unique values with modification | MutableSet |
| Key-Value data | Map |
| Editable key-value data | MutableMap |

---

# Best Practices

- Prefer **List** over Array for most Kotlin programs.
- Use **MutableList** when data changes.
- Use **Set** to remove duplicate values.
- Use **Map** for key-value pairs.
- Use **filter()** instead of writing manual filtering loops when appropriate.
- Use **map()** when transforming every element.

---

# Common Beginner Mistakes

## Forgetting Mutable

❌

```kotlin
val fruits = listOf("Apple")

fruits.add("Orange")
```

Compile-time Error

✅

```kotlin
val fruits = mutableListOf("Apple")

fruits.add("Orange")
```

---

## Expecting Set to Store Duplicates

```kotlin
val numbers = setOf(1, 1, 1)
```

Output

```text
[1]
```

---

## Using Array for Dynamic Data

Wrong

```kotlin
Array<String>
```

Better

```kotlin
MutableList<String>
```

---

# Interview Questions

1. What is a Collection?
2. Difference between List and MutableList?
3. Difference between List and Set?
4. Difference between Map and MutableMap?
5. Difference between Array and List?
6. What does filter() do?
7. What does map() do?
8. What does forEach() do?
9. Why is MutableList commonly used in Android?
10. Which Collection removes duplicate values?

---

# Quick Revision

- List → Ordered, Read-only
- MutableList → Ordered, Read & Write
- Set → Unique elements
- MutableSet → Editable unique elements
- Map → Key-Value pairs
- MutableMap → Editable Key-Value pairs
- filter() → Select matching elements
- map() → Transform elements

---

# Homework

1. Create a List of five fruits.
2. Create a MutableList and add three students.
3. Remove one student.
4. Update one student's name.
5. Create a Set containing duplicate values.
6. Create a MutableSet and add/remove elements.
7. Create a Map of student information.
8. Create a MutableMap and update values.
9. Print all collections using loops.
10. Use filter() to find even numbers.
11. Use map() to double numbers.
12. Sort and reverse a list.

---

# Key Takeaways

- Collections store multiple objects.
- List is read-only.
- MutableList is editable.
- Set automatically removes duplicates.
- Map stores key-value pairs.
- MutableMap allows modification.
- Collections are used extensively in Android development.

---

# Next Lesson

**Week 2 – Day 1: Object-Oriented Programming (OOP)**

Topics:

- Classes
- Objects
- Constructors
- Properties
- Methods
- init Block
- Visibility Modifiers
- Android Examples