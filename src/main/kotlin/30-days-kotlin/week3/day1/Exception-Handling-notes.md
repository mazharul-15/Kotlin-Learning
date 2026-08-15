# Kotlin Exception Handling — Notes

## 1. What is an Exception?

An **exception** is an unexpected problem that occurs while a program is running.

Example:

```kotlin
fun main() {
    val result = 10 / 0
    println(result)
}
```

This causes an `ArithmeticException`.

Exception handling allows us to handle such problems instead of allowing the program to crash.

---

## 2. Why Do We Need Exception Handling?

Consider:

```kotlin
fun main() {
    val age = readln().toInt()
    println(age)
}
```

If the user enters:

```text
abc
```

Kotlin cannot convert `"abc"` into an `Int`, so it throws a `NumberFormatException`.

We can handle it:

```kotlin
fun main() {

    try {
        val age = readln().toInt()
        println("Age: $age")
    } catch (e: NumberFormatException) {
        println("Please enter a valid number")
    }
}
```

---

## 3. `try`

The `try` block contains code that may cause an exception.

```kotlin
try {
    val result = 10 / 0
}
```

By itself, `try` does not handle the exception. Usually it is combined with `catch` or `finally`.

---

## 4. `try-catch`

Basic syntax:

```kotlin
try {
    // Code that may cause an exception
} catch (e: Exception) {
    // Handle the exception
}
```

Example:

```kotlin
fun main() {

    try {
        val result = 10 / 0
        println(result)
    } catch (e: Exception) {
        println("Something went wrong")
    }
}
```

Output:

```text
Something went wrong
```

Instead of crashing, the exception is handled by `catch`.

---

## 5. What is `e`?

In:

```kotlin
catch (e: Exception)
```

`e` is a variable containing information about the exception.

You can print the exception:

```kotlin
catch (e: Exception) {
    println(e)
}
```

You can also print its message:

```kotlin
catch (e: Exception) {
    println(e.message)
}
```

For example:

```kotlin
fun main() {

    try {
        val result = 10 / 0
    } catch (e: Exception) {
        println(e.message)
    }
}
```

Possible output:

```text
/ by zero
```

---

## 6. Specific Exception Types

Instead of catching every exception using:

```kotlin
catch (e: Exception)
```

you can catch a specific exception.

Example:

```kotlin
fun main() {

    try {
        val number = "abc".toInt()
        println(number)
    } catch (e: NumberFormatException) {
        println("Invalid number")
    }
}
```

Specific exception handling is usually better because it tells us exactly what problem we are expecting.

---

## 7. Common Exception Types

### `ArithmeticException`

Usually occurs because of an invalid arithmetic operation.

```kotlin
val result = 10 / 0
```

---

### `NumberFormatException`

Occurs when a String cannot be converted into a number.

```kotlin
val number = "abc".toInt()
```

---

### `IndexOutOfBoundsException`

Occurs when accessing an invalid index.

```kotlin
val numbers = listOf(10, 20, 30)

println(numbers[5])
```

Valid indexes are:

```text
0
1
2
```

---

### `NullPointerException`

Occurs when code attempts to use a null reference incorrectly.

Kotlin's null-safety system prevents many situations that commonly cause null pointer errors.

---

## 8. Multiple `catch` Blocks

A `try` block can have multiple `catch` blocks.

```kotlin
fun main() {

    try {
        val number = "abc".toInt()
        println(number)

    } catch (e: NumberFormatException) {
        println("Invalid number")

    } catch (e: ArithmeticException) {
        println("Arithmetic error")

    } catch (e: Exception) {
        println("Something else went wrong")
    }
}
```

Kotlin checks the `catch` blocks and uses the matching one.

---

## 9. Order of `catch` Blocks

The order is important.

Do this:

```kotlin
catch (e: NumberFormatException) {
    println("Invalid number")
}

catch (e: Exception) {
    println("Other error")
}
```

Do not put the general `Exception` first:

```kotlin
catch (e: Exception) {
    println("Error")
}

catch (e: NumberFormatException) {
    println("Invalid number")
}
```

`Exception` is a general parent type, so it can catch `NumberFormatException` before the specific `catch` gets a chance.

### Rule

**Specific exceptions should come before general exceptions.**

---

## 10. `finally`

The `finally` block runs whether an exception occurs or not.

Syntax:

```kotlin
try {
    // Risky code
} catch (e: Exception) {
    // Handle exception
} finally {
    // Always runs
}
```

Example:

```kotlin
fun main() {

    try {
        val result = 10 / 0
        println(result)

    } catch (e: ArithmeticException) {
        println("Cannot divide by zero")

    } finally {
        println("Program finished")
    }
}
```

Output:

```text
Cannot divide by zero
Program finished
```

---

## 11. `try` With `finally`

A `try` block can also be followed directly by `finally`.

```kotlin
try {
    println("Trying...")
} finally {
    println("Finally")
}
```

However, if the exception is not caught, it can still propagate after `finally` executes.

---

## 12. `try` Is an Expression in Kotlin

In Kotlin, `try` can return a value.

Example:

```kotlin
fun main() {

    val number = try {
        "100".toInt()
    } catch (e: NumberFormatException) {
        0
    }

    println(number)
}
```

Output:

```text
100
```

If the conversion fails:

```kotlin
fun main() {

    val number = try {
        "abc".toInt()
    } catch (e: NumberFormatException) {
        0
    }

    println(number)
}
```

Output:

```text
0
```

The idea is:

```text
try   -> successful value
catch -> alternative value
```

---

## 13. `throw`

The `throw` keyword is used when you want to manually create and throw an exception.

Example:

```kotlin
fun checkAge(age: Int) {

    if (age < 18) {
        throw Exception("You must be 18 or older")
    }

    println("You can enter")
}
```

Calling:

```kotlin
checkAge(15)
```

throws the exception.

---

## 14. Handling a `throw`

A manually thrown exception can be handled with `try-catch`.

```kotlin
fun checkAge(age: Int) {

    if (age < 18) {
        throw Exception("You must be 18 or older")
    }

    println("You can enter")
}

fun main() {

    try {
        checkAge(15)
    } catch (e: Exception) {
        println(e.message)
    }
}
```

Output:

```text
You must be 18 or older
```

---

## 15. Custom Exception

You can create your own exception class.

```kotlin
class InvalidAgeException(message: String) : Exception(message)
```

Then use it:

```kotlin
fun checkAge(age: Int) {

    if (age < 18) {
        throw InvalidAgeException("Age must be 18 or older")
    }

    println("Valid age")
}
```

Handle it:

```kotlin
fun main() {

    try {
        checkAge(15)

    } catch (e: InvalidAgeException) {
        println(e.message)
    }
}
```

Output:

```text
Age must be 18 or older
```

Custom exceptions are useful when you want errors to have a clear meaning specific to your application.

---

## 16. Exception Handling in Android

Exception handling is useful in Android when dealing with user input, network responses, file operations, database operations, and other operations that can fail.

For example:

```kotlin
val age = editText.text.toString().toInt()
```

If the user enters:

```text
abc
```

the app can throw `NumberFormatException`.

Instead:

```kotlin
try {

    val age = editText.text.toString().toInt()

    Toast.makeText(
        this,
        "Age: $age",
        Toast.LENGTH_SHORT
    ).show()

} catch (e: NumberFormatException) {

    Toast.makeText(
        this,
        "Please enter a valid number",
        Toast.LENGTH_SHORT
    ).show()
}
```

This prevents invalid user input from causing an application crash.

---

## 17. Exception Handling vs Null Safety

Exception handling and null safety are different concepts.

### Null Safety

Deals primarily with nullable values.

```kotlin
val name: String? = null

println(name?.length)
```

The safe-call operator `?.` prevents the operation from being performed when `name` is null.

### Exception Handling

Deals with exceptions that occur during program execution.

```kotlin
try {
    val number = "abc".toInt()
} catch (e: NumberFormatException) {
    println("Invalid number")
}
```

### Remember

```text
Null Safety
    ↓
Helps prevent null-related problems

Exception Handling
    ↓
Handles exceptions when they occur
```

---

## 18. Don't Use `try-catch` Everywhere

Do not wrap every piece of code in `try-catch`.

Bad example:

```kotlin
try {
    val name = "Mazharul"
    println(name)
} catch (e: Exception) {
    println("Error")
}
```

There is no meaningful reason to catch an exception here.

Use exception handling when:

1. An operation can realistically fail.
2. You know what exception may occur.
3. You know how to handle the failure.

---

## 19. Real Example — User Input

```kotlin
fun main() {

    print("Enter your age: ")

    try {

        val age = readln().toInt()

        println("Your age is $age")

    } catch (e: NumberFormatException) {

        println("Please enter a valid number")
    }
}
```

If the user enters:

```text
25
```

Output:

```text
Your age is 25
```

If the user enters:

```text
hello
```

Output:

```text
Please enter a valid number
```

---

## 20. Complete Exception Handling Structure

A common structure is:

```kotlin
try {

    // Code that might cause an exception

} catch (e: SpecificException) {

    // Handle specific exception

} catch (e: Exception) {

    // Handle other exceptions

} finally {

    // Code that should run at the end
}
```

To manually throw an exception:

```kotlin
throw Exception("Something went wrong")
```

---

# Important Concepts to Remember

| Concept | Purpose |
|---|---|
| `try` | Contains code that may throw an exception |
| `catch` | Handles an exception |
| `finally` | Runs after `try`/`catch` regardless of whether an exception occurred |
| `throw` | Manually throws an exception |
| `Exception` | General exception type |
| `NumberFormatException` | Invalid String-to-number conversion |
| `ArithmeticException` | Invalid arithmetic operation |
| `IndexOutOfBoundsException` | Invalid index access |
| Custom Exception | Application-specific exception |
| `try` expression | Allows `try-catch` to produce a value |

---

# Mental Model

Think about exception handling like this:

```text
                 try
                  |
                  v
            Code executes
             /        \
        success       error
           |             |
           v             v
       continue        catch
                         |
                         v
                      handle
                         |
                         v
                      finally
                         |
                         v
                      continue
```

---

# Practice Tasks

## Task 1 — Division

Write a program that:

- Takes two numbers.
- Divides the first by the second.
- Handles `ArithmeticException`.

---

## Task 2 — Number Conversion

Write a program that:

- Takes input as a String.
- Converts it to `Int`.
- Handles `NumberFormatException`.

---

## Task 3 — List Index

Create:

```kotlin
val numbers = listOf(10, 20, 30)
```

Try to access an invalid index and handle the exception.

---

## Task 4 — Age Validation

Create:

```kotlin
fun checkAge(age: Int)
```

If age is less than 18:

```text
throw an exception
```

Otherwise print:

```text
You can enter
```

---

## Task 5 — Custom Exception

Create:

```kotlin
class InvalidAgeException(message: String) : Exception(message)
```

Use it inside `checkAge()` and handle it using `try-catch`.

---

# Quick Revision

```kotlin
try {
    // risky code
} catch (e: Exception) {
    // handle error
} finally {
    // always execute
}
```

```kotlin
throw Exception("Error message")
```

Specific exception:

```kotlin
catch (e: NumberFormatException) {
    println("Invalid number")
}
```

General exception:

```kotlin
catch (e: Exception) {
    println("Something went wrong")
}
```

**Key rule:**

> Handle specific exceptions first and general exceptions later.
