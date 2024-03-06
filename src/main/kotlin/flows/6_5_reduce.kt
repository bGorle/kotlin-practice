package flows

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val value = generateInts()
        .take(5)
        .reduce { a, b -> a * b }

    println("Final Value: $value")


    val value2 = generateInts()
        .drop(1)
        .take(5)
        .fold(1) { a, b -> a * b }

    println("Final Value2: $value2")
}