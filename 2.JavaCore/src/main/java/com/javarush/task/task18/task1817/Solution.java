package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        double a = 0;
        double b = 0;
        while ( inputStream.available() > 0)
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            // чтобы определить байт английских букв можно рапечатаь data всех англ. букв прописанных в файле.
            if( data == 32)
            { a++;}
            if (data != 32 )
            {b++;}
        }
        double d = a + b;
      //  System.out.println(a);
      //  System.out.println(d);

        double g = a/d;
        double c = g*100;
        //    System.out.print(c);

//  double p = Math.round(c * 100.0) / 100.0;

        DecimalFormat count = new DecimalFormat("##.00");

        String p = count.format(c);

        System.out.println(p);

        inputStream.close();





    }
}
