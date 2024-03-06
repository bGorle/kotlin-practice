package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job1: Deferred<Int> = doWorkAsync()
    val job2: Deferred<Int> = async { doWork() }

    println("value1 ${job1.await()}")
    println("In middle")
    println("value2 ${job2.await()}")

    println()
}


