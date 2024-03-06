package practice

class Constructor(val name: String) {
    init {
        println("init block")
    }

    constructor(): this("") {
        println("Secondary empty Constructor 1")
    }

    constructor(name: Int): this() {
        println("Secondary empty Constructor 2")
    }

    fun play() {
        println("Are you ready to play")
    }
}

fun main() {
    val c1 = Constructor("Bharath")
    c1.play()
    println()
    val c2 = Constructor()
    c2.play()
    println()
    val c3 = Constructor(10)
    c3.play()
}