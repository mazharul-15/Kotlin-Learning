# Week 2 - Day 2
# Inheritance in Kotlin

> Duration: 30 Minutes

Inheritance is an important concept of Object-Oriented Programming (OOP).

Inheritance allows one class to acquire properties and functions from another class.

Inheritance is also very important in Android development because Android code frequently uses inheritance.

Example:

```kotlin
class MainActivity : AppCompatActivity()
```

Here `MainActivity` inherits from `AppCompatActivity`.

---

# Learning Objectives

After completing this lesson, you should understand:

- What is inheritance?
- Parent class
- Child class
- `open`
- `:`
- Inheriting properties
- Inheriting functions
- Parent constructors
- Method overriding
- `override`
- `super`
- `final`
- Multi-level inheritance
- Inheritance vs Composition
- Android inheritance examples

---

# 1. What is Inheritance?

Inheritance allows one class to acquire properties and functions from another class.

Example:

```text
Animal
   |
   +---- Dog
   |
   +---- Cat
```

Here:

```text
Animal → Parent class
Dog    → Child class
Cat    → Child class
```

The child classes can use functionality defined in the parent class.

---

# 2. Parent Class

A class that is inherited by another class is called a **parent class** or **superclass**.

Example:

```kotlin
open class Animal {

    fun eat() {
        println("Animal is eating")
    }
}
```

The `open` keyword allows another class to inherit from `Animal`.

---

# 3. Child Class

A class that inherits from another class is called a **child class** or **subclass**.

Example:

```kotlin
class Dog : Animal()
```

The syntax:

```kotlin
class Dog : Animal()
```

means:

```text
Dog inherits from Animal
```

The `:` is used for inheritance in Kotlin.

---

# 4. Why `open`?

Kotlin classes are `final` by default.

That means this:

```kotlin
class Animal {

}
```

cannot be inherited.

This will produce an error:

```kotlin
class Dog : Animal()
```

To allow inheritance:

```kotlin
open class Animal {

}
```

Now this is valid:

```kotlin
class Dog : Animal()
```

### Remember

```text
class
    ↓
Cannot be inherited by default

open class
    ↓
Can be inherited
```

---

# 5. Inheriting Functions

Parent:

```kotlin
open class Animal {

    fun eat() {
        println("Animal is eating")
    }

    fun sleep() {
        println("Animal is sleeping")
    }
}
```

Child:

```kotlin
class Dog : Animal()
```

Create an object:

```kotlin
val dog = Dog()
```

The `Dog` object can use the inherited functions:

```kotlin
dog.eat()
dog.sleep()
```

Output:

```text
Animal is eating
Animal is sleeping
```

The functions were declared in `Animal`, not `Dog`.

---

# 6. Inheriting Properties

A child class can also access properties from the parent.

Example:

```kotlin
open class Animal(
    val name: String
)

class Dog(
    name: String
) : Animal(name)
```

Create an object:

```kotlin
val dog = Dog("Tommy")
```

Access the inherited property:

```kotlin
println(dog.name)
```

Output:

```text
Tommy
```

---

# 7. Calling the Parent Constructor

Consider:

```kotlin
open class Animal(
    val name: String
)

class Dog(
    name: String
) : Animal(name)
```

This:

```kotlin
Animal(name)
```

calls the parent class constructor.

The flow is:

```text
Dog("Tommy")
      |
      ↓
Animal("Tommy")
      |
      ↓
name = "Tommy"
```

---

# 8. Child-Specific Functions

A child class can have its own properties and functions.

Example:

```kotlin
open class Animal(
    val name: String
) {

    fun eat() {
        println("$name is eating")
    }
}

class Dog(
    name: String
) : Animal(name) {

    fun bark() {
        println("$name is barking")
    }
}
```

Usage:

```kotlin
val dog = Dog("Tommy")

dog.eat()
dog.bark()
```

Output:

```text
Tommy is eating
Tommy is barking
```

The `Dog` object has:

```text
Inherited:
    eat()

Own:
    bark()
```

---

# 9. Method Overriding

Sometimes a child class needs a different implementation of a function inherited from the parent.

This is called **method overriding**.

Parent:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal makes a sound")
    }
}
```

Child:

```kotlin
class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}
```

Usage:

```kotlin
val dog = Dog()

dog.sound()
```

Output:

```text
Dog barks
```

---

# 10. Why `open` on Functions?

A function is also `final` by default.

Therefore, this:

```kotlin
open class Animal {

    fun sound() {
        println("Animal sound")
    }
}
```

cannot be overridden.

If you want a child class to override it:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}
```

There are two separate `open` keywords:

```kotlin
open class Animal {

    open fun sound() {

    }
}
```

First `open`:

```text
Allows class inheritance
```

Second `open`:

```text
Allows function overriding
```

---

# 11. `override`

The child class uses `override` when replacing a parent's implementation.

Example:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Cat : Animal() {

    override fun sound() {
        println("Meow")
    }
}
```

The child has replaced the parent's implementation of `sound()`.

---

# 12. `super`

`super` refers to the parent class.

You can use `super` to call the parent's implementation.

Example:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal sound")
    }
}

class Dog : Animal() {

    override fun sound() {

        super.sound()

        println("Dog barks")
    }
}
```

Usage:

```kotlin
val dog = Dog()

dog.sound()
```

Output:

```text
Animal sound
Dog barks
```

Here:

```kotlin
super.sound()
```

means:

```text
Call the parent's sound() function.
```

---

# 13. `this` vs `super`

### `this`

Refers to the current object.

```kotlin
this.name
```

means:

```text
The name of the current object.
```

### `super`

Refers to the parent class.

```kotlin
super.sound()
```

means:

```text
Call the parent's sound().
```

Simple rule:

```text
this  → current class/object
super → parent class
```

---

# 14. Overriding Properties

Properties can also be overridden.

Example:

```kotlin
open class Animal {

    open val type = "Animal"
}

class Dog : Animal() {

    override val type = "Dog"
}
```

Usage:

```kotlin
val dog = Dog()

println(dog.type)
```

Output:

```text
Dog
```

---

# 15. `super` with Properties

Example:

```kotlin
open class Animal {

    open val type = "Animal"
}

class Dog : Animal() {

    override val type = "Dog"

    fun printTypes() {
        println(super.type)
        println(this.type)
    }
}
```

Output:

```text
Animal
Dog
```

Here:

```kotlin
super.type
```

refers to the parent's property.

And:

```kotlin
this.type
```

refers to the current object's property.

---

# 16. `final`

Kotlin classes and functions are final by default.

You can explicitly use `final` to prevent overriding.

Example:

```kotlin
open class Animal {

    final fun eat() {
        println("Animal is eating")
    }
}
```

A child cannot override `eat()`:

```kotlin
class Dog : Animal() {

    // ERROR
    // override fun eat() { }
}
```

---

# 17. Multi-Level Inheritance

Inheritance can have multiple levels.

Example:

```text
Animal
   |
   ↓
Mammal
   |
   ↓
Dog
```

Code:

```kotlin
open class Animal {

    fun eat() {
        println("Eating")
    }
}

open class Mammal : Animal() {

    fun breathe() {
        println("Breathing")
    }
}

class Dog : Mammal() {

    fun bark() {
        println("Barking")
    }
}
```

Now:

```kotlin
val dog = Dog()

dog.eat()
dog.breathe()
dog.bark()
```

Output:

```text
Eating
Breathing
Barking
```

`Dog` indirectly inherits `eat()` from `Animal`.

---

# 18. Example: Person → Student

Parent:

```kotlin
open class Person(
    val name: String,
    val age: Int
) {

    fun introduce() {
        println("Name: $name")
        println("Age: $age")
    }
}
```

Child:

```kotlin
class Student(
    name: String,
    age: Int,
    val university: String
) : Person(name, age) {

    fun study() {
        println("$name is studying")
    }
}
```

Usage:

```kotlin
val student = Student(
    "Mazharul",
    24,
    "HSTU"
)

student.introduce()
student.study()
```

Output:

```text
Name: Mazharul
Age: 24
Mazharul is studying
```

The Student has:

```text
Inherited:
    name
    age
    introduce()

Own:
    university
    study()
```

---

# 19. Inheritance and `is-a`

Inheritance represents an **is-a relationship**.

Examples:

```text
Dog is an Animal
Student is a Person
Car is a Vehicle
Manager is an Employee
```

Example:

```kotlin
class Dog : Animal()
```

This makes sense because:

```text
Dog is an Animal
```

---

# 20. Composition and `has-a`

Composition represents a **has-a relationship**.

Example:

```text
Student has an Address
Car has an Engine
Computer has a CPU
```

Example:

```kotlin
class Address(
    val city: String
)

class Student(
    val name: String,
    val address: Address
)
```

Usage:

```kotlin
val address = Address("Dhaka")

val student = Student(
    "Mazharul",
    address
)
```

Here:

```text
Student
   |
   └── has an Address
```

This is composition, not inheritance.

---

# 21. Inheritance vs Composition

| Inheritance | Composition |
|-------------|-------------|
| IS-A relationship | HAS-A relationship |
| Child inherits parent | Object contains another object |
| `:` is used | Property/reference is used |
| Dog → Animal | Student → Address |
| Car → Vehicle | Car → Engine |

Use inheritance when the relationship genuinely represents **is-a**.

---

# 22. Android Connection

Inheritance is heavily used in Android.

Example:

```kotlin
class MainActivity : AppCompatActivity()
```

Conceptually:

```text
AppCompatActivity
        ↑
        |
MainActivity
```

`MainActivity` inherits functionality from `AppCompatActivity`.

Another example:

```kotlin
class MainViewModel : ViewModel()
```

Conceptually:

```text
ViewModel
    ↑
    |
MainViewModel
```

This is why understanding inheritance is important before learning Android architecture components.

---

# 23. Complete Example

```kotlin
open class Vehicle(
    val brand: String,
    val speed: Int
) {

    open fun drive() {
        println("$brand is driving at $speed km/h")
    }
}

class Car(
    brand: String,
    speed: Int,
    val numberOfDoors: Int
) : Vehicle(brand, speed) {

    override fun drive() {
        super.drive()
        println("Car is driving")
    }

    fun showCarInfo() {
        println("Brand: $brand")
        println("Speed: $speed km/h")
        println("Doors: $numberOfDoors")
    }
}
```

Usage:

```kotlin
val car = Car(
    "Toyota",
    80,
    4
)

car.drive()
car.showCarInfo()
```

Output:

```text
Toyota is driving at 80 km/h
Car is driving
Brand: Toyota
Speed: 80 km/h
Doors: 4
```

---

# 24. Important Keywords

| Keyword | Meaning |
|---------|---------|
| `open` | Allows inheritance or overriding |
| `:` | Used for inheritance |
| `override` | Replaces parent implementation |
| `super` | Refers to parent |
| `this` | Refers to current object |
| `final` | Prevents inheritance/overriding |

---

# 25. Common Beginner Mistakes

## Mistake 1: Forgetting `open`

Incorrect:

```kotlin
class Animal

class Dog : Animal()
```

Correct:

```kotlin
open class Animal

class Dog : Animal()
```

---

## Mistake 2: Forgetting `open` on a function

Incorrect:

```kotlin
open class Animal {

    fun sound() {
        println("Animal")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog")
    }
}
```

Correct:

```kotlin
open class Animal {

    open fun sound() {
        println("Animal")
    }
}

class Dog : Animal() {

    override fun sound() {
        println("Dog")
    }
}
```

---

## Mistake 3: Confusing `this` and `super`

```kotlin
this.name
```

means:

```text
Current object
```

while:

```kotlin
super.name
```

means:

```text
Parent class
```

---

## Mistake 4: Using Inheritance for Everything

Not every relationship should use inheritance.

Ask:

```text
Is it an IS-A relationship?
```

If yes, inheritance might make sense.

If:

```text
HAS-A
```

composition is usually more appropriate.

---

# Practice

## Exercise 1 — Animal

Create:

```text
Animal
 ├── Dog
 └── Cat
```

Parent:

```kotlin
eat()
```

Dog:

```kotlin
bark()
```

Cat:

```kotlin
meow()
```

---

## Exercise 2 — Person and Student

Create:

```text
Person
   ↓
Student
```

Person:

```text
name
age
introduce()
```

Student:

```text
university
study()
```

Create a Student object and call both inherited and child functions.

---

## Exercise 3 — Vehicle and Car

Create:

```text
Vehicle
   ↓
Car
```

Vehicle:

```text
brand
speed
drive()
```

Car:

```text
numberOfDoors
showCarInfo()
```

Override `drive()`.

---

# Mini Challenge

Create:

```text
Employee
    ↓
Manager
```

### Employee

Properties:

```text
name
salary
```

Function:

```text
work()
```

### Manager

Property:

```text
teamSize
```

Override:

```text
work()
```

Use:

```kotlin
super.work()
```

inside the overridden function.

Expected output:

```text
Mazharul is working
Mazharul is managing 5 employees
```

---

# Quick Quiz

Try answering these without looking at the notes:

1. What is inheritance?
2. What does `:` mean in Kotlin?
3. Why is `open` needed?
4. What does `override` do?
5. What does `super` mean?
6. What is the difference between `this` and `super`?
7. What does `final` mean?
8. What is method overriding?
9. What is an `is-a` relationship?
10. What is a `has-a` relationship?
11. Why is `open` needed before a function that will be overridden?
12. Can a child class access a parent's properties?
13. How do you pass arguments to a parent constructor?
14. What is multi-level inheritance?

---

# Quick Revision

```text
Inheritance
│
├── Parent Class
│      ↓
│   open class
│
├── Child Class
│      ↓
│   class Child : Parent()
│
├── Override
│      ↓
│   override fun
│
├── Parent Access
│      ↓
│   super
│
├── Current Object
│      ↓
│   this
│
└── Prevent Override
       ↓
      final
```

---

# Key Takeaways

- Inheritance allows one class to acquire functionality from another class.
- The parent class is also called a superclass.
- The child class is also called a subclass.
- Kotlin classes are final by default.
- Use `open` to allow inheritance.
- Use `:` to inherit from a class.
- Use `open` on a function if it should be overridable.
- Use `override` to replace a parent's implementation.
- Use `super` to access the parent's implementation.
- Use `this` to refer to the current object.
- `final` prevents inheritance or overriding.
- Inheritance represents an **is-a** relationship.
- Composition represents a **has-a** relationship.
- Android uses inheritance extensively.

---

# Next Lesson

## Week 2 - Day 3: Polymorphism

Topics:

- What is Polymorphism?
- Runtime Polymorphism
- Parent references
- Method overriding
- Upcasting
- `is`
- `as`
- `as?`
- Smart casting
- Real Android examples