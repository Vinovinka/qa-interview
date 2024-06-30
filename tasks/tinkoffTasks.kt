import java.util.*

fun main(args: Array<String>) {}

// Задача 1
// Дана строка и буква. Написать метод, который вернет число, сколько раз буква встречается в строке вне зависимости от регистра

fun countLetter(word: String, letter: Char): Int {
    var count = 0
    val lowercasedWord = word.lowercase()

    for (l in uppercasedWord) {
        if (l == letter) {
            count++
        }
    }

    return count
}

// Задача 2
// Дан массив целых чисел. Вывести медиану массива.
// Медиана - среднее число в массиве с нечетным количеством элементов. 
// Если количество четное - вывести среднее арифметическое двух средних чисел массива.

fun medianOfArray(nums: Array<Int>): Double {
    val sizeOfArray = nums.size
    
    return if (sizeOfArray % 2 == 1) {
        // Odd number of elements
        nums[sizeOfArray / 2].toDouble()

    } else {
        // Even number of elements
        ((nums[sizeOfArray / 2] + nums[sizeOfArray / 2 - 1]) / 2.0).toDouble()
    }
}

// Задача 3
// Написать функцию, которая возвращает true, если поданный на вход массив содержит последовательность из трех или более чисел в любом месте. 

fun hasSequence(numbers: Array<Int>): Boolean {
    
    var count = 1
    
    for (i in 1 until numbers.size) {
        if (numbers[i] == numbers[i - 1] + 1) {
            count++
            if (count >= 3) 
           	return true
        } else {
            count = 1
        }
    }
    return false
}