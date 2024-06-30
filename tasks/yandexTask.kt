import java.util.*

// Сколько раз входное число встречается в массиве?
// Input: [1, 2, 3, 4, 4, 5] и 4
// Output: 2

fun count(numbers: IntArray, number: Int): Int {
	var count = 0
    
    for (element in numbers) {
        if (element == number) {
            count += 1
        }
    }

    return count
}

fun main() {
    val numbers = intArrayOf(3, 2, 1, 1, 0, 4, 5, 2, 0)
	val number = 1
    println(count(numbers, number))
}