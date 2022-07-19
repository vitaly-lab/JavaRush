package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable{
 private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
       // map = new ConcurrentHashMap<>();
        int i = 1;
        try {
        while (true) {

            i++;
            String key = String.valueOf(i);
                map.put(key, String.format("Some text for %d", i++));
            Thread.sleep(500);
        }

            } catch (InterruptedException e )  {
                        System.out.println(Thread.currentThread().getName()+" thread was terminated" );}

    }
}
