# Kotlin `lazy` — Notes

## What is `lazy`?

`lazy` means: **do not create/calculate this value now; create it only when I first need it.**

```kotlin
val name by lazy {
    println("Creating name...")
    "Mazharul"
}
```

The block does not execute immediately. It executes when `name` is first accessed.

## Normal `val` vs `lazy`

Normal:

```kotlin
val database = createDatabase()
```

`createDatabase()` runs immediately.

Lazy:

```kotlin
val database by lazy {
    createDatabase()
}
```

`createDatabase()` runs only when `database` is first accessed.

## Simple Example

```kotlin
fun main() {
    println("Before")

    val name by lazy {
        println("Creating name...")
        "Mazharul"
    }

    println("After")
    println(name)
}
```

Output:

```text
Before
After
Creating name...
Mazharul
```

The lazy block runs when `name` is accessed.

## Lazy Runs Only Once

```kotlin
val name by lazy {
    println("Creating...")
    "Mazharul"
}

println(name)
println(name)
println(name)
```

Output:

```text
Creating...
Mazharul
Mazharul
Mazharul
```

The block executes only once.

```text
First access
    ↓
Execute lazy block
    ↓
Calculate value
    ↓
Save value
    ↓
Return value

Later accesses
    ↓
Use saved value
```

So:

> **Lazy initialization = calculate later + calculate once + reuse the result.**

## Why Use `lazy`?

It is useful when creating something is expensive or unnecessary until it is actually needed.

```kotlin
val database by lazy {
    createDatabase()
}
```

Instead of creating the database immediately, it waits until the database is actually used.

## `by lazy` vs `lazy`

With `by`:

```kotlin
val name by lazy {
    "Mazharul"
}

println(name)
```

Without `by`:

```kotlin
val name = lazy {
    "Mazharul"
}

println(name.value)
```

Without `by`, `name` is a `Lazy<String>` object. With `by`, Kotlin's property delegation lets you use `name` directly as the value.

## Why Is `by` Used?

`by` is Kotlin's **property delegation** syntax.

```kotlin
val name by lazy {
    "Mazharul"
}
```

The `Lazy` object manages when the value is initialized.

## `lazy` Is Usually Used With `val`

You will normally see:

```kotlin
val database by lazy {
    createDatabase()
}
```

Lazy initialization is designed around:

```text
Calculate once
     ↓
Keep the result
     ↓
Reuse it
```

Therefore, `val` is the natural choice.

## `lazy` vs Function

A normal function can execute every time it is called:

```kotlin
fun getNumber(): Int {
    println("Calculating...")
    return 100
}

println(getNumber())
println(getNumber())
println(getNumber())
```

The function can calculate three times.

With lazy:

```kotlin
val number by lazy {
    println("Calculating...")
    100
}

println(number)
println(number)
println(number)
```

Output:

```text
Calculating...
100
100
100
```

So:

```text
Function
→ can execute every time

Lazy property
→ execute on first access, then reuse result
```

## Android Example

A common Android use is delayed creation of an object:

```kotlin
class MainActivity {

    val repository by lazy {
        StudentRepository()
    }
}
```

Conceptually:

```text
MainActivity created
        ↓
repository is not created yet
        ↓
some code accesses repository
        ↓
StudentRepository() is created
        ↓
same instance is reused
```

Another common example is a database:

```kotlin
private val database by lazy {
    createDatabase()
}
```

The database is created only when it is first needed.

## Important Practice Example

```kotlin
fun main() {

    println("Program started")

    val number by lazy {
        println("Calculating number...")
        100
    }

    println("Lazy variable created")

    println(number)

    println(number)
}
```

Output:

```text
Program started
Lazy variable created
Calculating number...
100
100
```

Notice that:

```kotlin
val number by lazy {
    ...
}
```

does not execute the block immediately.

## Normal `val` vs `lazy`

| Normal `val` | `lazy` |
|---|---|
| Value is created immediately | Value is created later |
| Initialization happens when declaration executes | Initialization happens on first access |
| Calculates immediately | Delays calculation |
| Normal property | Delegated property |
| `val x = create()` | `val x by lazy { create() }` |

## Final Mental Model

Do not think:

> "`lazy` is another kind of variable."

Think:

> **"`lazy` means wait until the first time I need this value, calculate it, then remember the result."**

```kotlin
val database by lazy {
    createDatabase()
}
```

means:

```text
Don't create database yet
          ↓
First time database is used
          ↓
Create database
          ↓
Remember it
          ↓
Reuse it afterwards
```

### One-line rule

```text
lazy = delayed initialization + calculate once + reuse
```
