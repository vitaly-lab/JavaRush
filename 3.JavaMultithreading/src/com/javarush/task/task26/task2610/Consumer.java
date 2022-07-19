package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
   private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {

           // for (int i = 0; i < queue.size(); i++){
           // System.out.println(queue.take());}
            while (true) {

              //  consume(queue.take());
                System.out.println(queue.take());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
