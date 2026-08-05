# Week 1 - Day 5
# Arrays in Kotlin

> Duration: 30 Minutes

Arrays are one of the fundamental data structures in Kotlin. They store multiple values of the same type in a fixed-size collection.

Although **List** is more commonly used in Android development, understanding arrays is essential for DSA, interviews, and working with Java/Android APIs.

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand what an Array is
- Create Arrays
- Access and modify elements
- Iterate through Arrays
- Use common Array functions
- Understand Primitive Arrays
- Understand the difference between Arrays and Lists
- Apply Arrays in Android development

---

# 1. What is an Array?

An **Array** is a collection of elements stored in contiguous memory locations.

Characteristics:

- Stores multiple values
- Fixed size
- Elements are accessed using an index
- Index starts from **0**

Example

```text
Index :   0    1    2    3
Value : [10] [20] [30] [40]
```

---

# 2. Creating Arrays

## Using arrayOf()

```kotlin
val numbers = arrayOf(10, 20, 30, 40)
```

String Array

```kotlin
val names = arrayOf(
    "Mazharul",
    "Alex",
    "John"
)
```

---

## Explicit Type

```kotlin
val numbers: Array<Int> =
    arrayOf(10, 20, 30)
```

---

## Empty Array

Create an array of size 5 filled with zeros.

```kotlin
val numbers = Array(5) { 0 }
```

Output

```text
[0, 0, 0, 0, 0]
```

---

# 3. Accessing Elements

Using index

```kotlin
val numbers = arrayOf(10, 20, 30)

println(numbers[0])
```

Output

```text
10
```

Another way

```kotlin
println(numbers.get(0))
```

---

# 4. Updating Elements

```kotlin
val numbers = arrayOf(10, 20, 30)

numbers[1] = 100

println(numbers.contentToString())
```

Output

```text
[10, 100, 30]
```

---

# 5. Array Size

```kotlin
println(numbers.size)
```

Output

```text
3
```

---

# 6. Iterating Through Arrays

## Method 1: For-each Loop

```kotlin
for (number in numbers) {
    println(number)
}
```

---

## Method 2: Using Indices

```kotlin
for (i in numbers.indices) {
    println(numbers[i])
}
```

---

## Method 3: Using withIndex()

```kotlin
for ((index, value) in numbers.withIndex()) {
    println("$index -> $value")
}
```

Output

```text
0 -> 10
1 -> 20
2 -> 30
```

---

# 7. Common Array Functions

## contentToString()

Prints array elements in a readable format.

```kotlin
println(numbers.contentToString())
```

Without it

```kotlin
println(numbers)
```

Output

```text
[Lkotlin.Array;@5e91993f
```

---

## size

```kotlin
println(numbers.size)
```

Returns the total number of elements.

---

## first()

```kotlin
println(numbers.first())
```

Returns the first element.

---

## last()

```kotlin
println(numbers.last())
```

Returns the last element.

---

## contains()

```kotlin
println(numbers.contains(20))
```

Output

```text
true
```

---

## indexOf()

```kotlin
println(numbers.indexOf(30))
```

Output

```text
2
```

---

## sum()

```kotlin
val numbers = arrayOf(10, 20, 30)

println(numbers.sum())
```

Output

```text
60
```

---

## average()

```kotlin
println(numbers.average())
```

Output

```text
20.0
```

---

## maxOrNull()

```kotlin
println(numbers.maxOrNull())
```

Returns the largest value.

---

## minOrNull()

```kotlin
println(numbers.minOrNull())
```

Returns the smallest value.

---

## sortedArray()

```kotlin
val numbers = arrayOf(5, 2, 9, 1)

println(numbers.sortedArray().contentToString())
```

Output

```text
[1, 2, 5, 9]
```

---

## reversedArray()

```kotlin
println(numbers.reversedArray().contentToString())
```

Output

```text
[1, 9, 2, 5]
```

---

# 8. Primitive Arrays

Instead of

```kotlin
Array<Int>
```

Kotlin provides specialized arrays.

```kotlin
IntArray
DoubleArray
FloatArray
BooleanArray
CharArray
LongArray
ShortArray
ByteArray
```

Example

```kotlin
val marks = intArrayOf(80, 90, 70)
```

Advantages:

- Faster
- Less memory
- No boxing/unboxing

---

# 9. Arrays vs Lists

| Array | List |
|--------|------|
| Fixed size | Dynamic size |
| Cannot add/remove elements | MutableList can add/remove |
| Good for fixed data | Good for changing data |
| Common in Java APIs | Preferred in Kotlin |

---

# 10. Android Examples

## Weekday Names

```kotlin
val weekdays = arrayOf(
    "Sat",
    "Sun",
    "Mon",
    "Tue",
    "Wed",
    "Thu",
    "Fri"
)
```

---

## Image Resources

```kotlin
val images = intArrayOf(
    R.drawable.img1,
    R.drawable.img2,
    R.drawable.img3
)
```

---

## Quiz Options

```kotlin
val options = arrayOf(
    "Kotlin",
    "Java",
    "Python",
    "Swift"
)
```

---

# Best Practices

✅ Use `contentToString()` to print arrays.

✅ Use `withIndex()` when you need both the index and value.

✅ Use `IntArray` instead of `Array<Int>` when working with primitive integers.

✅ Prefer `List` when the number of elements can change.

---

# Common Beginner Mistakes

## Printing Arrays Directly

❌

```kotlin
println(numbers)
```

Output

```text
[Lkotlin.Array;@5e91993f
```

✅

```kotlin
println(numbers.contentToString())
```

---

## Accessing an Invalid Index

```kotlin
numbers[5]
```

If the array has only three elements, this causes:

```text
ArrayIndexOutOfBoundsException
```

Always make sure the index is valid.

---

## Thinking Arrays are Dynamic

❌ Arrays automatically grow.

Correct:

Arrays have a **fixed size**.

---

# Interview Questions

1. What is an Array?
2. What is the difference between `Array<Int>` and `IntArray`?
3. What is `contentToString()`?
4. How do you find the size of an array?
5. What happens if you access an invalid index?
6. Difference between Arrays and Lists?
7. When should you use Arrays?
8. Why are Primitive Arrays faster?

---

# Quick Revision

- Array stores multiple values.
- Index starts from **0**.
- Arrays have a fixed size.
- Use `contentToString()` for printing.
- Use `withIndex()` to get index and value.
- Use `IntArray` for better performance.
- Use `List` when the collection size can change.

---

# Homework

1. Create an array of five integers.
2. Print the first and last element.
3. Update the third element.
4. Print all elements using all three loop methods.
5. Find the largest and smallest values.
6. Find the sum and average.
7. Check whether a number exists in the array.
8. Find the index of an element.
9. Reverse the array.
10. Sort the array.

---

# Next Lesson

**Week 1 - Day 6:** Kotlin Collections

Topics:

- List
- MutableList
- Set
- MutableSet
- Map
- MutableMap
- Collection Functions
- Android Examples