//import jdk.jfr.internal.tool.View

/*
    Anonymous Object:
 */

/*interface OnclickListener {
    fun onClick(v: View?)
}*/

interface User3 {
    val name: String
    fun show()
}

fun main() {


    // user interface
    val user = object: User3 {
        override val name: String = "Admin"
        override fun show() {
            println("Name is: $name")
        }
    }

    user.show()
}

