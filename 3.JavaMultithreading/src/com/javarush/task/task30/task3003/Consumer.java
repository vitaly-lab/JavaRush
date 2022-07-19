package com.javarush.task.task30.task3003;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

import static java.lang.Thread.currentThread;

public class Consumer implements Runnable {

    TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
      //  while (!currentThread().isInterrupted()){
        {
            try {
                Thread.sleep(450);

                while (true) {
                    ShareItem item = queue.take();
                    System.out.format("Processing " + item.toString() + "\n");
                                  }
                } catch (InterruptedException e) {}
        }
    }
}
