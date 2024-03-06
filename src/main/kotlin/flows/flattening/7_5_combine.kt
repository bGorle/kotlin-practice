package flows.flattening

import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    var startTime = System.currentTimeMillis()

    generateInts()
        .take(5)
        .zip(generateRandomInts()) {a, b -> a * b }
        .collect {
            println("Collected zip $it at ${System.currentTimeMillis() - startTime}")
        }

    startTime = System.currentTimeMillis()
    generateInts()
        .combine(generateRandomInts()) {a, b -> a * b }
        .collect {
            println("Collected combine $it at ${System.currentTimeMillis() - startTime}")
        }
}
