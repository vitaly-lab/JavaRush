package com.javarush.task.task35.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;

        try {
            byte[] buffer = Files.readAllBytes(Paths.get(name)); // записываем по байтно файл в массив
            clazz = defineClass(null, buffer, 0, buffer.length); // в классе java.lang.ClassLoader
            // уже реализован метод непосредственной загрузки — defineClass(...),
            // который байт-код преобразует в java.lang.Class, осуществляя его валидацию;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clazz;
    }
}
