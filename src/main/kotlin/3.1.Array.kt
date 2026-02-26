// Array in Kotlin

fun main() {
    //creatingArraysUsingArrayOf()
    //creatingArraysUsingConstructor()
    //creatingArraysUsingBuiltInFunction()
    //accessingAndModifyingArray()
    allFunctionsOfArrays()
}

fun creatingArraysUsingArrayOf() {
    // using arrayOf()
        // implicit type declaration
    val arrIm = arrayOf(1, 3, 4, -100, 0, 23)

    for(i in 0..arrIm.size - 1) {
        print(" " + arrIm[i])
    }
    println()
        // explicit type declaration
    val arrEx = arrayOf<Int>(1234, 534, -999, 0, 12345)
    arrEx.forEach { index -> print(" " + index) }
    println()
}

fun creatingArraysUsingConstructor() {
    val arrCons = Array(15, {i -> i*1})
    arrCons.forEach { index -> print(" " + index) }
    println()
    for(i in 0..arrCons.size - 1) {
        print(" " + arrCons[i])
    }
    println()
}

fun creatingArraysUsingBuiltInFunction() {
    val arrBuilt = intArrayOf(12, 34, 56, -345, -897)
    arrBuilt.forEach { index -> print(" " + index) }
    println()
}

fun accessingAndModifyingArray() {
    val arr = arrayOf(1, 4, 5, 9, 10, 34)
    arr.set(3, -9801)
    print(arr.get(3))
}

fun allFunctionsOfArrays() {
    val arr = arrayOf(1101, 3412, 76840,18203, 6765666578, 3412, -20390, 3412)

    // size
    println("The size function: " + arr.size)

    // indices
    for(i in arr.indices) { print(" " + arr[i]) }
    println()

    // Access and Modify
    println("The get function: " + arr.get(2))
    arr.set(2, -99999999)
    println("The get function: " + arr.get(2))

    // conversation
    val arr2 = arrayOf(-1009, 23787890, -28375, 138, 999, 2222)
    arr2.toList()   // array to list
    for(element in arr2) { print(" " + element) }
    println()
    arr2.forEach { element -> print(" " + element) }

        // list to typedArray
    val arr3 = arr2.toIntArray() // list to int array
    val list = listOf(1, 2, 3)  // list declaration
    val arr12 = list.toTypedArray() // list to typed array
    val arr123 = arr12.toList() // array to list

        // searching == return Boolean value
    // val arr = arrayOf(1101, 3412, 76840,18203, 6765666578, 3412, -20390, 3412)
    val value: Boolean = arr.contains(3412)
    println("\n\nThe searching of 3412: $value")

    val id: Int = arr.indexOf(3412)
    println("\n\nThe id of 3412: $id")

    val lastId: Int = arr.lastIndexOf(3412)
    println("\n\nThe lasr id of 3412: $lastId")


        // Sorting
    val arrSort = arrayOf(12, 31, -1, 1000, 12, 5)
    arrSort.sort()
    arrSort.forEach { print(" "+it) } // it means: index -> print(index)
    println()
    arrSort.sorted()
    arrSort.forEach { print(" " + it) }
    println()
    arrSort.sortDescending()
    arrSort.forEach { print(" " + it) }

        // math function
    val arrMath = arrayOf(31, 0, -32, 345, 982, 3910, 0, 45, -2)
    val sum = arrMath.sum()
    val max:Int = arrMath.max()
    val max2 = arrMath.maxOrNull()
    val max3: Int? = arrMath.maxOrNull()
    val min: Int? = arrMath.minOrNull()
    val average = arrMath.average()

    println("\nSum of array: $sum \nAverage of array: $average")
    println("Max: $max   Max2: $max2   Max3: $max3   Min value: $min")

        // Filtering and Mapping
    val arrFilterAndMapping = arrayOf(1, 3, 5, 10, 15, 13, 20, 23)

    val result = arrFilterAndMapping.filter { it > 5}
    result.forEach { print(" " + it) }
    println()

    val result2 = arrFilterAndMapping.map { it * 2}
    result2.forEach { print(" " + it) }

    /*
        important function of array for android development
        size()
        sum()
        sort()
        maxOrNull()
        map()
        filter()
        contains()
        indexOf()
        lastIndexOf()
     */

}
