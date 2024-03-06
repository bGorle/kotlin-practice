package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    coroutineScope {

    }
    val job = doWorkAsync()
    val value1 = job.await()
    println("value1 $value1")

    println()
    println()

    val value2 = async { doWork() }
    println("vlaue2 ${value2.await()}")

    println()
    println("End")
}

fun doWorkAsync(): Deferred<Int> = GlobalScope.async {
    println("Working")
    delay(3000)
    println("Work done")

    return@async 42
}


suspend fun doWork(): Int {
    println("Working")
    delay(3000)
    println("Work Done")

    return 42
}
