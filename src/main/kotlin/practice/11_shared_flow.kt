package practice

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sharedFlow = MutableSharedFlow<Int>()
    val job = launch {
        repeat(10) {
            delay(100)
            sharedFlow.emit(it)
        }
    }

    val job2 = launch {
        delay(300)
        sharedFlow.collect() {
            println(it)
        }

        delay(2000)
        sharedFlow.replayCache.forEach {
            println(it)
        }
    }

    job.join()
    job2.join()

    println()
}
