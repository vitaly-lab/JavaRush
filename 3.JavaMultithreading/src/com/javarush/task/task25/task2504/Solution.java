package com.javarush.task.task25.task2504;


/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
       // for (int i = 0; i < threads.length; i++){

            for (Thread ts : threads){
        switch (ts.getState()){
            case NEW: ts.start();  break;
            case BLOCKED: ts.interrupt(); break;
            case WAITING: ts.interrupt(); break;
            case TIMED_WAITING: ts.interrupt(); break;
            case RUNNABLE: ts.isInterrupted(); break;
            case TERMINATED: System.out.println(ts.getPriority()); break;
        }

        }
    }

    public static void main(String[] args) {

        Thread[] tt = new Thread[30];
        for (int i = 0; i < tt.length; i++)
        {
            tt[i] = new Thread(Integer.toString(i));}
        processThreads(tt);
    }
}
