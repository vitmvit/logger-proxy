package by.vitikova.logger.proxy.exception;

/**
 * Исключение {@code LoggingException} используется для обработки ошибок, возникающих во время логирования вызова методов.
 */
public class LoggingException extends RuntimeException {

    public LoggingException(String message) {
        super(message);
    }
}