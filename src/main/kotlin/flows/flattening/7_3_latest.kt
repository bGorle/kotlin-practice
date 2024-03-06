package flows.flattening

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flows.generateInts()
        .take(10)
        .collectLatest {
            println("Collecting $it")
            delay(300)
            println("Collected $it")
        }
}
