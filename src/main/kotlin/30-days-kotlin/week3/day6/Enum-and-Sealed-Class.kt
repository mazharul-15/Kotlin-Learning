/*
    Enum Class
    Sealed Class
 */

// Enum class
enum class Direction {
    NOTRH,
    SOUTH,
    EAST,
    WEST
}

enum class OrderStatus {
    PENDING,
    CONFIRMED,
    DELIVERED,
    CANCELLED
}

enum class ScreenMode {
    VIEW,
    EDIT
}

enum class UserRole {
    ADMIN,
    USER,
    GUEST
}



// Sealed class //
sealed class ApiState {
    data object Loading: ApiState()

    data class Success(
        val student: List<String>
    ): ApiState()

    data class Error(
        val message: String
    ): ApiState()
}





fun main() {
  // creating an enum
    val direction = Direction.NOTRH
    when(direction) {
        Direction.EAST -> println("East")
        Direction.WEST -> println("West")
        Direction.NOTRH -> println("North")
        Direction.SOUTH -> println("South")
    }

    val orderStatus = OrderStatus.DELIVERED
    when(orderStatus) {
        OrderStatus.PENDING -> println("Pending")
        OrderStatus.CONFIRMED -> println("Confirmed")
        OrderStatus.DELIVERED -> println("Delivered")
        OrderStatus.CANCELLED -> println("Cancelled")
    }

    val screenMode = ScreenMode.VIEW
    when(screenMode) {
        ScreenMode.VIEW -> {
            println("View Mode")
            // show ui in view mode
        }
        ScreenMode.EDIT -> {
            println("Edit Mode")
            // show ui in edit mode
        }
    }

    val userRole = UserRole.GUEST


    // sealed class
    val apiState = ApiState.Success(listOf("Abir", "Arman", "kabir"))

    when(apiState) {
        ApiState.Loading -> {
            println("Loading.....")
            // show progress bar
        }

        is ApiState.Success -> {
            println(apiState.student)
        }

        is ApiState.Error -> {
            println(apiState.message)
        }
    }

}

fun showScreen(userRole: UserRole) {
    when(userRole) {
        UserRole.ADMIN -> {
            // Admin dashboard
        }
        UserRole.USER -> {
            // User dashboard
        }
        UserRole.GUEST -> {
            // Login screen
        }
    }
}