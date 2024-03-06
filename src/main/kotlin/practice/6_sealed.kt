package practice

fun main() {

}

sealed class OneSealed {
    data object SubSealed1 : OneSealed() {
        override fun sampleFunction() {

        }
    }

    data object SubSealed2 : OneSealed() {
        override fun sampleFunction() {

        }
    }

    data class SubSealed3(val age: Int) : OneSealed() {
        override fun sampleFunction() {

        }
    }

    abstract fun sampleFunction()
}

sealed class TwoSealed : OneSealed() {
    data object SubSubSealed3 : TwoSealed() {
        override fun sampleFunction() {

        }
    }

}

enum class OneEnum {
    ONE,
    TWO,
    THREE,
    FOUR
}

enum class TwoEnum {
    ONE,
    TWO,
    THREE,
    FOUR
}

