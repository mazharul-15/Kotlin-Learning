# Abstraction in Kotlin

## 1. What is Abstraction?

Abstraction is one of the four major concepts of Object-Oriented Programming (OOP).

The four major OOP concepts are:

```text
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction
```

### Definition

> Abstraction means hiding unnecessary implementation details and exposing only the essential functionality.

In simple words:

```text
Hide HOW it works
        +
Show WHAT it does
```

For example, when you use an ATM:

```text
You
 ↓
ATM buttons
 ↓
Withdraw money
```

You don't need to know:

```text
How the bank verifies your account
How the database works
How the transaction is processed
How the bank communicates with the ATM
```

You only need to know:

```text
Withdraw
Deposit
Check Balance
```

That is abstraction.

---

# 2. Real-World Example

Consider a car.

You use:

```text
Steering wheel
Brake
Accelerator
Gear
```

You don't need to understand:

```text
Engine combustion
Fuel injection
Transmission mechanism
Engine control system
```

The car hides these implementation details.

You interact with a simple interface:

```text
Drive
Brake
Accelerate
```

Conceptually:

```text
You
 ↓
Simple controls
 ↓
Hidden complex implementation
```

This is abstraction.

---

# 3. Why Do We Need Abstraction?

Without abstraction, users of a class may need to understand too many implementation details.

For example:

```text
Payment
 ↓
Bank API
 ↓
Authentication
 ↓
Encryption
 ↓
Database
 ↓
Transaction
```

A developer using a payment system shouldn't need to understand every internal step.

Instead, they might simply call:

```kotlin
payment.pay()
```

The complicated implementation stays hidden.

Abstraction helps us:

- Reduce complexity
- Hide implementation details
- Focus on important behavior
- Make code easier to use
- Make large systems easier to maintain
- Define clear contracts

---

# 4. Abstraction in Kotlin

Kotlin mainly provides two important mechanisms for abstraction:

```text
1. Abstract class
2. Interface
```

We will learn both.

---

# 5. Abstract Class

Kotlin provides:

```kotlin
abstract class
```

for creating abstract classes.

Example:

```kotlin
abstract class Animal {

    abstract fun sound()
}
```

Here:

```kotlin
abstract fun sound()
```

doesn't have an implementation.

It says:

> Every concrete animal must provide its own implementation of `sound()`.

---

# 6. Abstract Function

An abstract function has no body.

Example:

```kotlin
abstract class Animal {

    abstract fun sound()
}
```

Notice:

```kotlin
abstract fun sound()
```

There is no:

```kotlin
{
    println(...)
}
```

The child class must implement it.

---

# 7. Implementing an Abstract Function

Create a child class:

```kotlin
class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}
```

Another child:

```kotlin
class Cat : Animal() {

    override fun sound() {
        println("Cat meows")
    }
}
```

Now:

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

The parent class defines:

```text
WHAT should happen
```

The child class defines:

```text
HOW it happens
```

This is abstraction.

---

# 8. Abstract Class Cannot Be Instantiated

You cannot create an object directly from an abstract class.

This is invalid:

```kotlin
abstract class Animal {

    abstract fun sound()
}

val animal = Animal()
```

Why?

Because `Animal` is incomplete.

It contains:

```kotlin
abstract fun sound()
```

but doesn't provide its implementation.

Instead, create a concrete child:

```kotlin
class Dog : Animal() {

    override fun sound() {
        println("Dog barks")
    }
}

val dog = Dog()
```

---

# 9. Why Can't We Create an Abstract Object?

Think of an abstract class as a blueprint that is incomplete.

For example:

```text
Animal
```

doesn't tell us exactly what sound every animal makes.

A:

```text
Dog → barks
Cat → meows
Cow → moos
```

Therefore:

```text
Animal
```

defines the common concept, while child classes provide the specific behavior.

---

# 10. Abstract Class Can Have Normal Functions

An abstract class doesn't have to contain only abstract functions.

Example:

```kotlin
abstract class Animal {

    abstract fun sound()

    fun eat() {
        println("Animal is eating")
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
dog.eat()
```

Output:

```text
Dog barks
Animal is eating
```

So an abstract class can contain both:

```text
Abstract members
+
Normal members
```

---

# 11. Abstract Class Can Have Properties

Example:

```kotlin
abstract class Animal {

    val category = "Animal"

    abstract val name: String

    abstract fun sound()
}
```

Child:

```kotlin
class Dog : Animal() {

    override val name = "Tommy"

    override fun sound() {
        println("Dog barks")
    }
}
```

Usage:

```kotlin
val dog = Dog()

println(dog.category)
println(dog.name)

dog.sound()
```

Output:

```text
Animal
Tommy
Dog barks
```

---

# 12. Abstract Property

An abstract property is declared without an implementation.

Example:

```kotlin
abstract class Animal {

    abstract val name: String
}
```

A child class must provide it:

```kotlin
class Dog : Animal() {

    override val name = "Tommy"
}
```

The parent says:

```text
Every Animal must have a name.
```

The child provides the actual value.

---

# 13. Abstract Class with Constructor

An abstract class can have a constructor.

Example:

```kotlin
abstract class Animal(
    val name: String
) {

    abstract fun sound()
}
```

Child:

```kotlin
class Dog(
    name: String
) : Animal(name) {

    override fun sound() {
        println("$name barks")
    }
}
```

Usage:

```kotlin
val dog = Dog("Tommy")

dog.sound()
```

Output:

```text
Tommy barks
```

---

# 14. Abstract Class with Common Behavior

Abstract classes are useful when multiple classes share some common data or behavior.

Example:

```kotlin
abstract class Employee(
    val name: String
) {

    fun login() {
        println("$name logged in")
    }

    abstract fun work()
}
```

Developer:

```kotlin
class Developer(
    name: String
) : Employee(name) {

    override fun work() {
        println("$name is writing code")
    }
}
```

Designer:

```kotlin
class Designer(
    name: String
) : Employee(name) {

    override fun work() {
        println("$name is designing UI")
    }
}
```

Usage:

```kotlin
val developer = Developer("Mazharul")
val designer = Designer("Rahim")

developer.login()
developer.work()

designer.login()
designer.work()
```

Output:

```text
Mazharul logged in
Mazharul is writing code

Rahim logged in
Rahim is designing UI
```

The common behavior:

```text
login()
```

is defined in the abstract parent.

The specific behavior:

```text
work()
```

is defined by each child.

---

# 15. Abstraction + Polymorphism

Abstraction and polymorphism often work together.

Example:

```kotlin
abstract class Animal {

    abstract fun sound()
}
```

Children:

```kotlin
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
val animals: List<Animal> = listOf(
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
```

Here:

```text
Abstraction
    ↓
Animal defines sound()

Polymorphism
    ↓
Dog and Cat provide different sound()
```

---

# 16. Interface

The second major way to achieve abstraction in Kotlin is:

```kotlin
interface
```

An interface defines a contract.

Example:

```kotlin
interface Printable {

    fun printInfo()
}
```

A class implements it:

```kotlin
class Student : Printable {

    override fun printInfo() {
        println("Student information")
    }
}
```

Usage:

```kotlin
val student = Student()

student.printInfo()
```

---

# 17. Interface as a Contract

Think of an interface as a promise.

Example:

```kotlin
interface Flyable {

    fun fly()
}
```

This means:

> Any class that implements `Flyable` must provide `fly()`.

Example:

```kotlin
class Bird : Flyable {

    override fun fly() {
        println("Bird is flying")
    }
}
```

The interface defines:

```text
WHAT the class must provide
```

The class defines:

```text
HOW it works
```

---

# 18. Multiple Interfaces

A Kotlin class can implement multiple interfaces.

Example:

```kotlin
interface Flyable {

    fun fly()
}

interface Swimmable {

    fun swim()
}
```

A class can implement both:

```kotlin
class Duck : Flyable, Swimmable {

    override fun fly() {
        println("Duck is flying")
    }

    override fun swim() {
        println("Duck is swimming")
    }
}
```

Usage:

```kotlin
val duck = Duck()

duck.fly()
duck.swim()
```

Output:

```text
Duck is flying
Duck is swimming
```

This is one reason interfaces are very useful.

---

# 19. Why Use Interfaces?

Suppose:

```text
Bird
Duck
Airplane
Drone
```

All of these can fly, but they are not necessarily related through inheritance.

Instead, define:

```kotlin
interface Flyable {

    fun fly()
}
```

Then:

```kotlin
class Bird : Flyable {

    override fun fly() {
        println("Bird flies")
    }
}
```

```kotlin
class Airplane : Flyable {

    override fun fly() {
        println("Airplane flies")
    }
}
```

Now both have the capability:

```text
Flyable
```

The interface represents:

```text
"What can this object do?"
```

---

# 20. Interface Can Have Implementation

Kotlin interfaces can contain functions with implementations.

Example:

```kotlin
interface Printable {

    fun printInfo()

    fun showMessage() {
        println("This is a printable object")
    }
}
```

A class can implement only the required function:

```kotlin
class Student : Printable {

    override fun printInfo() {
        println("Student information")
    }
}
```

Usage:

```kotlin
val student = Student()

student.printInfo()
student.showMessage()
```

Output:

```text
Student information
This is a printable object
```

---

# 21. Interface Properties

Interfaces can define properties.

Example:

```kotlin
interface Person {

    val name: String
}
```

A class must provide the property:

```kotlin
class Student : Person {

    override val name = "Mazharul"
}
```

---

# 22. Abstract Class vs Interface

This is an important interview and Android concept.

| Abstract Class | Interface |
|---|---|
| `abstract class` | `interface` |
| Can have constructor | Cannot have a normal constructor |
| Can have state | Cannot have backing fields for stored state |
| Can have normal functions | Can have function implementations |
| Can have abstract functions | Can have abstract-like functions |
| A class can inherit only one class | A class can implement multiple interfaces |
| Usually represents a common base | Usually represents a contract/capability |

---

# 23. Simple Way to Remember

Ask:

```text
"What are you?"
```

If the answer represents a common base:

```text
Dog is an Animal
Developer is an Employee
Student is a Person
```

An abstract class may be appropriate.

Ask:

```text
"What can you do?"
```

If the answer represents a capability:

```text
Bird can Fly
Duck can Swim
Student can Print
```

An interface may be appropriate.

Remember:

```text
Abstract Class
→ What are you?

Interface
→ What can you do?
```

---

# 24. Abstract Class Example

```kotlin
abstract class Vehicle {

    abstract fun start()

    fun stop() {
        println("Vehicle stopped")
    }
}
```

Car:

```kotlin
class Car : Vehicle() {

    override fun start() {
        println("Car started")
    }
}
```

Bike:

```kotlin
class Bike : Vehicle() {

    override fun start() {
        println("Bike started")
    }
}
```

Usage:

```kotlin
val car = Car()
val bike = Bike()

car.start()
car.stop()

bike.start()
bike.stop()
```

Output:

```text
Car started
Vehicle stopped
Bike started
Vehicle stopped
```

---

# 25. Interface Example

```kotlin
interface Startable {

    fun start()
}
```

Car:

```kotlin
class Car : Startable {

    override fun start() {
        println("Car started")
    }
}
```

Bike:

```kotlin
class Bike : Startable {

    override fun start() {
        println("Bike started")
    }
}
```

Now both can be treated as:

```kotlin
Startable
```

Example:

```kotlin
val vehicles: List<Startable> = listOf(
    Car(),
    Bike()
)

for (vehicle in vehicles) {
    vehicle.start()
}
```

Output:

```text
Car started
Bike started
```

---

# 26. Multiple Interfaces + Abstract Class

Kotlin allows a class to inherit one class and implement multiple interfaces.

Example:

```kotlin
abstract class Animal {

    abstract fun eat()
}

interface Flyable {

    fun fly()
}

interface Swimmable {

    fun swim()
}
```

A class can do:

```kotlin
class Duck : Animal(), Flyable, Swimmable {

    override fun eat() {
        println("Duck is eating")
    }

    override fun fly() {
        println("Duck is flying")
    }

    override fun swim() {
        println("Duck is swimming")
    }
}
```

This is valid.

Conceptually:

```text
             Animal
                |
              Duck
             /    \
        Flyable  Swimmable
```

---

# 27. Abstraction in Android

Abstraction is everywhere in Android.

You frequently use APIs without knowing their complete internal implementation.

For example:

```text
Activity
ViewModel
RecyclerView
Room
Retrofit
Repository
StateFlow
```

You use their public APIs while the complicated implementation remains hidden.

---

# 28. Android Example: Repository

Imagine:

```kotlin
interface UserRepository {

    fun getUsers(): List<String>
}
```

Implementation:

```kotlin
class UserRepositoryImpl : UserRepository {

    override fun getUsers(): List<String> {
        // Complex database/API logic
        return listOf("Mazharul", "Rahim")
    }
}
```

The ViewModel doesn't need to know how users are obtained.

It only knows:

```kotlin
repository.getUsers()
```

Conceptually:

```text
ViewModel
    ↓
UserRepository
    ↓
Hidden implementation
    ├── API
    ├── Database
    └── Cache
```

This is abstraction.

---

# 29. Android Example: Interface Callback

Interfaces are commonly used for callbacks.

Example:

```kotlin
interface OnStudentClickListener {

    fun onStudentClick(studentId: Int)
}
```

A class can implement it:

```kotlin
class StudentActivity : OnStudentClickListener {

    override fun onStudentClick(studentId: Int) {
        println("Student clicked: $studentId")
    }
}
```

The component generating the event only needs to know:

```text
OnStudentClickListener
```

It doesn't need to know exactly what the Activity will do.

This is abstraction.

---

# 30. Encapsulation vs Abstraction

These two concepts are related but different.

## Encapsulation

Focus:

```text
Protect and control data
```

Example:

```kotlin
private var balance = 0.0
```

or:

```kotlin
var balance = 0.0
    private set
```

Question:

> How do I control access to my data?

---

## Abstraction

Focus:

```text
Hide implementation complexity
```

Example:

```kotlin
interface Payment {

    fun pay()
}
```

Question:

> What does the user need to know, and what can remain hidden?

---

# 31. Easy Difference

Remember:

```text
Encapsulation
→ Protect data

Abstraction
→ Hide complexity
```

Example:

```text
BankAccount
│
├── private balance
│       ↓
│   Encapsulation
│
└── withdraw()
        ↓
   User doesn't need to know
   the internal calculation
        ↓
    Abstraction
```

---

# 32. Abstract Class vs Normal Class

Normal class:

```kotlin
class Dog {

    fun sound() {
        println("Bark")
    }
}
```

You can create:

```kotlin
val dog = Dog()
```

Abstract class:

```kotlin
abstract class Animal {

    abstract fun sound()
}
```

You cannot create:

```kotlin
val animal = Animal()
```

You need a concrete child:

```kotlin
class Dog : Animal() {

    override fun sound() {
        println("Bark")
    }
}

val dog = Dog()
```

---

# 33. Abstract Function Rules

If a parent contains:

```kotlin
abstract fun sound()
```

a concrete child must implement it:

```kotlin
override fun sound() {
    println("Bark")
}
```

You cannot forget:

```kotlin
override
```

---

# 34. Abstract Property Rules

If the parent contains:

```kotlin
abstract class Animal {

    abstract val name: String
}
```

the child must provide it:

```kotlin
class Dog : Animal() {

    override val name = "Tommy"
}
```

---

# 35. Can an Abstract Class Have Normal Properties?

Yes.

Example:

```kotlin
abstract class Animal {

    val category = "Animal"

    abstract val name: String
}
```

The child only needs to implement:

```kotlin
name
```

because `category` already has an implementation.

---

# 36. Can an Abstract Class Have a Constructor?

Yes.

Example:

```kotlin
abstract class Employee(
    val name: String
) {

    abstract fun work()
}
```

Child:

```kotlin
class Developer(
    name: String
) : Employee(name) {

    override fun work() {
        println("$name is coding")
    }
}
```

Usage:

```kotlin
val developer = Developer("Mazharul")
```

---

# 37. Can an Interface Have a Constructor?

No.

You cannot write:

```kotlin
interface Person(
    val name: String
)
```

Instead:

```kotlin
interface Person {

    val name: String
}
```

Then the implementing class provides the property:

```kotlin
class Student(
    override val name: String
) : Person
```

---

# 38. Common Beginner Mistakes

## Mistake 1 — Trying to Instantiate an Abstract Class

Wrong:

```kotlin
val animal = Animal()
```

if:

```kotlin
abstract class Animal
```

Correct:

```kotlin
val dog = Dog()
```

---

## Mistake 2 — Forgetting `override`

Parent:

```kotlin
abstract fun sound()
```

Child must have:

```kotlin
override fun sound() {
    ...
}
```

---

## Mistake 3 — Thinking Abstract Means Everything Is Abstract

This is valid:

```kotlin
abstract class Animal {

    abstract fun sound()

    fun eat() {
        println("Eating")
    }
}
```

An abstract class can have both abstract and concrete members.

---

## Mistake 4 — Confusing Interface with Abstract Class

Remember:

```text
Abstract class
→ Common base

Interface
→ Contract/capability
```

---

# 39. Practice Exercise 1 — Shape

Create:

```kotlin
abstract class Shape {

    abstract fun calculateArea(): Double
}
```

Create:

```text
Circle
Rectangle
```

Circle:

```kotlin
class Circle(
    private val radius: Double
) : Shape() {

    override fun calculateArea(): Double {
        return 3.1416 * radius * radius
    }
}
```

Rectangle:

```kotlin
class Rectangle(
    private val width: Double,
    private val height: Double
) : Shape() {

    override fun calculateArea(): Double {
        return width * height
    }
}
```

Then:

```kotlin
val shapes: List<Shape> = listOf(
    Circle(5.0),
    Rectangle(10.0, 5.0)
)
```

Calculate each area.

---

# 40. Practice Exercise 2 — Payment Interface

Create:

```kotlin
interface Payment {

    fun pay(amount: Double)
}
```

Create:

```text
BkashPayment
CardPayment
```

Each should implement:

```kotlin
pay()
```

Example output:

```text
Paid 1000.0 using bKash
Paid 2000.0 using Card
```

Then:

```kotlin
val payments: List<Payment> = listOf(
    BkashPayment(),
    CardPayment()
)
```

Process them using:

```kotlin
for (payment in payments) {
    payment.pay(1000.0)
}
```

---

# 41. Practice Exercise 3 — Employee

Create:

```kotlin
abstract class Employee(
    val name: String
) {

    abstract fun work()
}
```

Create:

```text
Developer
Designer
```

Developer:

```text
Mazharul is writing code
```

Designer:

```text
Rahim is designing UI
```

Then:

```kotlin
val employees: List<Employee> = listOf(
    Developer("Mazharul"),
    Designer("Rahim")
)
```

Call:

```kotlin
employee.work()
```

for each employee.

---

# 42. Mini Challenge

Create a simple notification system.

Structure:

```text
Notification
    |
    +---- EmailNotification
    |
    +---- SmsNotification
    |
    +---- PushNotification
```

Create:

```kotlin
abstract class Notification {

    abstract fun send(message: String)
}
```

Each child should implement `send()` differently.

Expected:

```text
Email sent: Hello
SMS sent: Hello
Push notification sent: Hello
```

Then:

```kotlin
val notifications: List<Notification> = listOf(
    EmailNotification(),
    SmsNotification(),
    PushNotification()
)
```

Call:

```kotlin
for (notification in notifications) {
    notification.send("Hello")
}
```

---

# 43. Quick Quiz

Try answering without looking back.

1. What is abstraction?
2. Why do we need abstraction?
3. What is an abstract class?
4. Can we create an object of an abstract class?
5. What is an abstract function?
6. Can an abstract class have normal functions?
7. Can an abstract class have properties?
8. Can an abstract class have a constructor?
9. What is an interface?
10. Why do we use interfaces?
11. Can a class implement multiple interfaces?
12. Can an interface have function implementations in Kotlin?
13. What is the difference between an abstract class and an interface?
14. What is the difference between abstraction and encapsulation?
15. Why is abstraction useful in Android development?

---

# 44. Quick Revision

```text
ABSTRACTION
│
├── Hide implementation details
│
├── Show essential behavior
│
├── Abstract Class
│     ├── abstract fun
│     ├── abstract val
│     ├── normal fun
│     ├── normal val
│     └── constructor
│
└── Interface
      ├── contract
      ├── functions
      ├── properties
      └── multiple interfaces
```

---

# 45. Most Important Concepts

Remember these:

### Abstraction

```text
Hide HOW
Show WHAT
```

### Abstract Class

```kotlin
abstract class Animal {

    abstract fun sound()
}
```

### Child Implementation

```kotlin
class Dog : Animal() {

    override fun sound() {
        println("Bark")
    }
}
```

### Interface

```kotlin
interface Flyable {

    fun fly()
}
```

### Multiple Interfaces

```kotlin
class Duck : Flyable, Swimmable
```

### Abstract Class vs Interface

```text
Abstract class
→ What are you?

Interface
→ What can you do?
```

---

# 46. OOP Concepts Together

You have now learned the four major OOP concepts:

```text
                 OOP
                  |
        +---------+---------+
        |         |         |
        ↓         ↓         ↓
 Encapsulation  Inheritance  Polymorphism
        |
        ↓
   Abstraction
```

More clearly:

```text
Encapsulation
→ Protect data

Inheritance
→ Reuse parent behavior

Polymorphism
→ One type, many forms

Abstraction
→ Hide implementation complexity
```

These four concepts are fundamental to Kotlin and Android development.

---

# Summary

Abstraction means:

> Hiding unnecessary implementation details and exposing only the essential functionality.

Kotlin provides two major tools for abstraction:

```text
1. Abstract class
2. Interface
```

An abstract class can contain:

```text
Abstract properties
Abstract functions
Normal properties
Normal functions
Constructor
```

An interface can define:

```text
Functions
Properties
Default implementations
```

A class can inherit only one class but can implement multiple interfaces.

The most important mental model is:

```text
Abstract class
→ What are you?

Interface
→ What can you do?
```

And the most important abstraction principle is:

```text
The user should know WHAT to use,
not necessarily HOW it works internally.
```

---

# Next Kotlin Topic

After completing the OOP foundation, continue with:

```text
Collections
    ↓
List
MutableList
Set
MutableSet
Map
MutableMap
Collection operations
```

These are extremely important for Android development.