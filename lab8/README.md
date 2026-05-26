Лабораторная работа №8: Аннотации, Stream API и многопоточность в Java

Описание

Данная лабораторная работа посвящена изучению аннотаций, Stream API и многопоточной обработки данных в Java.  
В ходе выполнения работы реализована система обработки текстовых данных с использованием пользовательских аннотаций, Reflection API, Stream API и ExecutorService.

Программа считывает данные из файла, применяет к ним последовательность обработчиков и сохраняет результат в новый файл.

Ключевые концепции

Thread — механизм выполнения задач в отдельных потоках

&nbsp;&nbsp;&nbsp;&nbsp;ExecutorService — инструмент для управления потоками и асинхронного выполнения задач

&nbsp;&nbsp;&nbsp;&nbsp;Annotation — механизм добавления метаданных к элементам программы

&nbsp;&nbsp;&nbsp;&nbsp;Reflection API — средство динамического анализа классов и вызова методов во время выполнения программы

&nbsp;&nbsp;&nbsp;&nbsp;Stream API — функциональный способ обработки коллекций данных

&nbsp;&nbsp;&nbsp;&nbsp;parallelStream() — параллельная обработка данных в нескольких потоках

Задания:

1 Создание пользовательской аннотации @DataProcessor

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Реализована аннотация @DataProcessor для пометки методов обработки данных.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Аннотация используется совместно с Reflection API для автоматического поиска методов обработки.

2 Реализация обработчиков данных

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Создан класс FilterProcessor для фильтрации строк по длине.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Создан класс TransformProcessor для преобразования строк в верхний регистр.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Обработка выполняется через Stream API.

3 Реализация класса DataManager

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Класс DataManager отвечает за загрузку, обработку и сохранение данных.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Метод registerDataProcessor() регистрирует обработчики данных.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Метод processData() выполняет многопоточную обработку данных с использованием ExecutorService и parallelStream().

4 Работа программы

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Программа считывает данные из файла input.txt.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;После обработки удаляются короткие слова и оставшиеся слова переводятся в верхний регистр.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Результат сохраняется в файл output.txt.

Пример результата работы:

Входные данные:
cat
apple
dog
banana
kiwi
sun

Выходные данные:
APPLE
BANANA
KIWI
