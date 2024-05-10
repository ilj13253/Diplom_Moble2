# Отчет о тестировании

## Количество тест-кейсов
- В процессе автоматизированного UI тестирования был реализован 51 тест-кейс. 
- В ходе автоматического тестирования приложения на эмуляторе Pixel 6 API30 из 51 теста
успешно пройдено 44 теста (86.27% - успешных тестов)
- Часть тестов, где требовалась проверка всплывающих сообщений пропущена(5 тестов),
  т.к. данная проверка в приложении не может быть реализована, видимо из-зи ошибки приложения.
- Также выявились Flacky тесты, в которых периоически может не проходить проверка из-за ошибки
  в приложении (тесты смены статуса заявок) - 1 такой тест в report.

[Allure Report](https://github.com/Boarderbare/Diplom_MobileTestingAutomatization/tree/main/allure-results)

![](https://github.com/Boarderbare/Diplom_MobileTestingAutomatization/blob/main/docs/allure_report.jpg)

- В процессе тестирования мобильного приложения "Мобильный хоспис" были выявлены дефекты.
Созданы соответствующие Issue.

## Общие рекомендации:
- Сделать читаемым и видимым отображение элементов в приложении при включенной темной теме.
- Заблокировать поле категории нвоости для ввода. Использвоать только селект.
- Сделать сортировку в списке заявок по дате создания. Первые в списке - новые заявки.
- Добавить корректные ссылки на Политику конфиденциальности и Пользовательское соглашение.
- Доработать функцию смены статуса в заявке в модуле Claims - работает нестабильно.
- Исправить функцию проверки всплывающих сообщений.
- Добавить ID для категории новости в блоке самой нвости для возможности авт. тестирования. 
 Так как в списке новостей не отображаеся название категории, а только разные типы иконок. 
- Добавить ID в селекторе категории новости.