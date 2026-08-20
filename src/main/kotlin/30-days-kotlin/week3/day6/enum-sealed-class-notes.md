# Enum and Sealed Class — Kotlin Notes

## 1. Enum Class

An `enum class` is used when a value can only be one of a **small, fixed set of choices**.

```kotlin
enum class UserRole {
    ADMIN,
    USER,
    MODERATOR
}
```

The possible values are:

```text
UserRole
├── ADMIN
├── USER
└── MODERATOR
```

Use an enum when the choices are fixed and the choices do not need significantly different data.

### Using an enum

```kotlin
val role = UserRole.ADMIN

println(role)
```

Output:

```text
ADMIN
```

`ADMIN` is an enum entry/constant and its type is `UserRole`.

---

## 2. Enum with Constructor Properties

An enum can have a constructor:

```kotlin
enum class UserRole(
    val description: String
) {
    ADMIN("Administrator"),
    USER("Normal User"),
    MODERATOR("Moderator")
}
```

Each enum entry provides a value for `description`.

Conceptually:

```text
UserRole.ADMIN
    description = "Administrator"

UserRole.USER
    description = "Normal User"

UserRole.MODERATOR
    description = "Moderator"
```

So:

```kotlin
println(UserRole.ADMIN.description)
```

prints:

```text
Administrator
```

### Important

```kotlin
ADMIN("Administrator")
```

does not mean `ADMIN` is a String.

`ADMIN` is still a `UserRole`. `"Administrator"` is passed to the enum constructor and becomes the `description` property of that enum entry.

---

## 3. Why Use Enum Instead of String?

Without enum:

```kotlin
var status = "PENDING"
```

Someone could accidentally write:

```kotlin
status = "PENDNG"
status = "hello"
```

With enum:

```kotlin
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    DELIVERED,
    CANCELLED
}

var status = OrderStatus.PENDING
```

The variable has type `OrderStatus`, so Kotlin provides type safety for the defined choices.

---

## 4. Enum with `when`

```kotlin
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    DELIVERED,
    CANCELLED
}

val status = OrderStatus.DELIVERED

when (status) {
    OrderStatus.PENDING -> println("Waiting")
    OrderStatus.CONFIRMED -> println("Confirmed")
    OrderStatus.DELIVERED -> println("Delivered")
    OrderStatus.CANCELLED -> println("Cancelled")
}
```

---

## 5. Where Enum Is Used in Android

Common examples:

```text
UserRole
    ADMIN
    USER
    MODERATOR

OrderStatus
    PENDING
    CONFIRMED
    DELIVERED
    CANCELLED

PaymentMethod
    CASH
    CARD
    BKASH

ScreenMode
    VIEW
    EDIT

SortType
    PRICE_LOW_TO_HIGH
    PRICE_HIGH_TO_LOW
```

Example:

```kotlin
enum class PaymentMethod {
    CASH,
    CARD,
    BKASH
}

val paymentMethod = PaymentMethod.BKASH
```

---

# 6. Sealed Class

A sealed class is useful when you have a **fixed set of possible types/states**, but different possibilities may contain different data.

A common Android example is:

```text
Loading
Success(data)
Error(message)
```

```kotlin
sealed class ApiState {

    data object Loading : ApiState()

    data class Success(
        val data: List<String>
    ) : ApiState()

    data class Error(
        val message: String
    ) : ApiState()
}
```

Hierarchy:

```text
ApiState
├── Loading
├── Success(data)
└── Error(message)
```

---

## 7. What Does `: ApiState` Mean?

```kotlin
data class Success(
    val data: List<String>
) : ApiState()
```

means:

> `Success` is a type of `ApiState`.

Likewise:

```kotlin
data class Error(
    val message: String
) : ApiState()
```

means `Error` is also a type of `ApiState`.

This is inheritance.

```text
ApiState
    ↑
    ├── Loading
    ├── Success
    └── Error
```

---

## 8. What Does `sealed` Mean?

`sealed` means Kotlin knows the defined set of subclasses in the sealed hierarchy.

This is especially useful with `when` because the possible states are known.

```kotlin
when (state) {
    ApiState.Loading -> {
        // show loading
    }

    is ApiState.Success -> {
        // show data
    }

    is ApiState.Error -> {
        // show error
    }
}
```

---

## 9. Why Not Use Enum for Loading/Success/Error?

You could write:

```kotlin
enum class ApiStatus {
    LOADING,
    SUCCESS,
    ERROR
}
```

But what happens when `SUCCESS` needs data and `ERROR` needs a message?

For example:

```text
SUCCESS → students
ERROR   → error message
```

A sealed class can represent this naturally:

```kotlin
sealed class ApiState {

    data object Loading : ApiState()

    data class Success(
        val students: List<String>
    ) : ApiState()

    data class Error(
        val message: String
    ) : ApiState()
}
```

Now:

```kotlin
ApiState.Success(
    listOf("Abir", "Rahman", "Kamrul")
)
```

contains successful data.

And:

```kotlin
ApiState.Error(
    "Internet connection failed"
)
```

contains the error message.

---

## 10. Why Is `Loading` a `data object`?

Loading does not need additional information.

```kotlin
data object Loading : ApiState()
```

Use:

```kotlin
ApiState.Loading
```

There is no data to provide.

---

## 11. Why Is `Success` a `data class`?

Success usually needs to carry the result:

```kotlin
data class Success(
    val students: List<String>
) : ApiState()
```

Example:

```kotlin
val state = ApiState.Success(
    listOf("Abir", "Rahman", "Kamrul")
)

println(state.students)
```

---

## 12. Why Is `Error` a `data class`?

An error usually carries information such as a message:

```kotlin
data class Error(
    val message: String
) : ApiState()
```

Example:

```kotlin
val state = ApiState.Error("Network error")

println(state.message)
```

---

# 13. Who Gives the State?

The sealed class does **not automatically decide** whether the state is `Loading`, `Success`, or `Error`.

Your application logic creates the appropriate state.

For example, a ViewModel might do:

```kotlin
state = ApiState.Loading
```

If the operation succeeds:

```kotlin
state = ApiState.Success(students)
```

If it fails:

```kotlin
state = ApiState.Error("Network error")
```

The typical flow is:

```text
API / Repository
       ↓
    ViewModel
       ↓
creates appropriate state
       ↓
Loading / Success / Error
       ↓
      UI
```

---

# 14. Real Android Example: Student API

Suppose an Android app loads students from a server.

```kotlin
sealed class StudentUiState {

    data object Loading : StudentUiState()

    data class Success(
        val students: List<Student>
    ) : StudentUiState()

    data class Error(
        val message: String
    ) : StudentUiState()
}
```

Conceptually:

```text
User opens screen
       ↓
ViewModel starts API request
       ↓
Loading
       ↓
API response
   ↙           ↘
Success       Error
   ↓             ↓
students      message
```

The UI observes the state and reacts.

---

# 15. UI Handling with `when`

```kotlin
when (state) {

    StudentUiState.Loading -> {
        // Show ProgressBar
    }

    is StudentUiState.Success -> {
        // Show students
        println(state.students)
    }

    is StudentUiState.Error -> {
        // Show error message
        println(state.message)
    }
}
```

The communication is:

```text
ViewModel:
"Current state is Loading."
        ↓
UI:
"Show loading indicator."

ViewModel:
"Current state is Success and here is the data."
        ↓
UI:
"Show the data."

ViewModel:
"Current state is Error and here is the message."
        ↓
UI:
"Show the error."
```

---

# 16. Another Android Example: Login

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

Possible states:

```kotlin
LoginResult.Loading
```

```kotlin
LoginResult.Success("Mazharul")
```

```kotlin
LoginResult.Error("Wrong password")
```

UI:

```kotlin
when (result) {

    LoginResult.Loading -> {
        // Show progress
    }

    is LoginResult.Success -> {
        // Navigate to home
        println(result.userName)
    }

    is LoginResult.Error -> {
        // Show error
        println(result.message)
    }
}
```

---

# 17. Enum vs Sealed Class

## Enum

Use enum when you have:

> **Fixed choices**

```kotlin
enum class UserRole {
    ADMIN,
    USER,
    MODERATOR
}
```

Think:

```text
ADMIN
USER
MODERATOR
```

The choices are basically values/names.

## Sealed Class

Use sealed class when you have:

> **Fixed choices/types where different choices may carry different data.**

```kotlin
sealed class LoginResult {

    data object Loading : LoginResult()

    data class Success(
        val user: User
    ) : LoginResult()

    data class Error(
        val message: String
    ) : LoginResult()
}
```

Think:

```text
Loading
   ↓
no data

Success
   ↓
User data

Error
   ↓
Error message
```

---

# 18. Simple Decision Rule

### Fixed choices only?

```text
ADMIN
USER
MODERATOR
```

Use enum:

```kotlin
enum class UserRole {
    ADMIN,
    USER,
    MODERATOR
}
```

### Fixed states with different data?

```text
Loading
Success(data)
Error(message)
```

Use sealed class:

```kotlin
sealed class Result {
    data object Loading : Result()
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}
```

---

# 19. Quick Comparison

| Feature | Enum | Sealed Class |
|---|---|---|
| Fixed set of possibilities | Yes | Yes |
| Simple named values | Excellent | Possible |
| Different data per possibility | Not the main purpose | Excellent |
| Common Android use | Roles, status, type, mode | UI state, API result, events |
| Example | `ADMIN`, `USER` | `Loading`, `Success(data)`, `Error(message)` |

---

# 20. Final Mental Model

### Enum

```text
Enum = fixed choices
```

```kotlin
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    DELIVERED
}
```

### Sealed Class

```text
Sealed class = fixed types/states + different data when needed
```

```kotlin
sealed class ApiState {
    data object Loading : ApiState()
    data class Success(val data: String) : ApiState()
    data class Error(val message: String) : ApiState()
}
```

Most importantly:

> **The enum/sealed class defines the possible choices. Your application logic (often the ViewModel/repository) creates the appropriate value/state based on what actually happens.**
