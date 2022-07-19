package com.javarush.task.task18.task1807;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/*
Самые частые байты
*/
public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        ArrayList<Integer> list = new ArrayList<>();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            list.add(data);
        }
        inputStream.close();
        ArrayList<Integer> arr = new ArrayList<>();
       for (int key : list) {

            if (key == 44) {

               arr.add(key);

            }  }


      //  for (int sss = 1; sss > arr.size(); sss++)
            System.out.print(arr.size());

      //  System.out.println(" ");
      //  System.out.print(list);
    }}
