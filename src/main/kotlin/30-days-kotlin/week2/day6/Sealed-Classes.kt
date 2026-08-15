/*
    Sealed Classes:
 */

sealed class LoginResult {
    object Loading: LoginResult()
    data class Success(val userName: String): LoginResult()
    data class Error(val message: String): LoginResult()

    fun handleLogin(result: LoginResult) {
        when(result) {
            is LoginResult.Loading -> {}
            is LoginResult.Success -> {}
            is LoginResult.Error -> {}
        }
    }
}

fun handleLogin(result: LoginResult) {
    when(result) {
        is LoginResult.Loading -> {println("Loading......")}
        is LoginResult.Success -> {println("Welcome: ${result.userName}")}
        is LoginResult.Error -> {println("Error: ${result.message}")}
    }
}

fun main() {

}