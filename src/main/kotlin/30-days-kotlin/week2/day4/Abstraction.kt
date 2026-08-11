/*
    Abstraction:
 */

abstract class Payment{
    val process: String = "Payment"
    abstract val paymentMethod: String

    fun paymentProcess() {
        println("The payment process is going on")
    }
    abstract fun pay(amount: Double)
}

class BkashPayment: Payment() {
    override val paymentMethod = "Bkash"

    override fun pay(amount: Double) {
        println("Paid $amount using Bkash")
    }
}

class CardPayment: Payment() {
    override val paymentMethod = "Card"

    override fun pay(amount: Double) {
        println("Paid $amount using Card")
    }
}

/// Interface
interface Flyable {
    fun fly()
}

interface Swimable {
    fun swim()
}

class Duck: Flyable, Swimable {
    override fun fly() {
        println("Duck is flying")
    }

    override fun swim() {
        println("Duck is swimming")
    }
}

fun main() {

    val payment = BkashPayment()
    println("${payment.process}")
    payment.paymentProcess()
    println("${payment.paymentMethod}")
    payment.pay(4599.00)

}