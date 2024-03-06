package practice

fun main() {
    val complex = Complex(10.0, 10.0)
    println(complex + complex)

}
data class Complex(val real: Double, val imaginary: Double) {
    operator fun plus(another: Complex) = Complex(
        real + another.real,
        imaginary + another.imaginary
    )

    operator fun minus(another: Complex) = Complex(
        real - another.real,
        imaginary - another.imaginary
    )


    operator fun times(another: Complex) = Complex(
        real * another.real,
        imaginary * another.imaginary
    )
}
