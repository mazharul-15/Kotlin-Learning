/*

 */

fun main() {
    ifElseExp()
    ifElseAsTernaryOperator()
    ifElseLadder()
    nestedIfElse()
}

fun ifElseExp() {
    val x = 10
    val y = 15

    if(x > y){
        println("$x is bigger!!")
    }
    else{
        println("$y is smaller!!")
    }
}

fun ifElseAsTernaryOperator(){
    val x = 45
    val y = 23
    val max = if(x > y){
        println("Here $x is bigger!!")
        x
    }
    else{
        println("Here $y is smaller!!")
        y
    }
    println("The Answer is : $max")

    val a = 13
    val b = 12
    val c = 15
    val max2 = if(a < b){
        if(b < c){
            println("$c is the max number!!!")
            c
        }
        else{
            println("$b is the max number!!!")
            b
        }
    }
    else{
        if(a > c){
            println("$a is the max number!!!")
            a
        }
        else{
            println("$c is the max number!!!")
            c
        }
    }
    println("The max2 is : $max2")
}

fun ifElseLadder() {
    val x = 10
    val y = 12
    val z = 15
    if(x > y){
        println("$x is bigger")
    }
    else if(x == y){
        println("$x and $y are equal!!")
    }
    else if(x == z){
        println("$x ans $z are equal!!")
    }
    else if(x > z){
        println("$x is bigger!!!")
    }
    else{
        println("$x is really smaller!!!")
    }
}

fun nestedIfElse() {
    val a = 13
    val b = 12
    val c = 15
    if(a < b){
        if(b < c){
            println("$c is the max number!!!")
        }
        else{
            println("$b is the max number!!!")
        }
    }
    else{
        if(a > c){
            println("$a is the max number!!!")
        }
        else{
            println("$c is the max number!!!")
        }
    }
}