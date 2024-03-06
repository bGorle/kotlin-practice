package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        var count = 0
        while (true) {
            println("coroutine 1 ${count++}")
        }
    }

    val job2 = launch {
        var count = 700
        while (true) {
            println("coroutine 2 ${count++}")
        }
    }

    job.join()
    job2.join()

    delay(100)

    job.cancel()
    job2.cancel()
}


