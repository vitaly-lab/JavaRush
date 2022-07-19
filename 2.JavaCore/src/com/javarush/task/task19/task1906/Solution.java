package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName1 = reader.readLine();
     //   BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        FileReader fileReader = new FileReader(fileName);
        FileWriter fileWriter = new FileWriter(fileName1);
        ArrayList<Integer> arr = new ArrayList<>();

        while (fileReader.ready()){
            int data = fileReader.read();
            arr.add(data);
        }
         for (int i = 0; i < arr.size(); i = i + 1){

           if ((i + 1) % 2 == 0){
                fileWriter.write(arr.get(i));
            }
        }

        reader.close();
        fileReader.close();
        fileWriter.close();


    }
}