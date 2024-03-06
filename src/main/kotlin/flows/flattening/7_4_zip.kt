package flows.flattening

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun generateRandomInts() = flow {
    val random = Random(100)
    while (true) {
        val value = random.nextInt(30)
        delay(1000)
        println("emit random $value")
        emit(value)
    }
}

fun main() = runBlocking {
    flows.generateInts()
        .take(5)
        .zip(generateRandomInts()) { a ,b -> "$a, $b"}
        .collectLatest {
            println("Collected $it")
        }
}