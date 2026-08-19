# Kotlin Scope Functions

## 1. What Are Scope Functions?

Kotlin provides five important Scope Functions:

```kotlin
let
run
with
apply
also
```

They allow you to execute a block of code in the context of an object.

Example:

```kotlin
val student = Student("Mazharul", 25)

student.let {
    println(it.name)
    println(it.age)
}
```

Inside the block, we are working with the `student` object.

---

# 2. The Two Things to Understand

For every Scope Function, remember two things:

1. How do I access the object inside the block?
2. What does the Scope Function return?

There are two ways to access the object:

```kotlin
it
```

or:

```kotlin
this
```

And there are two types of return values:

```text
Lambda result
Original object
```

---

# 3. Scope Functions Cheat Sheet

| Function | Object inside block | Returns | Common Use |
|---|---|---|---|
| `let` | `it` | Lambda result | Null handling / transformation |
| `run` | `this` | Lambda result | Calculate using object |
| `with` | `this` | Lambda result | Multiple operations |
| `apply` | `this` | Original object | Configure object |
| `also` | `it` | Original object | Extra action / logging |

---

# 4. Easy Way to Remember

## Uses `it`

```text
let
also
```

## Uses `this`

```text
run
with
apply
```

---

## Returns Lambda Result

```text
let
run
with
```

---

## Returns Original Object

```text
apply
also
```

So remember:

```text
             it          this

Result       let         run
                         with

Object       also        apply
```

---

# 5. `let`

`let` uses `it` to refer to the object.

Example:

```kotlin
val name = "Mazharul"

name.let {
    println(it)
}
```

Here:

```text
it = name
```

So:

```kotlin
println(it)
```

is equivalent to:

```kotlin
println(name)
```

---

# 6. `let` With a Named Parameter

Instead of `it`, you can give the object a meaningful name:

```kotlin
val student = Student("Mazharul", 25)

student.let { student ->
    println(student.name)
    println(student.age)
}
```

This is useful when `it` becomes confusing.

---

# 7. `let` and Null Safety

One of the most important uses of `let` is working with nullable values.

Suppose:

```kotlin
var name: String? = "Mazharul"
```

You can write:

```kotlin
name?.let {
    println(it)
}
```

If `name` is not null:

```text
lambda executes
```

If `name` is null:

```text
lambda does not execute
```

---

# 8. `let` With a Nullable Student

```kotlin
val student: Student? = getStudent()

student?.let {
    println(it.name)
    println(it.age)
}
```

Inside the `let` block:

```kotlin
it
```

represents the non-null `Student`.

Therefore:

```kotlin
it.name
it.age
```

are safe.

---

# 9. `let` Returns the Lambda Result

```kotlin
val name = "mazharul"

val result = name.let {
    it.uppercase()
}

println(result)
```

Output:

```text
MAZHARUL
```

The last expression:

```kotlin
it.uppercase()
```

is returned.

Therefore:

```text
let
↓
it
↓
lambda result
```

---

# 10. `let` Mental Model

Think:

```kotlin
object.let {
    // it = object

    // do something

    // last expression is returned
}
```

Example:

```kotlin
val result = "hello".let {
    it.uppercase()
}
```

Result:

```text
HELLO
```

---

# 11. `run`

`run` uses `this` to refer to the object.

Example:

```kotlin
val student = Student("Mazharul", 25)

student.run {
    println(this.name)
    println(this.age)
}
```

You can normally omit `this`:

```kotlin
student.run {
    println(name)
    println(age)
}
```

Inside the block:

```text
this = student
```

---

# 12. `run` vs `let`

### `let`

```kotlin
student.let {
    println(it.name)
    println(it.age)
}
```

### `run`

```kotlin
student.run {
    println(name)
    println(age)
}
```

Main difference:

```text
let → it

run → this
```

---

# 13. `run` Returns the Lambda Result

```kotlin
val student = Student("Mazharul", 25)

val description = student.run {
    "$name is $age years old"
}

println(description)
```

Output:

```text
Mazharul is 25 years old
```

So:

```text
run
↓
this
↓
lambda result
```

---

# 14. When to Use `run`

Use `run` when you want to:

- Work with an object.
- Access several properties/functions of that object.
- Calculate something.
- Return the result.

Example:

```kotlin
val student = Student("Mazharul", 25)

val description = student.run {
    "$name - $age"
}
```

---

# 15. `with`

`with` is slightly different from the other Scope Functions.

Instead of:

```kotlin
student.with {
}
```

you write:

```kotlin
with(student) {
}
```

Example:

```kotlin
val student = Student("Mazharul", 25)

with(student) {
    println(name)
    println(age)
}
```

Inside the block:

```text
this = student
```

---

# 16. `with` Returns the Lambda Result

```kotlin
val description = with(student) {
    "$name is $age years old"
}
```

Result:

```text
Mazharul is 25 years old
```

Therefore:

```text
with
↓
this
↓
lambda result
```

---

# 17. `run` vs `with`

Both:

```text
use this
return lambda result
```

### `run`

```kotlin
student.run {
    println(name)
}
```

### `with`

```kotlin
with(student) {
    println(name)
}
```

A practical rule:

```text
Already have an object:
object.run { }

Want to group operations around an object:
with(object) { }
```

---

# 18. `apply`

`apply` uses `this`.

Example:

```kotlin
val student = Student("Mazharul", 25)

val result = student.apply {
    println(name)
}
```

Inside:

```text
this = student
```

But unlike `run`, `apply` returns the original object.

Therefore:

```text
apply
↓
this
↓
configure object
↓
return object
```

---

# 19. Why Use `apply`?

`apply` is mainly used for **object configuration**.

Example:

```kotlin
val student = Student("", 0).apply {
    name = "Mazharul"
    age = 25
}
```

The result is the configured `Student` object.

---

# 20. Android Example — `Intent`

`apply` is very common in Android.

```kotlin
val intent = Intent(
    this,
    DetailsActivity::class.java
).apply {
    putExtra("name", "Mazharul")
    putExtra("age", 25)
}
```

We are:

```text
Create Intent
    ↓
Configure Intent
    ↓
Return Intent
```

Then:

```kotlin
startActivity(intent)
```

---

# 21. Android Example — TextView

```kotlin
val textView = TextView(this).apply {
    text = "Hello Kotlin"
    textSize = 20f
}
```

Here `apply` is used to configure:

```kotlin
text
textSize
```

and return the configured `TextView`.

---

# 22. `also`

`also` uses `it`.

Example:

```kotlin
val student = Student("Mazharul", 25)

val result = student.also {
    println(it.name)
}
```

Inside:

```text
it = student
```

Unlike `let`, `also` returns the original object.

---

# 23. Why Use `also`?

Use `also` when you want to perform an **additional action** without changing the object.

For example:

```kotlin
val student = getStudent()
    .also {
        println("Student received: $it")
    }
```

The student object is still returned.

---

# 24. `also` for Logging

A common use:

```kotlin
val student = getStudent()
    .also {
        Log.d("Student", "Received: $it")
    }
```

The logging is an additional action.

The original `student` continues through the code.

---

# 25. `apply` vs `also`

This is very important.

## `apply`

Uses:

```kotlin
this
```

Example:

```kotlin
student.apply {
    name = "Rahim"
    age = 20
}
```

Main purpose:

```text
Configure the object
```

---

## `also`

Uses:

```kotlin
it
```

Example:

```kotlin
student.also {
    println(it.name)
}
```

Main purpose:

```text
Perform an additional action
```

Remember:

```text
apply → configure

also → additional action
```

---

# 26. `let` vs `also`

Both use:

```kotlin
it
```

But their return values are different.

## `let`

Returns the lambda result:

```kotlin
val result = "hello".let {
    it.uppercase()
}
```

Result:

```text
HELLO
```

---

## `also`

Returns the original object:

```kotlin
val result = "hello".also {
    println(it)
}
```

Result:

```text
hello
```

Remember:

```text
let → lambda result

also → original object
```

---

# 27. `run` vs `apply`

Both use:

```kotlin
this
```

But their return values are different.

## `run`

```kotlin
val result = student.run {
    "$name - $age"
}
```

Result:

```text
Mazharul - 25
```

---

## `apply`

```kotlin
val result = student.apply {
    println(name)
}
```

Result:

```text
Student object
```

Remember:

```text
run → lambda result

apply → original object
```

---

# 28. Complete Comparison

| Function | Access | Return | Main Purpose |
|---|---|---|---|
| `let` | `it` | Lambda result | Null handling / transformation |
| `run` | `this` | Lambda result | Calculate result |
| `with` | `this` | Lambda result | Work with an object |
| `apply` | `this` | Object | Configure object |
| `also` | `it` | Object | Extra action / logging |

---

# 29. The `it` Functions

Two functions use `it`:

```kotlin
let
also
```

Example:

```kotlin
student.let {
    println(it.name)
}
```

```kotlin
student.also {
    println(it.name)
}
```

Difference:

```text
let
→ returns lambda result

also
→ returns original object
```

---

# 30. The `this` Functions

Three functions use `this`:

```kotlin
run
with
apply
```

Example:

```kotlin
student.run {
    println(name)
}
```

```kotlin
with(student) {
    println(name)
}
```

```kotlin
student.apply {
    println(name)
}
```

Differences come mainly from **how they are called** and **what they return**.

---

# 31. Scope Functions and Object Reference

Suppose:

```kotlin
val student = Student("Mazharul", 25)
```

### `let`

```kotlin
student.let {
    println(it.name)
}
```

```text
it = student
```

### `also`

```kotlin
student.also {
    println(it.name)
}
```

```text
it = student
```

### `run`

```kotlin
student.run {
    println(name)
}
```

```text
this = student
```

### `apply`

```kotlin
student.apply {
    println(name)
}
```

```text
this = student
```

### `with`

```kotlin
with(student) {
    println(name)
}
```

```text
this = student
```

---

# 32. Scope Functions and Return Values

Suppose:

```kotlin
val student = Student("Mazharul", 25)
```

### `let`

```kotlin
val result = student.let {
    it.name
}
```

Result:

```text
"Mazharul"
```

---

### `run`

```kotlin
val result = student.run {
    name
}
```

Result:

```text
"Mazharul"
```

---

### `with`

```kotlin
val result = with(student) {
    name
}
```

Result:

```text
"Mazharul"
```

---

### `apply`

```kotlin
val result = student.apply {
    println(name)
}
```

Result:

```text
Student object
```

---

### `also`

```kotlin
val result = student.also {
    println(it.name)
}
```

Result:

```text
Student object
```

---

# 33. Scope Function Chaining

Scope functions can be chained.

Example:

```kotlin
val result = "mazharul"
    .let {
        it.uppercase()
    }
    .also {
        println("Result: $it")
    }
```

Flow:

```text
"mazharul"
    ↓
let
    ↓
"MAZHARUL"
    ↓
also
    ↓
print it
    ↓
"MAZHARUL"
```

---

# 34. Don't Overuse Scope Functions

Scope functions are useful, but don't use them everywhere.

This:

```kotlin
student.let {
    println(it.name)
}
```

is not necessarily better than:

```kotlin
println(student.name)
```

Use Scope Functions when they make your code:

- Clearer
- Safer
- More readable
- Easier to configure
- Easier to chain

Avoid complicated chains that are difficult to understand.

---

# 35. Practical Decision Guide

## Need null checking?

Use:

```kotlin
?.let { }
```

Example:

```kotlin
name?.let {
    println(it)
}
```

---

## Need to configure an object?

Use:

```kotlin
apply { }
```

Example:

```kotlin
val intent = Intent(...).apply {
    putExtra("name", "Mazharul")
}
```

---

## Need an extra action or logging?

Use:

```kotlin
also { }
```

Example:

```kotlin
student.also {
    Log.d("TAG", "$it")
}
```

---

## Need to calculate a result using an object?

Use:

```kotlin
run { }
```

Example:

```kotlin
val description = student.run {
    "$name - $age"
}
```

---

## Need to perform several operations on one object?

Use:

```kotlin
with(object) { }
```

Example:

```kotlin
with(student) {
    println(name)
    println(age)
}
```

---

# 36. Android Examples

## Nullable Data

```kotlin
val name = intent.getStringExtra("name")

name?.let {
    binding.tvName.text = it
}
```

Meaning:

```text
If name != null
       ↓
execute block
       ↓
it = name
```

---

## Configure Intent

```kotlin
val intent = Intent(
    this,
    DetailsActivity::class.java
).apply {
    putExtra("name", "Mazharul")
    putExtra("age", 25)
}
```

---

## Configure a View

```kotlin
val textView = TextView(this).apply {
    text = "Hello Kotlin"
    textSize = 20f
}
```

---

## Logging

```kotlin
val student = getStudent()
    .also {
        Log.d("Student", "Received: $it")
    }
```

---

## Calculate a Value

```kotlin
val description = student.run {
    "$name is $age years old"
}
```

---

## Work With View Binding

```kotlin
with(binding) {
    tvName.text = "Mazharul"
    tvAge.text = "25"
    btnSave.text = "Save"
}
```

---

# 37. Practice Task 1 — `let`

Create:

```kotlin
var name: String? = "Mazharul"
```

Use:

```kotlin
?.let
```

to print the name.

Then:

```kotlin
name = null
```

Run the program again and observe the result.

---

# 38. Practice Task 2 — `apply`

Create:

```kotlin
data class Student(
    var name: String,
    var age: Int
)
```

Then create a student using `apply`:

```kotlin
val student = Student("", 0).apply {
    name = "Mazharul"
    age = 25
}
```

Print:

```kotlin
println(student)
```

---

# 39. Practice Task 3 — `also`

Create:

```kotlin
val student = Student("Mazharul", 25)
```

Use `also` to print:

```text
Student created: ...
```

while keeping the student object.

---

# 40. Practice Task 4 — `run`

Create:

```kotlin
val student = Student("Mazharul", 25)
```

Use `run` to create:

```text
Mazharul is 25 years old
```

Store the result in a variable.

---

# 41. Practice Task 5 — `with`

Create:

```kotlin
val student = Student("Mazharul", 25)
```

Use `with` to print:

```text
Name: Mazharul
Age: 25
```

---

# 42. Practice Task 6 — Android

Create an `Intent` and configure multiple extras using `apply`:

```kotlin
val intent = Intent(
    this,
    DetailsActivity::class.java
).apply {
    putExtra("name", "Mazharul")
    putExtra("age", 25)
}
```

Understand why `apply` is suitable here.

---

# 43. Final Cheat Sheet

```text
┌─────────┬────────┬───────────────┬────────────────────────┐
│ Function│ Object │ Returns       │ Main Use               │
├─────────┼────────┼───────────────┼────────────────────────┤
│ let     │ it     │ Lambda result │ Null / transformation │
│ run     │ this   │ Lambda result │ Calculate result       │
│ with    │ this   │ Lambda result │ Work with object       │
│ apply   │ this   │ Object        │ Configure object       │
│ also    │ it     │ Object        │ Extra action / logging │
└─────────┴────────┴───────────────┴────────────────────────┘
```

## Rule 1 — `it` vs `this`

```text
it:
    let
    also

this:
    run
    with
    apply
```

## Rule 2 — Return Value

```text
Lambda result:
    let
    run
    with

Original object:
    apply
    also
```

---

# 44. Most Important Android Patterns

### `let` — Null Safety

```kotlin
name?.let {
    println(it)
}
```

### `apply` — Configure Object

```kotlin
val intent = Intent(...).apply {
    putExtra("name", "Mazharul")
}
```

### `also` — Extra Action / Logging

```kotlin
student.also {
    Log.d("TAG", "$it")
}
```

### `run` — Produce a Result

```kotlin
val description = student.run {
    "$name - $age"
}
```

### `with` — Work With One Object

```kotlin
with(binding) {
    tvName.text = "Mazharul"
    tvAge.text = "25"
}
```

---

# 45. Final Memory Trick

Think of them like this:

```text
let
→ "Let me use this object."
→ it
→ returns result


run
→ "Let me run some code using this object."
→ this
→ returns result


with
→ "With this object, do these things."
→ this
→ returns result


apply
→ "Apply these settings to this object."
→ this
→ returns object


also
→ "Also do this extra thing."
→ it
→ returns object
```

For Android development, pay special attention to:

```text
let
apply
also
```

You will encounter these very frequently in real Android code.