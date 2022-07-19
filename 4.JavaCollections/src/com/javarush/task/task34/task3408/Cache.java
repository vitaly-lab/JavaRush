package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {

   // private Map<K, V> cache = null;   //TODO add your code here
   private Map<K, V> cache = new WeakHashMap<>();
    // Рефлексия !!!
//----------------------------------------------------------------------------------------------------------------------
//1. Выбери правильный тип для поля cache. Map<K, V> cache должен хранить ключи, на которые есть активные ссылки.
//Если нет активных ссылок на ключи, то они вместе со значениями должны автоматически удаляться из cache.
//2. Реализуй логику метода getByKey:
//2.1. Верни объект из cache для ключа key.
//2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
// а) публичный конструктор с одним параметром типа K;
    public V getByKey(K key, Class<V> clazz) throws Exception {
        V obj = cache.get(key);
        if (obj == null) {
            Constructor<V> method = clazz.getConstructor(key.getClass());
            put(method.newInstance(key));
        }
        return obj;
        //TODO add your code here
        //return null;
    }
// 3. Реализуй логику метода put:
//3.1. Используя рефлексию получи ссылку на метод, описанный в пункте б).
// б) метод K getKey() с любым модификатором доступа.
//3.2. Используя рефлексию разреши к нему доступ.
// 3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
//3.4. Добавь в кэш пару <key, obj>.
//3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.
    public boolean put(V obj) {
        int size = cache.size();
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            method.invoke(obj);
            cache.put((K) method.invoke(obj), obj);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            //e.printStackTrace();
        }
            if (size + 1 == cache.size()) return true;
            else
        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}
