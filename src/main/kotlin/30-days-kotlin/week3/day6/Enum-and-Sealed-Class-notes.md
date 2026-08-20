# Kotlin Enum Classes and Sealed Classes

## 1. What Problem Do They Solve?

Sometimes an application has a fixed set of possible values or states.

For example:

```text
Loading
Success
Error
```

or:

```text
North
South
East
West
```

Kotlin provides two useful tools for this:

```kotlin
enum class
sealed class
```

---

# 2. Enum Class

An `enum class` represents a fixed set of named constants.

Example:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

The possible values are:

```text
NORTH
SOUTH
EAST
WEST
```

---

# 3. Creating an Enum Value

```kotlin
val direction = Direction.NORTH
```

Here:

```kotlin
Direction
```

is the enum class.

```kotlin
NORTH
```

is one of the constants defined inside that enum.

You cannot write:

```kotlin
val direction = Direction.HELLO
```

because `HELLO` was not defined.

---

# 4. Why Use Enum?

Use an enum when you have a small, fixed list of related values.

Common examples:

```text
Directions
Days
User roles
Priority
Order status
Colors
Payment types
```

Example:

```kotlin
enum class UserRole {
    ADMIN,
    USER,
    MODERATOR
}
```

---

# 5. Enum With `when`

Enums work very well with `when`.

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

val direction = Direction.NORTH

when (direction) {
    Direction.NORTH -> println("Going North")
    Direction.SOUTH -> println("Going South")
    Direction.EAST -> println("Going East")
    Direction.WEST -> println("Going West")
}
```

Output:

```text
Going North
```

---

# 6. Why Doesn't `when` Need `else`?

Kotlin knows all possible values of the enum.

```kotlin
when (direction) {
    Direction.NORTH -> println("North")
    Direction.SOUTH -> println("South")
    Direction.EAST -> println("East")
    Direction.WEST -> println("West")
}
```

All enum cases are handled.

This is called an:

```text
exhaustive when
```

---

# 7. Enum With Properties

An enum can have properties.

```kotlin
enum class UserRole(
    val description: String
) {
    ADMIN("Administrator"),
    USER("Normal User"),
    MODERATOR("Moderator")
}
```

Use:

```kotlin
val role = UserRole.ADMIN

println(role.description)
```

Output:

```text
Administrator
```

---

# 8. Enum With Multiple Properties

```kotlin
enum class ProductStatus(
    val code: Int,
    val description: String
) {
    AVAILABLE(1, "Product available"),
    OUT_OF_STOCK(2, "Product unavailable"),
    DISCONTINUED(3, "Product discontinued")
}
```

Use:

```kotlin
val status = ProductStatus.AVAILABLE

println(status.code)
println(status.description)
```

Output:

```text
1
Product available
```

---

# 9. Enum Constructor

The parameters:

```kotlin
val code: Int,
val description: String
```

are constructor parameters.

Each enum constant provides values:

```kotlin
AVAILABLE(1, "Product available")
OUT_OF_STOCK(2, "Product unavailable")
DISCONTINUED(3, "Product discontinued")
```

Think:

```text
ProductStatus
       |
       ├── AVAILABLE
       │     ├── code = 1
       │     └── description = "Product available"
       │
       ├── OUT_OF_STOCK
       │     ├── code = 2
       │     └── description = "Product unavailable"
       │
       └── DISCONTINUED
             ├── code = 3
             └── description = "Product discontinued"
```

---

# 10. Enum Functions

Enums can contain functions.

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    fun description(): String {
        return when (this) {
            NORTH -> "Up"
            SOUTH -> "Down"
            EAST -> "Right"
            WEST -> "Left"
        }
    }
}
```

Use:

```kotlin
println(Direction.NORTH.description())
```

Output:

```text
Up
```

Notice the semicolon:

```kotlin
WEST;
```

The semicolon separates enum constants from other class members.

---

# 11. Enum `name`

Every enum constant has a `name` property.

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

val direction = Direction.NORTH

println(direction.name)
```

Output:

```text
NORTH
```

---

# 12. Enum `ordinal`

Every enum constant has an `ordinal` value.

It represents its position.

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Positions:

```text
NORTH → 0
SOUTH → 1
EAST  → 2
WEST  → 3
```

Example:

```kotlin
println(Direction.NORTH.ordinal)
```

Output:

```text
0
```

Another example:

```kotlin
println(Direction.WEST.ordinal)
```

Output:

```text
3
```

### Important

Do not normally use `ordinal` as a permanent database/API ID.

If you change the enum order, ordinal values change.

---

# 13. Getting All Enum Values

You can get all enum entries:

```kotlin
val directions = Direction.entries
```

Then:

```kotlin
directions.forEach {
    println(it)
}
```

Output:

```text
NORTH
SOUTH
EAST
WEST
```

---

# 14. Finding an Enum From a String

Suppose:

```kotlin
val roleName = "ADMIN"
```

You can use:

```kotlin
val role = UserRole.valueOf(roleName)
```

Then:

```kotlin
println(role)
```

Output:

```text
ADMIN
```

`valueOf()` is case-sensitive.

This:

```kotlin
UserRole.valueOf("ADMIN")
```

works.

But:

```kotlin
UserRole.valueOf("admin")
```

throws an exception.

---

# 15. `enumValueOf`

Another way:

```kotlin
val role = enumValueOf<UserRole>("ADMIN")
```

Result:

```text
UserRole.ADMIN
```

When handling external input such as API/user data, don't blindly call `valueOf()` unless you know the input is valid.

---

# 16. Android Example — User Role

```kotlin
enum class UserRole {
    ADMIN,
    USER,
    GUEST
}
```

Then:

```kotlin
fun showScreen(role: UserRole) {

    when (role) {

        UserRole.ADMIN -> {
            println("Admin Dashboard")
        }

        UserRole.USER -> {
            println("User Dashboard")
        }

        UserRole.GUEST -> {
            println("Guest Screen")
        }
    }
}
```

This is safer than:

```kotlin
fun showScreen(role: String)
```

because a `String` can contain anything.

---

# 17. What Is a Sealed Class?

A sealed class represents a restricted hierarchy of types.

Example:

```kotlin
sealed class Result
```

Then:

```kotlin
class Loading : Result()

class Success : Result()

class Error : Result()
```

Conceptually:

```text
Result
├── Loading
├── Success
└── Error
```

The hierarchy is restricted.

---

# 18. Why Use Sealed Classes?

Enums are good for simple fixed values.

But sometimes different states need different data.

For example:

```text
Loading

Success
    ↓
    data

Error
    ↓
    error message
```

A sealed class is ideal for this.

---

# 19. Simple Sealed Class

```kotlin
sealed class Result

class Loading : Result()

class Success : Result()

class Error : Result()
```

Now:

```kotlin
val result: Result = Loading()
```

or:

```kotlin
val result: Result = Success()
```

or:

```kotlin
val result: Result = Error()
```

---

# 20. Sealed Class With Data

This is where sealed classes become especially useful.

```kotlin
sealed class Result {

    class Success(
        val data: String
    ) : Result()

    class Error(
        val message: String
    ) : Result()

    class Loading : Result()
}
```

Now each state can contain different information.

---

# 21. Creating Sealed Class Objects

Success:

```kotlin
val result = Result.Success("Student data")
```

Error:

```kotlin
val result = Result.Error("Network error")
```

Loading:

```kotlin
val result = Result.Loading()
```

---

# 22. Sealed Class With `when`

This is one of the biggest reasons to use sealed classes.

```kotlin
fun handleResult(result: Result) {

    when (result) {

        is Result.Loading -> {
            println("Loading...")
        }

        is Result.Success -> {
            println(result.data)
        }

        is Result.Error -> {
            println(result.message)
        }
    }
}
```

Notice:

```kotlin
is Result.Success
```

because `Success` is a class/type.

---

# 23. Enum `when` vs Sealed Class `when`

### Enum

```kotlin
when (status) {

    Status.LOADING -> {
    }

    Status.SUCCESS -> {
    }

    Status.ERROR -> {
    }
}
```

### Sealed Class

```kotlin
when (result) {

    is Result.Loading -> {
    }

    is Result.Success -> {
    }

    is Result.Error -> {
    }
}
```

The difference:

```text
Enum
→ values/constants

Sealed class
→ types/subclasses
```

---

# 24. Android Example — `UiState`

A very common Android pattern is:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val students: List<Student>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

There are three possible states:

```text
Loading
Success
Error
```

But:

```text
Success
→ contains students

Error
→ contains error message
```

---

# 25. Handling `UiState`

```kotlin
fun updateUI(state: UiState) {

    when (state) {

        UiState.Loading -> {
            println("Show progress bar")
        }

        is UiState.Success -> {
            println("Show students")
            println(state.students)
        }

        is UiState.Error -> {
            println("Show error")
            println(state.message)
        }
    }
}
```

This pattern is extremely useful in Android.

---

# 26. `data object`

You may see:

```kotlin
data object Loading : UiState()
```

A `data object` is useful when the state doesn't need to contain separate data for each instance.

For example:

```text
Loading
```

is just one state.

You use:

```kotlin
UiState.Loading
```

not:

```kotlin
UiState.Loading()
```

---

# 27. Normal `object` in a Sealed Class

You can also write:

```kotlin
sealed class UiState {

    object Loading : UiState()

    data class Success(
        val data: String
    ) : UiState()
}
```

Then:

```kotlin
UiState.Loading
```

is the single `Loading` object.

---

# 28. `data class` Inside a Sealed Class

When a state contains data, use a `data class`.

```kotlin
sealed class UiState {

    data class Success(
        val data: String
    ) : UiState()
}
```

Create it:

```kotlin
val state = UiState.Success("Hello")
```

Access its data:

```kotlin
println(state.data)
```

Output:

```text
Hello
```

---

# 29. Why Not Just Use an Enum?

You could write:

```kotlin
enum class UiState {
    LOADING,
    SUCCESS,
    ERROR
}
```

This works if you only need to know the state.

But what if you need:

```text
SUCCESS → student list
ERROR   → error message
```

An enum cannot naturally represent these different pieces of data.

A sealed class can:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val students: List<Student>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

---

# 30. Simple Enum vs Sealed Class

Think:

```text
Enum
↓
"What value is it?"
```

Example:

```text
NORTH
SOUTH
EAST
WEST
```

Sealed class:

```text
"What state/type is it
and what data does it contain?"
```

Example:

```text
Loading

Success(data)

Error(message)
```

---

# 31. Another Example — Payment Method

Enum:

```kotlin
enum class PaymentMethod {
    CASH,
    CARD,
    BKASH
}
```

This is good when you only need the payment type.

But suppose different payment methods contain different data.

A sealed class is better:

```kotlin
sealed class PaymentMethod {

    data object Cash : PaymentMethod()

    data class Card(
        val cardLastFourDigits: String
    ) : PaymentMethod()

    data class Bkash(
        val phoneNumber: String
    ) : PaymentMethod()
}
```

Now:

```text
Cash
→ no extra data

Card
→ cardLastFourDigits

Bkash
→ phoneNumber
```

---

# 32. Another Example — Login Result

```kotlin
sealed class LoginResult {

    data object Loading : LoginResult()

    data class Success(
        val userName: String
    ) : LoginResult()

    data class Error(
        val message: String
    ) : LoginResult()
}
```

Handle it:

```kotlin
fun handleLogin(result: LoginResult) {

    when (result) {

        LoginResult.Loading -> {
            println("Logging in...")
        }

        is LoginResult.Success -> {
            println("Welcome ${result.userName}")
        }

        is LoginResult.Error -> {
            println("Login failed: ${result.message}")
        }
    }
}
```

---

# 33. Why This Matters in Android

You will frequently work with states such as:

```text
Loading
Success
Error
Empty
```

For example:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val users: List<User>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()

    data object Empty : UiState()
}
```

This pattern is commonly used with:

```text
ViewModel
StateFlow
LiveData
Retrofit
Repository
MVVM
```

---

# 34. `when` With Sealed Classes

Kotlin knows the permitted cases of the sealed hierarchy.

Therefore:

```kotlin
when (state) {

    UiState.Loading -> {
    }

    is UiState.Success -> {
    }

    is UiState.Error -> {
    }
}
```

can be exhaustive without an `else` when all cases are covered.

---

# 35. Enum vs Sealed Class

| Feature | Enum | Sealed Class |
|---|---|---|
| Fixed set | Yes | Yes |
| Named constants | Yes | Not necessarily |
| Different subclasses | No | Yes |
| Different data per state | Limited/not natural | Yes |
| Works with `when` | Yes | Yes |
| Good for simple choices | Excellent | Possible |
| Good for UI states | Basic | Excellent |
| Can contain properties | Yes | Yes |
| Can contain functions | Yes | Yes |

---

# 36. Decision Guide

Ask yourself:

### Are these simple fixed choices?

Use:

```kotlin
enum class
```

Example:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

---

### Are these different states/types?

Use:

```kotlin
sealed class
```

Example:

```kotlin
sealed class Result {

    data object Loading : Result()

    data class Success(
        val data: String
    ) : Result()

    data class Error(
        val message: String
    ) : Result()
}
```

---

# 37. Common Mistake

Don't use an enum when different states need different information.

Instead of:

```kotlin
enum class Result {
    SUCCESS,
    ERROR
}
```

and then maintaining separate variables:

```kotlin
var data: String?
var errorMessage: String?
```

model the state directly:

```kotlin
sealed class Result {

    data class Success(
        val data: String
    ) : Result()

    data class Error(
        val message: String
    ) : Result()
}
```

This makes the code safer and clearer.

---

# 38. Practice Task 1 — Enum

Create:

```kotlin
enum class Day {
    SATURDAY,
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY
}
```

Use `when` to print:

```text
Weekend
```

for:

```text
SATURDAY
SUNDAY
```

and:

```text
Working day
```

for the other days.

---

# 39. Practice Task 2 — Enum With Properties

Create:

```kotlin
enum class Priority(
    val level: Int
) {
    LOW(1),
    MEDIUM(2),
    HIGH(3)
}
```

Then:

```kotlin
println(Priority.HIGH)
println(Priority.HIGH.level)
```

Expected:

```text
HIGH
3
```

---

# 40. Practice Task 3 — Sealed Class

Create:

```kotlin
sealed class Result {

    data object Loading : Result()

    data class Success(
        val message: String
    ) : Result()

    data class Error(
        val message: String
    ) : Result()
}
```

Create one object for each state.

Then use `when` to print an appropriate message.

---

# 41. Practice Task 4 — Android-Style `UiState`

Create:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val students: List<String>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

Then:

```kotlin
val state: UiState =
    UiState.Success(
        listOf("Rahim", "Karim", "Mazharul")
    )
```

Use `when` to display the students.

---

# 42. Practice Task 5 — Weather App

Imagine you are building a weather app.

Possible states:

```text
Loading
Success(weather data)
Error(error message)
```

Create:

```kotlin
sealed class WeatherState
```

with appropriate subclasses.

Then handle all states using `when`.

---

# 43. Quick Revision

## Enum

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Use:

```kotlin
Direction.NORTH
```

Best for:

```text
Fixed set of simple values
```

---

## Sealed Class

```kotlin
sealed class Result {

    data object Loading : Result()

    data class Success(
        val data: String
    ) : Result()

    data class Error(
        val message: String
    ) : Result()
}
```

Best for:

```text
Fixed set of states/types
that may contain different data
```

---

# 44. Final Cheat Sheet

## ENUM

```text
Enum
│
├── Fixed set of values
├── Named constants
├── Same general type
├── Can have properties
└── Can have functions
```

Example:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

---

## SEALED CLASS

```text
Sealed Class
│
├── Fixed set of subclasses
├── Represents different states/types
├── Each subclass can contain different data
├── Works very well with when
└── Excellent for Android UI states
```

Example:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val data: List<String>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

---

# 45. The Most Important Rule

```text
Simple fixed choices
        ↓
     ENUM
```

Example:

```text
NORTH
SOUTH
EAST
WEST
```

But:

```text
Different states/types
+
Different data
        ↓
 SEALED CLASS
```

Example:

```text
Loading

Success(data)

Error(message)
```

---

# 46. Android Pattern to Remember

This is one of the most important sealed-class patterns for Android:

```kotlin
sealed class UiState {

    data object Loading : UiState()

    data class Success(
        val data: List<String>
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

Then:

```kotlin
when (state) {

    UiState.Loading -> {
        // Show progress bar
    }

    is UiState.Success -> {
        // Show data
    }

    is UiState.Error -> {
        // Show error
    }
}
```

This pattern will become especially important when you learn:

```text
ViewModel
    ↓
StateFlow
    ↓
UiState
    ↓
Activity / Fragment / Compose UI
```

---

# 47. Final Memory Trick

### Enum

Think:

```text
"What VALUE is it?"
```

Example:

```kotlin
Direction.NORTH
```

### Sealed Class

Think:

```text
"What STATE/TYPE is it?"
"What DATA does this state contain?"
```

Example:

```kotlin
UiState.Loading

UiState.Success(students)

UiState.Error(message)
```

**Remember:**

```text
ENUM
→ fixed values

SEALED CLASS
→ fixed states/types + different data
```