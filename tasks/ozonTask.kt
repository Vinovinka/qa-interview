import java.util.*

// Дан массив целых чисел. Написать функцию, которая будет возвращать массив целых чисел без дубликатов

fun removeDuplicates(numbers: Array<Int>): Array<Int> {
    val uniqueNumbers = mutableListOf<Int>()
    for (number in numbers) {
        if (number !in uniqueNumbers) {
            uniqueNumbers.add(number)
        }
    }
    return uniqueNumbers.toTypedArray()
}

fun main() {
    val numbers = arrayOf(3, 2, 1, 1, 0, 4, 5, 2, 0)
    val uniqueNumbers = removeDuplicates(numbers)
    println(uniqueNumbers.joinToString(", "))  // Output: 3, 2, 1, 0, 4, 5
}