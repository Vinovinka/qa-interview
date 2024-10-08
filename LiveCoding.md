# Практические задачи - код

*Disclamer*: данные задачи встречались лично мне на собеседованиях в крупных IT-компаниях в разные годы. Также добавлены задачи из открытых источников компаний и литкода.

Цель данной секции - выяснить, насколько тестировщик вообще способен писать простой код и реализовывать несложные алгоритмы. 

У одной задачи может быть несколько решений, приведено по одному, с использованием Kotlin. 
В общем случае возможно переложить тот же алгоритм на привычный вам язык либо описать псевдокодом. Чаще всего требуется писать без использования встроенных функций. Код должен компилироваться и проходить тестирование на приведенных примерах.

  

### Ozon

Дан массив целых чисел.
Написать функцию, которая будет возвращать массив целых чисел без дубликатов.

`Input: [3, 2, 1, 1, 0, 4, 5, 2, 0]`

`Output: [3, 2, 1, 0, 4, 5]`

#### Решение
```kt
fun removeDuplicates(numbers: Array<Int>): Array<Int> {
    val uniqueNumbers = mutableListOf<Int>()
    for (number in numbers) {
        if (number !in uniqueNumbers) {
            uniqueNumbers.add(number)
        }
    }
    return uniqueNumbers.toTypedArray()
}
```

Сложность 

по памяти - О(n), где n - длина массива numbers

по времени - О(n)


### Тинькофф

#### Задача 1.
Дана строка и буква. Написать метод, который вернет число, сколько раз буква встречается в строке вне зависимости от регистра. 

`Input: “Hello”, “L”`

`Output: 2`

#### Решение
```kt
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
```

Сложность 

по памяти - О(1)

по времени - О(n)

#### Задача 2. 
Дан массив целых чисел. Вывести медиану массива.
Медиана - среднее число в массиве с нечетным количеством элементов. 
Если количество четное - вывести среднее арифметическое двух средних чисел массива.

`Input: [1, 2, 3]`

`Output: 2`

`Input: [2, 3, 4, 5]`

`Output: 3,5`

#### Решение
```kt
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
```

Сложность 

по памяти - О(1)

по времени - О(n)

#### Задача 3. 
Написать функцию, которая возвращает true, если поданный на вход массив содержит последовательность из трех или более чисел в любом месте. 

`Input: [1, 3, 4, 5]`

`Output: true`

`Input: [1, 1, 2, 4, 6, 7]`

`Output: false`

#### Решение
```kt
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

```

Сложность 

по памяти - О(1)

по времени - О(n)

### Яндекс

#### Задача 1.

Дан массив целых чисел и еще число. Написать функцию, которая выводит сколько раз данное число встречается в массиве. Если не встретилось ни разу или массив пуст, вернуть 0.


`Input: [1, 2, 3, 4, 4, 5] и 4`

`Output: 2`

#### Решение
```kt
fun count(numbers: IntArray, number: Int): Int {
	var count = 0
    
    for (element in numbers) {
        if (element == number) {
            count += 1
        }
    }
    return count
}
```

Сложность 

по памяти - О(1)

по времени - О(n)

#### Задача 2.

Написать функцию, которая определяет, является ли переданная строка палиндромом
(читается слева-направо и справа-налево одинаково).

Примеры палиндромов:
- Казак
- А роза упала на лапу Азора
- Do geese see God?
- Madam, I’m Adam

#### Решение
Через встроенный метод reversed() - очищаем строку от символов пробела и знаков препинания, разворачиваем, сравниваем с исходной.

```kt
fun isPalindrome(inputString: String): Boolean {
    val cleanedString = inputString.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()
    return cleanedString == cleanedString.reversed()
}
```

Очищаем строку от всего, что не буквы, приводим к одному кейсу, дальше работаем с получившимся массивом букв. Известен размер строки - это размер массива. Нужно разделить массив пополам и дальше пройтись по нему и сравнить посимвольно первый и последний символы. Не совпали? Возвращаем false. Совпали - true.

```kt
fun isPalindrome(s: String): Boolean {
   val cleanString = s.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()

   for (i in 0 until cleanString.length / 2) {
      if (cleanString[i] != cleanString[cleanString.length - i - 1]) {
          return false
       }
    }
    
    return true
}
```

#### Задача 3.
Являются ли строки анаграммой?

#### Решение
```kt
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        
        if (s.length != t.length) return false
        // return s.lowercase().toCharArray().sorted() == t.lowercase().toCharArray().sorted()

        val charCount = mutableMapOf<Char, Int>()

        for (char in s.lowercase()) {
            charCount[char] = charCount.getOrDefault(char, 0) + 1
        }

        for (char in t.lowercase()) {
            charCount[char] = charCount.getOrDefault(char, 0) - 1
            if (charCount[char] == 0) {
                charCount.remove(char)
            }
        }

        return charCount.isEmpty()
    
    }
}
```

### Avito

#### Задача 1.

Дана функция, что принимает входным параметром целое число Y, возвращает булевое значение. Что вернет функция, если входной параметр равен 1? При каких значениях Y вернется false?

```py
def function(y):
    list_1 = [1, 0, 3, 4, 1]
    x = True
    for item in list_1:
        if item >= y:
            x = True
        else:
            x = False
    return x
```

#### Решение:

1. При y = 1 вернется true
2. В диапазоне значений y > 2 (внимание на последнее число заданного массива - только на него и нужно смотреть при решении данной задачи)

#### Задача 2.

Дано два неубывающих массива. Необходимо их объединить.

`Input: [-2, 0, 3, 3], [-5, 0]`, 

`Output: [-5, -2, 0, 3, 3]`

```kt
fun summOfArrays(nums1: Array<Int>, nums2: Array<Int>): Array<Int> {
    var result = nums1 + nums2
    return result.sort()
}
```
#### Задача 3.
Написать функцию, вычисляющую факториал натурального числа. Написать тесты на нее.

Пример: 5! = 1 * 2 * 3 * 4 * 5 = 120

Заранее известно, что 
0! = 1 и 1! = 1

#### Решение
```kt
fun factorial(n: Int): Int {
    require(n >= 0) { "Factorial is not defined for negative numbers" }
    return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
}


class FactorialTest {

    @Test
    fun testFactorialOfZero() {
        assertEquals(1, factorial(0))
    }

    @Test
    fun testFactorialOfOne() {
        assertEquals(1, factorial(1))
    }

    @Test
    fun testFactorialOfPositiveNumber() {
        assertEquals(120, factorial(5))
        assertEquals(3628800, factorial(10))
    }

    @Test
    fun testFactorialOfLargeNumber() {
        assertEquals(243290200, factorial(12)) // 12! is still within the Int range
    }

    @Test
    fun testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException::class.java) {
            factorial(-1)
        }
    }
}
```

### Прочие задачи

#### Функция вычисления интеграла

Интерграл можно вычислить методом прямоугольников, методом трапеций или методом Симпсона. Для данного случая взят метод трапеций. 

Решение

```kt
fun integrate(f: (Double) -> Double, a: Double, b: Double, n: Int): Double {
    if (n <= 0) {
        throw IllegalArgumentException("Number of intervals must be greater than zero")
    }

    val h = (b - a) / n
    var sum = 0.5 * (f(a) + f(b))

    for (i in 1 until n) {
        val x = a + i * h
        sum += f(x)
    }

    return sum * h
}

fun main() {
    // Пример использования: вычисление интеграла функции f(x) = x^2 от 0 до 1
    val result = integrate({ x -> x * x }, 0.0, 1.0, 1000)
    println("Result: $result")  // Ожидаемый результат: 1/3 ≈ 0.3333
}

```
Сложность 

по памяти - О(1)

по времени - О(n)
