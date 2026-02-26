/*
#1. Val & Var: variable like high school math variable that contains value.
    val = immutable: can not be changed-> constant value and immutable
    var = mutable: can be changed by defining various value or taking input from keyboard
*/

fun main() {

    // Integer type  variables
    val num1 = 101
    val num2: Int = 101
    var num3: Int

    // Float & Double
    val numf1 = 102.1234f
    val numf2: Float = 102.10456f
    var numf3: Float

    val numd1 = 89556.1234
    val numd2: Double = 89556.123456
    var numd3: Double

    // Boolean
    val bol1 = false
    val bol2: Boolean = true
    var bol3: Boolean ? = null

    // Char & String
    val ch1 = 'C'
    val Ch2: Char = 'C'
    var ch3: Char

    val str1 = "" // empty String
    val str2 = "Zuckerburg"
    val str3: String = "Australia Higher Study"
    var str4: String



    // Int Array
            // 1D
    val arr1 = arrayOf(10, 12, 14, 16, 18, 20)
    val arr2 = IntArray(5) // init value: 0 0 0 0 0
    val arr3 = IntArray(20) // init value: 0 0 0 0 0 .... 0
    val arr10 = intArrayOf(10, 10, 123, 313, 408)

            // 2D
    val rows = 3
    val cols = 4
    val arr4 = Array(rows) {IntArray(cols)}
    /*
        initialization values:
         0 0 0 0
         0 0 0 0
         0 0 0 0
     */

    // Float Array
    val arrf2 = floatArrayOf(1.2f, 4.5f, 6.7f)
    val arrf1 = FloatArray(3) // init value: 0.0, 0.0, 0.0

    val arrf3 = Array(3){ FloatArray(3) }
        /*
            0.0, 0.0, 0.0
            0.0, 0.0, 0.0
            0.0, 0.0, 0.0
         */

    // Double Array
    val arrd1 = doubleArrayOf(1.4, 1.4, 11.5)
    val arrd2 = DoubleArray(3)  // 0.0, 0.0, 0.0

    val arrd3 = Array(3) { DoubleArray(3) }
        /*
            0.0, 0.0, 0.0
            0.0, 0.0, 0.0
            0.0, 0.0, 0.0
         */

    // Char Array
    val arrChr = CharArray(3) // '\u0000' (null character)
    val arrChr2 = Array(2){ CharArray(3) } // all cells init by '\u0000' (null character)


    // String Array
    val arrStr1 = arrayOf("mn", "AUS", "prog")
    val arrStr2 = Array(3){""}  // {"", "", ""}

    val arrStr3 = Array(2){Array(3){""} }
        /*
            "", "", ""
            "", "", ""
         */

    // Boolean Array
    val arrBool3 = arrayOf(false, false, true, true, false)
    val arrBol4 = booleanArrayOf(false, true, true)
    val arrBool = BooleanArray(3)   // false, false, false
    val arrBool2 = Array(2) { BooleanArray(3) }
        /*
            false, false, false
            false, false, false
         */
}