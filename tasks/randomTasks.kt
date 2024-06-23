import java.util.*

// Задача 1. Возможно ли разделить массив пополам?

fun isPossibleToSplit(nums: IntArray): Boolean {
    
    var x: Boolean = false
    
    for (i in nums) {
        if (i > 2) {
            x = false
        } else {
            x = true
        }
    }
    return x
}
    
fun main(args: Array<String>) {
    // Задача 1.
    // val simpleArray = intArrayOf(1, 2)
	// isPossibleToSplit(simpleArray)
}