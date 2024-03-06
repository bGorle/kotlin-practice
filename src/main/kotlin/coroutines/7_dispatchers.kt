package org.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Unconfined
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

val scope = CoroutineScope(Job())

val customDispatcher: ExecutorCoroutineDispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
val customExecutor: ExecutorService = Executors.newFixedThreadPool(10)

fun main() = runBlocking {
//    println("'run blocking': In thread ${Thread.currentThread().name}")

    val jobs = arrayListOf<Job>()

    // With Main scope
     jobsList(jobs, this)

    // Custom scope
//    val job = scope.launch {
//        jobsList(jobs, this)
//    }
//    job.join()
}


suspend fun jobsList(jobs: ArrayList<Job>, scope: CoroutineScope) {
    scope.run {
        jobs += launch {
            delay(100)
            println("'               default': In thread ${Thread.currentThread().name}")
        }

//        jobs += launch(Main) {
//            delay(100)
//            println("'    default dispatcher': In thread ${Thread.currentThread().name}")
//        }

        jobs += launch(Default) {
            delay(100)
            println("'    default dispatcher': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(IO) {
            delay(100)
            println("'         IO dispatcher': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(Unconfined) {
            delay(100)
            println("' Unconfined dispatcher': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(newSingleThreadContext("New Thread")) {
            delay(100)
            println("'newSingleThreadContext': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(customDispatcher) {
            delay(100)
            println("'    cached Thread pool': In thread ${Thread.currentThread().name}")
        }

        jobs += launch(customExecutor.asCoroutineDispatcher()) {
            delay(100)
            println("'     Fixed thread pool': In thread ${Thread.currentThread().name}")
        }
    }

    jobs.forEach {
        it.join()
    }
}
