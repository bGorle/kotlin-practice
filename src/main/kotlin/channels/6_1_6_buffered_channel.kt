package channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val channel = Channel<Int>(4)

    val producer = launch {
        repeat(100) {
            println("Sending $it")
            channel.send(it)
        }
    }

    val consumer = launch {
        println("Consumer starting")
        delay(2000)
        println("Consumer started")

        channel.consumeEach {
            println("Receiving $it on Thread ${Thread.currentThread().name}")
        }
    }

    delay(300)

    println("Canceling producer")
    producer.cancel()

    consumer.join()
}
