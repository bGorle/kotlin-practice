package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun consume2(id: Int, coroutineScope: CoroutineScope, producer: ReceiveChannel<Int>) = coroutineScope.launch {
    producer.consumeEach {
        println("Received in consumer id: $id, Received $it in Thread ${Thread.currentThread().name}")
    }
}

fun main() = runBlocking {
    val producer = produceNumbers(this)

    repeat(5) {
        consume2(it, this, producer)
    }

    delay(1500)

    producer.cancel()
}
