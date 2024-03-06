package org.example.coroutines

import kotlinx.coroutines.*

class Person {
    val children = GlobalScope.async(start = CoroutineStart.LAZY) { loadChildren() }

    companion object {
        suspend fun loadChildren(): List<String> {
            println("Loading children")
            delay(4000)
            return listOf("Harry", "Sam", "Alex")
        }
    }

}

fun main() = runBlocking {

    println()
    val person = Person()
    person.children.start()

    person.children.await().forEach {
        println(it)
    }

    println()
    println("Done")
}
