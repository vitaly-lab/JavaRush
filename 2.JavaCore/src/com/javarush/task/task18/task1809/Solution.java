package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;
/*
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        BufferedReader read2= new BufferedReader(new InputStreamReader(System.in));
        String fileName2 = read2.readLine();
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);

      ArrayList<Integer> list = new ArrayList<Integer>();

        while (inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            list.add(data);
                    }
        inputStream.close();

       for (int i = list.size() - 1; i >= 0; i--){

           int k = list.get(i);

           outputStream2.write(k);
      }

//System.out.print(list);

        outputStream2.close();
            }}
