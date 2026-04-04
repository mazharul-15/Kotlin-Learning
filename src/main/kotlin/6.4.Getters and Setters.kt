// getters and setters

class Person3 {
    var age: Int = 0
        set(value) {
            if(value >= 1) {
                field = value
            }
        }

    fun getInfo() {
        println("Age is ${this.age}")
    }
}

fun main() {

    val p1 = Person3()
    p1.age = 12
    p1.getInfo()
}