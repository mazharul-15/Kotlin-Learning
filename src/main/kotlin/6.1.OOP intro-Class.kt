/*
    OOP = A way of writing code where everything is organised in one place ( data + behavior) as
          a real world object
*/

class Car(val carName: String, val carBrandName: String) {
    fun start() {
        println("$carName is started")
    }

    fun stop() {
        println("$carName is stopped")
    }
}


fun main() {
    val car1 = Car("Fielder", "Toyota")
    car1.start()
    car1.stop()
}