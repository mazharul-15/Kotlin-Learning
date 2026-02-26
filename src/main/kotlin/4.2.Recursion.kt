// Recursion::


fun main()
{
    printOneToN(5)
}

fun printOneToN(n: Int)
{
    if(n == 0) return
    printOneToN(n-1)
    println(n)
}