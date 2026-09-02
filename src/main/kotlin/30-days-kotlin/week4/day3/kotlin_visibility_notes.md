# Kotlin Visibility Modifiers

## 1. What is Visibility in Kotlin?

Visibility modifiers control where a class, function, property, constructor, or other declaration can be accessed.

Kotlin provides four visibility modifiers:

1. `public`
2. `private`
3. `protected`
4. `internal`

If no visibility modifier is specified, Kotlin uses `public` by default.

---

## 2. public

`public` means the declaration can be accessed from anywhere it is visible.

```kotlin
class User {
    public val name = "Jammer"

    public fun showName() {
        println(name)
    }
}
```

`public` is the default visibility:

```kotlin
class User {
    val name = "Jammer"
}
```

The above is equivalent to:

```kotlin
class User {
    public val name = "Jammer"
}
```

### Example

```kotlin
class Car {
    public fun start() {
        println("Car started")
    }
}

fun main() {
    val car = Car()
    car.start()
}
```

---

## 3. private

`private` restricts access to the declaration.

For a top-level declaration, `private` means it is accessible only inside the same Kotlin file.

```kotlin
private fun calculate() {
    println("Calculating...")
}

fun main() {
    calculate()
}
```

For a member inside a class, `private` means it can only be accessed inside that class.

```kotlin
class Account {
    private val balance = 5000

    fun showBalance() {
        println(balance)
    }
}

fun main() {
    val account = Account()
    account.showBalance()

    // println(account.balance) // Error
}
```

### Why use private?

It helps hide implementation details and prevents outside code from directly changing internal data.

---

## 4. protected

`protected` allows access inside the declaring class and its subclasses.

```kotlin
open class Animal {
    protected fun eat() {
        println("Animal is eating")
    }
}

class Dog : Animal() {
    fun doSomething() {
        eat()
    }
}
```

Here, `Dog` can access `eat()` because `Dog` inherits from `Animal`.

```kotlin
fun main() {
    val dog = Dog()
    dog.doSomething()

    // dog.eat() // Error
}
```

### Important

Kotlin does not allow `protected` declarations at the top level.

This is invalid:

```kotlin
// protected fun test() { } // Error
```

---

## 5. internal

`internal` makes a declaration visible throughout the same Kotlin module.

```kotlin
internal class User {
    internal fun show() {
        println("User")
    }
}
```

A module can be thought of as a project/library compiled together.

For example:

```kotlin
// File: User.kt

internal class User
```

Another file in the same module can use it:

```kotlin
// File: Main.kt

fun main() {
    val user = User()
}
```

But code outside that module cannot access the `internal` declaration.

### Android example

In an Android project, `internal` can be useful when you want a class or function to be available across your application/module but not exposed as part of a public API.

---

# 6. Visibility of Top-Level Declarations

Top-level declarations are declarations outside classes.

```kotlin
class MainActivity

fun login() {
    // ...
}

val appName = "My App"
```

Their visibility can be:

```kotlin
public fun login() {}
private fun logout() {}
internal fun calculate() {}
```

`protected` cannot be used for top-level declarations.

---

# 7. Visibility Inside a Class

Example:

```kotlin
open class Person {

    public val name = "Alex"

    private val age = 25

    protected val city = "Dhaka"

    internal val country = "Bangladesh"
}
```

The meaning is:

| Modifier | Accessible from |
|---|---|
| `public` | Everywhere |
| `private` | Inside the declaring class |
| `protected` | Declaring class + subclasses |
| `internal` | Same module |

For `private` top-level declarations, remember the special rule: they are accessible within the same file.

---

# 8. Visibility and Inheritance

Consider:

```kotlin
open class Parent {

    public val a = 10
    private val b = 20
    protected val c = 30
}

class Child : Parent() {

    fun show() {
        println(a)
        // println(b) // Error
        println(c)
    }
}
```

`Child` can access:

- `public a`
- `protected c`

It cannot directly access:

- `private b`

---

# 9. private Constructor

A constructor can also be private.

```kotlin
class Database private constructor() {

    companion object {
        fun create(): Database {
            return Database()
        }
    }
}
```

Now this is not allowed:

```kotlin
// val db = Database() // Error
```

Instead:

```kotlin
val db = Database.create()
```

Private constructors are useful when you want to control how objects are created.

---

# 10. Visibility in Kotlin Properties

Visibility modifiers can be applied to properties.

```kotlin
class User {

    var name: String = "Alex"
        private set
}
```

Here:

- `name` can be read from outside the class.
- `name` can only be changed from inside the class.

Example:

```kotlin
class User {

    var name: String = "Alex"
        private set

    fun changeName(newName: String) {
        name = newName
    }
}
```

Usage:

```kotlin
fun main() {

    val user = User()

    println(user.name)

    user.changeName("Jammer")

    println(user.name)

    // user.name = "John" // Error
}
```

This pattern is very useful in Android development.

---

# 11. Visibility in Android Development

Visibility modifiers are commonly used in Android projects.

Example:

```kotlin
class UserViewModel {

    private val users = mutableListOf<String>()

    fun addUser(name: String) {
        users.add(name)
    }

    fun getUsers(): List<String> {
        return users
    }
}
```

The `users` list is private, so other classes cannot directly modify it.

This helps with **encapsulation**.

---

# 12. Visibility and Encapsulation

Encapsulation means keeping data and implementation details protected and exposing only what is necessary.

Example:

```kotlin
class BankAccount {

    private var balance = 0

    fun deposit(amount: Int) {
        if (amount > 0) {
            balance += amount
        }
    }

    fun getBalance(): Int {
        return balance
    }
}
```

Outside code cannot directly do:

```kotlin
// account.balance = -1000 // Error
```

Instead, it must use the controlled function:

```kotlin
account.deposit(500)
```

This prevents unwanted modification.

---

# 13. Quick Comparison

| Modifier | Class Member | Top-Level | Subclass Access | Same Module |
|---|---|---|---|---|
| `public` | Yes | Yes | Yes | Yes |
| `private` | Yes | Yes, same file | No direct access | No outside declaring scope |
| `protected` | Yes | No | Yes | Not the defining rule |
| `internal` | Yes | Yes | Yes if otherwise accessible | Yes |

---

# 14. Important Rules to Remember

### Rule 1
If no modifier is specified, visibility is `public`.

```kotlin
class User
```

is effectively:

```kotlin
public class User
```

### Rule 2
`private` at the top level means **same file**.

### Rule 3
`private` inside a class means **inside that class**.

### Rule 4
`protected` means **class + subclasses**.

### Rule 5
`internal` means **same module**.

### Rule 6
`protected` cannot be used for top-level declarations.

---

# 15. Simple Memory Trick

Think of the four modifiers like this:

- **public** → Everyone
- **private** → Me only
- **protected** → Me + Children (subclasses)
- **internal** → My Module

---

# 16. Interview Questions

### Q1. What is the default visibility modifier in Kotlin?

`public`.

### Q2. How many visibility modifiers does Kotlin have?

Four:

- `public`
- `private`
- `protected`
- `internal`

### Q3. Can protected be used for top-level declarations?

No.

### Q4. What does internal mean?

The declaration is accessible within the same Kotlin module.

### Q5. What does private mean for a top-level function?

It is accessible only within the same Kotlin file.

### Q6. What is the difference between private and protected?

`private` restricts access to the declaring class (or file for top-level declarations), while `protected` also allows subclasses to access a class member.

---

# 17. Final Example

```kotlin
open class Employee {

    public val name = "Alex"

    private var salary = 50000

    protected fun showDepartment() {
        println("IT Department")
    }

    internal fun showCompany() {
        println("ABC Company")
    }

    fun showSalary() {
        println(salary)
    }
}

class Developer : Employee() {

    fun showDetails() {
        println(name)
        showDepartment()
        showCompany()

        // println(salary) // Error
    }
}
```

The example demonstrates all four visibility modifiers and shows how they behave with inheritance.

---

# Summary

Kotlin visibility modifiers control access to classes, functions, properties, and constructors.

```text
public    → accessible everywhere
private   → restricted to declaring scope
protected → class + subclasses
internal  → same module
```

For Android development, `private` and `internal` are especially useful for keeping implementation details hidden, while `public` is used for APIs that other parts of the application need to access.
