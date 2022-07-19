package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
        import java.util.ArrayList;
        import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // String fileNameIn = args[0];
        //  byte[] aa = fileNameIn.getBytes();
       // System.setIn(new FileInputStream(args[0]));
       // InputStreamReader isr = new InputStreamReader(System.in);
       // BufferedReader sss = new BufferedReader(isr);
        FileInputStream inputStream = new FileInputStream(args[0]);
    int count = 0;
        while ( inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            // чтобы определить байт английских букв можно рапечатаь data всех англ. букв прописанных в файле.
            if( data > 64 & data < 91 || data > 96 & data <123)
            { count++;}
        }

        System.out.print(count);

             inputStream.close();





    }
}
