package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun CoroutineScope.produce() = produce {
    while (true) {
        delay(50)
        send(1)
    }
}

fun main() = runBlocking {
    val produce = produce()
//    select {
    launch {
        delay(5000)
        produce.consumeEach {
            println(it)
        }
    }

    println()
//    }
}
