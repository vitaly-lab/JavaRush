package com.javarush.task.task32.task3202;

import java.io.*;
import java.util.Scanner;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        if (is == null) {
            return new StringWriter();
        }
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        stringWriter.write(new String(buffer));
        return stringWriter;
    }
}