# Week 2 - Day 3
# Polymorphism in Kotlin

> Duration: 30 Minutes

Polymorphism is one of the four major concepts of Object-Oriented Programming (OOP).

The word polymorphism comes from:

```text
Poly  → Many
Morph → Forms
```

Therefore:

```text
Polymorphism = Many Forms
```

In Kotlin, polymorphism allows a parent type to represent different child objects while each child can provide its own behavior.

---

# Learning Objectives

After completing this lesson, you should understand:

- What is polymorphism?
- Runtime polymorphism
- Parent reference and child object
- Method overriding
- Upcasting
- `is`
- Smart casting
- `as`
- `as?`
- Safe casting
- Polymorphism with collections
- Polymorphism with function parameters
- Android connection

---

# 1. What is Polymorphism?

Polymorphism means:

> One type can represent different forms of objects.

Example:

```text
Animal
  |
  +---- Dog
  |
  +---- Cat
```

Both `Dog` and `Cat` are `Animal`s.

However, they can behave differently.

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}

class Cat : Animal() {

    override fun sound() {
        println("Cat meows")
    }
}
```

Usage:

```kotlin
val dog = Dog()
val cat = Cat()

dog.sound()
cat.sound()
```

Output:

```text
Dog barks
Cat meows
```

The same function:

```kotlin
sound()
```

has different behavior.

This is polymorphism.

---

# 2. Parent Reference and Child Object

One of the most important examples of polymorphism is:

```kotlin
val animal: Animal = Dog()
```

Look carefully:

```text
Variable type:
Animal

Actual object:
Dog
```

So:

```text
Animal reference
       |
       ↓
    Dog object
```

This works because:

```text
Dog IS-A Animal
```

Since `Dog` inherits from `Animal`, a `Dog` object can be treated as an `Animal`.

---

# 3. Runtime Polymorphism

Consider:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}

class Cat : Animal() {

    override fun sound() {
        println("Cat meows")
    }
}
```

Now:

```kotlin
val animal1: Animal = Dog()
val animal2: Animal = Cat()

animal1.sound()
animal2.sound()
```

Output:

```text
Dog barks
Cat meows
```

Although both variables have type:

```kotlin
Animal
```

the actual objects are:

```text
animal1 → Dog
animal2 → Cat
```

Therefore Kotlin executes the appropriate overridden function.

This is called:

```text
Runtime Polymorphism
```

---

# 4. Why Runtime Polymorphism?

The actual implementation is determined based on the object at runtime.

Example:

```kotlin
val animal: Animal = Dog()
```

At runtime:

```text
animal
  ↓
actual object = Dog
  ↓
Dog.sound()
```

Therefore:

```kotlin
animal.sound()
```

calls:

```kotlin
Dog.sound()
```

rather than:

```kotlin
Animal.sound()
```

---

# 5. Polymorphism with Multiple Objects

You can store different child objects in a collection of the parent type.

Example:

```kotlin
val animals: List<Animal> = listOf(
    Dog(),
    Cat(),
    Dog()
)
```

Now:

```kotlin
for (animal in animals) {
    animal.sound()
}
```

Output:

```text
Dog barks
Cat meows
Dog barks
```

The collection only needs to know:

```text
Animal
```

It doesn't need to know the exact child type beforehand.

---

# 6. Why Is This Useful?

Without polymorphism, you might have to write separate code for every type.

For example:

```text
If Dog → call Dog sound
If Cat → call Cat sound
If Bird → call Bird sound
```

With polymorphism:

```kotlin
for (animal in animals) {
    animal.sound()
}
```

Each object automatically uses its own implementation.

This makes code:

- More flexible
- Easier to extend
- Easier to maintain
- Less repetitive

---

# 7. Upcasting

When a child object is treated as its parent type, it is called **upcasting**.

Example:

```kotlin
val animal: Animal = Dog()
```

Conceptually:

```text
Dog
 ↓
Animal
```

The child is being viewed as its parent.

Upcasting is safe because:

```text
Dog IS-A Animal
```

---

# 8. What Can Be Accessed After Upcasting?

Consider:

```kotlin
open class Animal {

    fun eat() {
        println("Eating")
    }
}

class Dog : Animal() {

    fun bark() {
        println("Barking")
    }
}
```

Now:

```kotlin
val animal: Animal = Dog()
```

You can call:

```kotlin
animal.eat()
```

because `eat()` belongs to `Animal`.

But this is not directly allowed:

```kotlin
animal.bark()
```

Why?

Because the declared type is:

```text
Animal
```

and `Animal` does not define:

```text
bark()
```

Even though the actual object is a `Dog`.

---

# 9. Type Checking with `is`

Kotlin provides the `is` operator to check an object's type.

Example:

```kotlin
val animal: Animal = Dog()

if (animal is Dog) {
    println("This is a Dog")
}
```

Output:

```text
This is a Dog
```

The `is` operator checks:

```text
Is this object a Dog?
```

---

# 10. Smart Cast

Kotlin can automatically cast an object after an `is` check.

Example:

```kotlin
val animal: Animal = Dog()

if (animal is Dog) {
    animal.bark()
}
```

We did not write:

```kotlin
animal as Dog
```

Kotlin understands that inside the `if` block:

```text
animal is Dog
```

Therefore Kotlin automatically treats it as a `Dog`.

This is called:

```text
Smart Cast
```

---

# 11. `is` with `else if`

Example:

```kotlin
fun checkAnimal(animal: Animal) {

    if (animal is Dog) {

        println("Dog")
        animal.bark()

    } else if (animal is Cat) {

        println("Cat")
        animal.meow()
    }
}
```

Kotlin automatically smart-casts:

```text
animal → Dog
```

inside the first block.

And:

```text
animal → Cat
```

inside the second block.

---

# 12. `when` with Smart Cast

The `when` expression is often cleaner than multiple `if` statements.

```kotlin
fun checkAnimal(animal: Animal) {

    when (animal) {

        is Dog -> {
            animal.bark()
        }

        is Cat -> {
            animal.meow()
        }

        else -> {
            animal.sound()
        }
    }
}
```

Kotlin automatically smart-casts the object inside each branch.

---

# 13. Explicit Casting with `as`

The `as` operator performs an explicit cast.

Example:

```kotlin
val animal: Animal = Dog()

val dog = animal as Dog
```

Now:

```kotlin
dog.bark()
```

works.

The programmer is telling Kotlin:

> I know this object is a Dog. Treat it as a Dog.

---

# 14. Dangerous `as`

Be careful with `as`.

Example:

```kotlin
val animal: Animal = Cat()

val dog = animal as Dog
```

This fails because the actual object is a `Cat`.

It causes:

```text
ClassCastException
```

at runtime.

Therefore, don't use `as` unless you are sure about the object's type.

---

# 15. Safe Cast with `as?`

Kotlin provides `as?` for safe casting.

Example:

```kotlin
val animal: Animal = Cat()

val dog = animal as? Dog
```

Because the actual object is not a `Dog`:

```text
dog = null
```

No exception is thrown.

---

# 16. `as` vs `as?`

| `as` | `as?` |
|---|---|
| Unsafe cast | Safe cast |
| Throws exception if wrong | Returns `null` if wrong |
| Use when type is guaranteed | Use when type may be different |

Example:

```kotlin
val dog = animal as Dog
```

versus:

```kotlin
val dog = animal as? Dog
```

---

# 17. Safe Cast + Safe Call

This connects directly to Kotlin null safety.

Example:

```kotlin
val animal: Animal = Cat()

val dog = animal as? Dog

dog?.bark()
```

Flow:

```text
Cat
 ↓
as? Dog
 ↓
null
 ↓
?.bark()
 ↓
Nothing happens
```

This is a very useful Kotlin pattern.

---

# 18. Polymorphism with Function Parameters

One of the most useful applications of polymorphism is using a parent type as a function parameter.

Example:

```kotlin
fun makeSound(animal: Animal) {
    animal.sound()
}
```

Now both can be passed:

```kotlin
makeSound(Dog())
makeSound(Cat())
```

Output:

```text
Dog barks
Cat meows
```

Why does this work?

Because:

```text
Dog → Animal
Cat → Animal
```

Both are valid `Animal` objects.

---

# 19. Polymorphism with Collections

Example:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}

class Cat : Animal() {

    override fun sound() {
        println("Cat meows")
    }
}
```

Create a collection:

```kotlin
val animals: List<Animal> = listOf(
    Dog(),
    Cat(),
    Dog(),
    Cat()
)
```

Loop:

```kotlin
for (animal in animals) {
    animal.sound()
}
```

Output:

```text
Dog barks
Cat meows
Dog barks
Cat meows
```

The list doesn't need to know each object's exact type.

---

# 20. Real-World Example: Payment

Imagine a payment system:

```text
Payment
   |
   +---- BkashPayment
   |
   +---- CardPayment
   |
   +---- BankPayment
```

Parent:

```kotlin
open class Payment {

    open fun pay(amount: Double) {
        println("Processing payment")
    }
}
```

bKash:

```kotlin
class BkashPayment : Payment() {

    override fun pay(amount: Double) {
        println("Paying $amount using bKash")
    }
}
```

Card:

```kotlin
class CardPayment : Payment() {

    override fun pay(amount: Double) {
        println("Paying $amount using Card")
    }
}
```

Usage:

```kotlin
val payment1: Payment = BkashPayment()
val payment2: Payment = CardPayment()

payment1.pay(1000.0)
payment2.pay(2000.0)
```

Output:

```text
Paying 1000.0 using bKash
Paying 2000.0 using Card
```

Same parent type:

```text
Payment
```

Different behavior:

```text
bKash
Card
```

---

# 21. Android Connection

Polymorphism is heavily used in Android development.

For example, Android has a hierarchy like:

```text
View
 |
 +---- TextView
 |
 +---- Button
 |
 +---- ImageView
 |
 +---- EditText
```

Different views are all types of `View`.

Conceptually:

```kotlin
val view: View = TextView(...)
```

or:

```kotlin
val view: View = Button(...)
```

The common parent type allows Android APIs to work with different kinds of views.

---

# 22. RecyclerView Connection

Polymorphism can also be useful when working with different types of data.

For example:

```text
Message
 |
 +---- TextMessage
 |
 +---- ImageMessage
 |
 +---- VideoMessage
```

Then:

```kotlin
val messages: List<Message> = listOf(
    TextMessage(),
    ImageMessage(),
    VideoMessage()
)
```

The application can work with the common `Message` type while individual objects can have different behavior.

---

# 23. Four Concepts Together

You have now learned:

```text
Class
   ↓
Inheritance
   ↓
Overriding
   ↓
Polymorphism
```

Example:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}

val animal: Animal = Dog()

animal.sound()
```

The important line is:

```kotlin
val animal: Animal = Dog()
```

It means:

```text
Reference Type:
Animal

Actual Object:
Dog
```

Then:

```kotlin
animal.sound()
```

calls:

```kotlin
Dog.sound()
```

because the actual object is a `Dog`.

That is the core idea of runtime polymorphism.

---

# 24. Important Keywords

| Keyword | Meaning |
|---|---|
| `is` | Checks an object's type |
| `as` | Explicit unsafe cast |
| `as?` | Safe cast |
| `override` | Replaces parent implementation |
| `open` | Allows overriding |
| `super` | Refers to parent |
| `this` | Refers to current object |

---

# 25. `is` vs `as` vs `as?`

### `is`

Use it to check:

```kotlin
if (animal is Dog) {
    animal.bark()
}
```

Meaning:

```text
"Is this object a Dog?"
```

---

### `as`

Use it for explicit casting:

```kotlin
val dog = animal as Dog
```

If wrong:

```text
ClassCastException
```

---

### `as?`

Use it for safe casting:

```kotlin
val dog = animal as? Dog
```

If wrong:

```text
dog == null
```

---

# 26. Common Beginner Mistakes

## Mistake 1: Confusing Variable Type with Actual Object

```kotlin
val animal: Animal = Dog()
```

Do not think:

```text
The object is an Animal.
```

More precisely:

```text
Declared/reference type = Animal
Actual object = Dog
```

---

## Mistake 2: Calling Child-Specific Functions Through Parent Type

```kotlin
val animal: Animal = Dog()

animal.bark()
```

This doesn't work because `bark()` isn't part of the `Animal` type.

You can use:

```kotlin
if (animal is Dog) {
    animal.bark()
}
```

---

## Mistake 3: Using `as` Without Checking

Avoid:

```kotlin
val dog = animal as Dog
```

unless you know the object is definitely a `Dog`.

Prefer:

```kotlin
if (animal is Dog) {
    animal.bark()
}
```

or:

```kotlin
val dog = animal as? Dog
```

when appropriate.

---

# 27. Practice

## Exercise 1 — Animal

Create:

```text
Animal
 |
 +---- Dog
 |
 +---- Cat
```

Each child should override:

```kotlin
sound()
```

Then:

```kotlin
val animals: List<Animal> = listOf(
    Dog(),
    Cat(),
    Dog()
)
```

Loop through the list:

```kotlin
for (animal in animals) {
    animal.sound()
}
```

---

# Exercise 2 — Payment

Create:

```text
Payment
 |
 +---- BkashPayment
 |
 +---- CardPayment
```

Each should override:

```kotlin
pay()
```

Then create:

```kotlin
val payments: List<Payment>
```

and process all payments through the parent type.

---

# Exercise 3 — Type Checking

Create:

```kotlin
val animal: Animal = Dog()
```

Use:

```kotlin
is
```

to check whether the object is a `Dog`.

Then call:

```kotlin
bark()
```

using smart casting.

---

# Mini Challenge

Create:

```text
Employee
   |
   +---- Developer
   |
   +---- Designer
```

Parent:

```kotlin
open fun work()
```

Developer:

```text
Developer is writing code
```

Designer:

```text
Designer is creating UI
```

Then:

```kotlin
val employees: List<Employee> = listOf(
    Developer(),
    Designer(),
    Developer()
)
```

Loop:

```kotlin
for (employee in employees) {
    employee.work()
}
```

Expected output:

```text
Developer is writing code
Designer is creating UI
Developer is writing code
```

---

# Quick Quiz

Try answering without looking at the notes.

1. What does polymorphism mean?
2. What is runtime polymorphism?
3. What does this mean?

```kotlin
val animal: Animal = Dog()
```

4. Why can a `Dog` be assigned to an `Animal` variable?
5. What is upcasting?
6. What does `is` do?
7. What is smart casting?
8. What does `as` do?
9. What does `as?` do?
10. What is the difference between `as` and `as?`?
11. Why does `animal.sound()` call `Dog.sound()`?
12. Why can't `animal.bark()` be called directly when `animal` has type `Animal`?

---

# Quick Revision

```text
Polymorphism
│
├── Many forms
│
├── Parent reference
│      ↓
│   Child object
│
├── Runtime polymorphism
│      ↓
│   Overridden method selected
│
├── Upcasting
│      ↓
│   Dog → Animal
│
├── is
│      ↓
│   Type checking
│
├── Smart Cast
│      ↓
│   Automatic casting after is
│
├── as
│      ↓
│   Explicit unsafe cast
│
└── as?
       ↓
    Safe cast → null if failed
```

---

# Key Takeaways

- Polymorphism means **many forms**.
- A parent type can refer to a child object.
- Runtime polymorphism uses the actual object's overridden implementation.
- `val animal: Animal = Dog()` is a fundamental polymorphism example.
- Upcasting means treating a child object as its parent type.
- `is` checks an object's type.
- Kotlin can automatically smart-cast after an `is` check.
- `as` performs an explicit unsafe cast.
- `as?` performs a safe cast and returns `null` if the cast fails.
- Polymorphism is useful with collections and function parameters.
- Polymorphism makes code more flexible and extensible.
- Android uses polymorphism extensively.

---

# Next Lesson

## Week 2 - Day 4: Encapsulation and Abstraction

Topics:

- Encapsulation
- Data hiding
- `private`
- `protected`
- `public`
- `internal`
- Getters and setters
- `abstract class`
- `abstract fun`
- Abstraction
- Interfaces
- Android examples