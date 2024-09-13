package by.vitikova.logger.proxy.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code CheckAnnotation} предоставляет утилитарный метод для поиска методов с заданной аннотацией.
 */
public class CheckAnnotation {

    public static <T extends Annotation> List<Method> getAnnotatedMethod(Class<?> clazz, Class<T> annotationClass) {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                annotatedMethods.add(method);
            }
        }
        Class<?> parent = clazz.getSuperclass();
        if (parent != Object.class) {
            annotatedMethods.addAll(getAnnotatedMethod(parent, annotationClass));
        }
        return annotatedMethods;
    }
}