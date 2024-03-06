package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        generateInts()
            .take(3)
            .collect {
                println("Collected (A) $it")
            }
    }

    launch {
        generateInts()
            .takeWhile { it < 10 }
            .collect {
                println("Collected (B) $it")
            }
    }

    delay(15000)
    println("End")
}