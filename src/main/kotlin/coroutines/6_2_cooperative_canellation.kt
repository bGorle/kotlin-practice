package org.example.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default

fun main() = runBlocking {

    var child1: Job? = null
    var child2: Job? = null
    var child3: Job? = null
    var child4: Job? = null
    var child5: Job? = null
    var child6: Job? = null
    coroutineScope {
        val job = launch(Default)  {
            child1 = launch {
                repeat(1000) {
                    yield()
                    Thread.sleep(1000)
                    print("1")
                }
            }

            child2 = launch {
                repeat(1000) {
                    if(!isActive) return@launch
                    Thread.sleep(1000)
                    print("2")
                }
            }

            child3 = launch {
                repeat(1000) {
                    Thread.sleep(1000)
                    print("3")
                    if(!isActive) throw CancellationException()
                }
            }

            child4 = launch {
                repeat(1000) {
                    Thread.sleep(1000)
                    print("4")
                    ensureActive()
                }
            }

            child5 = launch {
                try {
                    repeat(1000) {
                        Thread.sleep(1000)
                        print("5")
                        ensureActive()
                    }
                } catch (ex: CancellationException) {
                    println()
                    println("Cancelled : $ex")
                }
            }

            try {
                child6 = launch {
                    repeat(1000) {
                        Thread.sleep(1000)
                        print("5")
                        ensureActive()
                    }
                }
            } catch (ex: CancellationException) {
                println()
                println("Cancelled : $ex")
            }

            repeat(1000) {
                delay(1000)
                print("0")
            }
        }

        delay(4000)
        child6?.cancelAndJoin()

        println()
        println()
        println("Job is cancelled ${job.isCancelled}")
        println("Job is active ${job.isActive}")


        job.join()
    }

    println("Came to end")
}
