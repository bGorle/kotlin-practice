package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
//    version1()
    version2()
}

 fun version1() = runBlocking {
    val job = launch {
        repeat(1000) {
            delay(10)
            print("$it ")
        }
    }

    delay(100)
    job.cancel()
    job.join()

    println()
    println("Done")
}

fun version2() = runBlocking {
    val job = launch {
        repeat(1000) {
            print("$it ")
            Thread.sleep(1)
            delay(1)
        }
    }

    delay(100)
    job.cancelAndJoin()

    println()
    println("Done")
}
