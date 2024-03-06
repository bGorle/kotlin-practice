package flows.flattening

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun generateStrings(value: Int)  = flow {
    emit("$value as String-1 at ${Thread.currentThread().name}")
    delay(300)
    emit("$value as String-2 at ${Thread.currentThread().name}")
}

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking {
    val f: Flow<Flow<Int>> = generateInts()
        .map { generateRandomInts() }

    val jobConcat = launch {
        generateInts()
            .take(5)
            .flatMapConcat { generateStrings(it) }
            .collect {
                println("Collected $it")
            }
    }


    jobConcat.join()
    println()
    println()
    println()
    println()

     val jobMerge = launch {
        generateInts()
            .take(5)
            .flatMapMerge { generateStrings(it) }
            .collect {
                println("Collected $it")
                delay(1000)
                println("Collected $it")
            }
    }
    jobMerge.join()

    println()
    println()
    println()
    println()

     launch {
        generateInts()
            .take(5)
            .flatMapLatest { generateStrings(it) }
            .collect {
                delay(1000)
                println("Collected $it")
            }
    }


    println()

}
