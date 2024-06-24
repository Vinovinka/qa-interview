# Mobile Automation

## Фреймворки автоматизации тестов в мобилках
- XCTest для iOS
- Espresso / Kaspresso / UI Automator - Android
- Appium, Calabash  - мультиплатформа

## Что такое simctl?

`simctl` — это командная утилита, входящая в состав Xcode, которая используется для управления симуляторами iOS, watchOS и tvOS. Она предоставляет программный интерфейс для выполнения различных операций с симуляторами, таких как создание, удаление, запуск, остановка и настройка симуляторов. 

### Основные возможности `simctl`

1. **Управление устройствами**:
   - **Создание**: Создание новых симуляторов.
   - **Удаление**: Удаление существующих симуляторов.
   - **Запуск и остановка**: Запуск и остановка симуляторов.
   - **Перечисление**: Список всех доступных симуляторов.

2. **Управление приложениями**:
   - **Установка**: Установка приложений на симулятор.
   - **Удаление**: Удаление приложений с симулятора.
   - **Запуск и остановка**: Запуск и остановка приложений на симуляторе.

3. **Снимки экрана и видео**:
   - **Снимки экрана**: Создание снимков экрана симулятора.
   - **Запись видео**: Запись видео с экрана симулятора.

4. **Имитация событий и состояний**:
   - **GPS координаты**: Изменение местоположения симулятора.
   - **Состояние батареи**: Изменение состояния батареи (например, заряд, разряд).

### Примеры использования

1. **Перечисление всех доступных устройств**:
   ```sh
   xcrun simctl list devices
   ```

2. **Создание нового симулятора**:
   ```sh
   xcrun simctl create "My iPhone 14" com.apple.CoreSimulator.SimDeviceType.iPhone-14 com.apple.CoreSimulator.SimRuntime.iOS-17-4
   ```

3. **Запуск симулятора**:
   ```sh
   xcrun simctl boot "My iPhone 14"
   ```

4. **Установка приложения на симулятор**:
   ```sh
   xcrun simctl install booted /path/to/your/app.app
   ```

5. **Запуск приложения на симуляторе**:
   ```sh
   xcrun simctl launch booted com.yourcompany.yourapp
   ```

6. **Снимок экрана**:
   ```sh
   xcrun simctl io booted screenshot /path/to/screenshot.png
   ```

7. **Запись видео**:
   ```sh
   xcrun simctl io booted recordVideo /path/to/video.mp4
   ```

## Как реализован поиск объектов в XCTest?

В XCTest поиск объектов в пользовательском интерфейсе осуществляется с помощью `XCUIElementQuery`. Этот класс позволяет находить элементы интерфейса на основе различных критериев, таких как идентификаторы, метки, типы элементов и другие атрибуты.

Основные способы поиска объектов в XCTest:

### 1. Поиск по Accessibility Identifier

Каждый элемент пользовательского интерфейса может иметь уникальный идентификатор, который задается в коде приложения. Это один из самых надежных способов поиска элементов.

```swift
let app = XCUIApplication()
let button = app.buttons["myButtonIdentifier"]
```

### 2. Поиск по метке (Label)

Элементы интерфейса могут также идентифицироваться по меткам, например, тексту, который отображается на кнопке.

```swift
let app = XCUIApplication()
let button = app.buttons["Submit"]
```

### 3. Поиск по типу элемента

Можно искать элементы по их типу, например, все кнопки, все текстовые поля и т.д.

```swift
let app = XCUIApplication()
let textField = app.textFields.element(boundBy: 0) // Первый текстовое поле
```

### 4. Комбинированный поиск

Можно комбинировать различные критерии поиска для более точного нахождения элементов.

```swift
let app = XCUIApplication()
let button = app.buttons.containing(.staticText, identifier: "Submit").element
```

### Примеры использования

#### 1. Проверка существования элемента

```swift
func testButtonExists() {
    let app = XCUIApplication()
    let button = app.buttons["myButtonIdentifier"]
    XCTAssertTrue(button.exists, "The button should exist")
}
```

#### 2. Нажатие на элемент

```swift
func testTapButton() {
    let app = XCUIApplication()
    let button = app.buttons["myButtonIdentifier"]
    button.tap()
}
```

#### 3. Ввод текста в текстовое поле

```swift
func testEnterText() {
    let app = XCUIApplication()
    let textField = app.textFields["myTextFieldIdentifier"]
    textField.tap()
    textField.typeText("Hello, world!")
}
```

### Дополнительные методы поиска

- **children(matching:)**: Используется для поиска дочерних элементов.
- **descendants(matching:)**: Используется для поиска всех вложенных элементов.
- **element(boundBy:)**: Возвращает элемент на основании его индекса в коллекции.
- **element(matching:identifier:)**: Возвращает элемент, соответствующий определенному типу и идентификатору.



## Можно ли повлиять на тип элемента в дереве?

Да, в iOS можно повлиять на тип элемента в дереве доступности (accessibility tree), что помогает XCTest правильно распознавать и взаимодействовать с элементами пользовательского интерфейса. Это достигается с помощью настройки свойств доступности (accessibility properties) элементов.

### Основные свойства доступности

1. **accessibilityLabel**: Описательный текст, который используется для идентификации элемента.
2. **accessibilityIdentifier**: Уникальный идентификатор, используемый для поиска элемента в тестах.
3. **accessibilityTraits**: Набор признаков, определяющих тип и поведение элемента.

### Настройка свойства `accessibilityTraits`

Свойство `accessibilityTraits` помогает указать, как элемент должен вести себя в дереве доступности. Например, можно указать, что элемент является кнопкой, ссылкой, заголовком и т.д.

### Пример настройки доступности

Рассмотрим пример, где мы хотим, чтобы `UIView` распознавался как кнопка:

```swift
import UIKit

class CustomView: UIView {
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupAccessibility()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupAccessibility()
    }

    private func setupAccessibility() {
        self.isAccessibilityElement = true
        self.accessibilityLabel = "Custom Button"
        self.accessibilityIdentifier = "customButtonIdentifier"
        self.accessibilityTraits = .button
    }
}
```

В этом примере:
- `isAccessibilityElement = true` указывает, что `UIView` является элементом доступности.
- `accessibilityLabel` задает текст, описывающий элемент.
- `accessibilityIdentifier` задает уникальный идентификатор для элемента, который можно использовать в XCTest.
- `accessibilityTraits` устанавливает тип элемента как кнопку.

### Пример использования в XCTest

Теперь мы можем найти этот элемент в тестах и взаимодействовать с ним, как с обычной кнопкой:

```swift
import XCTest

class MyAppUITests: XCTestCase {

    func testCustomButton() {
        let app = XCUIApplication()
        app.launch()
        
        let customButton = app.buttons["customButtonIdentifier"]
        XCTAssertTrue(customButton.exists, "The custom button should exist")
        
        customButton.tap()
    }
}
```

### Дополнительные свойства доступности

Кроме `accessibilityTraits`, существуют и другие свойства, которые можно настроить для улучшения взаимодействия с элементами в дереве доступности:

- **accessibilityHint**: Дополнительная информация о действии, которое произойдет при взаимодействии с элементом.
- **accessibilityValue**: Текущее значение элемента, например, для слайдеров или переключателей.
- **accessibilityFrame**: Границы элемента в координатах экрана.
- **accessibilityElementsHidden**: Скрывает дочерние элементы от дерева доступности.

