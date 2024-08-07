# CI/CD

## Опишите, в чем суть подхода Continuous Integration?
Сборка релиза и прогон на нем как можно большего количества тестов после каждого изменения кода.

## Зачем нужен CI?

- Найденные рано дефекты дешевле исправить (см пирамиду тестов)
- Снижение Time To Market - программа всегда протестирована и готова к деплою

## В чем отличие Continuous Integration от Continuous Delivery?
CD - установка изменений на боевое окружение сразу после коммита кода без ручного вмешательства тестирования и релиз-инженеров. CI оставляет ручной контроль за некоторыми стадиями разработки, включая финальную выкладку на production

## Какие CI знаешь, с чем работал?

- Jenkins
- TeamCity
- GitLab
- CruiseControl
- Hudson 

## Что такое контейнеризация?

Контейнеризация - это способ, позволяющий запускать на одном linux-ядре большое количество изолированных друг от друга приложений с помощью cgroups и namespaces

**Преимущества**:

- Абстрагирование приложений в контейнерах от хост-машины (хост-машина не знает, что внутри контейнера, а контейниризированное приложение не зависит от архитектуры хоста)
- Простота масштабирования
- Простота управления зависимостями и версиями приложения
- Изолированные среды выполнения
- Совместно используемые разными контейнерами слои

# GIT

## Для чего используют системы контроля версий?
Системы контроля версий (Version Control Systems, VCS) используются для управления изменениями в коде программного обеспечения и других документах в процессе разработки. Основные цели:

1. **Отслеживание изменений**:
   - позволяют отслеживать все изменения, которые были внесены в проект. Это включает в себя добавление, удаление или изменение кода, а также добавление комментариев к каждому изменению.

2. **Историчность и возврат к предыдущим версиям**:
   - возможность вернуться к любой предыдущей версии проекта, что полезно для исправления ошибок или анализа изменений. Это позволяет отменить ошибочные изменения и восстановить рабочее состояние проекта.

3. **Совместная работа**:
   - Разработчики могут работать над проектом одновременно, не мешая друг другу. VCS позволяют интегрировать изменения от разных разработчиков и решать конфликты, если они возникают.

4. **Ветвление и слияние**:
   - Системы контроля версий поддерживают создание веток (branches), которые позволяют разработчикам работать над новыми функциями или исправлениями ошибок в изолированных средах. После завершения работы изменения могут быть объединены (merged) с основной веткой проекта.

5. **Документирование изменений**:
   - Каждое изменение в проекте сопровождается комментарием (commit message), что помогает в документировании процесса разработки и понимании причины каждого изменения.

6. **Резервное копирование и восстановление**:
   - Хранение истории изменений служит дополнительной формой резервного копирования. Если проект потерян или поврежден, его можно восстановить из системы контроля версий.

7. **Отслеживание задач и улучшение качества кода**:
   - интегрируются с системами отслеживания задач и управления проектами, что помогает следить за выполнением задач и улучшать качество кода посредством ревизий и проверок.

8. **Управление релизами и версиями**:
   - позволяют создавать метки (tags) для обозначения стабильных версий и релизов программного обеспечения, что облегчает управление релизами и их поддержку.

9. **Безопасность**:
   - обеспечивать контроль доступа к исходному коду, что помогает предотвратить несанкционированные изменения и поддерживать безопасность кода.

Примеры популярных систем контроля версий включают Git, Subversion (SVN), Mercurial.

## Что такое Git? Каков принцип его работы?

Git — это распределённая система контроля версий, предназначенная для отслеживания изменений в исходном коде и облегчения совместной работы разработчиков над проектами.

**Принцип работы Git**:

1. **Репозиторий**:
   - **Локальный репозиторий**: Каждая копия репозитория на устройстве разработчика содержит полную историю всех изменений. Это позволяет работать в автономном режиме и выполнять большинство операций без подключения к сети.
   - **Удалённый репозиторий**: Центральное хранилище, обычно размещённое на серверах, таких как GitHub, GitLab или Bitbucket. Обеспечивает синхронизацию изменений между разработчиками.

2. **Коммиты (Commits)**:
   - Коммиты фиксируют снимки состояния проекта в определённый момент времени. Каждый коммит содержит уникальный хеш, описание изменений и ссылку на предыдущий коммит.

3. **Ветвление (Branches)**:
   - Ветки позволяют работать над разными версиями проекта параллельно. Основная ветка (обычно называется `main` или `master`) содержит стабильную версию проекта. Новые ветки создаются для разработки новых функций или исправлений, которые потом могут быть объединены с основной веткой.

4. **Слияние (Merge)**:
   - Процесс объединения изменений из одной ветки в другую. При этом могут возникать конфликты, если изменения вносятся в одни и те же строки кода, которые требуется разрешить вручную.

5. **Клонирование (Clone)**:
   - Копирование удалённого репозитория на локальный компьютер, включая всю его историю изменений.

6. **Фиксация изменений (Stage)**:
   - Перед созданием коммита изменения должны быть добавлены в индекс (staging area), который готовится к коммиту. Это позволяет группировать изменения по смыслу перед их фиксацией.

7. **Push и Pull**:
   - **Push**: Отправка локальных изменений в удалённый репозиторий.
   - **Pull**: Получение изменений из удалённого репозитория и их интеграция в локальный.

8. **Отслеживание файлов**:
   - Git отслеживает изменения только в тех файлах, которые были добавлены в систему управления версиями с помощью команды `git add`.
