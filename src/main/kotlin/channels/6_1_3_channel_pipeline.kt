package channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.*

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun produceNumbers(coroutineScope: CoroutineScope): ReceiveChannel<Int> = coroutineScope.produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100)
    }
}


@OptIn(ExperimentalCoroutinesApi::class)
suspend fun <T, R> ReceiveChannel<T>.map(
    coroutineScope: CoroutineScope,
    transform: (T) -> R
): ReceiveChannel<R> {
    val receiveChannel = this
    return coroutineScope.produce {
        try {
            for (value in receiveChannel) {
                send(transform(value))
            }
        } catch (ex: CancellationException) {
            receiveChannel.cancel( )
        }
    }
}

fun consume(coroutineScope: CoroutineScope, producer: ReceiveChannel<Int>) = coroutineScope.launch {
    producer.consumeEach {
        println("Received $it")
    }
}

fun main() = runBlocking {
    val producer = produceNumbers(this).map(this) { value ->
        value * value * value
    }
    consume(this, producer)

    delay(1100)

    producer.cancel()
}
