package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
       String one = args[0];
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();
        BufferedReader read1 = new BufferedReader(new FileReader(fileName));

        ArrayList<String> arr = new ArrayList<>();

        String ss;
        while ((ss = read1.readLine()) != null){
        for (String bbb : ss.split(" ")){
                arr.add(bbb); }}

        for (int i = 0; i < arr.size(); i++){
           if (arr.get(i).equals(one)){

         System.out.print(arr.get(i) + " " + arr.get(i+1) + " " + arr.get(i+2) + " " +  arr.get(i+3));}
        }

  read.close();
  read1.close();

        }






    }




