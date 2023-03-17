# Дипломная работа, часть 3

Веб интерфейс приложения Stellar Burgers

Проект разработан на Java 11, собирается maven'ом

Перед запуском тестов в Яндекс браузере потребуется скачать дравер 

- https://github.com/yandex/YandexDriver/releases

и положить его в директорию

    $HOME/.webdrivers/


Тесты разработаны на JUnit 4, запуск тестов:

    mvn clean verify

По умолчанию используется Yandex Browser, для явного указания браузера необходимо использовать параметр `browser`:

    mvn clean verify -Dbrowser=yandex
    mvn clean verify -Dbrowser=firefox
    mvn clean verify -Dbrowser=chrome

Построение отчёта после запуска тестов:

    mvn allure:report

По завершении прогона тестов строится отчёт Allure, доступный в `target/site/allure-maven-plugin/index.html`
