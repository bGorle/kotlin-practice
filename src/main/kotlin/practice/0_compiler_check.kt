package practice

fun main() {
    val nums = intArrayOf(-1, 0, -1, 1, 2, -4)
    nums.sort()

    val numss = nums.toSet()

        numss.forEachIndexed { index, i ->
    }
    println()

    val map: Map<Int, Int> = nums.associateWith { it }.toMap()

//    for( v in map.entries.withIndex()) {
//        println(v)
//    }

    for (i in 0..0) {
        println(i)
    }

    

//    val result: List<List<Any>> = nums.mapIndexed { i, value ->
//        val target = value
//        var left = i + 1
//        var right = nums.size - 1
//
//        while (left < right) {
//            val sum = target + nums[left] + nums[right]
//            if (sum < 0) left++
//            else if (sum > 0) right--
//            else {
//                left++
//                right--
//                listOf(target, nums[left], nums[right])
//            }
//        }
//    }.map {
//        listOf(
//            it
//        )
//    }

//     println(map)

//    for (value in map) {
//        println(value.value)
//    }

    val one = intArrayOf(0, 1)
    val two =  intArrayOf(0, 2)
    val three = intArrayOf(0, 3)

    val final = arrayOf(one, two, three)
    println(final.size)
}