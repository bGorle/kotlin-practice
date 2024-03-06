package flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun generateIntsContext() = flow {
    var value = 0
    while (true) {
        delay(1000)
        println("emit $value on Thread ${Thread.currentThread().name}")
        emit(value++)
    }
}.flowOn(Dispatchers.IO)

fun main() = runBlocking {
    launch {
        generateIntsContext().collect {
            println("Collected $it on Thread ${Thread.currentThread().name}")
        }
    }

    println()
}