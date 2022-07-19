package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public void run() {
        System.out.println("Mой поток запущен..."); }

    public Solution()  {

       setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
            {
                                            public void uncaughtException(Thread  thread,  Throwable e) {
                                                if (e instanceof Error) {System.out.println("Нельзя дальше работать"); }
                                               else if (e instanceof Exception) {System.out.println("Надо обработать"); }
                                               else if (e instanceof Throwable) {System.out.println("Поживем - увидим"); }

                                               }
                                           }
        );

    }

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Solution();
           thread1.start();


    }
}
