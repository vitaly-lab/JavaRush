package com.javarush.task.task18.task1808;

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

        BufferedReader read3= new BufferedReader(new InputStreamReader(System.in));
        String fileName3 = read3.readLine();
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);

        ArrayList<Integer> list = new ArrayList<>();

        while (inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            list.add(data);
        }
        inputStream.close();

        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        if (list.size() % 2 == 0) {
         //   System.out.println("Чётное");
            for (int i = 0; i < list.size()/2; i++) {
                int a = list.get(i);
                list2.add(a);}
            for (int i = list.size()/2; i < list.size(); i++){
                int b = list.get(i);
                list3.add(b);} }

        if (list.size() % 2 != 0) {
         //   System.out.println("Нечётное");
            for (int i = 0; i <= (list.size() - 1)/2; i++) {
                int p = list.get(i);
                list2.add(p);}
           for (int i = (list.size() - 1)/2 + 1; i < list.size(); i++){
                int k = list.get(i);
                list3.add(k);}

        }

//System.out.print(list);
//System.out.println(" ");
//System.out.print(list2);
//System.out.println(" ");
//System.out.print(list3);


for (int m : list2)
outputStream2.write(m);
for (int n : list3)
outputStream3.write(n);

 outputStream2.close();
 outputStream3.close();
    }}
