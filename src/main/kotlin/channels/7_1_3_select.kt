package channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.producer() = produce<Int> {
    var count = 1;
    while (true) {
        delay(10)
        send(count++)
    }
}

fun main() = runBlocking {
    val producer = producer()

    repeat(10) {
        select {
            producer.onReceive {
                println(it)
            }
        }
    }


    delay(100)
    producer.cancel()
}
