package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet <String> set = new TreeSet<>();

        String fileName;
        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) { break; }
            set.add(fileName); }
        reader.close();

        String file = set.first();
        String[] fileN = file.split(".part");
        String str = fileN[0];

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(str, true));

        BufferedInputStream inputStream = null;
        for (String a : set)   {
            inputStream = new BufferedInputStream(new FileInputStream(a));

            int c;
            while ((c = inputStream.available()) != 0)
            {
                int data = inputStream.read();
                outputStream.write(data);

            }

                inputStream.close();
                outputStream.close();//}
        }




    }
}
