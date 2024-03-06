package flows

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        generateInts()
            .transform {
                emit(it)
            }.collect {
                println("Collected (A) $it")
                if (it == 5) this.cancel()
            }
    }
    delay(5000)
    job.cancel()


    val job2 = launch {
        generateInts()
            .transform {
                emit(it * 2)
            }.collect {
                println("Collected (B) $it")
            }
    }
    delay(5000)
    job2.cancel()

    val job3 = launch {
        generateInts()
            .transform {
                if (it % 2 == 0) {
                    emit(it * 1)
                    emit(it * 2)
                    emit(it * 3)
                }
            }.collect {
                println("Collected (C) $it")
            }
    }

    delay(5000)
    job3.cancel()


}