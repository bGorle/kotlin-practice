package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach

suspend fun produceNumbers(coroutineScope: CoroutineScope, channel: Channel<Int>, delay: Long) = coroutineScope.launch {
    var x = delay.toInt()
    while (true) {
        //println("Sending $x in Thread ${Thread.currentThread().name}")
        channel.send(x++)
        delay(delay)
    }
}

fun consume3(coroutineScope: CoroutineScope, producer: ReceiveChannel<Int>) = coroutineScope.launch {
    producer.consumeEach {
        println("Received $it in Thread ${Thread.currentThread().name}")
    }
}

fun main() = runBlocking<Unit> {
    val channel = Channel<Int>()
    produceNumbers(this, channel, 500)
    produceNumbers(this, channel, 200)
    produceNumbers(this, channel, 100)

    consume3(this, channel)

    delay(10000)

    channel.cancel()
}