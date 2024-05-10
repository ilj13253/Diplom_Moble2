## План проверки мобильного приложения "В хосписе"
### Этапы тестирования 
- Анализ приложения
- Составление чеклиста 
- Написание тест-кейсов
- Создание автоматизированных тестов
- Проверка, отладка, запускк тестов
- Составление отчета
- Анализ результатов автоматизации

Исходные данные:
- Архив с проектом приложения.
- Учетые данные для аторизации в приложении
login2;
password2.

### Область тестироваиния
Тестируется UI приложения, навигация в приложении, функционал(частично).
Полное функциональное тестирование провести не представляется возможным, 
т.к. нет доступа к БД для очистки уже существующих данных и проверки корректности 
сохрнения новых, а также из-за ограниченного сроков для реализации.

Основные модули в приложении:
- Авторизация (Логин, логаут)
- Экран Main. 
- Раздел Claims
- Раздел News
- Раздел  "Любовь - это все"
- About

Для всех сценариев кроме првоерок авторизации 
первый шаг:
- авторизация в приложении

### Перечень используемых инструментов
- Android Studio Dolphin | 2021.3.1 Patch 1 -среда разработки для Android
- JDK 11.0.13 -набор инструментов для разработки на языке Java.
- Gradle Version 7.2 Система сборки кода.
- Android Gradle Plugin Version 7.1.0
- Espresso 3.4.0 - фреймворк для тестирования приложений на Android
- Github -репозиторий хранения кода
- Allure 2.4.0 - создание отчетов

### Документация:
- [тест-кейсы+чек лист](check-cases.xlsx).

### Перечень и описание возможных рисков при автоматизации
- Отсутствие технической документации и описания работы приложения
- Отсутсвие доступа к базе данных
- Сложности с поиском селекторов на страницах приложения
- Отсутствие контакта с разработчиком
- Невозможность протестировать приложение на всех девайсах
- Ограничение по времени и возможность покрыть все кейсы автотестами.

### Интервальная оценка с учётом рисков (в часах)
Ориентировочно оценка внедрения автоматизации - 48 часов.

### План сдачи работ
- подготовка: составление плана, чеклист, тест-кейсы - 11.05.2024
- автотесты - 11.05.2024
- результаты  прогона - 11.05.2024
- отчёт  - 11.05.2024