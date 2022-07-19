package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

       String line;
       int count = 0;
       while ((line = reader.readLine()) != null){
           String[] str = line.split("\\W");
           String word = "world";

           for (String wordD : str){
         //     System.out.println(wordD + "\\\\w+");
               if (wordD.equals(word)){
                   count++;

               }

           }
       }

       System.out.print(count);

       bufferedReader.close();
       reader.close();

    }
}
