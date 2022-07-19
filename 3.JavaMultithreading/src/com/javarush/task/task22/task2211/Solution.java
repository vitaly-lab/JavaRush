package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/*
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String Input = args[0];
        String Output = args[1];

        FileInputStream fileInputStream = new FileInputStream(Input);
        FileOutputStream fileOutputStream = new FileOutputStream(Output);

        byte[] massIn = new byte[fileInputStream.available()];
        fileInputStream.read(massIn);
        String str = new String(massIn, "Windows-1251");
        byte[] massOut = str.getBytes("UTF-8");

        fileOutputStream.write(massOut);

        fileOutputStream.close();
        fileInputStream.close();


    }
}
