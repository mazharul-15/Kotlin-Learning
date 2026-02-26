/*
#1. Data Types:
               Int = Byte(8), Short(16), Int(32), Long(64)
               Float = Float(32), Double(64)
               Boolean = Boolean(1bit) -> true or false
               Char = Char(16) 'C'
               String = String: Sequence of Character
               Array = Array is a collection of same type of its sub-type, Which store
                       in a contiguous memory.
                       arrayof(101, 45, -89, 289)
                       arrayof("C", "ABC", "HGT")

               var X: Char = readLine()!![0]
*/

fun main() {
   // printAllIntDataTypes()
    inputArrayInASingleLine()
}

fun printAllIntDataTypes() {
    var num: Int
    var numf: Float
    var numd: Double
    var x: Char
    var name: String
    var arr = arrayOf(1, 3, 4, 4)
    var arr2 = IntArray(5)

    // input section
    println("Enter Input:")
    num = readLine()!!.toInt()
    numf = readLine()!!.toFloat()
    numd = readLine()!!.toDouble()
    x = readLine()!![0]
    name = readLine()!!

    println("Enter array values:")
    for(i in 0 until 5) {
        arr2[i] = readLine()!!.toInt()
    }

    for(i in 0 until 5) {
        println(arr2[i])
    }
    println("Number are: $num , $numf, $numd")
    println("Character: $x, $name")
}

fun inputArrayInASingleLine() {
    var arr = IntArray(5)
    println("Enter Five Integer values:")
    // input in a single line
    arr = readLine()!!
        .trim()
        .split(" ")
        .map{ it.toInt()}
        .toIntArray()

    for(i in arr) print("$i ")
    print("\n")
    println(arr.size)
}