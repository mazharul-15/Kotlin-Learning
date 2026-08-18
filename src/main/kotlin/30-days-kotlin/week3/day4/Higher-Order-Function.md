# Kotlin Higher-Order Functions

## 1. What Is a Higher-Order Function?

A **Higher-Order Function** is a function that does at least one of these:

1. Accepts another function as a parameter.
2. Returns another function.

Example:

```kotlin
fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
}
```

Here:

```kotlin
operation: (Int, Int) -> Int
```

is a function parameter.

Therefore, `calculate()` is a Higher-Order Function.

---

# 2. Why Are Collection Functions Higher-Order Functions?

Example:

```kotlin
val numbers = listOf(1, 2, 3, 4, 5)

numbers.forEach {
    println(it)
}
```

`forEach` receives a lambda:

```kotlin
{
    println(it)
}
```

Therefore, `forEach` is a Higher-Order Function.

The same is true for:

```kotlin
map
filter
find
any
all
none
```

and many other Kotlin collection functions.

---

# 3. The Basic Mental Model

Think of collection processing like this:

```text
Collection
    ↓
Higher-Order Function
    ↓
Lambda
    ↓
Process items
```

Example:

```kotlin
numbers.filter {
    it % 2 == 0
}
```

Flow:

```text
numbers
   ↓
filter
   ↓
check each item
   ↓
keep matching items
```

---

# 4. `forEach`

`forEach` performs an action for every element.

```kotlin
val numbers = listOf(10, 20, 30)

numbers.forEach {
    println(it)
}
```

Output:

```text
10
20
30
```

`it` represents the current element.

---

# 5. `forEach` With a Named Parameter

Instead of:

```kotlin
numbers.forEach {
    println(it)
}
```

You can write:

```kotlin
numbers.forEach { number ->
    println(number)
}
```

Both are equivalent.

Use a meaningful name when the lambda becomes more complicated.

---

# 6. `forEachIndexed`

Use `forEachIndexed` when you need both the index and the value.

```kotlin
val names = listOf("Rahim", "Karim", "Mazharul")

names.forEachIndexed { index, name ->
    println("$index: $name")
}
```

Output:

```text
0: Rahim
1: Karim
2: Mazharul
```

---

# 7. `map`

`map` transforms every element and returns a new collection.

```kotlin
val numbers = listOf(1, 2, 3, 4)

val squares = numbers.map {
    it * it
}
```

Result:

```text
[1, 4, 9, 16]
```

Think:

```text
1 → 1
2 → 4
3 → 9
4 → 16
```

---

# 8. `map` With Strings

```kotlin
val names = listOf(
    "rahim",
    "karim",
    "mazharul"
)

val upperNames = names.map {
    it.uppercase()
}
```

Result:

```text
[RAHIM, KARIM, MAZHARUL]
```

---

# 9. `map` Does Not Modify the Original List

```kotlin
val numbers = listOf(1, 2, 3)

val doubled = numbers.map {
    it * 2
}

println(numbers)
println(doubled)
```

Output:

```text
[1, 2, 3]
[2, 4, 6]
```

The original list remains unchanged.

---

# 10. `filter`

`filter` keeps elements that satisfy a condition.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

val evenNumbers = numbers.filter {
    it % 2 == 0
}
```

Result:

```text
[2, 4, 6]
```

Think:

```text
1 → false → remove
2 → true  → keep
3 → false → remove
4 → true  → keep
5 → false → remove
6 → true  → keep
```

---

# 11. `filter` With Objects

Example:

```kotlin
data class Student(
    val name: String,
    val age: Int
)

val students = listOf(
    Student("Rahim", 17),
    Student("Karim", 20),
    Student("Mazharul", 25)
)
```

Get adult students:

```kotlin
val adults = students.filter {
    it.age >= 18
}
```

Result:

```text
Karim
Mazharul
```

This is very important in Android because Android applications frequently process lists of objects.

---

# 12. `find`

`find` returns the **first element** that matches a condition.

```kotlin
val numbers = listOf(10, 20, 30, 40)

val result = numbers.find {
    it > 20
}
```

Result:

```text
30
```

Processing:

```text
10 → false
20 → false
30 → true → STOP
```

The function returns the first matching element.

---

# 13. `find` Can Return `null`

If no element matches:

```kotlin
val result = numbers.find {
    it > 100
}
```

Result:

```text
null
```

Therefore, the return type of `find()` is nullable.

Example:

```kotlin
val result: Int? = numbers.find {
    it > 100
}
```

This connects directly with Kotlin null safety.

---

# 14. `first`

`first()` returns the first element.

```kotlin
val numbers = listOf(10, 20, 30)

println(numbers.first())
```

Output:

```text
10
```

It can also accept a condition:

```kotlin
val result = numbers.first {
    it > 15
}
```

Result:

```text
20
```

If no matching element exists, `first()` can throw an exception.

---

# 15. `firstOrNull`

`firstOrNull()` safely returns the first element or `null`.

```kotlin
val numbers = listOf(10, 20, 30)

val result = numbers.firstOrNull {
    it > 100
}
```

Result:

```text
null
```

Unlike `first()`, it does not throw an exception when there is no matching element.

---

# 16. `find` vs `filter`

### `find`

Returns one matching element:

```kotlin
val student = students.find {
    it.age >= 18
}
```

Return:

```text
Student?
```

### `filter`

Returns all matching elements:

```kotlin
val adults = students.filter {
    it.age >= 18
}
```

Return:

```text
List<Student>
```

Remember:

```text
find
→ first matching item

filter
→ all matching items
```

---

# 17. `first` vs `firstOrNull`

```kotlin
numbers.first()
```

If no element exists, it can throw an exception.

```kotlin
numbers.firstOrNull()
```

If no element exists:

```text
null
```

When you are unsure whether an element exists, `firstOrNull()` is usually safer.

---

# 18. `last`

`last()` returns the last element.

```kotlin
val numbers = listOf(10, 20, 30)

println(numbers.last())
```

Output:

```text
30
```

It can also accept a condition:

```kotlin
val result = numbers.last {
    it > 10
}
```

Result:

```text
30
```

---

# 19. `lastOrNull`

Returns the last matching element or `null`.

```kotlin
val result = numbers.lastOrNull {
    it > 100
}
```

Result:

```text
null
```

---

# 20. `any`

`any()` checks whether **at least one** element satisfies the condition.

```kotlin
val numbers = listOf(1, 3, 5, 8)

val result = numbers.any {
    it % 2 == 0
}
```

Output:

```text
true
```

Because `8` is even.

Think:

```text
any
↓
Does at least ONE item match?
```

---

# 21. `all`

`all()` checks whether **every** element satisfies the condition.

```kotlin
val numbers = listOf(2, 4, 6, 8)

val result = numbers.all {
    it % 2 == 0
}
```

Output:

```text
true
```

Think:

```text
all
↓
Do ALL items match?
```

---

# 22. `none`

`none()` checks whether **no** element satisfies the condition.

```kotlin
val numbers = listOf(1, 3, 5, 7)

val result = numbers.none {
    it % 2 == 0
}
```

Output:

```text
true
```

Think:

```text
none
↓
Does ZERO items match?
```

---

# 23. Remember `any`, `all`, `none`

```text
any
↓
at least one

all
↓
every item

none
↓
zero items
```

Examples:

```kotlin
numbers.any {
    it > 10
}
```

```kotlin
numbers.all {
    it > 0
}
```

```kotlin
numbers.none {
    it < 0
}
```

---

# 24. `count`

`count()` returns the number of elements.

```kotlin
val numbers = listOf(10, 20, 30, 40)

println(numbers.count())
```

Output:

```text
4
```

It can also count elements matching a condition:

```kotlin
val evenCount = numbers.count {
    it % 2 == 0
}
```

Output:

```text
4
```

---

# 25. `sum`

For numeric collections:

```kotlin
val numbers = listOf(10, 20, 30)

println(numbers.sum())
```

Output:

```text
60
```

---

# 26. `sumOf`

`sumOf` is useful when working with objects.

```kotlin
data class Product(
    val name: String,
    val price: Int
)

val products = listOf(
    Product("Keyboard", 2000),
    Product("Mouse", 1000),
    Product("Monitor", 15000)
)
```

Calculate total price:

```kotlin
val total = products.sumOf {
    it.price
}

println(total)
```

Output:

```text
18000
```

---

# 27. `maxOrNull`

Find the largest value:

```kotlin
val numbers = listOf(10, 50, 20, 80, 30)

println(numbers.maxOrNull())
```

Output:

```text
80
```

It returns `null` if the collection is empty.

---

# 28. `minOrNull`

Find the smallest value:

```kotlin
val numbers = listOf(10, 50, 20, 80, 30)

println(numbers.minOrNull())
```

Output:

```text
10
```

---

# 29. `sorted`

Sort a collection in ascending order:

```kotlin
val numbers = listOf(50, 10, 30, 20, 40)

val sortedNumbers = numbers.sorted()

println(sortedNumbers)
```

Output:

```text
[10, 20, 30, 40, 50]
```

---

# 30. `sortedDescending`

Sort in descending order:

```kotlin
val numbers = listOf(50, 10, 30, 20, 40)

val sortedNumbers = numbers.sortedDescending()

println(sortedNumbers)
```

Output:

```text
[50, 40, 30, 20, 10]
```

---

# 31. `sortedBy`

Sort objects according to a property.

```kotlin
data class Student(
    val name: String,
    val age: Int
)

val students = listOf(
    Student("Rahim", 25),
    Student("Karim", 18),
    Student("Mazharul", 22)
)
```

Sort by age:

```kotlin
val sortedStudents = students.sortedBy {
    it.age
}
```

Result:

```text
Karim → 18
Mazharul → 22
Rahim → 25
```

---

# 32. `distinct`

Removes duplicate values.

```kotlin
val numbers = listOf(1, 2, 2, 3, 3, 3, 4)

val uniqueNumbers = numbers.distinct()

println(uniqueNumbers)
```

Output:

```text
[1, 2, 3, 4]
```

---

# 33. Combining `filter` and `map`

This is one of the most important patterns.

```kotlin
val numbers = listOf(1, 2, 3, 4, 5, 6)

val result = numbers
    .filter {
        it % 2 == 0
    }
    .map {
        it * 10
    }
```

Result:

```text
[20, 40, 60]
```

Flow:

```text
[1, 2, 3, 4, 5, 6]
        ↓
      filter
        ↓
    [2, 4, 6]
        ↓
       map
        ↓
  [20, 40, 60]
```

---

# 34. Combining `filter` and `find`

Example:

```kotlin
val numbers = listOf(10, 15, 20, 25, 30)

val result = numbers
    .filter {
        it % 5 == 0
    }
    .find {
        it > 20
    }
```

Result:

```text
25
```

However, this can be simplified:

```kotlin
val result = numbers.find {
    it % 5 == 0 && it > 20
}
```

Use the simpler version when it is clear enough.

---

# 35. Real Android Example — Students

```kotlin
data class Student(
    val name: String,
    val age: Int
)

val students = listOf(
    Student("Rahim", 17),
    Student("Karim", 20),
    Student("Mazharul", 25)
)
```

Get adult students:

```kotlin
val adults = students.filter {
    it.age >= 18
}
```

Get student names:

```kotlin
val names = students.map {
    it.name
}
```

Find Mazharul:

```kotlin
val student = students.find {
    it.name == "Mazharul"
}
```

Count adults:

```kotlin
val adultCount = students.count {
    it.age >= 18
}
```

Check whether anyone is under 18:

```kotlin
val hasMinor = students.any {
    it.age < 18
}
```

---

# 36. Real Android Example — RecyclerView

Suppose a RecyclerView displays students.

You may receive a list from an API:

```kotlin
val students = getStudents()
```

Filter adult students:

```kotlin
val adults = students.filter {
    it.age >= 18
}
```

Then send the result to your adapter:

```kotlin
adapter.submitList(adults)
```

You will use this kind of collection processing frequently in Android applications.

---

# 37. `map` vs `filter`

## `map`

Changes every item.

```kotlin
val result = numbers.map {
    it * 2
}
```

Example:

```text
[1, 2, 3]
    ↓
[2, 4, 6]
```

## `filter`

Selects some items.

```kotlin
val result = numbers.filter {
    it % 2 == 0
}
```

Example:

```text
[1, 2, 3, 4]
    ↓
[2, 4]
```

Remember:

```text
map
→ transform

filter
→ select
```

---

# 38. `forEach` vs `map`

## `forEach`

Use when you want to perform an action:

```kotlin
numbers.forEach {
    println(it)
}
```

## `map`

Use when you want a transformed collection:

```kotlin
val doubled = numbers.map {
    it * 2
}
```

Remember:

```text
forEach
→ perform an action

map
→ create transformed collection
```

---

# 39. `find` vs `filter`

## `find`

Returns the first matching item:

```kotlin
val student = students.find {
    it.age >= 18
}
```

Return type:

```text
Student?
```

## `filter`

Returns all matching items:

```kotlin
val adults = students.filter {
    it.age >= 18
}
```

Return type:

```text
List<Student>
```

Remember:

```text
find
→ first matching item

filter
→ all matching items
```

---

# 40. Important Return Types

| Function | Purpose | Return |
|---|---|---|
| `forEach` | Perform action | `Unit` |
| `map` | Transform items | New list |
| `filter` | Select items | New list |
| `find` | Find first match | `Element?` |
| `first` | First item/match | `Element` |
| `firstOrNull` | Safe first item/match | `Element?` |
| `any` | At least one? | `Boolean` |
| `all` | Every item? | `Boolean` |
| `none` | No items? | `Boolean` |
| `count` | Count items | `Int` |
| `sum` | Add numbers | Number |
| `maxOrNull` | Largest value | `Element?` |
| `minOrNull` | Smallest value | `Element?` |
| `sorted` | Sort ascending | New list |
| `distinct` | Remove duplicates | New list |

---

# 41. Common Mistake: `forEach`

Do not expect `forEach` to return a new list.

Incorrect idea:

```kotlin
val result = numbers.forEach {
    it * 2
}
```

`forEach` returns:

```text
Unit
```

If you want a new list:

```kotlin
val result = numbers.map {
    it * 2
}
```

---

# 42. Common Mistake: `filter`

`filter` needs a condition that returns `Boolean`.

Incorrect:

```kotlin
val result = numbers.filter {
    it * 2
}
```

Correct:

```kotlin
val result = numbers.filter {
    it % 2 == 0
}
```

---

# 43. Common Mistake: `map`

`map` transforms values.

```kotlin
val result = numbers.map {
    it * 2
}
```

It does not require a Boolean condition.

Example:

```kotlin
val names = numbers.map {
    "Number: $it"
}
```

Here:

```text
Int → String
```

---

# 44. Practice Task 1

Given:

```kotlin
val numbers = listOf(
    1, 2, 3, 4, 5,
    6, 7, 8, 9, 10
)
```

Use `filter` to get:

```text
[2, 4, 6, 8, 10]
```

---

# 45. Practice Task 2

Using the same list, use `map` to produce:

```text
[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
```

---

# 46. Practice Task 3

Given:

```kotlin
val numbers = listOf(10, 20, 30, 40, 50)
```

Use `find` to find the first number greater than `25`.

Expected:

```text
30
```

---

# 47. Practice Task 4

Create:

```kotlin
data class Student(
    val name: String,
    val age: Int
)
```

Create at least five students.

Then:

1. Get students aged 18 or above using `filter`.
2. Get only their names using `map`.
3. Find `"Mazharul"` using `find`.
4. Count students aged 18 or above using `count`.
5. Check whether any student is under 18 using `any`.

---

# 48. Practice Task 5 — Combined

Given:

```kotlin
val numbers = listOf(
    1, 2, 3, 4, 5,
    6, 7, 8, 9, 10
)
```

Try to create a chain using:

```text
filter
→ map
```

Your goal is to practice processing a collection through multiple Higher-Order Functions.

---

# 49. Quick Revision

```kotlin
numbers.forEach {
    println(it)
}
```

Perform an action for every item.

```kotlin
numbers.map {
    it * 2
}
```

Transform every item.

```kotlin
numbers.filter {
    it % 2 == 0
}
```

Keep matching items.

```kotlin
numbers.find {
    it > 20
}
```

Find the first matching item.

```kotlin
numbers.any {
    it > 20
}
```

Check whether at least one matches.

```kotlin
numbers.all {
    it > 0
}
```

Check whether all match.

```kotlin
numbers.none {
    it < 0
}
```

Check whether none match.

---

# 50. Most Important Things to Remember

## `forEach`

```text
Do something with every item.
```

## `map`

```text
Transform every item.
```

## `filter`

```text
Keep items that satisfy a condition.
```

## `find`

```text
Find the first matching item.
```

## `any`

```text
Is there at least one?
```

## `all`

```text
Do all satisfy the condition?
```

## `none`

```text
Does none satisfy the condition?
```

The four functions you should be able to use confidently are:

```kotlin
forEach
map
filter
find
```

These are extremely important for Android development because you will constantly work with lists of:

- Users
- Students
- Messages
- Products
- Posts
- API responses
- RecyclerView items

```text
Collection
    ↓
Higher-Order Function
    ↓
Lambda
    ↓
Process data
    ↓
Result
```