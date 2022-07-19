package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        String fileName1 = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] arr = line.split(" ");

            for (String str : arr) {
                //    String aaa = str.replace(/^\d+(\.\d{0,2})?$/, "");
                //    System.out.print(aaa + " ");
                if (isNumber(str))
                  //  System.out.println(str);


                writer.write(str + " ");}

            }
        reader.close();
        writer.close();
        bufferedReader.close();

        }

    public static boolean isNumber(String str) {
        Pattern p = Pattern.compile("(^0$)|(^[1-9]([0-9])*)$");
        Matcher m = p.matcher(str);
        return m.find();
    }
}