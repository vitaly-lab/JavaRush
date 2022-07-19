package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
     BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = read.readLine();
        String fileName2 = read.readLine();
     BufferedReader   reader = new BufferedReader(new FileReader(fileName1));
     BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        String aaa = reader.readLine();
        String[] bbb = aaa.split(" ");


        for (int i = 0; i < bbb.length; i++) {

           // Double sss = Double.parseDouble(bbb[i]);
           // long ppp = Math.round(sss);
           // int ap = (int)ppp;

           // writer.write(ap + " ");
            writer.write(Math.round(Double.parseDouble(bbb[i]))+" ");
        }

        reader.close();
        writer.close();
        read.close();

    }  }
