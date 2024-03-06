package channels

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {

    val produce1 = produce {
        var count = 100
        while (true) {
            println("Sending $count")
            send(count++)
        }
    }

    val produce2 = produce {
        var count = 200
        while (true) {
            println("Sending $count")
            send(count++)
        }
    }

    repeat(15) {
        select {
            produce1.onReceive {
                println("Received $it")
            }
            produce2.onReceive {
                println("Received $it")
            }
        }
    }

    produce1.cancel()
    produce2.cancel()
}
