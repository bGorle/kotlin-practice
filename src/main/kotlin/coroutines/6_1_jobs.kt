package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = Job()
    val scope = CoroutineScope(parentJob)

    val job = scope.launch {

        println("        Parent job object : $parentJob")
        println("Context object job object : ${coroutineContext[Job]}")
    }

    job.join()
    println("Returned Job obejct $job")

ensureActive()
    println("             Run blocking job: ${coroutineContext.job}")

    val job1 = launch {
        println("           new launch job: ${coroutineContext.job}")

    }
    println("                  job1 object: $job1")

}
