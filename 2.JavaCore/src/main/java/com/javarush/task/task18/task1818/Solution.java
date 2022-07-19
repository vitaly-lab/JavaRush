package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerw = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerw.readLine();
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName2 = reader.readLine();
        String filenamw3 = reader.readLine();
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(filenamw3);
        ArrayList<Integer> ass = new ArrayList<>();

        while (fileInputStream2.available() > 0){
            int date2 = fileInputStream2.read();
        //    ass.add(date2);
        fileOutputStream1.write(date2); }

        while (fileInputStream3.available() > 0){
            int date3 = fileInputStream3.read();
            //ass.add(date3);
            fileOutputStream1.write(date3);
        }

 fileOutputStream1.close();
 fileInputStream2.close();
 fileInputStream3.close();


    }
}
