package org.example.coroutines

data class Person2(
    val name: String,
    val age: Int
)

fun main() {
    val p = Person2(
        age = 2,
        name = "Bharath"
    )

    val p1 = p.copy(age = 21)


    println(p)
    println(p1)

    println(p == p1)
}
