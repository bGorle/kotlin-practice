package practice


class Greeter {
    val greeting: String = "HEllo"
    operator fun invoke() = println("$greeting!")
}

fun main() {
    val s = Greeter()
//    HashMap
    s()
}