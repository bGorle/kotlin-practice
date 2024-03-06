package channels

import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()
    val jobs = mutableListOf<Job>()

    jobs.add(
        launch {
            for (x in 1..5) {
                println("Sending ${x * x}")
                channel.send(x * x)
            }
            channel.close()
        }
    )


    jobs.add(
        launch {
            delay(2000)
            val value = channel.receive()
            println("Received: $value")

            for (value1 in channel) {
                println("Received: $value1")
            }
        }
    )


    jobs.forEach { it.join() }
}
