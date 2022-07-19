package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> arrayList = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null){
            String[] arrayStr = line.split("\n");

            for (String str : arrayStr){
               // arrayList.add(str);
                arrayList.add(new StringBuffer(str).reverse().toString());
               // System.out.print( new StringBuffer(str).reverse().toString() + " ");
                } }


       // for (int i = arrayList.size()-1; i >= 0; i--){
          for (int i = 0; i < arrayList.size(); i++) {

            System.out.println(arrayList.get(i));
          //  System.out.println( new StringBuffer(arrayList.get(i)).reverse().toString() + " ");

        }

       // for (String test : arrayList ){System.out.println(test);}


        bufferedReader.close();
        reader.close();

        }

    }

