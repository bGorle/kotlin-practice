package flows.state_shared

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun generateInts() = flow {
    var value = 0
    while (true) {
        delay(100)
        //println("emit $value")
        emit(value++)
    }
}

fun main(): Unit = runBlocking {
    val sd = MutableSharedFlow<Int>()
    val sd2 = sd.asSharedFlow()

    val flow = generateInts()
        .shareIn(this, SharingStarted.WhileSubscribed(), 5)

    delay(1000)
    launch {
        flow.collect {
            println("Collected (A) $it")
        }
    }

    delay(2000)

    launch {
        flow.collect {
            println("Collected (B) $it")
        }
    }

}
