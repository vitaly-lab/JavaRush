package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/*
Самые частые байты
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            list.add(data);
        }
        inputStream.close();

        Map<Integer, Integer> abba = new TreeMap<Integer, Integer>(Collections.reverseOrder());

        for (Integer a : list) {
            int freq = Collections.frequency(list, a);
            abba.put(a, freq);      }

        Integer  maxInt = Collections.min(abba.values());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int key : abba.keySet()) {

            if (abba.get(key).equals(maxInt)) {

                arr.add(key);   }  }

        for (int sss : arr)
            System.out.print(sss + " ");

//    Set<Integer> set = new HashSet<>(arr);
        //         arr.clear();
//            arr.addAll(set);

        //         for (int test: arr)
        //         System.out.print(test + " ");


    }}
//}