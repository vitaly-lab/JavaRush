package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import static java.lang.Thread.currentThread;

public class Producer implements Runnable {
    TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
    //   while (!currentThread().isInterrupted()) {
        {
            for (int i = 1; i < 10; i++) {
                try {

                    System.out.format("Элемент 'ShareItem-%d' добавлен" + "\n", i);
                    queue.offer(new ShareItem("ShareItem-" + i, i));

                    Thread.sleep(100);
                    if (queue.hasWaitingConsumer()) { System.out.format("Consumer в ожидании!" + "\n"); }

                } catch (InterruptedException e) {
                   return;
               }

            }
        }
    }
}

