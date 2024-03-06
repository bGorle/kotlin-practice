package channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    val producer = launch {
        delay(1000)
        channel.send(1)
    }

    val consumer = launch {
        val data = channel.receive()
        println("Received: $data")
    }

    producer.join()
    consumer.join()
}
