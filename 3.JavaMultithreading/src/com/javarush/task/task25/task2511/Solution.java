package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
      //  this.handler = null;    //init handler here

      this.handler = new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
              String errTh = e.toString();
              String errTh1 = t.getName();

            //    String[] words = errTh.split("\\s*(\\s|,|!|\\.)\\s*");
           // System.out.println(words[3] + " " + errTh1.replaceAll(".","*") + " " + words[5]);

                System.out.println(e.getMessage().replace(errTh1, errTh1.replaceAll(".","*")));


            }
        };
    }
    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }
    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {

        new Solution (new TimerTask() {
            @Override
            public void run() {
                throw new UnsupportedOperationException();
            }
        }).run();
    }
}