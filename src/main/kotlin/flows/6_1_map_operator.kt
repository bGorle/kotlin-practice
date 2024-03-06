package flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun generateIntsO() = flow {
    var value = 0
    while (true) {
        delay(1000)
        println("emit $value")
        emit(value++)
    }
}

fun main() = runBlocking {
    launch {
        generateIntsO()
            .map { it * 2 }
            .map { "$it * 2" }
            .collect {
            println("Collected $it")
        }
    }

    println()
}