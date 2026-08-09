# Composition in Kotlin

## 1. Definition

**Composition** means a class contains an object of another class as a property.

It represents a **HAS-A relationship**.

```kotlin
class Address(
    val roadNo: String,
    val city: String
)

class User(
    val name: String,
    val address: Address
)
```

Here:

```text
User HAS-A Address
```

---

## 2. Basic Example

```kotlin
class Address(
    val roadNo: String,
    val city: String
)

class User(
    val name: String,
    val address: Address
)

fun main() {
    val address = Address("KHL Road", "Paikgachha")
    val user = User("Shamim", address)

    println(user.name)
    println(user.address.roadNo)
    println(user.address.city)
}
```

Output:

```text
Shamim
KHL Road
Paikgachha
```

---

## 3. How Composition Works

```text
User
 |
 +-- name
 |
 +-- address
       |
       +-- roadNo
       +-- city
```

The `User` object contains a reference to an `Address` object.

---

## 4. HAS-A Relationship

Composition is used when one object **has** another object.

Examples:

```text
User HAS-A Address
Car HAS-A Engine
Computer HAS-A CPU
Order HAS-A Product
Student HAS-A Address
```

Example:

```kotlin
class Engine(
    val type: String
)

class Car(
    val brand: String,
    val engine: Engine
)
```

Usage:

```kotlin
val engine = Engine("Petrol")
val car = Car("Toyota", engine)

println(car.engine.type)
```

---

## 5. Composition vs Inheritance

### Composition

```kotlin
class Engine

class Car(
    val engine: Engine
)
```

Relationship:

```text
Car HAS-A Engine
```

### Inheritance

```kotlin
open class Animal

class Dog : Animal()
```

Relationship:

```text
Dog IS-A Animal
```

### Rule

| Relationship | Usually use |
|---|---|
| HAS-A | Composition |
| IS-A | Inheritance |

---

## 6. Why Not Use Inheritance for HAS-A?

Suppose a user has an address.

Incorrect:

```kotlin
class User : Address()
```

This means:

```text
User IS-A Address
```

That is not logically correct.

Correct:

```kotlin
class User(
    val address: Address
)
```

This means:

```text
User HAS-A Address
```

---

## 7. Multiple Composed Objects

A class can contain objects of several different classes.

```kotlin
class Engine(
    val type: String
)

class Address(
    val city: String
)

class Car(
    val brand: String,
    val engine: Engine,
    val address: Address
)
```

Structure:

```text
Car
 |
 +-- brand
 +-- engine --> Engine
 |
 +-- address --> Address
```

---

## 8. Accessing Nested Objects

If:

```kotlin
class Address(
    val city: String
)

class User(
    val address: Address
)
```

Then:

```kotlin
user.address.city
```

means:

```text
user
  |
  +-- address
        |
        +-- city
```

Example:

```kotlin
println(user.address.city)
```

---

## 9. Composition with a Student

```kotlin
class Address(
    val city: String,
    val country: String
)

class Student(
    val name: String,
    val cgpa: Double,
    val address: Address
)

fun main() {
    val address = Address(
        "Paikgachha",
        "Bangladesh"
    )

    val student = Student(
        "Mazharul",
        3.31,
        address
    )

    println(student.name)
    println(student.cgpa)
    println(student.address.city)
    println(student.address.country)
}
```

---

## 10. Composition with Profile

A common Android-style example:

```kotlin
class Profile(
    val imageUrl: String,
    val bio: String
)

class User(
    val name: String,
    val profile: Profile
)
```

Usage:

```kotlin
val profile = Profile(
    "profile.jpg",
    "Android Developer"
)

val user = User(
    "Mazharul",
    profile
)

println(user.profile.imageUrl)
println(user.profile.bio)
```

Structure:

```text
User
 |
 +-- name
 |
 +-- profile
       |
       +-- imageUrl
       +-- bio
```

---

## 11. Important Point

Composition usually involves a class containing an **object of another class**.

Example:

```kotlin
class Address(
    val city: String
)

class Student(
    val address: Address
)
```

The important part is:

```kotlin
val address: Address
```

`address` is a property of `Student`, and its type is another class: `Address`.

---

## 12. Composition Does Not Require Constructor Properties

The contained object can also be created inside the class.

```kotlin
class Address(
    val city: String
)

class User {
    val address = Address("Paikgachha")
}
```

Here `User` still has an `Address`.

However, constructor injection is often clearer:

```kotlin
class User(
    val address: Address
)
```

---

## 13. Original Example

```kotlin
class Address5(
    val roadNo: String,
    val city: String
)

class User5(
    val name: String,
    val address: Address5
)

fun main() {
    val address = Address5(
        "KHL Road",
        "Paikgachha"
    )

    val user = User5(
        "Shamim",
        address
    )

    println(user.name)
    println(user.address.roadNo)
    println(user.address.city)
}
```

This is composition because:

```text
User5 HAS-A Address5
```

---

## 14. Quick Comparison

```text
Inheritance:
Dog : Animal

Dog IS-A Animal


Composition:
Car(
    val engine: Engine
)

Car HAS-A Engine
```

---

## 15. Key Points to Remember

- Composition means one class contains another class's object.
- It represents a **HAS-A** relationship.
- The contained object is usually stored as a property.
- Composition is different from inheritance.
- Inheritance represents **IS-A**.
- Composition represents **HAS-A**.
- Composition is often preferable when there is no genuine IS-A relationship.

### Memory Trick

```text
IS-A  → Inheritance
HAS-A → Composition
```
