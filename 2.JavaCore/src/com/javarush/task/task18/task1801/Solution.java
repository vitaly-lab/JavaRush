package com.javarush.task.task18.task1801;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/* 
Максимальный байт
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //Создаем поток-чтения-байт-из-файла
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName = read.readLine();
       // BufferedReader buff = new BufferedReader(new FileReader(fileName));
        FileInputStream inputStream = new FileInputStream(fileName);

        ArrayList<Integer> ass = new ArrayList<>();

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data

            ass.add(data);
        }
        inputStream.close(); //закрываем оба потока. Они больше не нужны.
   // for (int sss : ass){
   // System.out.print(sss + " "); }

        System.out.println(Collections.max(ass));






    }
}
