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