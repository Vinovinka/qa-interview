# Автоматизация тестирования
## Что такое ООП? Назовите его принципы с примерами
Объектно-ориентированное программирование (ООП) - подход, при котором вся программа рассматривается как набор взаимодействующих друг с другом объектов. При этом нам важно знать их характеристики.

Основные понятия ООП:

**Класс** – способ описания сущности, определяющий состояние и поведение, зависящее от этого состояния, а также правила для взаимодействия с данной сущностью (контракт).
С точки зрения программирования класс можно рассматривать как набор данных (полей, атрибутов, членов класса) и функций для работы с ними (методов).
С точки зрения структуры программы, класс является сложным типом данных.

**Объект (экземпляр)** – отдельный представитель класса, имеющий конкретное состояние и поведение, полностью определяемое классом.
Говоря простым языком, объект имеет конкретные значения атрибутов и методы, работающие с этими значениями на основе правил, заданных в классе.

**Интерфейс** – набор методов класса, доступных для использования другими классами.

**Абстрагирование** – способ выделить набор значимых характеристик объекта, исключая из рассмотрения незначимые. Соответственно, абстракция – это набор всех таких характеристик.

**Инкапсуляция** – свойство системы, позволяющее объединить данные и методы, работающие с ними, в классе и скрыть детали реализации от пользователя.

**Полиморфизм** – свойство системы использовать объекты с одинаковым интерфейсом без информации о типе и внутренней структуре объекта.

**Наследование** – свойство системы, позволяющее описать новый класс на основе уже существующего с частично или полностью заимствующейся функциональностью. Класс, от которого производится наследование, называется базовым или родительским. Новый класс – потомком, наследником или производным классом.

**Делегация** — перепоручение задачи от внешнего объекта внутреннему

**Композиция** — включение объектом-контейнером объекта-содержимого и управление его поведением; последний не может существовать вне первого

**Агрегация** — включение объектом-контейнером ссылки на объект-содержимое; при уничтожении первого последний продолжает существование

## Интерфейс. Абстрактный класс. В чем отличия?

Конечно! Вот более общий ответ на вопрос о различиях между интерфейсами и абстрактными классами, который подойдет для собеседования на тему объектно-ориентированного программирования (ООП).

### Интерфейс

#### Основные характеристики:
1. **Контракт**:
   - Интерфейс определяет набор методов, которые класс должен реализовать, без предоставления конкретной реализации этих методов. Он служит для задания контракта, который класс должен соблюдать.

2. **Множественное наследование**:
   - В большинстве языков программирования, которые поддерживают интерфейсы, класс может реализовать несколько интерфейсов. Это позволяет классу комбинировать функциональность из разных источников.

3. **Отсутствие состояния**:
   - Интерфейсы не могут содержать поля или состояния. Они определяют только методы и иногда свойства (в зависимости от языка), но не хранят данные.

### Абстрактный класс

#### Основные характеристики:
1. **Базовый класс**:
   - Абстрактный класс служит базовым классом, который может содержать как абстрактные методы (без реализации), так и методы с конкретной реализацией. Он может предоставлять частичную реализацию, которую подклассы могут использовать и расширять.

2. **Одиночное наследование**:
   - В большинстве языков программирования класс может наследовать только один абстрактный класс. Это ограничение обусловлено тем, что абстрактный класс может содержать состояние и методы с реализацией, что усложняет множественное наследование.

3. **Состояние и методы**:
   - Абстрактные классы могут содержать поля (состояние) и методы с реализацией. Это позволяет создавать более сложные иерархии классов, где общие методы и данные могут быть унаследованы.

### Основные отличия

1. **Множественное наследование**:
   - **Интерфейс**: Класс может реализовать несколько интерфейсов.
   - **Абстрактный класс**: Класс может наследовать только один абстрактный класс.

2. **Состояние**:
   - **Интерфейс**: Не может содержать состояния или полей.
   - **Абстрактный класс**: Может содержать состояние и поля.

3. **Реализация методов**:
   - **Интерфейс**: Определяет только методи без реализации (или может содержать методы с реализацией в некоторых языках, таких как Java 8+).
   - **Абстрактный класс**: Может содержать как абстрактные методы (без реализации), так и методы с конкретной реализацией.

4. **Конструкторы**:
   - **Интерфейс**: Не может иметь конструкторов.
   - **Абстрактный класс**: Может иметь конструкторы.

### Когда использовать

- **Интерфейсы**:
  - Используются для задания контрактов, которые классы должны соблюдать, без предоставления общей реализации.
  - Полезны, когда нужно реализовать множественное наследование или объединить функциональность из разных источников.

- **Абстрактные классы**:
  - Используются для создания общих базовых классов с частичной реализацией, которую можно разделить между подклассами.
  - Полезны, когда нужно обеспечить общую функциональность и состояние для всех подклассов.

Эти концепции являются ключевыми в ООП и помогают разработчикам создавать гибкие и расширяемые системы.

# Kotlin

## Какие коллекции есть в Kotlin?

Коллекция — это объект, содержащий в себе набор значений одного или различных типов, а также позволяющий к этим значениям обращаться и извлекать. Другими словами — это контейнер, в который вы можете помещать то, что вам нужно, а затем каким-либо образом с ним взаимодействовать. В Kotlin есть три типа коллекций:

**List (список)**. Упорядоченная коллекция, в которой к элементам можно обращаться по их индексам. Идентичные элементы (дубликаты) могут встречаться в списке более одного раза. Примером списка является предложение: это группа слов, их порядок важен, и они могут повторяться.

**Set (множество/набор)**. Неупорядоченная коллекция без повторяющихся значений. Примером множества является алфавит.

**Map (словарь/ассоциативный список)**. Набор из пар "ключ-значение". Ключи уникальны и каждый из них соответствует ровно одному значению. В коллекции могут присутствовать повторяющиеся значения, но не повторяющиеся ключи. Пример — ID сотрудников и их должностей. Map не является наследником интерфейса Collection.

Два типа интерфейсов, на основе которых создаются коллекции:

Неизменяемый (read-only) — дают доступ только для чтения (Set, List, Map, Collection).

Изменяемый (mutable) — расширяет предыдущий интерфейс и дополнительно даёт доступ к операциям добавления, удаления и обновления элементов коллекции (MutableSet, MutableList, MutableMap, MutableCollection).