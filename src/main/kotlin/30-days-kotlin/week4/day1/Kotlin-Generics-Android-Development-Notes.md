# Kotlin Generics
## Android Development Notes with Examples

---

# 1. What Are Generics?

Generics allow us to write classes, functions, and data structures that work with **different types** while keeping type safety.

Without generics:

```kotlin
val name: String = "Mazharul"
val age: Int = 33
```

With generics, we can create reusable code that works with different types.

```kotlin
class Box<T>(val value: T)
```

Here, `T` is a **generic type parameter**.

Usage:

```kotlin
val stringBox = Box("Hello")
val intBox = Box(100)
val booleanBox = Box(true)
```

Kotlin automatically infers the type in many cases.

---

# 2. Why Use Generics?

Generics provide:

- Type safety
- Code reusability
- Less duplicate code
- Better IDE support
- Fewer runtime type-casting errors

Example without generics:

```kotlin
val list: List<Any> = listOf("Hello", 10, true)
```

This allows mixed types, which may not be desirable.

With generics:

```kotlin
val names: List<String> = listOf("A", "B", "C")
```

Only `String` values are allowed.

---

# 3. Generic Class

Basic syntax:

```kotlin
class Box<T>(
    val value: T
)
```

Usage:

```kotlin
val nameBox = Box<String>("Mazharul")
val ageBox = Box<Int>(33)
```

Usually Kotlin can infer the type:

```kotlin
val nameBox = Box("Mazharul")
val ageBox = Box(33)
```

---

# 4. Generic Class with Multiple Type Parameters

A class can have multiple generic types.

```kotlin
class PairData<T, U>(
    val first: T,
    val second: U
)
```

Usage:

```kotlin
val user = PairData(
    "Mazharul",
    33
)

println(user.first)
println(user.second)
```

Another example:

```kotlin
class ApiResponse<T, U>(
    val data: T?,
    val error: U?
)
```

---

# 5. Generic Function

Functions can also use generics.

```kotlin
fun <T> printItem(item: T) {
    println(item)
}
```

Usage:

```kotlin
printItem("Hello")
printItem(100)
printItem(true)
```

Another example:

```kotlin
fun <T> getFirstItem(
    list: List<T>
): T? {
    return list.firstOrNull()
}
```

Usage:

```kotlin
val names = listOf(
    "A",
    "B",
    "C"
)

println(getFirstItem(names))
```

---

# 6. Generic Collections

You already use generics in Kotlin collections.

```kotlin
val names: List<String> =
    listOf("A", "B")

val numbers: List<Int> =
    listOf(1, 2, 3)

val users: MutableList<User> =
    mutableListOf()
```

`List<String>` means:

```text
List containing String values
```

`List<User>` means:

```text
List containing User objects
```

Example:

```kotlin
data class User(
    val id: Int,
    val name: String
)

val users = listOf(
    User(1, "Mazharul"),
    User(2, "Rahim")
)
```

---

# 7. Type Constraints

Sometimes a generic type should be limited to a particular type or its subclasses.

Syntax:

```kotlin
fun <T : Number> printNumber(
    value: T
) {
    println(value)
}
```

Usage:

```kotlin
printNumber(10)
printNumber(10.5)
```

This will work because `Int` and `Double` are numbers.

A `String` is not allowed:

```kotlin
// printNumber("Hello") // Error
```

---

# 8. Generic Constraint Example

Suppose we have:

```kotlin
open class Animal {
    fun eat() {
        println("Eating")
    }
}
```

Now:

```kotlin
class Dog : Animal()
class Cat : Animal()
```

Create a generic function:

```kotlin
fun <T : Animal> feed(
    animal: T
) {
    animal.eat()
}
```

Usage:

```kotlin
feed(Dog())
feed(Cat())
```

Only subclasses of `Animal` are allowed.

---

# 9. Multiple Constraints

A generic type can satisfy more than one constraint.

Example:

```kotlin
interface Printable {
    fun print()
}

interface Saveable {
    fun save()
}
```

Then:

```kotlin
fun <T> process(
    item: T
) where T : Printable,
        T : Saveable {

    item.print()
    item.save()
}
```

The object must implement both interfaces.

---

# 10. Star Projection

Sometimes you do not know the exact generic type.

Example:

```kotlin
fun printList(
    list: List<*>
) {
    for (item in list) {
        println(item)
    }
}
```

Usage:

```kotlin
printList(
    listOf("A", "B")
)

printList(
    listOf(1, 2, 3)
)
```

`*` means:

```text
Unknown type
```

Star projection is useful when you only need to read values generally.

---

# 11. Covariance - out

`out` means the generic type is **produced** or returned.

A common rule:

```text
out = Producer
```

Example:

```kotlin
class Producer<out T>(
    private val value: T
) {
    fun getValue(): T {
        return value
    }
}
```

Usage:

```kotlin
open class Animal

class Dog : Animal()

val dogProducer =
    Producer(Dog())

val animalProducer:
    Producer<Animal> =
    dogProducer
```

This is safe because a producer only gives us `T`.

Important:

With `out T`, you generally should not use `T` as an input parameter.

Example:

```kotlin
// fun setValue(value: T)
// Not allowed in the normal out position
```

---

# 12. Contravariance - in

`in` means the generic type is **consumed**.

Rule:

```text
in = Consumer
```

Example:

```kotlin
class Consumer<in T> {

    fun consume(
        value: T
    ) {
        println(value)
    }
}
```

Example hierarchy:

```kotlin
open class Animal

class Dog : Animal()
```

Usage:

```kotlin
val animalConsumer =
    Consumer<Animal>()

val dogConsumer:
    Consumer<Dog> =
    animalConsumer
```

This is safe because a consumer that accepts any `Animal` can also accept a `Dog`.

Important:

With `in T`, you generally cannot safely return `T`.

---

# 13. Easy Memory Rule: PECS

A useful memory rule:

```text
Producer = out
Consumer = in
```

In Kotlin:

```text
out -> produces/returns values

in -> consumes/accepts values
```

---

# 14. Declaration-Site Variance

Kotlin can define variance directly in the class declaration.

Example:

```kotlin
interface Source<out T> {
    fun get(): T
}
```

Example consumer:

```kotlin
interface Sink<in T> {
    fun put(value: T)
}
```

Kotlin's standard library already uses variance in several APIs.

For example:

```kotlin
List<out E>
```

A list is generally used as a producer of values.

---

# 15. Use-Site Variance

You can also specify variance at a particular usage location.

Example:

```kotlin
fun copy(
    from: Array<out Any>,
    to: Array<Any>
) {
    // Read from `from`
}
```

Another example:

```kotlin
fun addDog(
    list: MutableList<in Dog>,
    dog: Dog
) {
    list.add(dog)
}
```

This is useful when working with mutable collections and inheritance.

---

# 16. Generic Data Class

A very common pattern:

```kotlin
data class Response<T>(
    val data: T
)
```

Usage:

```kotlin
val userResponse =
    Response(
        User(
            id = 1,
            name = "Mazharul"
        )
    )

val numberResponse =
    Response(100)
```

The same class works with different data types.

---

# 17. Android Connection: API Response

Generics are extremely common in Android networking.

Suppose an API returns different types of data.

```kotlin
data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val message: String?
)
```

For users:

```kotlin
data class User(
    val id: Int,
    val name: String
)

val response =
    ApiResponse(
        success = true,
        data = User(
            id = 1,
            name = "Mazharul"
        ),
        message = null
    )
```

The same response class can also handle a list of products:

```kotlin
data class Product(
    val id: Int,
    val title: String
)

val productResponse =
    ApiResponse(
        success = true,
        data = listOf(
            Product(1, "Phone"),
            Product(2, "Laptop")
        ),
        message = null
    )
```

This prevents creating separate response classes for every data type.

---

# 18. Android Connection: Sealed API Result + Generics

This is one of the most important Android patterns.

```kotlin
sealed class ApiResult<out T> {

    data object Loading :
        ApiResult<Nothing>()

    data class Success<T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val message: String
    ) : ApiResult<Nothing>()
}
```

Why `out T`?

Because `ApiResult` produces data.

Usage:

```kotlin
val result:
    ApiResult<User> =
    ApiResult.Success(
        User(
            id = 1,
            name = "Mazharul"
        )
    )
```

Handling:

```kotlin
when (result) {

    is ApiResult.Success -> {
        println(result.data.name)
    }

    is ApiResult.Error -> {
        println(result.message)
    }

    ApiResult.Loading -> {
        println("Loading...")
    }
}
```

---

# 19. Why Nothing Is Used

In:

```kotlin
data object Loading :
    ApiResult<Nothing>()
```

`Nothing` means:

```text
No actual value is produced.
```

It works well because `Nothing` is a subtype of all Kotlin types.

Therefore:

```kotlin
ApiResult<Nothing>
```

can fit where:

```kotlin
ApiResult<User>
```

is expected when the generic type is declared with `out`.

---

# 20. Android Repository Example

A repository can return generic results.

```kotlin
class UserRepository {

    suspend fun getUser(
        id: Int
    ): ApiResult<User> {

        return try {

            val user =
                User(
                    id = id,
                    name = "Mazharul"
                )

            ApiResult.Success(user)

        } catch (e: Exception) {

            ApiResult.Error(
                e.message
                    ?: "Unknown error"
            )
        }
    }
}
```

The return type clearly tells us that:

```text
The operation can return:

Success<User>
Error
Loading
```

---

# 21. Android ViewModel Example

```kotlin
class UserViewModel(
    private val repository:
        UserRepository
) : ViewModel() {

    private val _userState =
        MutableStateFlow<
            ApiResult<User>
        >(
            ApiResult.Loading
        )

    val userState =
        _userState.asStateFlow()

    fun loadUser() {

        viewModelScope.launch {

            _userState.value =
                ApiResult.Loading

            _userState.value =
                repository.getUser(1)
        }
    }
}
```

Generics allow `ApiResult` to know that this state contains a `User`.

---

# 22. Jetpack Compose Example

```kotlin
@Composable
fun UserScreen(
    viewModel: UserViewModel
) {

    val state by viewModel
        .userState
        .collectAsState()

    when (state) {

        ApiResult.Loading -> {
            CircularProgressIndicator()
        }

        is ApiResult.Success -> {

            val success =
                state as ApiResult.Success<User>

            Text(
                text =
                    success.data.name
            )
        }

        is ApiResult.Error -> {

            val error =
                state as ApiResult.Error

            Text(
                text =
                    error.message
            )
        }
    }
}
```

In real Android projects, this pattern is common with:

```text
ViewModel
Repository
Retrofit
Coroutines
Flow / StateFlow
Jetpack Compose
```

---

# 23. Better Generic UI State Example

```kotlin
sealed interface UiState<out T> {

    data object Loading :
        UiState<Nothing>

    data class Success<T>(
        val data: T
    ) : UiState<T>

    data class Error(
        val message: String
    ) : UiState<Nothing>
}
```

For a user screen:

```kotlin
UiState<User>
```

For a product screen:

```kotlin
UiState<List<Product>>
```

The same UI state system works everywhere.

---

# 24. Generic RecyclerView Adapter

Generics are useful when creating reusable Android components.

Conceptually:

```kotlin
abstract class BaseAdapter<T> :
    RecyclerView.Adapter<
        RecyclerView.ViewHolder
    >() {

    protected val items =
        mutableListOf<T>()

    fun submitList(
        newItems: List<T>
    ) {

        items.clear()

        items.addAll(newItems)

        notifyDataSetChanged()
    }
}
```

A concrete adapter could use:

```kotlin
BaseAdapter<User>
```

or:

```kotlin
BaseAdapter<Product>
```

This allows common logic to be reused.

Note: Real production RecyclerView adapters often use `ListAdapter` and `DiffUtil` for better performance.

---

# 25. Generic Mapper

Apps often convert API models into UI/domain models.

Generic mapper interface:

```kotlin
interface Mapper<F, T> {

    fun map(
        from: F
    ): T
}
```

Example concept:

```text
UserDto
   |
   v
User
```

This pattern is useful in clean architecture.

---

# 26. Generic Use Case

In larger Android projects:

```kotlin
interface UseCase<P, R> {

    suspend operator fun invoke(
        params: P
    ): R
}
```

Example idea:

```text
P = User ID

R = ApiResult<User>
```

Generics make architecture components reusable.

---

# 27. Generic Extension Function

Extension functions can also be generic.

```kotlin
fun <T> List<T>.printAll() {

    for (item in this) {
        println(item)
    }
}
```

Usage:

```kotlin
listOf(1, 2, 3)
    .printAll()

listOf("A", "B")
    .printAll()
```

Another useful example:

```kotlin
fun <T> T.log() {
    println(this)
}
```

Usage:

```kotlin
"Hello".log()

100.log()
```

---

# 28. Reified Type Parameters

Normally generic type information is erased at runtime.

Example:

```kotlin
fun <T> checkType(
    value: Any
): Boolean {

    return value is T
}
```

This does not work normally.

Use `inline` + `reified`:

```kotlin
inline fun <reified T>
    isType(
        value: Any
    ): Boolean {

    return value is T
}
```

Usage:

```kotlin
println(
    isType<String>("Hello")
)

println(
    isType<Int>("Hello")
)
```

Result:

```text
true
false
```

---

# 29. Android Connection: Reified

Reified types can make Android helper functions cleaner.

Example concept:

```kotlin
inline fun <reified T>
    printClassName() {

    println(
        T::class.simpleName
    )
}
```

Usage:

```kotlin
printClassName<User>()
```

Reified generics are often useful in:

- Navigation helpers
- JSON serialization helpers
- Dependency injection helpers
- Intent/Bundle utilities
- Generic ViewModel utilities

---

# 30. Generic Function with Nullable Type

Generics can also work with nullable types.

```kotlin
fun <T> getValue(
    value: T?
): T? {
    return value
}
```

Usage:

```kotlin
val name =
    getValue("Mazharul")

val empty =
    getValue<String>(null)
```

---

# 31. Generics + Null Constraint

If you want to allow only non-null types:

```kotlin
fun <T : Any>
    printNonNull(
        value: T
    ) {

    println(value)
}
```

`T : Any` means the type cannot be nullable.

---

# 32. Common Generic Syntax Cheat Sheet

## Generic class

```kotlin
class Box<T>
```

## Generic function

```kotlin
fun <T> function(
    value: T
)
```

## Multiple types

```kotlin
class Data<T, U>
```

## Constraint

```kotlin
fun <T : Number>
```

## Producer

```kotlin
class Box<out T>
```

## Consumer

```kotlin
class Box<in T>
```

## Unknown type

```kotlin
List<*>
```

## Runtime generic type

```kotlin
inline fun <reified T>
```

---

# 33. Generics vs Any

You might think:

```kotlin
Any
```

can replace generics.

Example:

```kotlin
class BadBox(
    val value: Any
)
```

Problem:

```kotlin
val box =
    BadBox("Hello")

val number =
    box.value as Int
```

This can cause a runtime error.

With generics:

```kotlin
class GoodBox<T>(
    val value: T
)
```

Then:

```kotlin
val box =
    GoodBox("Hello")

val text: String =
    box.value
```

Generics provide compile-time type safety.

---

# 34. Generics vs Sealed Class

Generics and sealed classes work very well together.

Example:

```kotlin
sealed class Result<out T> {

    data class Success<T>(
        val data: T
    ) : Result<T>()

    data class Error(
        val message: String
    ) : Result<Nothing>()

    data object Loading :
        Result<Nothing>()
}
```

Here:

```text
Sealed Class
=
Represents possible states

Generics
=
Represents the type of data
```

Example:

```text
Result<User>

Result<List<Product>>

Result<String>
```

---

# 35. Real Android Architecture Flow

A common architecture:

```text
API
 ↓
Retrofit
 ↓
Repository
 ↓
ApiResult<T>
 ↓
ViewModel
 ↓
StateFlow<UiState<T>>
 ↓
Jetpack Compose UI
```

Example:

```text
ApiResult<User>
```

The generic `T` ensures that every layer knows what type of data is being handled.

---

# 36. Common Beginner Mistakes

## Mistake 1: Using Any instead of Generics

Avoid:

```kotlin
fun process(
    data: Any
)
```

When type safety is important, prefer:

```kotlin
fun <T> process(
    data: T
)
```

---

## Mistake 2: Confusing out and in

Remember:

```text
out = gives data

in = receives data
```

---

## Mistake 3: Using Reified Without Inline

This is invalid:

```kotlin
fun <reified T> test()
```

Correct:

```kotlin
inline fun <reified T> test()
```

---

# 37. Interview Questions

## Q1. What are generics?

Generics allow classes and functions to work with different types while maintaining type safety.

## Q2. What does `<T>` mean?

`T` is a type parameter representing a type that will be specified or inferred when the class/function is used.

## Q3. What is `out`?

`out` represents covariance and is used when a generic type produces or returns values.

## Q4. What is `in`?

`in` represents contravariance and is used when a generic type consumes or accepts values.

## Q5. What is `reified`?

`reified` preserves access to the generic type at runtime and must be used with an inline function.

## Q6. Why are generics useful in Android?

They allow reusable and type-safe API results, UI states, repositories, adapters, mappers, and architecture components.

---

# 38. Practice Tasks

## Task 1: Generic Box

Create:

```kotlin
class Box<T>(
    val value: T
)
```

Test it with:

```text
String
Int
Boolean
```

---

## Task 2: Generic Function

Create:

```kotlin
fun <T> printValue(
    value: T
)
```

Test it with different types.

---

## Task 3: Number Constraint

Create a generic function that accepts only `Number` types.

---

## Task 4: API Result

Create:

```text
Loading
Success<T>
Error
```

using a sealed class and generics.

---

## Task 5: Android Practice

Build a small app flow:

```text
Button Click
     ↓
ViewModel
     ↓
Repository
     ↓
Result<User>
     ↓
StateFlow
     ↓
Jetpack Compose UI
```

Display:

```text
Loading
Success
Error
```

---

# 39. Quick Revision

```text
<T>
Generic type parameter

List<String>
List containing String

List<User>
List containing User

<T : Number>
T must be Number or subclass

out T
Producer

in T
Consumer

*
Unknown generic type

reified
Access generic type at runtime
```

---

# Final Takeaway

Generics are one of the most important concepts for writing reusable and type-safe Kotlin code.

The most important Android use cases are:

```text
ApiResult<T>
UiState<T>
Repository results
RecyclerView adapters
Mappers
Use cases
Generic helper functions
```

A very important pattern to remember:

```kotlin
sealed class ApiResult<out T> {

    data object Loading :
        ApiResult<Nothing>()

    data class Success<T>(
        val data: T
    ) : ApiResult<T>()

    data class Error(
        val message: String
    ) : ApiResult<Nothing>()
}
```

Mental model:

```text
Generics = What type of data?

Sealed Class = What state are we in?
```

Together, they are extremely useful for modern Android development.
