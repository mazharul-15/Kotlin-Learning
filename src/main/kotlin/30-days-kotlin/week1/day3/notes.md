# Week 1 - Day 3
# Kotlin Null Safety

> Duration: 30 Minutes

Null Safety is one of Kotlin's most powerful features. It helps prevent **NullPointerException (NPE)**, one of the most common runtime crashes in Java and Android applications.

---

# Learning Objectives

After completing this lesson, you will be able to:

- Understand `null`
- Differentiate nullable and non-nullable types
- Use the Safe Call operator (`?.`)
- Use the Elvis operator (`?:`)
- Use the Not-null Assertion operator (`!!`)
- Use Safe Cast (`as?`)
- Understand Smart Cast
- Understand Safe Call Chains
- Write safer Android code

---

# 1. What is null?

`null` means **the absence of a value**.

Example

```kotlin
var name: String? = null
```

Here,

```text
name
```

does not contain a string.

Instead, it contains **nothing**.

---

# 2. Non-Nullable Types

By default, every Kotlin variable is **non-nullable**.

```kotlin
var name: String = "Mazharul"
```

This is allowed.

```kotlin
name = "Alex"
```

This is also allowed.

But

```kotlin
name = null
```

❌ Compile-time Error

Because `String` cannot store `null`.

---

# Why?

Kotlin prevents many crashes before your app even runs.

---

# 3. Nullable Types

To allow `null`, place a `?` after the type.

```kotlin
var name: String? = "Mazharul"
```

Now this is valid.

```kotlin
name = null
```

Other examples

```kotlin
var age: Int? = null

var salary: Double? = null

var isLoggedIn: Boolean? = null
```

---

# Nullable vs Non-Nullable

| Non-Nullable | Nullable |
|--------------|----------|
| `String` | `String?` |
| `Int` | `Int?` |
| Cannot store `null` | Can store `null` |
| Safer | Requires null checking |

---

# 4. Why Can't We Access Nullable Variables Directly?

Consider

```kotlin
var name: String? = "Mazharul"
```

Now

```kotlin
println(name.length)
```

❌ Compile-time Error

Why?

Because later

```kotlin
name = null
```

If Kotlin allowed

```kotlin
name.length
```

it would crash.

Instead, Kotlin forces you to handle the possibility of `null`.

---

# 5. Safe Call Operator (?.)

Safe Call allows access only if the object exists.

Syntax

```kotlin
object?.property
```

Example

```kotlin
var name: String? = "Mazharul"

println(name?.length)
```

Output

```text
9
```

If

```kotlin
name = null
```

Output

```text
null
```

No crash occurs.

---

# How Safe Call Works

Read

```kotlin
name?.length
```

as

> **"If name is not null, return its length. Otherwise, return null."**

---

# 6. Elvis Operator (?:)

Used to provide a default value when an expression is `null`.

Example

```kotlin
val name: String? = null

val result = name ?: "Guest"

println(result)
```

Output

```text
Guest
```

Another example

```kotlin
val length = name?.length ?: 0
```

If `name` is null,

Output

```text
0
```

---

# 7. Not-null Assertion (!!)

Use `!!` only when you are **100% sure** a value is not null.

Example

```kotlin
val name: String? = "Mazharul"

println(name!!.length)
```

Output

```text
9
```

If

```kotlin
val name: String? = null

println(name!!.length)
```

Runtime

```text
NullPointerException
```

Avoid using `!!` unless absolutely necessary.

---

# 8. Safe Cast (as?)

Instead of

```kotlin
val number = value as Int
```

Use

```kotlin
val number = value as? Int
```

If casting fails,

Output

```text
null
```

instead of crashing.

Example

```kotlin
val value: Any = "Hello"

val number = value as? Int

println(number)
```

Output

```text
null
```

---

# 9. Smart Cast

Kotlin automatically casts after checking for `null`.

Example

```kotlin
val name: String? = "Mazharul"

if (name != null) {
    println(name.length)
}
```

Inside the `if` block,

Kotlin already knows

```text
name
```

cannot be null.

No extra cast is needed.

---

# 10. Safe Call Chain

Safe Call Chains are used when accessing nested objects.

Imagine

```text
Student
    │
    ▼
Address
    │
    ▼
City
```

Class

```kotlin
class Address(
    val city: String
)

class Student(
    val address: Address?
)
```

Create object

```kotlin
val student = Student(
    Address("Dhaka")
)
```

Access city

```kotlin
println(student.address?.city)
```

Output

```text
Dhaka
```

---

## If Address is Null

```kotlin
val student = Student(null)

println(student.address?.city)
```

Output

```text
null
```

No crash occurs.

---

# Nullable Student + Nullable Address

Now suppose even the student may not exist.

```kotlin
val student: Student? = null
```

To safely access the city

```kotlin
student?.address?.city
```

---

# How Safe Call Chain Works

Think of each `?.` as asking a question.

Step 1

```text
Does student exist?
```

If **No**

Return

```text
null
```

Stop.

If **Yes**

Go to Step 2.

---

Step 2

```text
Does address exist?
```

If **No**

Return

```text
null
```

Stop.

If **Yes**

Go to Step 3.

---

Step 3

```text
Return city
```

Example

```kotlin
val student: Student? =
    Student(Address("Dhaka"))

println(student?.address?.city)
```

Output

```text
Dhaka
```

Example

```kotlin
val student =
    Student(null)

println(student.address?.city)
```

Output

```text
null
```

Example

```kotlin
val student: Student? = null

println(student?.address?.city)
```

Output

```text
null
```

---

# Visual Explanation

```text
student?.address?.city

        │
        ▼

Is student null?

Yes ─────────► return null

No
 │
 ▼

Is address null?

Yes ─────────► return null

No
 │
 ▼

Return city
```

Every `?.` means

> **"If this object exists, continue. Otherwise, stop and return null."**

---

# Android Example

```kotlin
val imageUrl = user?.profile?.image?.url
```

Meaning

1. Does `user` exist?
2. Does `profile` exist?
3. Does `image` exist?
4. Return `url`.

If any object is `null`, the entire expression returns `null` safely.

---

# Best Practices

✅ Prefer non-nullable types whenever possible.

```kotlin
val name: String
```

instead of

```kotlin
val name: String?
```

---

✅ Prefer

```kotlin
?.
```

instead of

```kotlin
!!
```

---

✅ Use the Elvis operator to provide default values.

```kotlin
val username = user?.name ?: "Guest"
```

---

# Common Beginner Mistakes

## Using !!

❌

```kotlin
user!!.name
```

Prefer

```kotlin
user?.name
```

---

## Making Everything Nullable

❌

```kotlin
var name: String?

var age: Int?

var city: String?
```

Only use nullable types when a value can genuinely be absent.

---

## Forgetting Safe Call

❌

```kotlin
name.length
```

when

```kotlin
name: String?
```

Correct

```kotlin
name?.length
```

---

# Interview Questions

1. What is `null`?
2. What is the difference between `String` and `String?`
3. What is the Safe Call operator?
4. What is the Elvis operator?
5. What does `!!` do?
6. What is Smart Cast?
7. What is Safe Cast?
8. What is a Safe Call Chain?
9. Why is Kotlin called a null-safe language?
10. Why should `!!` generally be avoided?

---

# Key Takeaways

- `String` cannot store `null`.
- `String?` can store `null`.
- Use `?.` to safely access nullable objects.
- Use `?:` to provide default values.
- Avoid `!!` unless absolutely certain the value is not `null`.
- Smart Cast removes unnecessary casts after null checks.
- Safe Call Chains allow safe access to nested objects.
- Kotlin's null safety helps prevent `NullPointerException`.

---

# Homework

1. Declare nullable and non-nullable variables.
2. Print a nullable string's length using `?.`.
3. Use `?:` to print `"Guest"` when a name is `null`.
4. Demonstrate Smart Cast.
5. Demonstrate Safe Cast using `as?`.
6. Create `Student` and `Address` classes and use `student?.address?.city`.
7. Create `User`, `Profile`, and `Image` classes and access `user?.profile?.image?.url`.
8. Write comments explaining what each `?.` in a Safe Call Chain checks.
9. Explain the difference between `?.` and `!!`.
10. Explain why Kotlin's null safety is beneficial in Android development.

---

## Next Lesson

**Week 1 - Day 4: Strings**

Topics:

- String Templates
- String Functions
- Raw Strings
- String Comparison
- String Operations
- Android Examples