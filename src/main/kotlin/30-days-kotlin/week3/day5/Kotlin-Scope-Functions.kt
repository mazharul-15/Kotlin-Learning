/*
    Kotlin Scope Functions
 */
class Student90(
    val name: String,
    val age: Int
){
    fun showInfo() {
        println(this.name)
        println(this.age)
    }
}

fun main() {
    // let
    val name: String? = null
    name?.let {
        println("$name")
    }

    val student90 = Student90("Abir", 25)
    student90.let {
        println(it.name)
        println(it.age)
    }
    val result = student90.let {   // let returns the value
        it.age
    }

    // run
    student90.run {
        println(this.name)
    }
        //or
    student90.run {
        println(name)
        println(age)
    }

    name?.run {
        println(name)
    }

    // with
    with(student90) {
        println(name)
        println(age)
    }

    // apply
    val answer = student90.apply {
        println(this.name)
    }
    println(answer.name)

    // also
    val answer2 = Student90("Abir", 50).also {
        println(it.name)
    }


}