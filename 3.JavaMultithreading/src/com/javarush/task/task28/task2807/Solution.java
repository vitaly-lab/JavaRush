package com.javarush.task.task28.task2807;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>();
        ThreadPoolExecutor service = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, runnables);
        AtomicInteger atomicInteger = new AtomicInteger(1);

        for (int i = 0; i < 10; i++) {

           runnables.add(new Runnable() {
              // @Override
               public void run() {
                   int i = atomicInteger.getAndIncrement();
                   doExpensiveOperation(i); }
           }
           );
        }
        service.prestartAllCoreThreads();
        service.shutdown();
       try {
            service.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
