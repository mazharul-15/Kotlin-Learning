# Week 1 - Day 4
# Kotlin Strings

> Duration: 30 Minutes

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand Strings
- Use String Templates
- Use String properties
- Use common String functions
- Compare Strings
- Use Raw Strings
- Iterate through Strings
- Apply Strings in Android development

---

# 1. What is a String?

A **String** is a sequence of characters enclosed in double quotes.

Example

```kotlin
val name = "Mazharul"
```

---

# 2. Declaring Strings

Type Inference

```kotlin
val language = "Kotlin"
```

Explicit Type

```kotlin
val language: String = "Kotlin"
```

---

# 3. String Templates

Instead of

```kotlin
println("Hello " + name)
```

Use

```kotlin
println("Hello $name")
```

Output

```text
Hello Mazharul
```

---

## Using Expressions

```kotlin
val a = 10
val b = 20

println("Sum = ${a + b}")
```

Output

```text
Sum = 30
```

---

# 4. String Properties

## length

```kotlin
val name = "Mazharul"

println(name.length)
```

---

# 5. Common String Functions

## uppercase()

```kotlin
"Kotlin".uppercase()
```

Output

```text
KOTLIN
```

---

## lowercase()

```kotlin
"KOTLIN".lowercase()
```

Output

```text
kotlin
```

---

## trim()

```kotlin
"   Hello   ".trim()
```

Output

```text
Hello
```

---

## replace()

```kotlin
"I love Java".replace("Java", "Kotlin")
```

Output

```text
I love Kotlin
```

---

## contains()

```kotlin
email.contains("@")
```

---

## startsWith()

```kotlin
"Kotlin".startsWith("Kot")
```

---

## endsWith()

```kotlin
"Kotlin".endsWith("lin")
```

---

## substring()

```kotlin
"Android".substring(0,3)
```

Output

```text
And
```

---

## split()

```kotlin
"abc@gmail.com".split("@")
```

Output

```text
[abc, gmail.com]
```

---

## isEmpty()

Returns true if there are no characters.

```kotlin
"".isEmpty()
```

---

## isBlank()

Returns true if empty or contains only spaces.

```kotlin
"   ".isBlank()
```

---

# isEmpty() vs isBlank()

| String | isEmpty() | isBlank() |
|---------|-----------|-----------|
| "" | ✅ | ✅ |
| "   " | ❌ | ✅ |
| "Hello" | ❌ | ❌ |

---

# 6. String Comparison

## ==

Compares contents.

```kotlin
val a = "Kotlin"
val b = "Kotlin"

println(a == b)
```

---

## ===

Checks whether two references point to the same object.

```kotlin
println(a === b)
```

For beginners, prefer `==`.

---

# 7. Raw Strings

```kotlin
val address = """
House 10
Road 5
Dhaka
""".trimIndent()
```

Useful for:

- JSON
- SQL
- Multi-line text
- Documentation

---

# 8. Escape Characters

| Escape | Meaning |
|---------|---------|
| \n | New Line |
| \t | Tab |
| \" | Double Quote |
| \\ | Backslash |

Example

```kotlin
println("Hello\nWorld")
```

---

# 9. Iterate Through String

```kotlin
for(ch in "Kotlin"){
    println(ch)
}
```

---

# Android Examples

Greeting

```kotlin
textView.text = "Welcome $name"
```

Validation

```kotlin
if(name.isBlank()){
    println("Enter your name")
}
```

Search

```kotlin
if(title.contains(searchText)){
    println("Found")
}
```

---

# Best Practices

- Prefer String Templates over concatenation.
- Use `trim()` before validation.
- Use `isBlank()` for user input.
- Use meaningful variable names.
- Prefer `==` over `===` for String comparison.

---

# Common Beginner Mistakes

❌

```kotlin
"Hello " + name
```

✅

```kotlin
"Hello $name"
```

---

❌

Using `===` to compare Strings.

✅

Use

```kotlin
==
```

---

❌

Confusing `isEmpty()` with `isBlank()`.

Remember:

- Empty = No characters.
- Blank = Empty or only whitespace.

---

# Interview Questions

1. What is a String?
2. What is a String Template?
3. Difference between `$` and `${}`?
4. Difference between `isEmpty()` and `isBlank()`?
5. Difference between `==` and `===`?
6. What is a Raw String?
7. What does `trim()` do?
8. What does `substring()` do?
9. What does `split()` return?
10. Why should we use String Templates?

---

# Key Takeaways

- String = Sequence of characters.
- Use `$` and `${}` for String Templates.
- Learn common String functions.
- Use `trim()` before validation.
- Prefer `==` for comparison.
- Use Raw Strings for multi-line text.
- `isBlank()` is commonly used in Android forms.

---

# Next Lesson

Week 1 Day 5 → Arrays