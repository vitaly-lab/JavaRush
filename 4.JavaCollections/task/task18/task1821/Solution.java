package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
Встречаемость символов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
                list.add(data); }

TreeMap <Integer, Integer> abba = new TreeMap<Integer, Integer>();

        for (int a : list){
          int freq = Collections.frequency(list, a);
          abba.put(a, freq);
        }
        for ( Map.Entry<Integer, Integer> entry : abba.entrySet()) {

            int xxx = entry.getKey();
            char yyy = (char) xxx;

            System.out.println(yyy + " " + entry.getValue());
        }

         fileInputStream.close();

    }
}
