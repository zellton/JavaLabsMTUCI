Лабораторная работа №4: Обработка исключений и работа с файлами в Java

Описание

Данная лабораторная работа посвящена изучению механизма обработки исключений в Java, а также работе с файлами и потоками ввода-вывода.  
В ходе выполнения работы были реализованы программы для обработки ошибок, копирования файлов и создания собственных исключений.

Программа демонстрирует использование try-catch, создание пользовательских исключений, а также работу с FileInputStream, FileOutputStream и классами пакета java.nio.file.

Ключевые концепции

Exception — механизм обработки ошибок во время выполнения программы

&nbsp;&nbsp;&nbsp;&nbsp;try-catch — конструкция для перехвата исключений

&nbsp;&nbsp;&nbsp;&nbsp;Custom Exception — создание собственных классов исключений

&nbsp;&nbsp;&nbsp;&nbsp;FileInputStream и FileOutputStream — работа с файлами через потоки

&nbsp;&nbsp;&nbsp;&nbsp;Files.writeString() — запись данных в файл

&nbsp;&nbsp;&nbsp;&nbsp;IOException — обработка ошибок ввода-вывода

Задания:

1 Вычисление среднего арифметического массива

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Создана программа для вычисления среднего арифметического элементов массива.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Добавлена проверка типа данных элементов массива.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Реализована обработка исключений ArrayStoreException и ArrayIndexOutOfBoundsException.

2 Копирование содержимого файла

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Создана программа для копирования содержимого файла source.txt в target.txt.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Использованы FileInputStream и FileOutputStream.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Реализована обработка ошибок FileNotFoundException и IOException.

3 Создание пользовательского исключения

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Создан класс CustomDivisionException.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Реализована проверка деления на ноль.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Сообщение об ошибке записывается в файл report.txt.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Использован класс Files из пакета java.nio.file.

4 Демонстрация работы программы

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Продемонстрирована обработка различных типов исключений.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Показана работа с файлами и потоками ввода-вывода.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Реализована запись информации об ошибках в отдельный файл.

Пример результата работы:

Массив: [1, 2, 3, 4, 5]

Среднее арифметическое: 3.0

Hello World!

Деление на ноль невозможно; a = 7.0, b = 0.0