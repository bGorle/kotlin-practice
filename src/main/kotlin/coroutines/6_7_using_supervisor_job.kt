package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = SupervisorJob()
    val coroutineScope = CoroutineScope(parentJob)
    val job = coroutineScope.launch {
        launch {
            while (true) {
                print(1)
                delay(98)
            }
        }

        launch {
            while (true) {
                print(2)
                delay(100)
            }
        }
        coroutineScope.launch {
            delay(2000)
            throw Exception("Dude, we got an exception")
        }
    }

    job.join()
}
