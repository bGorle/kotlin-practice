package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = SupervisorJob()
    val scope = CoroutineScope(parentJob)
    val job: Job = launch {
        supervisorScope {
            launch {
                repeat(1000) {
                    print("1 ")
                    delay(100)
                }
            }

            launch {
                repeat(1000) {
                    print("2 ")
                    delay(50)
                }
            }

            launch {
                repeat(100) {
                    delay(100)
                    print("3 ")

                    launch {
                        repeat(100) {
                            delay(100)
                            print("3-1 ")
                        }
                    }

                    launch {
                        delay(100)
                        print("3-2 ")
                        throw Exception()
                    }
                }
            }

            launch {
                delay(1000)
                throw Exception()
            }
        }
    }


    delay(5000)
    job.join()

    println()
    println("End")
}