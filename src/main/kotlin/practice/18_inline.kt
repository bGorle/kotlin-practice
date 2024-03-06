package practice

inline fun sample() {
    println("Hello world from Inline")
    return
    println("Hello world after return")
}

val returnLamda : () -> Int = {
    println("Hello world from lamda")
    5 // return not allwowd here
}

inline fun inlineLamdas( func1: () -> Unit, func2: () -> Unit) {
    func1()
    func2()
}
inline fun crossInlineLamdas( func1: () -> Unit, crossinline func2: () -> Unit) {
    func1()
    func2()
}

//inline fun <reified T> typeName(t: T) {
//    println(t::class.java.name)
//}

inline fun <reified T> isType(value: Any): Boolean {
    return value is T
}

fun main() {
    println(returnLamda())
    sample()

    // Inline functions allow return in lamda
    inlineLamdas(
        { println("Hello world") },
        { return }
    )
    crossInlineLamdas(
        { println("Hello world 2") },
        { println("Hello world ")  }
    )

}