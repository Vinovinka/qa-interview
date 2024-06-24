# Практические задачи - код

*Disclamer*: данные задачи встречались лично мне на собеседованиях в крупных IT-компаниях в разные годы. Также добавлены задачи из открытых источников компаний и литкода.

Цель данной секции - выяснить, насколько тестировщик вообще способен писать простой код и реализовывать несложные алгоритмы. 

Решение задач приведено на Kotlin, но в общем случае возможно переложить тот же алгоритм на привычный вам язык либо описать псевдокодом. Чаще всего требуется писать без использования встроенных функций. Код должен компилироваться и проходить тестирование на приведенных примерах.

  

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


