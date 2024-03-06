package practice

class Test(var name: String) {
    private val ss
        get() = println(name)

    init {
        name = "Bharath"
        println("Init block")
        println("name: $name")
    }

    constructor(name: String, id: Int): this(name) {
        println("Secondary constructor block")
        println("$name $id")
    }
}

fun main() {
    val test = Test("Raghu", 1)
}