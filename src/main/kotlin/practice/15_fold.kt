package practice

fun main() {
    val str = "Hello world welcome to our team"
    val result: String = str.split(" ")
        .reduceRight {  a, b ->
            println(a)
            "$a $b"
        }

//    listOf<Int>().fold(0) {
//
//    }
    println(result)
}