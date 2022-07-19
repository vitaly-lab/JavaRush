package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
       FileInputStream inputStreamReader1 = new FileInputStream(fileName1);
       FileOutputStream outputStream1 = new FileOutputStream(fileName1);
       FileInputStream inputStreamReader2 = new FileInputStream(fileName2);

while (inputStreamReader2.available() > 0){
    int data2 = inputStreamReader2.read();
    outputStream1.write(data2);}

while (inputStreamReader1.available() > 0){
    int data1 = inputStreamReader1.read();
    outputStream1.write(data1); }

inputStreamReader1.close();
inputStreamReader2.close();
outputStream1.close();

    }
}
