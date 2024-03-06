package flows.state_shared

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val flow = generateInts().stateIn(this)

    launch {
        flow.collect {
            println("Collected (A) $it")
        }
    }

    delay(3000)

    launch {
        println("Collected (B) before collector ${flow.value}")

        flow.collect {
            println("Collected (B) $it")
        }
    }
}
