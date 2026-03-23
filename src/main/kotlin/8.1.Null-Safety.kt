// Null Safety: In Kotlin does not allow a variable which holds null value unless it is explicit defined.

fun main() {
    nullSafety()
}

fun nullSafety() {
    val strNull: String? = null
    var strNull2: String? = null

    println("Length: ${strNull?.length}")
    println("Length: ${strNull2?.length}")


    // nullable list
    val list2: MutableList<String> = mutableListOf()
    val list: MutableList<String>? = mutableListOf()
    println(list)
    println(list?.size)
    println("Size of List:${list2.size}")


}