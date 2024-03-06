package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = coroutineScope {
    produce {
        for (x in 1..5) {
            println("Sending ${x * x}")
            send(x * x)
        }
    }
}

fun main() = runBlocking {
    val receiveChannel: ReceiveChannel<Int> = produceSquares()
    receiveChannel.consumeEach {
        println("Received $it")
        println(it)
    }

    println("End")
}
