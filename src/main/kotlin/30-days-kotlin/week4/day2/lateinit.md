# Kotlin `lateinit` — Notes

## 1. What is `lateinit`?

`lateinit` means:

> **I will initialize this property later.**

It is mainly used with a **mutable (`var`) non-null reference property** when you cannot give it a value at the time of declaration.

Example:

```kotlin
class User {

    lateinit var name: String

    fun setName() {
        name = "Mazharul"
    }
}
```

Here:

```kotlin
lateinit var name: String
```

means:

```text
name exists
    ↓
but it does not have a value yet
    ↓
I promise to initialize it later
```

---

# 2. Why Do We Need `lateinit`?

Normally, a non-null property must be initialized:

```kotlin
class User {

    var name: String
}
```

This is invalid because Kotlin says:

> `name` must have a value before it can be used.

You could initialize it immediately:

```kotlin
class User {

    var name: String = "Unknown"
}
```

But sometimes you don't know the value yet.

For example, the value might be provided later by Android.

That's where `lateinit` can be useful:

```kotlin
class User {

    lateinit var name: String
}
```

---

# 3. `lateinit` Does NOT Mean Nullable

This is important.

Compare:

```kotlin
var name: String? = null
```

and:

```kotlin
lateinit var name: String
```

They are different.

### Nullable

```kotlin
var name: String? = null
```

means:

```text
name can contain a String
OR
name can contain null
```

Therefore you need:

```kotlin
println(name?.length)
```

### `lateinit`

```kotlin
lateinit var name: String
```

means:

```text
name will eventually contain a String
```

You don't write:

```kotlin
name?.length
```

Instead:

```kotlin
println(name.length)
```

But you must initialize it before using it.

---

# 4. Basic Example

```kotlin
class Student {

    lateinit var name: String

    fun setStudentName() {
        name = "Abir"
    }
}

fun main() {

    val student = Student()

    student.setStudentName()

    println(student.name)
}
```

Output:

```text
Abir
```

The sequence is:

```text
Student created
       ↓
name is not initialized
       ↓
setStudentName()
       ↓
name = "Abir"
       ↓
student.name
       ↓
"Abir"
```

---

# 5. What Happens If You Use It Too Early?

This is dangerous:

```kotlin
class Student {

    lateinit var name: String
}

fun main() {

    val student = Student()

    println(student.name)
}
```

The program throws:

```text
UninitializedPropertyAccessException
```

because:

```text
name
 ↓
not initialized yet
 ↓
but you tried to use it
```

So remember:

> **`lateinit` does not initialize the property. It only tells Kotlin that you will initialize it later.**

---

# 6. `lateinit` Must Be Initialized Before Use

Correct:

```kotlin
val student = Student()

student.name = "Abir"

println(student.name)
```

Incorrect:

```kotlin
val student = Student()

println(student.name)
```

---

# 7. How to Check Whether a `lateinit` Property Is Initialized

Kotlin provides:

```kotlin
::name.isInitialized
```

Example:

```kotlin
class Student {

    lateinit var name: String

    fun printName() {

        if (::name.isInitialized) {
            println(name)
        } else {
            println("Name is not initialized")
        }
    }
}
```

Before initialization:

```text
Name is not initialized
```

After:

```kotlin
student.name = "Abir"
```

it prints:

```text
Abir
```

---

# 8. What Does `::name` Mean?

When you write:

```kotlin
::name
```

you are referring to the property itself rather than its value.

Then:

```kotlin
::name.isInitialized
```

asks:

> Has this `lateinit` property been initialized?

This is useful when you are not sure whether initialization has already happened.

---

# 9. Important Rules of `lateinit`

`lateinit` has restrictions.

A `lateinit` property must generally be:

```kotlin
lateinit var name: String
```

It cannot normally be:

```kotlin
lateinit val name: String
```

because `lateinit` is designed for a property that will be assigned later, and `val` can only be assigned once through initialization.

It also cannot use primitive types such as:

```kotlin
lateinit var age: Int
```

This is invalid.

Primitive types include:

```text
Int
Long
Short
Byte
Float
Double
Boolean
Char
```

Use `lateinit` mainly with reference types such as:

```kotlin
lateinit var name: String
lateinit var student: Student
lateinit var repository: StudentRepository
```

---

# 10. `lateinit` vs Nullable Property

Suppose you need a `Student`.

### Nullable approach

```kotlin
var student: Student? = null
```

Then:

```kotlin
student?.name
```

or:

```kotlin
if (student != null) {
    println(student.name)
}
```

### `lateinit` approach

```kotlin
lateinit var student: Student
```

After initialization:

```kotlin
println(student.name)
```

No `?` is needed.

But if you access it too early:

```kotlin
println(student.name)
```

you get an exception.

---

# 11. When Should You Use `lateinit`?

Use it when:

1. The property cannot reasonably be initialized immediately.
2. You know it will definitely be initialized before use.
3. You want the property to remain non-null after initialization.

Example:

```kotlin
class UserManager {

    lateinit var repository: UserRepository

    fun setup() {
        repository = UserRepository()
    }

    fun loadUsers() {
        repository.getUsers()
    }
}
```

The intended lifecycle is:

```text
UserManager created
        ↓
setup()
        ↓
repository initialized
        ↓
loadUsers()
```

---

# 12. Android Example

You may see `lateinit` in Android code.

For example:

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.textView.text = "Hello"
    }
}
```

Why?

When the `MainActivity` object is created, the binding object may not have been created yet.

It is initialized later:

```kotlin
binding = ActivityMainBinding.inflate(layoutInflater)
```

Then it can be used:

```kotlin
binding.textView.text = "Hello"
```

The important rule is:

```text
Activity created
      ↓
binding not initialized yet
      ↓
onCreate()
      ↓
binding = ...
      ↓
binding can be used
```

---

# 13. `lateinit` vs `lazy`

These are often confused.

## `lateinit`

You manually initialize it later:

```kotlin
lateinit var repository: Repository

repository = Repository()
```

You decide **when and where** initialization happens.

## `lazy`

Kotlin initializes it automatically when it is first accessed:

```kotlin
val repository by lazy {
    Repository()
}
```

You don't manually write:

```kotlin
repository = Repository()
```

The first access triggers initialization.

---

# 14. Main Difference

### `lateinit`

```kotlin
lateinit var repository: Repository

// Later:
repository = Repository()
```

Think:

```text
"I promise to initialize this later."
```

### `lazy`

```kotlin
val repository by lazy {
    Repository()
}
```

Think:

```text
"Create this automatically when I first need it."
```

---

# 15. Comparison Table

| Feature | `lateinit` | `lazy` |
|---|---|---|
| Usually used with | `var` | `val` |
| Initialization | Manual | Automatic on first access |
| Nullable? | No | No |
| Can use before initialization? | No | Yes, because access initializes it |
| Primitive types | No | Can calculate primitive values |
| Reassignment | Yes | No, normally |
| Common Android use | ViewBinding, injected dependencies | Repository/database/object creation |

---

# 16. Simple Mental Model

Remember these two sentences:

### `lateinit`

> **"I will give this property a value later."**

```kotlin
lateinit var name: String

// Later:
name = "Mazharul"
```

### `lazy`

> **"You don't need to create this yet. Create it automatically when I first ask for it."**

```kotlin
val name by lazy {
    "Mazharul"
}
```

---

# 17. `lateinit` Example to Practice

Try this:

```kotlin
class Student {

    lateinit var name: String
    lateinit var university: String

    fun initialize() {
        name = "Mazharul"
        university = "HSTU"
    }

    fun printStudent() {

        if (::name.isInitialized &&
            ::university.isInitialized
        ) {
            println("Name: $name")
            println("University: $university")
        } else {
            println("Student is not initialized")
        }
    }
}

fun main() {

    val student = Student()

    student.printStudent()

    student.initialize()

    student.printStudent()
}
```

Output:

```text
Student is not initialized
Name: Mazharul
University: HSTU
```

---

# Final Rule

```text
lateinit
    ↓
property has no initial value now
    ↓
you promise to initialize it later
    ↓
you manually initialize it
    ↓
then use it
```

And:

```text
lateinit = "I will initialize this later."

lazy = "Initialize this automatically when I first use it."
```
