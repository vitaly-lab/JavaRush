package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты
*/
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

          String fileName1;
          while (true) {
          fileName1 = reader.readLine();
          if (fileName1.equals("exit")) {
          break; }
          list.add(fileName1); }

        for (String sss : list){

       ReadThread readThread = new ReadThread(sss);
       readThread.start();
    }
    }

    public static class ReadThread extends Thread {
String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;  }

        @Override
          synchronized   public void run() {
            ArrayList<Integer> list = new ArrayList<>();
            FileInputStream inputStream = null;

            try {
                inputStream = new FileInputStream(this.fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (true) {
                try { if (!(inputStream.available() > 0)) break;
                      int data = inputStream.read();
                      list.add(data);
                } catch (IOException e) {e.printStackTrace(); }
            }

           TreeMap<Integer, Integer> mapList = new TreeMap<>();

            for (int aaa : list) {
            int freq = Collections.frequency(list, aaa);
            mapList.put(aaa, freq);  }

            Integer maxInt = Collections.max(mapList.values());

            for (int key : mapList.keySet()) {
            if (mapList.get(key).equals(maxInt)) {
            resultMap.put(fileName, key); } }

            try {inputStream.close();} catch (IOException e) {e.printStackTrace(); }
        } }


        //    for (Map.Entry entry : resultMap.entrySet()) {
        //    System.out.println(entry.getKey() + ", " + entry.getValue());}
        }




