package com.javarush.task.task18.task1826;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Шифровка
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        byte[] source = new byte[inputStream.available()];
        inputStream.read(source);

        byte key = '5';

        switch (args[0]) {

            case ("-e"): {  for (int i = 0; i < source.length; i++) { source[i] = (byte) (source[i] ^ key); }}break;

            case ("-d"): {  for (int i = 0; i < source.length; i++) { source[i] = (byte) (source[i] ^ key); }}break;

        }
        for (int i = 0; i < source.length; i++) { outputStream.write(source[i]);}

        inputStream.close();
        outputStream.close();

    }

}