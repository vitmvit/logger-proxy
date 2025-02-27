# logger-proxy

## Задача: Написать прокси для логирования вызова методов через аннотацию

- Написать аннотацию @Log, которою можно указывать над методами класса.
- Если над методом стоит аннотация, то при его вызове в консоль должен выводиться лог о его начале и завершении (с
  указанием названия класса и метода).
- Для реализации аннотации необходимо использовать паттерн "Прокси", поэтому для логирования класс должен иметь
  интерфейс.

- Использовать JDK PROXY НЕЛЬЗЯ!
- Реализовывать генерацию байт-кода не нужно

## Реализация

Данный проект реализует паттерн проектирования "Прокси" с использованием аннотаций для логирования вызовов методов. Он
позволяет добавлять дополнительное поведение к методам, такими как логирование, без изменения исходного кода.

1. **Аннотация `@Log`**: Этот класс аннотации используется для пометки методов, которые должны быть логированы при их
   вызове через прокси.
2. **Исключение `LoggingException`**: Класс исключения, который выбрасывается при ошибках, связанных с логированием
   вызова методов.
3. **Интерфейс `CatVoice`**: Определяет методы, представляющие звуки, издаваемые котом.
4. **Класс `CatVoiceImp`**: Реализация интерфейса `CatVoice`. Содержит методы `getMay`, `getHissing` и `getGrowl`.
   Методы `getMay` и `getGrowl` помечены аннотацией `@Log`.
5. **Класс `CatProxy`**: Это прокси-реализация для `CatVoice`. Он содержит логику для логирования вызовов методов и
   делегирования вызовов оригинальному объекту.
6. **Класс `CheckAnnotation`**: Утилита для поиска методов с заданной аннотацией.

## Пример использования

```java
public static void main(String[]args){
    CatVoice example = new CatVoiceImp();
    CatVoice loggingProxy = new CatProxy(example);
        
    System.out.println(loggingProxy.getMay());
    System.out.println(loggingProxy.getHissing());
    System.out.println(loggingProxy.getGrowl());
}
```

## Результат

```text
------- Invoked method CatVoiceImp.getMay -------
------- Method finished with result: May! -------
May!
Shhhhh!
------- Invoked method CatVoiceImp.getGrowl -------
------- Method finished with result: Rrrrrr! -------
Rrrrrr!

```