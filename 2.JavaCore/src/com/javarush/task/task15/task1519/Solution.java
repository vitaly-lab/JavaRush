package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {

    static double a;
    static String x;
    static short b;
    static int c;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new  InputStreamReader(System.in));
        // x = reader.readLine();
        while (! ((x = reader.readLine()).equals("exit"))){
            try {

                c = Integer.parseInt(x);
                b = Short.parseShort(x);

                if ((b > 0) && (b < 128)) print(b);
                if ((c < 0) || (c >= 128)) print (c);
                if (c == 0) print(c);
            }         catch (NumberFormatException nfe)  {
                try {
                    print(Double.parseDouble(x));
                } catch (Exception e) {
                    print(x); }
            }

        }}

    public static void print(Double value) {

        System.out.println("Это тип Double, значение " + value);    }

    public static void print(String value) {

        System.out.println("Это тип String, значение " + value);      }

    public static void print(short value) {

        System.out.println("Это тип short, значение " + value);     }

    public static void print(Integer value) {

        System.out.println("Это тип Integer, значение " + value);     }}
