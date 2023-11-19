Это небольшое приложение представляет собой простую оболочку для общения с Чатом Гпт. Она использует сторонний сервис https://chatgptbot.ru/, этот сервис собирает деньги и несёт ответственность за работу Чат Гпт. Моя программа только упрощает интерфейс. В основном она сделана для людей пожилого возраста с нарушением зрения, которые хотят воспользоваться современными технологиями.

## Об интерфейсе:
Интерфейс представляет собой 4 части:
1. Первая часть это блок с 4 элементами\
![Блок номер один](https://mygemorr.ru/pic/gptswing/1.png).\
Текстовое поле "Логин" служит для ввода логина.
Текстовое поле "Пароль" для ввода пароля.
Зарегистрироваться нужно на сайте [сайте](https://chatgptbot.ru/)
Кнопка "подключиться" нужна для авторизации вас в системе. После её нажатия в поле информации появится информация о количестве ваших токенов.
2. Втора часть это нередактируемое текстовое поле, в котором будет выводиться весь диалог - сам чат.\
![Блок номер два](https://mygemorr.ru/pic/gptswing/2.png).\
3. Третья часть представляет собой обычное поле ввода, куда нужно вводить вопросы для ГПТ чат бота.\
![Блок номер три](https://mygemorr.ru/pic/gptswing/3.png).\
4. Четвёртый блок содержит 4 кнопки .\
![Блок номер четыре](https://mygemorr.ru/pic/gptswing/4.png).\
Кнопка "Отправить", при её нажатии запрос отправляется на сервер, и формируется ответ. В этот момент интерфейс программы не доступен и играет музыка. Как только ответ будет получен музыка прекратится и интерфейс будет снова доступен.
Кнопка "Очистить" очищает историю переписки с чат ботом.
Кнопка "Выход" закрывает программу.
Кнопка "Оплатить" открывает в браузере страницу оплаты.

## Принцип работы:
После регистрации на [сайте](https://chatgptbot.ru/) и пополнения счёта нужно ввести свой логин и пароль (тот же, что на сайте) в соответствующие поля в программе и нажать кнопку "Подключить". В поле информации вы увидете количество токенов доступных вам. Если у вас положительный баланс, вы можете задавать вопросы ГПТ Чат Боту. Токены будут списываться по количеству символов (вопрос + ответ).
## Запуск
Готовый, собраный jar архив с зависимостями (Jsoup) доступен [тут:](https://github.com/AlexanderPanshin/GptChatSwing/blob/master/out/artifacts/GptChatSwing_jar/GptChatSwing.jar)
Для запуска jar файла понадобится Java 19 и выше.
Запуск в Виндовс возможен просто двойным кликом по jar архиву.
Также можно запустить в командной строке командой
`java -jar .\GptChatSwing.jar`
Иногда, для чтения Java приложений скринридерами, нужно включить Bridge, подробнее [тут](https://docs.oracle.com/javase/8/docs/technotes/guides/access/enable_and_test.html)
Для поддержки экранного диктора орка (Ubunthu и т.д.) можно воспользоваться следующей командой:
`sudo java -jar -Djavax.accessibility.assistive_technologies=org.GNOME.Accessibility.AtkWrapper GptChatSwing.jar`,
также должен быть установлен пакет libatk-wrapper-java
и орка последней версии.

## Сборка:
Для сборки понадобится дополнительная библиотека [Jsoup](https://jsoup.org/)