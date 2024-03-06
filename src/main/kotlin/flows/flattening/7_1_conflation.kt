package flows.flattening

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun generateInts() = flow<Int> {
    var count = 0
    while (true) {
        delay(100)
        println("emit $count")
        emit(count++)
    }
}

fun main() = runBlocking {
    generateInts()
        .take(10)
        .conflate()
        .collect {
            delay(200)
            println("Colected $it")
        }
}
