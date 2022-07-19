package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {

    int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }



    @Override
    protected String compute() {

        int b;
        String temp = "";

        while(x !=0){
            b = x % 2;
            temp = b + temp;
            x = x / 2;
        }

        return temp;
    }
}
