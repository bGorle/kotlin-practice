package practice

fun main() {
    val a = A1()
    val b = B1()

    println(a.a)
    a.sampleMethod()

    println()

    println(b.a)
    b.sampleMethod()

    println()

    val ab = AB1()
    println(ab.a)
    ab.sampleMethod()
}

interface A {
    val a: String

    fun sampleMethod()  {
        println("from sample A")
    }
}

class A1: A {
    override val a: String
        get() = "A1 class"
}

class B1: B {
    override val a: String
        get() = "B1 class"
}

interface B: A {
    override val a: String
        get() = "B interface"

    override fun sampleMethod() {
        println("from sample B")
    }
}
interface C {
    val a: String
        get() = "C interface"

    fun sampleMethod() {
        println("from sample C")
    }
}

interface ABC: A, B, C {
    override val a: String
        get() = TODO("Not yet implemented")

    override fun sampleMethod() {
        super<B>.sampleMethod()
    }
}

class AB1: ABC, A, B {

}