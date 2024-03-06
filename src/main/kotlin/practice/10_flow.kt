package practice

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow = flow {
        repeat(10) {
            emit(it)
        }
    }.map {
        it * 2
    }

    flow.collect {
        println(it)
    }
}
