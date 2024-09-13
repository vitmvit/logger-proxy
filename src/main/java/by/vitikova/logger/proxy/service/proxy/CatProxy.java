package by.vitikova.logger.proxy.service.proxy;

import by.vitikova.logger.proxy.annotation.Log;
import by.vitikova.logger.proxy.exception.LoggingException;
import by.vitikova.logger.proxy.service.CatVoice;
import by.vitikova.logger.proxy.util.CheckAnnotation;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Класс {@code CatProxy} реализует интерфейс {@code CatVoice}
 * и служит прокси для логирования вызовов методов.
 */
public class CatProxy implements CatVoice {

    private final CatVoice catVoice;
    private final List<Method> annotatedMethods;

    public CatProxy(CatVoice example) {
        this.catVoice = example;
        this.annotatedMethods = CheckAnnotation.getAnnotatedMethod(example.getClass(), Log.class);
    }

    @Override
    public String getMay() {
        return invoke("getMay");
    }

    @Override
    public String getHissing() {
        return invoke("getHissing");
    }

    @Override
    public String getGrowl() {
        return invoke("getGrowl");
    }

    /**
     * Вспомогательный метод для вызова методов и логирования результатов.
     *
     * @param methodName имя метода для вызова.
     * @return результат вызова метода.
     */
    private String invoke(String methodName) {
        try {
            Method method = catVoice.getClass().getMethod(methodName);
            boolean isAnnotatedMethod = annotatedMethods.stream().anyMatch(m -> m.getName().equals(method.getName()));
            if (isAnnotatedMethod) {
                System.out.println("------- Invoked method " + catVoice.getClass().getSimpleName() + "." + method.getName() + " -------");
                String result = (String) method.invoke(catVoice);
                System.out.println("------- Method finished with result: " + result + " -------");
                return result;
            } else {
                return (String) method.invoke(catVoice);
            }
        } catch (Exception e) {
            throw new LoggingException(e.getMessage());
        }
    }
}
