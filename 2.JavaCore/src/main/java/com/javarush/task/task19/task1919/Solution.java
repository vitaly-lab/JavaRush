package com.javarush.task.task19.task1919;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

/*
Считаем зарплаты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(fileReader);
        TreeMap<String, Double> map = new TreeMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }
        String aaa = sb.toString();
        String[] arr = aaa.split(" ");

      //  for (String sss : keyValue){System.out.print(sss + " ");}

               for (int i = 0; i < arr.length;  i = i + 2) {

             // System.out.println(arr[i] + " ");

                   map.merge(arr[i], Double.valueOf(arr[i + 1]), Double::sum);

           }

        map.forEach((key, value) -> System.out.println(key + " " + value));

       fileReader.close();
       reader.close();

    }

}

