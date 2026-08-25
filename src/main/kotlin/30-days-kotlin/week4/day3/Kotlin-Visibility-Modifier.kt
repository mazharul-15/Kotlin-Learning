/*
   Kotlin Visibility Modifier
 */

class BankAccount() {
    // public
    val name: String = "Abir"
    private val password: String = "e@bnAiQ84@d"
    private var balance: Double = 500000.00

    fun showPassord() {
        println("The password is: $password")
    }

    fun getBalance(): Double {
        return balance
    }

    fun depositBalance(amount: Double) {
        if(amount > 0) {
            balance += amount
        }
    }

    fun withdrawBanlance(amount: Double): String {
        if(amount <= balance) {
            balance -= amount
            return "succesfully has been withdraw"
        } else {
            return "Invalid amount!!"
        }
    }
}

fun main() {

    val bankAccount = BankAccount()
    bankAccount.showPassord()
}