package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    coroutineScope {
        launch {
            doWork2(1)
        }

        launch {
            doWork2(2)
        }
    }

    println()
    println("Ended")
}

suspend fun doWork2(i: Int) {
    while (true) {
        print(i)
        delay(200)
    }
}
