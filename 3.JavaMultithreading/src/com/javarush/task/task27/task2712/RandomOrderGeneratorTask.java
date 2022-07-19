package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets = new ArrayList<>();
    private int interval;

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tablets.get((int)(Math.random() * tablets.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep (interval);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    public RandomOrderGeneratorTask (List<Tablet> array, int time) {
        this.tablets = array;
        this.interval = time;
    }
}
