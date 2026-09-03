# Kotlin Enum and Sealed Class
## Android Development Notes

## 1. Overview

In Kotlin, `enum class` and `sealed class` are both useful for representing a limited set of possible values or states.

- Use **Enum** when you need a fixed set of simple constants.
- Use **Sealed Class** when each possible type/state may contain different data or behavior.

---

# Part 1: Enum Class

## 2. What is an Enum?

An enum represents a fixed set of constants.

Example:

```kotlin
enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

Usage:

```kotlin
val direction = Direction.NORTH

println(direction)
```

An enum variable can only contain one of the predefined values.

---

## 3. Enum with Properties

Enums can contain properties.

```kotlin
enum class Priority(val level: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3)
}
```

Usage:

```kotlin
val priority = Priority.HIGH

println(priority.level) // 3
```

---

## 4. Enum with Functions

```kotlin
enum class PaymentStatus {
    PENDING,
    SUCCESS,
    FAILED;

    fun message(): String {
        return when (this) {
            PENDING -> "Payment is pending"
            SUCCESS -> "Payment successful"
            FAILED -> "Payment failed"
        }
    }
}
```

Usage:

```kotlin
val status = PaymentStatus.SUCCESS

println(status.message())
```

---

## 5. Using Enum with when

```kotlin
enum class TrafficLight {
    RED,
    YELLOW,
    GREEN
}

fun getMessage(light: TrafficLight): String {
    return when (light) {
        TrafficLight.RED -> "Stop"
        TrafficLight.YELLOW -> "Wait"
        TrafficLight.GREEN -> "Go"
    }
}
```

Because all enum values are covered, Kotlin does not require an `else` branch.

---

# Part 2: Sealed Class

## 6. What is a Sealed Class?

A sealed class represents a restricted hierarchy of classes.

Each subclass represents a possible state or result.

Example:

```kotlin
sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}
```

Usage:

```kotlin
val result: Result = Result.Success("User data loaded")
```

---

## 7. Handling a Sealed Class with when

```kotlin
fun handleResult(result: Result) {
    when (result) {
        is Result.Success -> {
            println(result.data)
        }

        is Result.Error -> {
            println(result.message)
        }

        Result.Loading -> {
            println("Loading...")
        }
    }
}
```

All possible subclasses are handled, so `else` is usually unnecessary.

---

# Part 3: Enum vs Sealed Class

| Feature | Enum Class | Sealed Class |
|---|---|---|
| Number of states | Fixed constants | Fixed subclasses |
| Can hold different data | Limited/shared structure | Yes |
| Best for | Simple categories | Complex UI/business states |
| Example | LOW, MEDIUM, HIGH | Loading, Success(data), Error(message) |
| Android usage | Theme, priority, status | UI state, API result, navigation state |

Rule of thumb:

- **Simple fixed values -> Enum**
- **States with different data -> Sealed Class**

---

# Part 4: Android Connection

## 8. Android Example: API/UI State with Sealed Class

One of the most common Android uses is representing a screen state.

```kotlin
sealed class UiState {
    object Loading : UiState()

    data class Success(
        val username: String
    ) : UiState()

    data class Error(
        val message: String
    ) : UiState()
}
```

Imagine a ViewModel fetching user information.

```kotlin
class UserViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState>(UiState.Loading)

    val uiState = _uiState.asStateFlow()

    fun loadUser() {
        _uiState.value = UiState.Loading

        try {
            val username = "Mazharul"
            _uiState.value =
                UiState.Success(username)

        } catch (e: Exception) {
            _uiState.value =
                UiState.Error(
                    e.message ?: "Unknown error"
                )
        }
    }
}
```

In Jetpack Compose:

```kotlin
@Composable
fun UserScreen(
    viewModel: UserViewModel
) {
    val state by viewModel.uiState
        .collectAsState()

    when (state) {

        UiState.Loading -> {
            CircularProgressIndicator()
        }

        is UiState.Success -> {
            val success = state as UiState.Success

            Text(
                text = "Hello ${success.username}"
            )
        }

        is UiState.Error -> {
            val error = state as UiState.Error

            Text(
                text = error.message
            )
        }
    }
}
```

This pattern is extremely common in modern Android development.

---

## 9. Better API Result Example

```kotlin
sealed class ApiResult<out T> {

    data class Success<T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val message: String
    ) : ApiResult<Nothing>()

    object Loading : ApiResult<Nothing>()
}
```

Usage:

```kotlin
fun fetchUser(): ApiResult<String> {
    return ApiResult.Success("Mazharul")
}
```

Handling:

```kotlin
when (val result = fetchUser()) {

    is ApiResult.Success -> {
        println(result.data)
    }

    is ApiResult.Error -> {
        println(result.message)
    }

    ApiResult.Loading -> {
        println("Loading...")
    }
}
```

This is useful with:

- Retrofit
- Repository pattern
- ViewModel
- StateFlow
- Coroutines
- Jetpack Compose

---

# Part 5: Android Example with Enum

## 10. User Role

```kotlin
enum class UserRole {
    ADMIN,
    TEACHER,
    STUDENT
}
```

Usage:

```kotlin
fun getDashboard(role: UserRole): String {
    return when (role) {
        UserRole.ADMIN -> "Admin Dashboard"
        UserRole.TEACHER -> "Teacher Dashboard"
        UserRole.STUDENT -> "Student Dashboard"
    }
}
```

This is a good enum use case because a user role is a simple fixed category.

---

## 11. Theme Example

```kotlin
enum class AppTheme {
    LIGHT,
    DARK,
    SYSTEM_DEFAULT
}
```

You could save the selected enum name in DataStore or SharedPreferences.

Example concept:

```kotlin
val selectedTheme = AppTheme.DARK

when (selectedTheme) {
    AppTheme.LIGHT -> {
        // Apply light theme
    }

    AppTheme.DARK -> {
        // Apply dark theme
    }

    AppTheme.SYSTEM_DEFAULT -> {
        // Follow system theme
    }
}
```

---

# Part 6: Real Android Decision Guide

## Use Enum When

```text
The options are simple and fixed.
```

Examples:

- User role
- Theme mode
- Payment status
- Sort order
- Language selection
- Screen orientation type
- Priority

Example:

```kotlin
enum class SortOrder {
    NEWEST,
    OLDEST,
    POPULAR
}
```

---

## Use Sealed Class When

```text
Each state may contain different data.
```

Examples:

- Loading / Success / Error
- Network result
- Form validation
- Navigation events
- Authentication state

Example:

```kotlin
sealed class LoginState {

    object Loading : LoginState()

    data class Success(
        val userId: String
    ) : LoginState()

    data class Error(
        val message: String
    ) : LoginState()
}
```

---

# Part 7: Enum vs Sealed Class Example

Suppose you are building a login screen.

### Enum approach

```kotlin
enum class LoginStatus {
    LOADING,
    SUCCESS,
    ERROR
}
```

Problem: Where will you store the user data or error message?

You would need additional variables.

### Sealed class approach

```kotlin
sealed class LoginState {

    object Loading : LoginState()

    data class Success(
        val userName: String
    ) : LoginState()

    data class Error(
        val message: String
    ) : LoginState()
}
```

Now each state can carry the data it needs.

This is why sealed classes are generally better for Android UI state.

---

# Part 8: Sealed Interface

Kotlin also supports sealed interfaces.

```kotlin
sealed interface ScreenState {

    data object Loading : ScreenState

    data class Success(
        val data: String
    ) : ScreenState

    data class Error(
        val message: String
    ) : ScreenState
}
```

Use a sealed interface when an interface is a better design choice for your hierarchy.

---

# Part 9: Important Keywords

## enum class

```kotlin
enum class Color {
    RED,
    GREEN,
    BLUE
}
```

## sealed class

```kotlin
sealed class State
```

## object

Used for a singleton state:

```kotlin
object Loading : State()
```

## data class

Used when the state contains data:

```kotlin
data class Success(
    val data: String
) : State()
```

---

# Part 10: Interview Questions

### Q1. What is an enum class?

An enum class represents a fixed set of constants.

### Q2. What is a sealed class?

A sealed class restricts a class hierarchy to known subclasses and is useful for representing different states.

### Q3. Why is sealed class useful in Android?

It is commonly used for UI states, API results, loading states, success states, and error states.

### Q4. Enum vs sealed class?

Use enum for simple fixed constants. Use sealed class when different states need different data.

### Q5. Why does when work well with sealed classes?

Kotlin knows all possible subclasses, allowing exhaustive `when` expressions without an `else` branch.

---

# Quick Revision

```text
ENUM
Simple fixed values
Example:
LIGHT, DARK, SYSTEM_DEFAULT

SEALED CLASS
Different possible states with different data
Example:
Loading
Success(data)
Error(message)
```

## Best Android Rule

```text
Simple category -> Enum

Complex state with data -> Sealed Class
```

---

# Practice Tasks

## Task 1

Create an enum called `OrderStatus`:

```text
PENDING
PROCESSING
SHIPPED
DELIVERED
CANCELLED
```

Write a function that returns a message for each status.

## Task 2

Create a sealed class called `NetworkState`:

```text
Loading
Success(data)
Error(message)
```

Use `when` to display each state.

## Task 3: Android Practice

Create a simple screen with three UI states:

1. Loading -> Show progress indicator
2. Success -> Show user name
3. Error -> Show error message

Use:

```text
ViewModel
StateFlow
Sealed Class
Jetpack Compose
```

---

# Final Takeaway

Enums and sealed classes both represent a limited number of possibilities.

Choose based on complexity:

```text
Enum = fixed simple constants

Sealed Class = fixed states that can contain different data
```

For modern Android development, sealed classes/interfaces are especially useful for:

```text
UI State
API Result
Loading / Success / Error
Navigation Events
Authentication State
Form Validation
```
