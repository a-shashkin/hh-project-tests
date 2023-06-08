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
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/IntelliJ_IDEA_Icon.svg/1200px-IntelliJ_IDEA_Icon.svg.png" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://cdn-icons-png.flaticon.com/512/226/226777.png" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://static-00.iconduck.com/assets.00/gradle-icon-256x256-jq2wrvfo.png" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://user-images.githubusercontent.com/47101779/210963191-4a3df255-fcac-418b-a903-eada87d84120.png" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://avatars.githubusercontent.com/u/26328913?s=280&v=4" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Jenkins_logo.svg/1200px-Jenkins_logo.svg.png" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="40" height="40"><br>Github</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://img.stackshare.io/service/40202/default_48abe5208fc58ffa608d65592ad0f588ebc04746.png" width="40" height="40"><br>Allure Report</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://img.stackshare.io/service/40438/default_a9d9f8f8546d65b5f12a32106e6d03e6921e11fa.png" width="40" height="40"><br>Allure TestOps</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://logowik.com/content/uploads/images/jira2966.logowik.com.webp" width="40" height="40"><br>Jira</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/2048px-Telegram_logo.svg.png" width="40" height="40"><br>Telegram Bot</td>
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
