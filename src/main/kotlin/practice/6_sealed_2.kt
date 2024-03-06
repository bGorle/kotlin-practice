package practice

sealed class ThreeSealed : OneSealed() {
    class SubThreeSealed(val name: String) : ThreeSealed() {
        override fun sampleFunction() {
            TODO("Not yet implemented")
        }
    }
}


fun main() {
    val t1 = ThreeSealed.SubThreeSealed("Bharath")
    val t2 = OneSealed.SubSealed1
    val t3 = OneSealed.SubSealed2
    val t4 = OneSealed.SubSealed3(1)

    val list = listOf(t1, t2, t3, t4)
    when (list.random()) {
        is TwoSealed -> println("Second")
        is ThreeSealed.SubThreeSealed -> println("Three")
        else -> println("First")
    }
}
