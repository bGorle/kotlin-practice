package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.producer1() = produce {
    val count = 100
    send(count)
}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.producer2() = produce {
    val count = 200
    send(count)
}

fun main() = runBlocking {
    val producer1 = producer1()
    val producer2 = producer2()

    repeat(15) {
        val value = select {
            producer1.onReceiveCatching {
                it.getOrNull() ?: "Channel 1 close"
            }
            producer2.onReceiveCatching {
                it.getOrNull() ?: "Channel 1 close"
            }
        }

        println(value)
    }

    println("End main")

    producer1.cancel()
    producer2.cancel()
}