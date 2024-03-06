package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun generateIntsMultipleFlow() = flow {
    var count = 0
    while (true) {
        delay(1000)
        println("emit $count")
        emit(count++)
    }
}

fun main() = runBlocking {
    val job = launch {
        generateIntsMultipleFlow().collect {
            println("Collected (A) $it")
        }
    }

    delay(5100)

    launch {
        generateIntsMultipleFlow().collect {
            println("Collected (B) $it")
        }
    }

    delay(2000)
    job.cancel()



}
