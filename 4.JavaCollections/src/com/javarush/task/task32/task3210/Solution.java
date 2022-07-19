package com.javarush.task.task32.task3210;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/*
Используем RandomAccessFile
*/
public class Solution {
    public static void main(String... args) throws IOException {

        int number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(number);
        byte[] arr = new byte[text.length()];
        raf.read(arr, 0, text.length());

        String str = new String(arr);

        raf.seek(raf.length());

        if (args[2].equals(str)) {raf.write("true".getBytes());}
        else {raf.write("false".getBytes());}

        raf.close();
    }
}
