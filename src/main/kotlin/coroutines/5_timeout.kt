package org.example.coroutines

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    try {
        withTimeout(500) {
            repeat(1000) {
                print("$it ")
                delay(10)
            }
        }
    } catch (ex: TimeoutCancellationException) {
        println()
        println("Timeout error ${ex.message}")
    }
}
