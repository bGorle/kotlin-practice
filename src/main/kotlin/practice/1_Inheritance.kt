package practice

open class One {

    open fun method() {
        println("One")
    }
    companion object Custom {
        val ONE = 1

        fun getName() {
            println("ONE get Name")
        }
    }
}

class Two : One() {

    override fun method() {
       println("Two")
    }
    companion object Custom: One() {

    }
}

fun main() {
    val one = Two()
    if (one is One)
        one.method()
    one.method()
}