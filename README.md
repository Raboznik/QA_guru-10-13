# Автотесты для сайта <a target="_blank" href="https://ayist.games/mainru">Ayist.Games</a>
<img src="src/img/icons/imgonline-com-ua-Tra.png" width="400" height="300"  alt="Jenkins"/>


## ✔️ Реализованы следующие проверки для сайта :

- ✓  Заголовок страницы соответствует заданному
- ✓  На сайте присутствует "Политика Конфидициальности"
- ✓  На сайте присутствует "Условия обслуживания"
- ✓  На сайте присутствует "Поддержка"
- ✓  На сайте присутствует ссылка на группу VK
- ✗  На сайте присутствует ссылка на группу Facebook (temporarily disabled)
- ✗  На сайте присутствует ссылка на группу Instagramm (temporarily disabled)
- ✓  На сайте присутствует onelink ссылка на игру в маркете
- ✓  Кнопка скролла по сайту работает
- ✓  Вкладка "Карьера" на сайте не пустая
- ✓  Вкладка "Контакты" на сайте не пустая  


##  ⚒️  Используемые технологии и инструменты :

![Java](src/img/icons/Java.png)![Gradle](src/img/icons/Gradle.png)![JUnit5](src/img/icons/JUnit5.png)![Intelij_IDEA](src/img/icons/Intelij_IDEA.png)![Selenoid](src/img/icons/Selenoid.png)![Selenide](src/img/icons/Selenide.png)![Allure Report](src/img/icons/Allure_Report.png)![Github](src/img/icons/Github.png)![Jenkins](src/img/icons/Jenkins.png)![Telegram](src/img/icons/Telegram.png)


## <img src="src/img/icons/Jenkins.png" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/10_13_HW_first_test_Kryuchkov/"> job </a>
<p align="center">
<a href="https://jenkins.autotests.cloud/job/10_13_HW_first_test_Kryuchkov/"><img src="src/img/jenkinsMain.png" alt="Jenkins"/></a>
</p>

## Можно настроить разные параметры в Jenkins :

- browser (default = chrome)
- version (default =  91.0)
- size (default = 1920x1080)
- remoteUrl (логин, пароль и адрес удаленного сервера selenoid)

![Jenkins](src/img/param.png)


## Для локального запуска :
```bash
gradle clean test
```

## Для удаленного запуска с параметрами :
```bash
clean
test
-Dbrowser=${BROWSER}
-Dversion=${VERSION}
-Dsize=${BROWSER_SIZE}
-Durl=${REMOTE_URL}
```
___
## <img src="src/img/icons/Allure_Report.png" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/10_13_HW_first_test_Kryuchkov/allure/">Allure report</a>

### Overview :
![Allure](src/img/owerview.png)

### Suites : 
![Allure](src/img/suites.png)

### Graphs :
![Allure](src/img/graphs1.png)
![Allure](src/img/graphs2.png)

#### <img src="src/img/icons/Telegram.png" width="25" height="25"  alt="Allure"/></a> Отчет в телеграмм о результатах тестов :

![Telegram](src/img/telegr.png)

### Прохождение каждого теста записывается : 
![video](src/img/gif.gif)
