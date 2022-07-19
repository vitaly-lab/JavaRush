package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value = 0;

   protected volatile boolean isValuePresent; //use this variable
    //-------------------------------------------------
    public synchronized int get() {

      //  while (value < 1) {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {     e.printStackTrace();
            }
           // return value;
        }
       // value--;
        isValuePresent = false;
        System.out.println("Got: " + value);
        notifyAll();
        return value--;
    }
//---------------------------------------------------
    public synchronized void put(int value) {
        this.value = value;
        System.out.println("Put: " + value);
       // while (value >= 5) {
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
      //  value++;

        isValuePresent = true;
        notifyAll();
    }

    }
