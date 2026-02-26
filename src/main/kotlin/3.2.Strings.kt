/*
#1. String = is a sequence of characters
 */

fun main() {

    stringVariables()
    //arrayString_1D()
    //arrayString_2D()
    //stringAllFunctions()
}

fun stringVariables() {

    val s: String = "Hello World"   // immutable
    val s2 = "Kotlin"   // type inference
    val s3 = ""     // empty string

    // multiple line string
    val s4 = """
        Hello
        World
        It is kotlin 
    """.trimIndent() // to remove the indent of each line
    println("$s\n $s2\n $s3\n $s4")

    //accessing by index of string
    print("Single character from a string: ")
    println(s2[3])

    val strNew = readLine()!!.split(" ").toTypedArray()
    //println(strNew)
    strNew.forEach { print(it + "\n") }
}

fun arrayString_1D() {

    println("Array of String:")
    val strArr = arrayOf("apple", "banana", "palm", "licy")
    for (str in strArr) {
        print("$str ")
    }
    print("\n")

   // 1D array of string declaration

    println("Array of String declaration with input size-3: ")
    val strArr2 = Array(3) {readLine()!!}

    println("Array of String declaration with input size-4: ")
    val strArr3 = Array(4){""}
    for(i in 0 until 4) {
        strArr3[i] = readLine()!!
    }

    for(str in strArr3) {
        print(str +" ")
    }
    print("\n")

    // 1D array : taking input in a single line
    println("Array of String with a single line input size-4: ")
    var strArr4 = Array(4){""}
    strArr4 = readLine()!!
        .trim()
        .split(" ")
        .toTypedArray()

    println(strArr4.joinToString(" "))
}

fun arrayString_2D() {

    println("2D array declaration: ")
    println("Enter row and col: ")
    val rows = readLine()!!.toInt()
    val cols = readLine()!!.toInt()

    val strArr = Array(rows) {Array(cols) {""} }
    for(i in 0 until rows) {
        for(j in 0 until cols) {
            strArr[i][j] = readLine()!!
        }
    }

    for(i in 0 until rows) {
        for(j in 0 until cols) {
            print(strArr[i][j] + " ")
        }
        print("\n")
    }
}

fun stringAllFunctions() {
    // access character
    val strAccess = "I Love Bangladesh!!!"
    println("The [i] function: " + strAccess[7])
    println("The .first function: " + strAccess.first())
    println("The .last function: " + strAccess.last())
    /*
        use case:
            to access certain character
     */

    // length and case conversion
    val str = "I Love Bangladesh!!!"
    println("The length function: " + str.length)
    /*
        use case:
            to find length of a string
     */

    println("Upper Case: ${str.uppercase()}")
    println("Lower Case: ${str.lowercase()}")
    /*
        use case:
            doesn't change the original string
            lowercase:case-insensitive comparison
            uppercase: heading, formating text
     */


    // Sub-string , subSequence and Split
    val strSubSplit = "We Love Bangladesh Very much. Bangladesh is a beautiful country"
    println("The substring function: " + strSubSplit.substring(3, 7))
    println("The subSequence function: " + strSubSplit.subSequence(3, 7))
    /*
        use case:
             start index = included
             end index = excluded
     */
    val splitList = strSubSplit.split(" ")
    for(element in splitList) print(element + " ")
    println()
    /*
        use case:
            Form input
            CSV data
            Query parameters
            multiple separator: str.split(" ", "/")
     */


    // Searching
    val strSearching = "Bangladesh is a great Country and we love Bangladesh!!!"
    println("The contains function: " + strSearching.contains("is"))
    println("The contains function: " + strSearching.contains("IS"))
    println("The contains function: " + strSearching.contains("iS", ignoreCase = true) + "\n")
    /*
        use case:
            Search Bar
            Email Validation: if(Email.contains("@')) { // code }
            Keyword matching
     */

    val s = "Kotlin Programming"
    println("The startsWith function: " + s.startsWith("Ko"))
    println("The startsWith function: " + s.startsWith("lin"))
    println("The startsWith function: " + s.startsWith("KO", ignoreCase = true) + "\n")
    /*
        use case:
            phone number checking: if(phoneNumber.startsWith("+880")) { // code }
            Url checking
            prefix checking
     */
    println("The endsWith function: " + s.endsWith("ing"))
    println("The endsWith function: " + s.endsWith("Prog"))
    println("The endsWith function: " + s.endsWith("ING", ignoreCase = true) + "\n")
    /*
        use case:
            file type checking: if(fileName.endsWith(".mp4")) { // code }
            image/video detection
     */
    println("The indexOf function: " + s.indexOf('P'))
    println("The indexOf function: " + s.indexOf("Prog"))
    println("The indexOf function: " + s.indexOf('p', ignoreCase = true))
    /*
        use case:
            Finds the position (index) of a substring
            Returns → index or -1 if not found
     */

    // Trim
    val str22: String = "  I Love  Bangladesh "
    println("The trim function: " + str.trim())
    println("The trimStart function: " + str.trimStart())
    println("The trimEnd function: " + str.trimEnd())
    /*
        use case:
            removes extra space
            clean EditTex input
     */

    // replace, remove: prefix and suffix
    println("The replace function: " + str22.replace("Love", "Hate"))
    println("The replace function: " + str22.replace("love", "Hate", ignoreCase = true))
    /*
        use case:
            to replace exist to new one
     */
    var strRemove: String = "Iam Love YOU"
    println("The removePrefix function: " + strRemove.removePrefix("Iam"))
    println("The removeSuffix function: " + strRemove.removeSuffix("YOU"))

    // checking
    val str23 = "LifeIsFullProblems"
    println("The isEmpty function: " + str23.isEmpty())
    println("The isNotEmpty function: " + str23.isNotEmpty())
    /*
        use case:
            check Empty or Not
     */
    println("The all{} function: " + str23.all { it.isDigit() })
    println("The all{} function: " + str23.all{ it.isLetter() }) // it gives false because: str23 contains space
    /*
        use case:
            return: true = if all match and false = if anyone not match
            OTP validation
            name validation
     */
    println("The any{} function: " + str23.any{ it.isLetter() })
    /*
        use case:
            returns: true = if anyone match and false = if all not match
     */

    // join and repeat
    val str24 = arrayOf(1, 2, 4)
    println("The joinToString function: " + str24.joinToString(""))
    println("The repeat function: " + "*".repeat(4))
    /*
        use case:

     */

    // take and drop
    val str54 = "I want tosee every things in my life"
    val subStr = str54.substring(2, 6)
    val strTake = str54.take(10)
    val strDrop = str54.drop(10)
    println("The take function: " + strTake)
    println("The drop function: " + strDrop)

    // equals
    val strEqual = "I want to go"
    val strEqual2 = "I want to go"
    println("The equals function: " + strEqual.equals(strEqual2))
    /*
        use case:
            return: ture if s1 === s2 or false if s1 is not equal to s2
     */

    // compareTo
    val strComp1 = "Love"
    val strComp2 = "Love"
    println("The compareTo function: " + strComp1.compareTo(strComp2))
    val result = if(strComp1 == strComp2) {
        true
    }
    else {
        false
    }
    println("The == function: " + result)
    /*
        use case:
            if string1 > string2, it returns positive number
            if string1 < string2, it returns negative number
            if string1 == string2, it returns 0
     */

    // multiline string
    val strMultiline = """
        |I
        |Love
        |You
        |Jan
    """.trimMargin()
    val strMultiline2 = """
        I
        Love
        You
        Jan
    """.trimIndent()

    println("The multiline string with trimMargin function: " + strMultiline)
    println("The multiline string with trimIndent function: " + strMultiline2)

    /*
        first()
        last()
        length
        uppercase()
        lowercase()
        substring()
        split()
        contains()
        startsWith()
        endsWith()
        indexOf()
        take(n)
        drop(n)
        equals()
        trim()
        trimStart()
        trimEnd()
        replace()
        removePrefix()
        removeSuffix()
        isEmpty()
        isNotEmpty()
        all{ it.isDigit() }
        any{ it.isLetter() }
        joinToString()
        repeat(n)
        trimIndent()
        trimMargin()

        ignoreCase = true / false
     */
}