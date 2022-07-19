package com.javarush.task.task37.task3707;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HashMapReflectionHelper {
    public static <T> T callHiddenMethod(HashMap map, String methodName) {
        try {
            Method method = map.getClass().getDeclaredMethod(methodName); // получает информацию о методах в классе
            method.setAccessible(true); // позволяет игнорировать проверки , устанавливает флаг override
            return (T) method.invoke(map); // вызывается сам метод
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
        }
        return null;
    }
}