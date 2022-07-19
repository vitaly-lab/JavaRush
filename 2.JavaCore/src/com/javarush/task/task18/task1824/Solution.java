package com.javarush.task.task18.task1824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <String> list = new ArrayList<>();
        ArrayList <Integer> arr = new ArrayList<>();
        String fileName = null;

        while (true) {
            try {
                fileName = reader.readLine();
                FileInputStream inputStream = new FileInputStream(fileName);
                if (!(inputStream.available() > 0)) break;
                int data = inputStream.read();
                arr.add(data);

                inputStream.close();

            } catch (IOException e) {//e.printStackTrace();
                System.out.println(fileName); 
            return;
            }

        }

        for (String ppp : list){
            for (int bbb : arr){
                ThreadOne threadOne = new ThreadOne(ppp, bbb);
                threadOne.start();}}
    }

    public static class ThreadOne extends Thread{
        String thord;
        int steam;
        public ThreadOne (String thord, int steam){
            this.thord = thord;
            this.steam = steam;}

        @Override
        public void run() {

            resultMap.put(thord, steam);

        }

    }
}

