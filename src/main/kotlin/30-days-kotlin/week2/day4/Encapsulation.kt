/*
    Encapsulation: hiding data from outside
 */

class BankAccount(
    private val accountNumber: String,
    private var balance: Double
) {
    fun deposit(amount: Double) {
        if(amount < 0) {
            println("Invalid amount!!")
            return
        }
        else {
            this.balance += amount
        }
    }

    fun withdraw(amount: Double) {
        if(amount < 0) {
            println("Invalid amount")
            return
        }
        else if(amount > this.balance) {
            println("Insufficient balance")
        }
        else {
            this.balance -= amount
        }
    }

    fun balanceShow() {
        println("Balance: ${this.balance}")
    }
}

// only read from outside
class BankAccount2{
    lateinit var  accountNumber: String
    var balance: Double = 0.0
    private set
}




fun main() {
    val account = BankAccount(
        "123434520945",
        5000000.00
    )

    account.balanceShow()
    account.deposit(45000.00)
    account.withdraw(100000.00)
    account.balanceShow()

    // only read from outside
    val account2 = BankAccount2()
    println("Read only outside: ${account2.balance}")
}