// continue

// break

fun main() {
    unlabelledContinue()
    labelledContinue()
}

fun unlabelledContinue() {
    var i = 1

    while(i < 10) {

        if(i == 6) {
            println("Continue statement")
            i++
            continue
        }
        println("Value is: $i")
        i++
    }
}

fun labelledContinue() {
    var i = 1

    outer@ while(i < 5) {
        var j = 1
        inner@ while(j < 5) {

            if(j == 3) {
                println("Continue statement")
                j++
                i++
                continue@outer
            }
            println("Value i = $i and j = $j")
            j++
        }
        i++
    }
}