package com.javarush.task.task32.task3201;

import java.io.*;
import java.nio.file.Path;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];

        long number = Long.parseLong(args[1]);
        String text = args[2];
        long sizeText = text.length();


        RandomAccessFile raf = new RandomAccessFile (fileName, "w");
        long p = raf.length();

        if (p >= number + sizeText) {
            raf.seek(number); raf.write(text.getBytes());
        }
        else raf.seek(p); raf.write(text.getBytes());

        raf.close();
    }
}
