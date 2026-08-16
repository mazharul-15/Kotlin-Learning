# Kotlin Extension Functions

## 1. What Is an Extension Function?

An **extension function** allows us to add a new function to an existing class/type without modifying the original class.

For example, Kotlin already has the `String` class.

We can create our own function for `String`:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

Now every `String` can use this function:

```kotlin
"Mazharul".sayHello()
```

Output:

```text
Hello Mazharul
```

The important idea:

```text
Extension Function
        ↓
Adds functionality to an existing type
without modifying the original class
```

---

# 2. Why Do We Need Extension Functions?

Suppose we have:

```kotlin
val name = "Mazharul"
```

Without an extension function:

```kotlin
fun printName(name: String) {
    println("Name: $name")
}

printName(name)
```

With an extension function:

```kotlin
fun String.printName() {
    println("Name: $this")
}
```

Now we can write:

```kotlin
name.printName()
```

Comparison:

```text
Normal function:

printName(name)


Extension function:

name.printName()
```

The extension function can make code easier to read when the operation naturally belongs to the receiver type.

---

# 3. Basic Syntax

The basic syntax is:

```kotlin
fun Type.functionName() {
    // function body
}
```

Example:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

Here:

```text
fun
 ↓
String
 ↓
sayHello()
 ↓
function body
```

`String` is called the **receiver type**.

---

# 4. Receiver Type

In:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

this:

```kotlin
String
```

is the **receiver type**.

It tells Kotlin:

> `sayHello()` is an extension function for `String`.

Therefore:

```kotlin
"Mazharul".sayHello()
```

works.

---

# 5. Receiver Object

In:

```kotlin
"Mazharul".sayHello()
```

the object:

```text
"Mazharul"
```

is the **receiver object**.

Think of it as:

```text
"Mazharul"
      ↓
   receiver
      ↓
  sayHello()
```

---

# 6. What Is `this`?

Inside an extension function, `this` refers to the receiver object.

Example:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

When we call:

```kotlin
"Mazharul".sayHello()
```

then:

```text
this
 ↓
"Mazharul"
```

So:

```kotlin
println("Hello $this")
```

prints:

```text
Hello Mazharul
```

---

# 7. `this` Example

```kotlin
fun String.printLength() {
    println("Length: ${this.length}")
}
```

Call:

```kotlin
"Android".printLength()
```

Output:

```text
Length: 7
```

Here:

```text
this
 ↓
"Android"

this.length
 ↓
"Android".length
 ↓
7
```

---

# 8. `this` Can Often Be Omitted

Instead of:

```kotlin
fun String.printLength() {
    println(this.length)
}
```

we can write:

```kotlin
fun String.printLength() {
    println(length)
}
```

Both work.

Because members of the receiver are directly accessible inside the extension function.

When learning extension functions, using `this` can make the concept easier to understand.

---

# 9. Extension Function with Parameters

An extension function can have parameters.

Example:

```kotlin
fun String.repeatText(times: Int) {

    repeat(times) {
        println(this)
    }
}
```

Use:

```kotlin
"Hello".repeatText(3)
```

Output:

```text
Hello
Hello
Hello
```

Here:

```text
"Hello"
   ↓
receiver

3
↓
parameter
```

---

# 10. Extension Function with Return Value

An extension function can return a value.

Example:

```kotlin
fun String.firstCharacter(): Char {
    return this[0]
}
```

Use:

```kotlin
val result = "Kotlin".firstCharacter()

println(result)
```

Output:

```text
K
```

---

# 11. Extension Function on Int

We can create extensions for `Int`.

```kotlin
fun Int.square(): Int {
    return this * this
}
```

Use:

```kotlin
println(5.square())
```

Output:

```text
25
```

Here:

```text
5
↓
this

this * this
↓
5 * 5
↓
25
```

---

# 12. Another Int Example

```kotlin
fun Int.isEven(): Boolean {
    return this % 2 == 0
}
```

Use:

```kotlin
println(10.isEven())
println(7.isEven())
```

Output:

```text
true
false
```

---

# 13. Extension Function on Double

```kotlin
fun Double.toPercentage(): String {
    return "${this * 100}%"
}
```

Use:

```kotlin
println(0.75.toPercentage())
```

Output:

```text
75.0%
```

---

# 14. Extension Function on List

Extension functions are very useful with collections.

Example:

```kotlin
fun List<Int>.sumOfNumbers(): Int {

    var sum = 0

    for (number in this) {
        sum += number
    }

    return sum
}
```

Use:

```kotlin
val numbers = listOf(10, 20, 30)

println(numbers.sumOfNumbers())
```

Output:

```text
60
```

Here:

```text
numbers
   ↓
this
```

---

# 15. Extension Function on a Custom Class

Extension functions can be created for our own classes.

Example:

```kotlin
class Student(
    val name: String,
    val age: Int
)
```

Now create an extension:

```kotlin
fun Student.showInfo() {
    println("Name: $name")
    println("Age: $age")
}
```

Use:

```kotlin
val student = Student("Mazharul", 25)

student.showInfo()
```

Output:

```text
Name: Mazharul
Age: 25
```

We didn't modify the `Student` class.

---

# 16. Another Custom Class Extension

```kotlin
fun Student.isAdult(): Boolean {
    return age >= 18
}
```

Use:

```kotlin
val student = Student("Mazharul", 25)

println(student.isAdult())
```

Output:

```text
true
```

---

# 17. Extension Function vs Normal Function

Normal function:

```kotlin
fun showStudent(student: Student) {
    println(student.name)
}
```

Call:

```kotlin
showStudent(student)
```

Extension function:

```kotlin
fun Student.showStudent() {
    println(name)
}
```

Call:

```kotlin
student.showStudent()
```

Comparison:

```text
Normal function
→ showStudent(student)

Extension function
→ student.showStudent()
```

---

# 18. Extension Functions Do Not Modify the Original Class

Suppose:

```kotlin
class Student(
    val name: String
)
```

Then:

```kotlin
fun Student.sayHello() {
    println("Hello $name")
}
```

We did not change the original class.

The original class is still:

```kotlin
class Student(
    val name: String
)
```

The extension exists outside the class.

---

# 19. Important Concept

An extension function may look like it was added to the class:

```kotlin
student.showInfo()
```

But it is **not actually a member of the class**.

Think:

```text
Extension function
        ↓
Provides convenient syntax
        ↓
Does NOT modify the original class
```

---

# 20. Accessing Class Members

An extension function can access members that are accessible from outside the class.

Example:

```kotlin
class Student(
    val name: String
)
```

Extension:

```kotlin
fun Student.showName() {
    println(name)
}
```

This works because `name` is public.

---

# 21. Extension Functions and Private Members

Consider:

```kotlin
class Student(
    private val name: String
)
```

This extension:

```kotlin
fun Student.showName() {
    println(name)
}
```

will not work.

Why?

Because an extension function is not a member of the class.

It does not get special access to private members.

---

# 22. Nullable Extension Functions

Kotlin allows extension functions on nullable types.

Suppose:

```kotlin
val name: String? = null
```

We can create:

```kotlin
fun String?.printValue() {
    println(this)
}
```

Notice:

```kotlin
String?
```

instead of:

```kotlin
String
```

Now:

```kotlin
name.printValue()
```

works even when `name` is `null`.

Output:

```text
null
```

---

# 23. Non-Nullable vs Nullable Extension

Non-nullable:

```kotlin
fun String.printValue() {
    println(this)
}
```

This expects:

```text
String
```

Nullable:

```kotlin
fun String?.printValue() {
    println(this)
}
```

This accepts:

```text
String
String?
null
```

Example:

```kotlin
val name1: String = "Mazharul"
val name2: String? = null

name1.printValue()
name2.printValue()
```

---

# 24. Nullable Extension Example

```kotlin
fun String?.isNullOrEmptyText(): Boolean {
    return this == null || this.isEmpty()
}
```

Use:

```kotlin
val name: String? = null

println(name.isNullOrEmptyText())
```

Output:

```text
true
```

---

# 25. Extension Function and `let`

Kotlin's standard library contains many extension functions.

For example:

```kotlin
val name: String? = "Mazharul"

name?.let {
    println(it)
}
```

Functions such as:

```text
let
also
apply
run
with
```

are heavily used in Kotlin.

These will be studied separately later.

---

# 26. Extension Properties

Kotlin also supports **extension properties**.

Example:

```kotlin
val String.lastCharacter: Char
    get() = this[this.length - 1]
```

Use:

```kotlin
println("Kotlin".lastCharacter)
```

Output:

```text
n
```

This is an extension property, not an extension function.

For now, focus mainly on extension functions.

---

# 27. Member Function vs Extension Function

Member function:

```kotlin
class Student {

    fun study() {
        println("Student studying")
    }
}
```

The function is inside the class.

Extension function:

```kotlin
fun Student.play() {
    println("Student playing")
}
```

The function is outside the class.

Comparison:

```text
Member function
→ defined inside the class

Extension function
→ defined outside the class
→ called using the receiver object
```

---

# 28. Member Function Has Priority

Suppose:

```kotlin
class Student {

    fun show() {
        println("Member function")
    }
}
```

Then create an extension with the same name:

```kotlin
fun Student.show() {
    println("Extension function")
}
```

Call:

```kotlin
val student = Student()

student.show()
```

Output:

```text
Member function
```

The member function has priority over the extension function.

---

# 29. Extension Functions Are Not Overridden

Extension functions are resolved based on the **declared/static type** of the receiver.

Example:

```kotlin
open class Animal

class Dog : Animal()
```

Extensions:

```kotlin
fun Animal.sound() {
    println("Animal sound")
}

fun Dog.sound() {
    println("Dog sound")
}
```

Now:

```kotlin
val dog: Animal = Dog()

dog.sound()
```

Output:

```text
Animal sound
```

Why?

Because the declared type is:

```kotlin
Animal
```

Extension functions are statically resolved.

Remember:

```text
Extension functions
→ are NOT virtual member functions
→ are NOT overridden like normal member functions
```

This is an advanced concept. Understand the basic idea now; you don't need to memorize the implementation details.

---

# 30. Android Example — View

Extension functions are extremely useful in Android.

Suppose we frequently write:

```kotlin
view.visibility = View.VISIBLE
```

and:

```kotlin
view.visibility = View.GONE
```

We can create:

```kotlin
fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
```

Now:

```kotlin
binding.progressBar.show()
```

and:

```kotlin
binding.progressBar.hide()
```

This makes Android code cleaner.

---

# 31. Android Example — Context

We can create an extension function for `Context`:

```kotlin
fun Context.showToast(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}
```

Then inside an Activity:

```kotlin
showToast("Login successful")
```

An Activity is a `Context`, so the extension can be used.

---

# 32. Android Example — EditText

Suppose you repeatedly write:

```kotlin
binding.etEmail.text.toString().trim()
```

We can create:

```kotlin
fun EditText.getTextValue(): String {
    return text.toString().trim()
}
```

Then:

```kotlin
val email = binding.etEmail.getTextValue()
```

This reduces repetitive code.

---

# 33. Android Example — View Visibility

A useful set of extensions:

```kotlin
fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.isVisibleNow(): Boolean {
    return visibility == View.VISIBLE
}
```

Usage:

```kotlin
binding.progressBar.show()

binding.progressBar.hide()

println(binding.progressBar.isVisibleNow())
```

---

# 34. Why Extension Functions Are Important in Android

You will frequently see extension functions for:

```text
View
Context
Activity
Fragment
EditText
TextView
String
List
```

They help reduce repeated code and make APIs easier to use.

Example:

```kotlin
binding.progressBar.show()
```

is easier to read than repeatedly writing:

```kotlin
binding.progressBar.visibility = View.VISIBLE
```

---

# 35. Extension Function Syntax Summary

### Basic

```kotlin
fun Type.functionName() {
}
```

### With parameter

```kotlin
fun Type.functionName(
    parameter: ParameterType
) {
}
```

### With return value

```kotlin
fun Type.functionName(): ReturnType {
    return value
}
```

### Nullable receiver

```kotlin
fun Type?.functionName() {
}
```

---

# 36. Complete Example

```kotlin
class Student(
    val name: String,
    val age: Int
)

fun Student.showInfo() {
    println("Name: $name")
    println("Age: $age")
}

fun Student.isAdult(): Boolean {
    return age >= 18
}

fun main() {

    val student = Student(
        name = "Mazharul",
        age = 25
    )

    student.showInfo()

    println(student.isAdult())
}
```

Output:

```text
Name: Mazharul
Age: 25
true
```

The `Student` class itself does not contain:

```kotlin
showInfo()
```

or:

```kotlin
isAdult()
```

They are extension functions.

---

# 37. Practice Task 1 — String

Create:

```kotlin
fun String.reverseText(): String
```

Example:

```kotlin
println("Kotlin".reverseText())
```

Expected:

```text
niltoK
```

Hint:

```kotlin
return this.reversed()
```

---

# 38. Practice Task 2 — Int

Create:

```kotlin
fun Int.isEven(): Boolean
```

Test:

```kotlin
println(10.isEven())
println(7.isEven())
```

Expected:

```text
true
false
```

---

# 39. Practice Task 3 — Student

Create:

```kotlin
class Student(
    val name: String,
    val age: Int
)
```

Then create:

```kotlin
fun Student.showInfo()
```

Expected:

```text
Name: Mazharul
Age: 25
```

---

# 40. Practice Task 4 — Student Adult Check

Create:

```kotlin
fun Student.isAdult(): Boolean
```

Rules:

```text
age >= 18 → true
age < 18  → false
```

Test:

```kotlin
val student1 = Student("Mazharul", 25)
val student2 = Student("Rahim", 15)

println(student1.isAdult())
println(student2.isAdult())
```

Expected:

```text
true
false
```

---

# 41. Practice Task 5 — Nullable String

Create:

```kotlin
fun String?.printOrDefault()
```

If the String is `null`, print:

```text
No value
```

Otherwise print the String.

Test:

```kotlin
val name1: String? = "Mazharul"
val name2: String? = null

name1.printOrDefault()
name2.printOrDefault()
```

Expected:

```text
Mazharul
No value
```

---

# 42. Quick Quiz

Try answering these without looking at the notes:

1. What is an extension function?
2. Why do we use extension functions?
3. What is the receiver type?
4. What is the receiver object?
5. What does `this` mean inside an extension function?
6. Can an extension function have parameters?
7. Can an extension function return a value?
8. Can we create extensions for our own classes?
9. Can we create extensions for nullable types?
10. Does an extension function actually modify the original class?
11. Which has priority: a member function or an extension function with the same name?
12. Are extension functions overridden like member functions?
13. Give one Android example of an extension function.

---

# 43. Quick Revision

Basic extension:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

Usage:

```kotlin
"Mazharul".sayHello()
```

Extension with return value:

```kotlin
fun Int.square(): Int {
    return this * this
}
```

Usage:

```kotlin
println(5.square())
```

Extension for a custom class:

```kotlin
fun Student.showInfo() {
    println(name)
}
```

Usage:

```kotlin
student.showInfo()
```

Nullable extension:

```kotlin
fun String?.printValue() {
    println(this)
}
```

Android extension:

```kotlin
fun View.show() {
    visibility = View.VISIBLE
}
```

---

# 44. The Most Important Mental Model

When you see:

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

think:

```text
String
   ↓
receiver type

"Mazharul"
   ↓
receiver object

.sayHello()
   ↓
extension function
```

So:

```kotlin
"Mazharul".sayHello()
```

means:

```text
Take this String
       ↓
call sayHello()
       ↓
inside the function, `this`
refers to that String
```

---

# 45. Final Summary

## Extension Function

An extension function lets us define a function for an existing type without changing the original class.

```kotlin
fun String.sayHello() {
    println("Hello $this")
}
```

Call:

```kotlin
"Mazharul".sayHello()
```

---

## Receiver Type

The type before the function name:

```kotlin
fun String.sayHello()
    ↑
receiver type
```

---

## Receiver Object

The object calling the extension:

```kotlin
"Mazharul".sayHello()
 ↑
receiver object
```

---

## `this`

Inside the extension function:

```kotlin
fun String.sayHello() {
    println(this)
}
```

`this` refers to the receiver object.

---

## Important Rules

```text
Extension functions:

✓ Can have parameters
✓ Can return values
✓ Can be created for Kotlin classes
✓ Can be created for custom classes
✓ Can have nullable receivers
✓ Do not modify the original class
✓ Do not get special access to private members
✓ Member functions have priority
✓ Are statically resolved
```

---

# 46. One Final Example

```kotlin
class Student(
    val name: String,
    val age: Int
)

fun Student.showInfo() {
    println("Name: $name")
    println("Age: $age")
}

fun Student.isAdult(): Boolean {
    return age >= 18
}

fun main() {

    val student = Student(
        name = "Mazharul",
        age = 25
    )

    student.showInfo()

    if (student.isAdult()) {
        println("Adult student")
    }
}
```

Output:

```text
Name: Mazharul
Age: 25
Adult student
```

The key idea to remember:

```text
Extension Function
        ↓
fun Type.functionName()
        ↓
Allows us to call our function
using an object of that Type
        ↓
without modifying the original class
```