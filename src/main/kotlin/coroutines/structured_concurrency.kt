package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        launch {
            launch {
                repeat(1000) {
                    print("$it ")
                }
                println()
                println("he he, I am inside")
            }
            println("Launch 2")
        }
        println("Launch 1")

    }

    delay(200)
    job.cancel()

    println()
}
