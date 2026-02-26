// break

fun main() {
    unlabelledBreak()
    labelledBreak()
}

fun unlabelledBreak() {
    var i = 1

    while(i < 10) {
        println("Value is: $i")
        if(i == 6) {
            break
        }
        i++
    }
}

fun labelledBreak() {
    var i = 1

    outer@ while(i < 5) {
        var j = 1
        inner@ while(j < 5) {
            println("Value i = $i and j = $j")
            if(j == 3) {
                break@outer
            }
            j++
        }
        i++
    }
}