# Kotlin Scope Functions

Kotlin has five main scope functions:

- `let`
- `run`
- `with`
- `apply`
- `also`

They execute a block of code in the context of an object.

## Quick Comparison

| Function | Object reference | Return value | Common use |
|---|---|---|---|
| `let` | `it` | Lambda result | Null checks, transformations |
| `run` | `this` | Lambda result | Execute block and calculate result |
| `with` | `this` | Lambda result | Multiple operations on an object |
| `apply` | `this` | Original object | Object configuration |
| `also` | `it` | Original object | Logging and side effects |

## 1. let

`let` uses `it` as the object reference and returns the lambda result.

```kotlin
val name = "Jammer"

val length = name.let {
    println(it)
    it.length
}

println(length)
```

### Common use: null checking

```kotlin
val name: String? = "Jammer"

name?.let {
    println("Name: $it")
}
```

The block executes only when the value is not null.

---

## 2. run

`run` uses `this` as the object reference and returns the lambda result.

```kotlin
val result = "Kotlin".run {
    println(this)
    length
}

println(result)
```

Output:

```text
Kotlin
6
```

Use `run` when you want to perform several operations on an object and calculate a result.

---

## 3. with

`with` is used to perform multiple operations on an existing object.

```kotlin
val user = User()

with(user) {
    name = "Jammer"
    age = 25
    println(name)
    println(age)
}
```

`with` uses `this` and returns the lambda result.

Unlike the other scope functions, it is normally written as:

```kotlin
with(user) {
    // code
}
```

---

## 4. apply

`apply` is mainly used to configure an object.

It uses `this` and returns the original object.

```kotlin
class User {
    var name = ""
    var age = 0
}

val user = User().apply {
    name = "Jammer"
    age = 25
}

println(user.name)
```

### Android example

```kotlin
val intent = Intent(this, SecondActivity::class.java).apply {
    putExtra("name", "Jammer")
    putExtra("age", 25)
}

startActivity(intent)
```

Remember:

```text
apply → configure object → return object
```

---

## 5. also

`also` performs an additional operation on an object.

It uses `it` and returns the original object.

```kotlin
val user = User("Jammer", 25).also {
    println("Created user: $it")
}
```

`also` is useful for:

- Logging
- Debugging
- Validation
- Side effects

---

# let vs also

Both use `it`, but their purposes differ.

### let

Usually used for transformation or obtaining a result:

```kotlin
val length = "Kotlin".let {
    it.length
}
```

Result:

```text
6
```

### also

Usually used for a side effect while keeping the original object:

```kotlin
val name = "Kotlin".also {
    println("Value: $it")
}
```

Result:

```text
Kotlin
```

---

# run vs apply

Both use `this`.

The important difference is the return value.

### run

```kotlin
val result = user.run {
    name
}
```

Returns the lambda result.

### apply

```kotlin
val result = user.apply {
    name = "Jammer"
}
```

Returns the original `user` object.

Memory trick:

```text
run   → result
apply → object
```

---

# with vs apply

Both can be used for object configuration.

### with

```kotlin
with(user) {
    name = "Jammer"
    age = 25
}
```

Returns the lambda result.

### apply

```kotlin
val user = User().apply {
    name = "Jammer"
    age = 25
}
```

Returns the original object.

---

# Android Examples

## `let` for nullable data

```kotlin
intent.getStringExtra("name")?.let {
    textView.text = it
}
```

## `apply` for object configuration

```kotlin
val intent = Intent(this, DetailsActivity::class.java).apply {
    putExtra("id", 101)
}
```

## `also` for logging

```kotlin
val users = getUsers().also {
    Log.d("Users", "Users loaded: $it")
}
```

## `run` for calculating a value

```kotlin
val text = textView.run {
    text.toString().trim()
}
```

## `with` for repeated operations

```kotlin
with(textView) {
    text = "Hello"
    visibility = View.VISIBLE
}
```

---

# Common Mistakes

## Mistake 1: Confusing `it` and `this`

Typically:

```text
let / also → it
run / with / apply → this
```

## Mistake 2: Confusing return values

```text
let   → lambda result
run   → lambda result
with  → lambda result
apply → original object
also  → original object
```

---

# Interview Questions

### Q1. What are Kotlin scope functions?

Functions that execute a block of code in the context of an object.

### Q2. What are the five main scope functions?

```text
let, run, with, apply, also
```

### Q3. Which return the original object?

```text
apply
also
```

### Q4. Which return the lambda result?

```text
let
run
with
```

### Q5. Which is commonly used for object configuration?

`apply`.

### Q6. Which is commonly used for null-safe operations?

`let`, usually with `?.`:

```kotlin
value?.let {
    // code
}
```

---

# Final Cheat Sheet

```text
┌─────────┬──────────────┬───────────────┬─────────────────────────┐
│ Function│ Reference    │ Returns       │ Main purpose            │
├─────────┼──────────────┼───────────────┼─────────────────────────┤
│ let     │ it           │ Lambda result │ Null checks/transform   │
│ run     │ this         │ Lambda result │ Execute and calculate   │
│ with    │ this         │ Lambda result │ Multiple object actions │
│ apply   │ this         │ Object        │ Configure object        │
│ also    │ it           │ Object        │ Side effects/logging    │
└─────────┴──────────────┴───────────────┴─────────────────────────┘
```

## One-line memory trick

```text
let   = use it
run   = run with this
with  = work with this
apply = configure this
also  = also do something
```

## Summary

The five Kotlin scope functions are:

```kotlin
let
run
with
apply
also
```

Most important distinction:

```text
let / run / with → return lambda result
apply / also      → return original object
```

And:

```text
let / also        → it
run / with / apply → this
```

Scope functions are especially useful in Android development for null handling, object configuration, logging, and concise code.
