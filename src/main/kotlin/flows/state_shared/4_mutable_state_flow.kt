package flows.state_shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val counter = Counter()
    launch {
        while (true) {
            println("1 Running on ${Thread.currentThread().name}")
            counter.increment()
            delay(1000)
        }
    }

    launch(Dispatchers.IO) {
        while (true) {
            println("2 Running on ${Thread.currentThread().name}")
            counter.increment()
            delay(100)
        }
    }

    delay(5000)

    launch {
        counter.count.collect {
            println("Collected $it on ${Thread.currentThread().name}")
        }
    }

    println()
}

class Counter {
    private val _counter = MutableStateFlow<Int>(0)
    val count = _counter.asStateFlow()

    suspend fun increment() {
        _counter.update { it + 1 }
    }
}