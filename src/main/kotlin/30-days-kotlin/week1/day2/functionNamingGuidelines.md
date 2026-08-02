# Function Naming in Kotlin

> Writing good function names is an important programming skill. A well-named function makes code easier to read, understand, maintain, and debug. In Kotlin, function names should clearly describe **what the function does**, not **how it does it**.

---

# Why is Function Naming Important?

Imagine reading the following code:

```kotlin
abc()
```

Can you guess what `abc()` does?

Probably not.

Now compare it with:

```kotlin
calculateTotalPrice()
```

Without reading its implementation, you already know its purpose.

**Good function names make your code self-documenting.**

---

# General Rules

## Rule 1: Use Meaningful Names

A function name should clearly describe its purpose.

✅ Good

```kotlin
fun calculateSalary()
fun printStudent()
fun findMaximum()
fun sendEmail()
```

❌ Bad

```kotlin
fun abc()
fun data()
fun work()
fun test()
```

---

## Rule 2: Start with a Verb

A function performs an action, so its name should usually begin with a verb.

Common verbs:

- calculate
- print
- display
- show
- hide
- get
- set
- find
- search
- create
- update
- delete
- save
- load
- read
- write
- check
- validate
- convert
- send
- open
- close
- fetch
- navigate

Examples

```kotlin
fun calculateTax()

fun printResult()

fun saveStudent()

fun updateProfile()

fun deleteFile()

fun sendNotification()
```

---

## Rule 3: Use camelCase

Kotlin follows **lower camelCase**.

✅ Correct

```kotlin
calculateTotalPrice()

findMaximumNumber()

saveStudent()

sendEmail()
```

❌ Incorrect

```kotlin
CalculateTotalPrice()

calculate_total_price()

calculate-total-price()
```

---

## Rule 4: Describe What, Not How

A function name should explain **what it does**, not **how it works**.

❌ Bad

```kotlin
fun loopThroughArrayAndPrintNames()
```

✅ Good

```kotlin
fun printNames()
```

The implementation details belong inside the function.

---

## Rule 5: Keep Names Concise

Choose the shortest name that clearly describes the purpose.

Instead of

```kotlin
fun calculateTheTotalPriceOfAllProducts()
```

Prefer

```kotlin
fun calculateTotalPrice()
```

---

## Rule 6: One Function = One Responsibility

A function should perform only one task.

Good

```kotlin
fun calculateSalary()
```

Bad

```kotlin
fun calculateSalaryAndPrintAndSaveDatabase()
```

---

# Boolean Function Naming

Functions returning `Boolean` should sound like questions.

Common prefixes

- is
- has
- can
- should

Examples

```kotlin
fun isPrime()

fun isLoggedIn()

fun isEmpty()

fun hasPermission()

fun canVote()

fun shouldRetry()
```

Usage

```kotlin
if (isLoggedIn()) {
    println("Welcome")
}
```

This reads naturally.

---

# Function Naming by Purpose

| Purpose | Recommended Prefix |
|----------|--------------------|
| Print | print |
| Display UI | show |
| Hide UI | hide |
| Get Value | get |
| Set Value | set |
| Calculate | calculate |
| Find | find |
| Search | search |
| Check Boolean | is |
| Validate | validate |
| Save | save |
| Update | update |
| Delete | delete |
| Create | create |
| Load | load |
| Read | read |
| Write | write |
| Convert | convert |
| Send | send |
| Open | open |
| Close | close |
| Fetch from API | fetch |
| Navigate Screen | navigate |

---

# Examples

## Printing

```kotlin
fun printName()

fun printStudent()

fun printInvoice()
```

---

## Finding

```kotlin
fun findMax()

fun findStudent()

fun findUserById()
```

---

## Calculating

```kotlin
fun calculateSalary()

fun calculateCircleArea()

fun calculateAverage()
```

---

## Saving

```kotlin
fun saveUser()

fun saveStudent()

fun saveProfile()
```

---

## Updating

```kotlin
fun updateProfile()

fun updatePassword()
```

---

## Deleting

```kotlin
fun deleteStudent()

fun deleteAccount()

fun deleteFile()
```

---

## Validation

```kotlin
fun validateEmail()

fun validatePassword()

fun validateInput()
```

---

## Loading

```kotlin
fun loadUsers()

fun loadImage()

fun loadProducts()
```

---

## Fetching

```kotlin
fun fetchUsers()

fun fetchWeather()

fun fetchNews()
```

---

# Android Examples

Android projects commonly contain functions like:

```kotlin
fun validateInput()

fun calculateTotalPrice()

fun saveUser()

fun updateProfile()

fun fetchUsers()

fun deleteAccount()

fun showToast()

fun hideKeyboard()

fun openSettings()

fun navigateToHome()

fun loadImage()

fun sendNotification()
```

---

# Avoid Redundant Words

Suppose you have:

```kotlin
fun saveStudent(student: Student)
```

Avoid

```kotlin
fun saveStudentInfo(student: Student)
```

Because a `Student` object already contains the student's information.

Similarly,

Instead of

```kotlin
fun calculateArea()
```

Prefer

```kotlin
fun calculateCircleArea()

fun calculateRectangleArea()

fun calculateTriangleArea()
```

This makes the function's purpose clear.

---

# A Simple Formula

Think of a function name as:

**Verb + Object**

Examples

```text
print + Name
= printName()

calculate + Salary
= calculateSalary()

save + Student
= saveStudent()

delete + File
= deleteFile()

validate + Email
= validateEmail()

find + Maximum
= findMax()
```

---

# Best Practices

✅ Use meaningful names

✅ Start with a verb

✅ Follow camelCase

✅ Keep names concise

✅ Describe what the function does

✅ Use `is`, `has`, `can`, or `should` for Boolean functions

✅ One function should perform one task

---

# Common Beginner Mistakes

❌

```kotlin
fun abc()
```

✅

```kotlin
fun calculateSalary()
```

---

❌

```kotlin
fun work()
```

✅

```kotlin
fun saveUser()
```

---

❌

```kotlin
fun calculateArea()
```

(When multiple shapes exist)

✅

```kotlin
fun calculateCircleArea()
```

---

❌

```kotlin
fun saveStudentInfo()
```

✅

```kotlin
fun saveStudent()
```

---

# Quick Revision

- Function names should explain **what** the function does.
- Start function names with a **verb**.
- Use **lower camelCase**.
- Boolean functions should begin with **is**, **has**, **can**, or **should**.
- Keep names short, meaningful, and descriptive.
- Avoid unnecessary or redundant words.
- Follow the **Verb + Object** naming pattern.

---

# Interview Tip

When interviewers review your code, they don't only check if it works—they also evaluate **how readable and maintainable** it is.

Good naming demonstrates:

- Clean coding practices
- Professionalism
- Communication skills
- Maintainability

> **"Code is read far more often than it is written."** — *Robert C. Martin (Uncle Bob)*