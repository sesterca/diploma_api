# Тестирование api открытого проекта petstore.swagger.io (магазин домашних животных)

### В проекте реализована :mag_right:
* Проверка создания питомца
* Проверка получения списка всех питомцев
* Проверка создания пользователя
* Проверка авторизации пользователя
* Проверка удаления пользователя
* Проверка удаления несуществующего пользователя
* Проверка оформления заказа на питомца
* Проверка информации о размещенном заказе

### В проекте использованы :gear:
<img src="image/Rest_Assured.svg" width="60"><img src="image/Java.svg" width="60"><img src="image/Gradle.svg" width="60"><img src="image/Intelij_IDEA.svg" width="60"><img src="image/GitHub.svg" width="60"><img src="image/Jenkins.svg" width="60"><img src="image/Allure_Report.svg" width="60"><img src="image/Telegram.svg" width="60">

## Для запуска тестов
### удаленно в Jenkins :desktop_computer:
```
gradle clean test
```
[Пример сборки](https://jenkins.autotests.cloud/job/012-sesterca-diploma_api/3/)
Открыть [Jenkins](https://jenkins.autotests.cloud/job/012-sesterca-diploma_api/), в меню слева выбрать ```Собрать с параметрами```


## Для просмотра отчета
Под названием проекта кликнуть [<img src="image/Allure_Report.svg" width="17">]

#### Экраны просмотра отчета о прохождении тестов Allure
<img src="image/Api_allure_main.jpg">
<img src="image/Api_allure_testsuites.jpg">

## Для уведомления о результатах тестирования
<img src="image/Api_telegram_report.jpg">
