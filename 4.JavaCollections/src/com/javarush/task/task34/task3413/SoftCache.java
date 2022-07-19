package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();
//----------------------------------------------------------------------------------------------------------------------
    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if (softReference == null) return null;
        else

        return softReference.get();
    }
//----------------------------------------------------------------------------------------------------------------------
    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        if (softReference != null){
            AnyObject anyObject  = softReference.get();

       softReference.clear();
        return anyObject;}
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        AnyObject anyObject;
        if (softReference != null) {
        anyObject = softReference.get();
            softReference.clear();
        //напишите тут ваш код
        return anyObject;}
        return null;
    }
}