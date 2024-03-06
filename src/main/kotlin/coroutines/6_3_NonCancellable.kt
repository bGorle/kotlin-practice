package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch {
        try {
            repeat(1000) {
                print("0")
                delay(1)
                Thread.sleep(1)
            }
        } catch (ex: CancellationException) {
            println()
            println("Exception : $ex")
            withContext(NonCancellable) {
                reportError()
            }
        }
    }

    delay(100)
    job.cancelAndJoin()
}

suspend fun reportError() {
    println("Reporting error")
    try {
        delay(1000)
    } catch (ex: CancellationException) {
        println()
        println("Inside suspend Exception : $ex")
    }
    println("Reported error")
}

