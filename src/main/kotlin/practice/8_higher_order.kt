package practice

fun main() {
    val value = calculate(5, 6) { a, _ -> a * a }
    val value2 = calculate(5, 6, ::sum)
    println(value)
    println(value2)
}

fun calculate(a: Int, b: Int, func: (Int, Int) -> Int): Int {
    return func(a, b)
}

fun sum(a: Int, b: Int) = a + b
