# Автотесты для [сайта HH.ru](https://hh.ru)

![Главная страница hh.ru](https://user-images.githubusercontent.com/47101779/184328128-cece6a04-cb90-4f64-879b-072e16467119.png)

## Реализованы проверки UI:
- Отображение на главной странице критически важных элементов: логотип, ссылка "Соискателям", ссылка "Работодателям", поле поиска, кнопка "Найти работу", кнопка "Расширенный поиск", ссылка "Помощь", кнопка "Создать резюме", кнопка "Войти", кнопка загрузки приложения из AppStore, кнопка загрузки приложения из Google Play, кнопка загрузки приложения из Huawei AppMarket;
- Отображение на странице результатов поиска критически важных элементов: поле поиска, кнопка "Найти работу", кнопка "Расширенный поиск", вкладка "Вакансии", вкладка "Резюме", вкладка "Работодатели", полужирный заголовок, теги, результаты поиска;
- Отображение на странице расширенного поиска всех элементов для фильтрации результатов поиска;
- Отображение всех элементов в модальных окнах, открывающихся на странице расширенного поиска;
- Отображение специализаций, отраслей и регионов, выбираемых в модальных окнах;
- Отображение регионов, найденных с помощью строки поиска
- Отображение разыскиваемой вакансии в первом результате;
- Отображение разыскиваемой вакансии в заданном результате;
- Отображение разыскиваемой вакансии при смене города только в заданном городе.

## Используемые технологии:
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"><br>Github</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"><br>Allure Report</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"><br>Allure TestOps</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"><br>Jira</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"><br>Telegram Bot</td>
</tr>
</tbody>
</table>

## Команды для запуска из терминала
Локально должны быть заданы параметры в credentials.properties
### Запуск всех тестов на удалённом сервере:
```bash
gradle clean test -DremoteUrl=remoteBrowserURL
```
### Запуск всех тестов в браузере Chrome с разрешением экрана 1920x1080:
```bash
gradle clean test -Dbrowser=chrome -DbrowserSize=1920x1080
```
### Запуск тестов для проверки поиска работы:
```bash
gradle clean job_search_tests
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```

## Параметры с помощью которых можно [запустить сборку в Jenkins](https://jenkins.autotests.cloud/job/C08-AShashkin-lesson13-project/build?delay=0sec):
![Параметры сборки в Jenkins](https://user-images.githubusercontent.com/47101779/184336629-f5672265-9a31-4852-b0fe-40b3d49718b6.png)

## Отчёт в [Allure Report](https://jenkins.autotests.cloud/job/C08-AShashkin-lesson13-project/allure/)
### Overview
![Allure Reports - Overview](https://user-images.githubusercontent.com/47101779/184340224-c6073b99-2fa9-45ac-9601-c8aab432e204.png)
### Дерево кейсов
![Allure Reports - Дерево кейсов](https://user-images.githubusercontent.com/47101779/184340316-41813393-64c5-4e0f-a25f-ead81f48b89d.png)

## Интеграция с Allure TestOps
### Дерево кейсов - ручные и автоматизированные
![Allure TestOps - дерево кейсов](https://user-images.githubusercontent.com/47101779/184340629-299398d5-a872-4427-bc6c-45b1dc08cb93.png)
### Dashboard
![Allure TestOps - Dashboard](https://user-images.githubusercontent.com/47101779/184340781-4bdb3d27-467e-48b2-83f4-4e7745478fec.png)

## Интеграция с Jira
![Jira](https://user-images.githubusercontent.com/47101779/184342774-48a61758-0b09-4031-adde-da114d89d027.png)

## Оповещение в Telegram
![Telegram - оповещение](https://user-images.githubusercontent.com/47101779/184342878-6ed8e5b6-6265-4268-b89a-abf10d161f95.png)

## Видео одного из тестов в Selenoid
### Тест-кейс "Проверка возврата запрашиваемой вакансии в первом результате"
![Selenoid](https://user-images.githubusercontent.com/47101779/184347813-2d4d59a7-cf60-401f-a154-29ba8aa750f1.gif)
