/*
    Input function: Scanner Class
                    readline() method
 */

// import scanner class
import java.util.Scanner

fun main() {
    //inputFunction()
    //arrayInputFunction()
    //charAndCharArrayInputFunction()
    stringInputFunction()
    //outputFunction()
}

fun inputFunction() {
    // Scanner Class
    val scanner = Scanner(System.`in`)
    // use shift + F6 for changes the all names
    var num1: Int = scanner.nextInt()
    var num2: Float = scanner.nextFloat()
    var num3: Double = scanner.nextDouble()
    var bolNum: Boolean = scanner.nextBoolean()
    var strName: String = scanner.nextLine()
    scanner.nextLine()
    var strName2: String = scanner.next()
    scanner.nextLine()
    var chr: Char = scanner.nextLine()[0]

    /*
           if u take two or more   string or character input from keyboard use skipping
           readLine()

     */

    // skiping
    var x1 = scanner.nextInt()
    //scanner.nextLine()
    readLine()
    var str4 = scanner.nextLine()


    // readline function
    var num4: Int = readLine()!!.toInt()
    var num5: Float = readLine()!!.toFloat()
    var num6: Double = readLine()!!.toDouble()
}

fun arrayInputFunction() {
    val size: Int = 5
    val arr = IntArray(size)
    println("Enter the array input:")
    for(i in 0 until  size) {
        arr[i] = readLine()!!.toInt()
    }

    for(number in arr) {
        print("$number ")
        //println(number)
    }
    print("\n")
    println("input ok")

    println("Input using while loop:")
    var i = 0
    val sz = 5
    val arr2 = IntArray(sz)
    var len = arr2.size

    while(i < len) {
        arr2[i] = readLine()!!.toInt()
        i++
    }

    println("Array input in a single line: ")
    var arr3 = IntArray(5)
    arr3 = readLine()!!
        .trim()
        .split(" ")
        .map{it.toInt()}
        .toIntArray()
    for(number in arr3) {
        print("$number ")
    }
    print("\n")
}

fun charAndCharArrayInputFunction() {
    // single character
    //val ch: Char = readLine()!![0]
    //println("Single Character: $ch")

    // 1D Character Array = Character List
    val chArray1: CharArray = readLine()!!.toCharArray()
    println(chArray1)

    val chArray = CharArray(5) // can store five characters
    for(i in 0 until 5) {
        chArray[i] = readLine()!![0]
    }
    println(chArray.joinToString(" "))
    println(chArray.joinToString(""))

    // 2D Character Array = Matrix or Table of Character
    val chArray2D = Array(2){ CharArray(3) }
    for(i in 0 until 2) {
        for(j in 0 until 3) {
            chArray2D[i][j] = readLine()!![0]
        }
    }

    for(i in 0 until 2) {
        for(j in 0 until 3) {
            print(chArray2D[i][j] + " ")
        }
        print("\n")
    }

    // taking input in one line
    for(i in 0 until 2) {
        chArray2D[i] = readLine()!!.toCharArray()
    }

    for(i in 0 until 2) {
        println(chArray2D[i].joinToString(""))
    }
}

fun stringInputFunction() {
    // single string
    val str: String = "Hello"

    // 1D String Array = List of Strings
    val str1D = Array(3){""}
    for(i in 0 until 3) {
        str1D[i] = readLine()!!
    }
    println(str1D.joinToString(" "))

    // another way of taking input of 1D string Array
    val str1D1: Array<String> = readLine()!!.split(" ").toTypedArray()
    println(str1D1.joinToString(" "))

    // 2D String = Matrix or Table of Strings
    val str2D = Array(2){Array(2){""} }
    for(i in 0 until 2) {
        for(j in 0 until 2) {
            str2D[i][j] = readLine()!!
        }
    }

    for(i in 0 until 2) {
        println(str2D[i].joinToString(""))
    }

}
fun outputFunction() {
    print("I am Bangladeshi!!!")
    println("I am Bangladeshi!!!")
}