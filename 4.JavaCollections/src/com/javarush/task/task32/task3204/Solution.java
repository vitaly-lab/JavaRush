package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String DICT1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String DICT2 = "abcdefghijklmnopqrstuvwxy";
        String DICT3 = "0123456789";
       int length1 = 3;
       int length2 = 3;
       int length3 = 2;
       String str1 = null;
       String str2 = null;
       String str3 = null;
       StringBuilder sb1 = new StringBuilder();
       StringBuilder sb2 = new StringBuilder();
       StringBuilder sb3 = new StringBuilder();

        Random random = new Random();

        for ( ; length1 > 0; --length1 ) {
            str1 = String.valueOf(sb1.append(DICT1.charAt(random.nextInt(DICT1.length()))));  }
        for ( ; length2 > 0; --length2 ) {
            str2 = String.valueOf(sb2.append(DICT2.charAt(random.nextInt(DICT2.length()))));  }
        for ( ; length3 > 0; --length3 ) {
            str3 = String.valueOf(sb3.append(DICT3.charAt(random.nextInt(DICT3.length()))));  }

        String str = str1 + str2 + str3;

        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
