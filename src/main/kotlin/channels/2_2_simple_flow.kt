package channels

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val generateInts = flow {
    var count = 0
    while(true) {
        delay(400)
        emit(count++)
    }
}.map {
    it.toString()
}

fun main() = runBlocking {
    launch {
        generateInts.collect {
            println("Received $it")
        }
    }

    println()
}