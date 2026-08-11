# Encapsulation in Kotlin

## 1. What is Encapsulation?

Encapsulation is one of the four main concepts of Object-Oriented Programming (OOP).

The other three are:

```text
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction
```

### Definition

> Encapsulation means keeping an object's data and the functions that operate on that data together, while controlling how that data can be accessed or modified.

In simple words:

```text
Encapsulation
    ↓
Hide/protect internal data
    +
Control access to that data
```

---

# 2. Real-World Example

Think about a bank account.

You have:

```text
Bank Account
    |
    +── balance
    +── deposit()
    +── withdraw()
```

You should not be able to directly change the balance to anything you want.

For example:

```text
balance = -50000
```

would be invalid.

Instead, the bank controls the balance through operations:

```text
deposit()
withdraw()
```

This is the idea of encapsulation.

---

# 3. Problem Without Encapsulation

Consider:

```kotlin
class BankAccount(
    var balance: Double
)
```

Now:

```kotlin
val account = BankAccount(1000.0)
```

Anyone can directly change the balance:

```kotlin
account.balance = -50000.0
```

This is dangerous because the class has no control over its data.

---

# 4. Using `private`

We can protect the data using `private`.

```kotlin
class BankAccount(
    private var balance: Double
)
```

Now:

```kotlin
val account = BankAccount(1000.0)
```

This is allowed.

But:

```kotlin
account.balance
```

is not allowed outside the class.

Why?

Because:

```kotlin
private
```

means:

> This property can only be accessed from its allowed private scope.

For a class member, that normally means the class itself.

---

# 5. Controlled Access

Instead of allowing direct access, we can provide functions.

```kotlin
class BankAccount(
    private var balance: Double
) {

    fun deposit(amount: Double) {

        if (amount > 0) {
            balance += amount
        }
    }

    fun withdraw(amount: Double) {

        if (amount > 0 && amount <= balance) {
            balance -= amount
        }
    }

    fun getBalance(): Double {
        return balance
    }
}
```

Usage:

```kotlin
val account = BankAccount(1000.0)

account.deposit(500.0)
account.withdraw(200.0)

println(account.getBalance())
```

Output:

```text
1300.0
```

Notice that outside code cannot directly do:

```kotlin
account.balance = -50000.0
```

The class controls how the balance changes.

---

# 6. Why Do We Need Encapsulation?

Without encapsulation:

```text
Anyone
  ↓
Can directly modify data
  ↓
Invalid data can enter the object
```

With encapsulation:

```text
Outside code
     ↓
Controlled function/property
     ↓
Validation
     ↓
Internal data
```

Therefore, encapsulation helps us:

- Protect data
- Prevent invalid values
- Control modification
- Reduce accidental changes
- Make code easier to maintain
- Hide internal implementation details

---

# 7. Data Hiding

A major part of encapsulation is **data hiding**.

Example:

```kotlin
class BankAccount {

    private var balance = 0.0
}
```

The `balance` is hidden from outside code.

Conceptually:

```text
Outside
   |
   |  Cannot directly access
   ↓
private balance
   ↑
   |
Inside class
```

The class itself controls the data.

---

# 8. Access Modifiers

Kotlin has four main visibility modifiers:

```text
public
private
protected
internal
```

---

# 9. `public`

`public` means the member is accessible publicly.

Example:

```kotlin
class Student {

    public val name = "Mazharul"
}
```

Usage:

```kotlin
val student = Student()

println(student.name)
```

Output:

```text
Mazharul
```

Actually, you normally don't need to write `public`.

This:

```kotlin
val name = "Mazharul"
```

is already public by default.

---

# 10. `private`

`private` restricts access.

Example:

```kotlin
class Student {

    private val studentId = 101

    fun showId() {
        println(studentId)
    }
}
```

This works:

```kotlin
val student = Student()

student.showId()
```

But this does not:

```kotlin
println(student.studentId)
```

because `studentId` is private.

---

# 11. `protected`

`protected` allows access inside:

```text
The class
+
Its subclasses
```

Example:

```kotlin
open class Person {

    protected val name = "Mazharul"
}

class Student : Person() {

    fun showName() {
        println(name)
    }
}
```

Usage:

```kotlin
val student = Student()

student.showName()
```

Output:

```text
Mazharul
```

But this is not allowed:

```kotlin
println(student.name)
```

because `name` is protected.

---

# 12. `internal`

`internal` means accessible within the same module.

Example:

```kotlin
internal class Student
```

In Android development, a module can be an application module or another Gradle module.

You don't need to use `internal` frequently as a beginner, but you should understand what it means.

---

# 13. Access Modifier Summary

| Modifier | Accessibility |
|---|---|
| `public` | Everywhere |
| `private` | Restricted to its scope |
| `protected` | Class + subclasses |
| `internal` | Same module |

Remember:

```text
private
→ Hide/protect

public
→ Expose

protected
→ Class + child classes

internal
→ Same module
```

---

# 14. Getters and Setters

Kotlin properties have getters and setters.

Example:

```kotlin
class Student {

    var name: String = ""
}
```

When you write:

```kotlin
student.name
```

you are reading the property.

Conceptually:

```text
name
 |
 +── getter → read
 |
 +── setter → write
```

When you write:

```kotlin
student.name = "Mazharul"
```

you are using the setter.

---

# 15. Custom Getter

You can create your own getter.

Example:

```kotlin
class Rectangle(
    val width: Double,
    val height: Double
) {

    val area: Double
        get() = width * height
}
```

Usage:

```kotlin
val rectangle = Rectangle(10.0, 5.0)

println(rectangle.area)
```

Output:

```text
50.0
```

Notice:

```kotlin
rectangle.area
```

not:

```kotlin
rectangle.area()
```

because `area` is a property.

---

# 16. Custom Setter

You can control how a property is changed.

Example:

```kotlin
class Student {

    var age: Int = 0
        set(value) {

            if (value >= 0) {
                field = value
            }
        }
}
```

Usage:

```kotlin
val student = Student()

student.age = 20

println(student.age)
```

Output:

```text
20
```

But:

```kotlin
student.age = -10
```

will not update the property.

---

# 17. What is `field`?

Inside a custom getter/setter, Kotlin provides:

```kotlin
field
```

`field` represents the property's backing field.

Example:

```kotlin
var age: Int = 0
    set(value) {

        if (value >= 0) {
            field = value
        }
    }
```

Here:

```kotlin
field
```

means the actual stored value of `age`.

Do not write:

```kotlin
age = value
```

inside the setter because that can cause recursive setter calls.

Use:

```kotlin
field = value
```

---

# 18. `private set`

One of the most useful Kotlin encapsulation patterns is:

```kotlin
class BankAccount {

    var balance: Double = 0.0
        private set
}
```

This means:

```text
Outside the class:
    Can READ balance
    Cannot CHANGE balance

Inside the class:
    Can READ balance
    Can CHANGE balance
```

Example:

```kotlin
val account = BankAccount()

println(account.balance)
```

Allowed.

But:

```kotlin
account.balance = 5000.0
```

Not allowed outside the class.

Inside the class:

```kotlin
fun deposit(amount: Double) {
    balance += amount
}
```

is allowed.

---

# 19. `private set` vs `private var`

These are different.

### `private var`

```kotlin
private var balance = 0.0
```

Outside code cannot:

```text
Read
Write
```

the property directly.

---

### `var` with `private set`

```kotlin
var balance = 0.0
    private set
```

Outside code can:

```text
Read
```

but cannot:

```text
Write
```

So:

```text
private var
→ Hide both reading and writing

var + private set
→ Allow reading
→ Hide writing
```

This distinction is very important in Android development.

---

# 20. Complete Encapsulation Example

```kotlin
class BankAccount(
    val accountNumber: String
) {

    var balance: Double = 0.0
        private set

    fun deposit(amount: Double) {

        if (amount <= 0) {
            println("Invalid deposit amount")
            return
        }

        balance += amount
    }

    fun withdraw(amount: Double) {

        if (amount <= 0) {
            println("Invalid withdrawal amount")
            return
        }

        if (amount > balance) {
            println("Insufficient balance")
            return
        }

        balance -= amount
    }
}
```

Usage:

```kotlin
fun main() {

    val account = BankAccount("12345")

    account.deposit(5000.0)

    account.withdraw(1000.0)

    println(account.balance)
}
```

Output:

```text
4000.0
```

But this is not allowed:

```kotlin
account.balance = -50000.0
```

because:

```kotlin
private set
```

protects the setter.

---

# 21. Encapsulation with Validation

Encapsulation becomes especially useful when data has rules.

Example:

```kotlin
class Student {

    var age: Int = 0
        private set

    fun setAge(newAge: Int) {

        if (newAge in 5..100) {
            age = newAge
        }
    }
}
```

Now:

```kotlin
val student = Student()

student.setAge(25)

println(student.age)
```

Output:

```text
25
```

But:

```kotlin
student.setAge(-10)
```

will not change the age.

The class controls its own data.

---

# 22. Encapsulation with a Mutable List

This is especially important in Android development.

Consider:

```kotlin
class UserRepository {

    private val users = mutableListOf<String>()

    fun addUser(name: String) {
        users.add(name)
    }

    fun getUsers(): List<String> {
        return users.toList()
    }
}
```

Outside code can do:

```kotlin
val repository = UserRepository()

repository.addUser("Mazharul")

println(repository.getUsers())
```

But it cannot directly access:

```kotlin
repository.users
```

because `users` is private.

Also, `getUsers()` returns:

```kotlin
List<String>
```

rather than:

```kotlin
MutableList<String>
```

So callers cannot directly modify the repository's internal list.

---

# 23. Why Return `List` Instead of `MutableList`?

Consider:

```kotlin
fun getUsers(): MutableList<String> {
    return users
}
```

Now outside code could potentially modify the internal list.

For example:

```kotlin
repository.getUsers().clear()
```

That would modify the repository's internal data.

Instead:

```kotlin
fun getUsers(): List<String> {
    return users.toList()
}
```

returns a read-only snapshot.

This provides stronger encapsulation.

---

# 24. Encapsulation in Android

Encapsulation is used heavily in Android architecture.

For example:

```text
UI
 ↓
ViewModel
 ↓
Repository
 ↓
Database / API
```

Each component should control its internal state.

A common pattern is:

```kotlin
private val _users = MutableStateFlow<List<User>>(emptyList())

val users: StateFlow<List<User>>
    get() = _users
```

The ViewModel can modify:

```kotlin
_users
```

but outside code only observes:

```kotlin
users
```

This is a practical example of encapsulation.

You will understand this pattern much better when you learn:

```text
StateFlow
ViewModel
MVVM
Repository
```

---

# 25. Encapsulation vs Abstraction

These two concepts are often confused.

## Encapsulation

Main question:

> How can I protect and control the object's data?

Example:

```kotlin
private var balance: Double
```

or:

```kotlin
var balance: Double = 0.0
    private set
```

---

## Abstraction

Main question:

> What details should I hide so the user only sees what is necessary?

Example:

```kotlin
abstract fun pay()
```

The user knows:

```text
pay()
```

but doesn't necessarily need to know the internal payment implementation.

---

# 26. Simple Difference

Remember this:

```text
Encapsulation
↓
Protect/control data

Abstraction
↓
Hide implementation complexity
```

Example:

```text
BankAccount
│
├── private balance
│      ↓
│   Encapsulation
│
└── withdraw()
       ↓
   User doesn't need to know
   the internal calculation
```

Both concepts can work together.

---

# 27. Encapsulation Does NOT Mean Everything Must Be Private

A common beginner misunderstanding is:

> "Encapsulation means all properties should be private."

Not necessarily.

Encapsulation means:

> Control access appropriately.

For example:

```kotlin
class Student {

    val name: String = "Mazharul"

    var age: Int = 0
        private set
}
```

Here:

```text
name
→ Public read-only

age
→ Public read
→ Private write
```

This can still be good encapsulation.

The goal is not:

```text
Make everything private
```

The goal is:

```text
Expose only what should be exposed.
```

---

# 28. Good Encapsulation Design

Bad:

```kotlin
class BankAccount {

    var balance = 0.0
}
```

Anyone can modify it.

Better:

```kotlin
class BankAccount {

    var balance = 0.0
        private set

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }
}
```

Now the class controls how the balance changes.

---

# 29. Encapsulation Pattern to Remember

A very common pattern is:

```kotlin
class Example {

    private var data = ...

    fun updateData(...) {
        // validate
        // modify data
    }

    fun getData(): ... {
        return data
    }
}
```

Or:

```kotlin
class Example {

    var data = ...
        private set

    fun updateData(...) {
        // validate
        data = ...
    }
}
```

---

# 30. Common Beginner Mistakes

## Mistake 1

Making important internal data public:

```kotlin
var balance = 1000.0
```

when outside code shouldn't directly modify it.

---

## Mistake 2

Using a public mutable collection:

```kotlin
val users = mutableListOf<String>()
```

when external code should not be able to modify the collection.

---

## Mistake 3

Confusing `private var` and `private set`.

```kotlin
private var balance = 0.0
```

means the property itself is private.

While:

```kotlin
var balance = 0.0
    private set
```

means:

```text
Getter → public
Setter → private
```

---

# 31. Practice Exercise

Create:

```kotlin
class BankAccount
```

Properties:

```text
accountNumber
balance
```

Requirements:

```text
accountNumber → read-only
balance → cannot be directly changed from outside
```

Functions:

```text
deposit()
withdraw()
```

Rules:

```text
Deposit must be > 0

Withdrawal must be > 0

Withdrawal cannot be greater than balance
```

Example:

```kotlin
val account = BankAccount("12345")

account.deposit(5000.0)
account.withdraw(1500.0)

println(account.balance)
```

Expected:

```text
3500.0
```

This should NOT be allowed:

```kotlin
account.balance = -10000.0
```

---

# 32. Mini Challenge

Create a:

```text
Student
```

class.

Properties:

```text
name
studentId
marks
```

Requirements:

```text
name → public read-only
studentId → public read-only
marks → private modification
```

Create:

```kotlin
addMarks()
```

Rules:

```text
Marks cannot be negative.
Marks cannot exceed 100.
```

Example:

```kotlin
val student = Student(
    "Mazharul",
    101
)

student.addMarks(85)

println(student.name)
println(student.studentId)
println(student.marks)
```

---

# 33. Quick Quiz

Answer these without looking at the notes:

1. What is encapsulation?
2. Why do we use encapsulation?
3. What is data hiding?
4. What does `private` mean?
5. What does `public` mean?
6. What does `protected` mean?
7. What does `internal` mean?
8. What is a getter?
9. What is a setter?
10. What does `private set` mean?
11. What is the difference between `private var` and `var` with `private set`?
12. What is `field` inside a setter?
13. Why shouldn't we expose mutable internal data unnecessarily?
14. How does encapsulation help Android development?
15. What is the difference between encapsulation and abstraction?

---

# 34. Quick Revision

```text
ENCAPSULATION
│
├── Protect internal data
│
├── Control access
│
├── Data hiding
│
├── Access modifiers
│     ├── public
│     ├── private
│     ├── protected
│     └── internal
│
├── Getters
│
├── Setters
│
├── Custom getter
│
├── Custom setter
│
├── private set
│
└── Validation
```

---

# 35. Most Important Things to Remember

### 1. Encapsulation

```text
Protect + Control data
```

### 2. `private`

```text
Hide from outside access
```

### 3. `private set`

```text
Can read from outside
Cannot write from outside
```

### 4. Getter

```text
Read property
```

### 5. Setter

```text
Change property
```

### 6. `field`

```text
Actual backing value inside a custom accessor
```

### 7. Main Goal

```text
Don't expose more than necessary.
```

---

# Android Connection

You will see encapsulation frequently in:

```text
ViewModel
Repository
Room
StateFlow
LiveData
MVVM
API/Network layers
```

A common Android pattern you'll encounter later is:

```kotlin
private val _state = MutableStateFlow(...)
val state = _state.asStateFlow()
```

The idea is:

```text
Inside ViewModel
      ↓
Can modify state

Outside/UI
      ↓
Can observe state
      ↓
Cannot directly modify it
```

That is encapsulation in real Android development.

---

# Summary

Encapsulation means:

> Keep data and the operations that manage that data together, and control how outside code can access or modify it.

The most important Kotlin tools for encapsulation are:

```kotlin
private
protected
internal
public
get()
set()
private set
```

The most important pattern to remember is:

```kotlin
class BankAccount {

    var balance: Double = 0.0
        private set

    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }
}
```

Outside code:

```kotlin
account.deposit(1000.0)
println(account.balance)
```

But:

```kotlin
account.balance = -5000.0
```

is not allowed.

That is **encapsulation**.