/*
    Null Safety
 */

fun main() {
        // 1. Non-nullable

    var teacherName: String = "Rahman"


        // 2. Nullable Types

    var studentName: String? = null
    var studentAge: Int? = null
    var studentMark: Double? = null
    var isLoggedIn: Boolean? = null

        // 3. Safe Call Operator ( ?. )
    println("The length of Teacher Name: ${teacherName?.length}") // when variable might be null
    println("The length of Student Name: ${studentName?.length}") // when variable might be null


        // 4. Elvis Operator ( ?: )

    var newStudentName = teacherName ?: "Abir" // Provide a default value when something is null.
    var length = studentName?.length ?: 0
    var length2 = teacherName?.length ?: 0

        // 5. Not-null Assertion
    var friendName: String? = null
    println("Friend Name: ${friendName!!.length}") // Avoid !! unless you are absolutely certain the value is not null.


        // 6. Safe Case( as? )
    var value: Any = "Kabir"
    var answer = value as? Int
    println("Answer: $answer") // print null



        // 7. Smart Cast
    var childName: String? = "Raihan"

    if(childName != null) {
        println("Child Name: $childName")
    }


        // 8. Safe Call Chain

    safeCallChain()

}

    // class for understanding safe call chain

class Image(
    val url: String
)

class Profile(
    val image: Image?
)

class FacebookUser(
    val profile: Profile?
)

fun safeCallChain() {
        // calling safe call chain
    val user: FacebookUser? = null
    val imageUrl = user?.profile?.image?.url
    println("The ImageUrl: $imageUrl")
}

