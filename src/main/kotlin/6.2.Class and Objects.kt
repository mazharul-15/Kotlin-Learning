// This will contain about class and objects details

class Person {
    var name: String = ""
    var age: Int = 0
    var id: Int = 0

    fun getInfo(): String {
        return "Name: $name Age: $age Id: $id"
    }
}

fun main() {
    val p1 = Person()
    p1.name = "Amjad Ahmmed"
    p1.age = 31
    p1.id = 1801045
    println(p1.getInfo())
}