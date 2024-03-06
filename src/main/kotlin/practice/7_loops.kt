package practice

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)

    list.forEach {
        println(it)
    }

    val list2 = list.map {
        it.toString()
    }

    println("For each Indexed")
    list2.forEachIndexed { i, v ->
        println("index: $i, value: $v ")
    }

    println("With Index")
    for (i in list.withIndex()) {
        println("${i.index}: ${i.value}")
    }

    println("In Between")
    for(i in 4..100) {
        print("$i ")
    }

    println()
    println()
    println("2 Step ")
    for (i in 1..6 step 2) {
        println(i)
    }

    println("downTo")
    for(i in 5 downTo  4 ) {
        println(i)
    }

    println()
    println("Indices")
    for (item: Int in list.indices) {
        println(item)
    }


}
