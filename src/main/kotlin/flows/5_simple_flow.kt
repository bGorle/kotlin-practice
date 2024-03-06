package flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.take

fun generateInts() = flow<Int> {
    var count = 0
    while (true) {
        delay(1000)
        println("emit $count")
        emit(count++)
    }
}.flowOn(Dispatchers.IO)

fun main() = runBlocking {
    val flow = generateInts()
    val job = launch {
        flow.take(5)
            .collect {
                delay(500)
                println("collected $it")

            }
    }

    println()
    val job2 = launch {
        flow.collect {
            println("collected  2 $it")

            if (it == 6) this.cancel() // cancel type 1
        }
    }

    job2.join()
    job.join()

//    delay(5100)
//    job.cancel()     // cancel type 1
}
