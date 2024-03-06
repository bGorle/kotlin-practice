package org.example.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
//        runWithGlobalScope()
//        println("After Globalscope returned")

        runWithLocalScope()
        println("After Local scope returned")
    }

    println()
    println("Done")
}


suspend fun runWithLocalScope() {
    coroutineScope {
        launch {
            println("Launch 1")
            delay(1000)
            println("Launch 1 End")
        }

        launch {
            println("Launch 2")
            delay(2000)
            println("Launch 2 End")
        }
    }

    println("After global scope finished")
}

suspend fun runWithGlobalScope() {
    GlobalScope.launch {
        println("Launch 1")
        delay(1000)
        println("Launch 1 End")
    }

    GlobalScope.launch {
        println("Launch 2")
        delay(2000)
        println("Launch 2 End")
    }

    println("After global scope finished")
}
