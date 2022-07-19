package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{

    Thread targe;

    public LoggingStateThread(Thread targe) {
        this.targe = targe; }

    @Override
    public void run() {
        State st;
        st = targe.getState();
        System.out.println(st);
        do
        {
            if (!st.equals(targe.getState())) {
                st = targe.getState();
                System.out.println(st);
            }
        } while (!st.equals(State.TERMINATED));
     //  System.out.println(targe.getState());
    }

}
