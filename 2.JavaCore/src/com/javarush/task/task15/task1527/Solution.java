package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String[] result11 = null;
        String[] result111 = null;

        if (name.contains("obj"))   {

            result11 = name.split("[?=&]");
            String val = result11[2];

            result111 = name.split("[?=]");
            String part2 = result111[1];
            String part3 = result111[2];

            List<String> result3 = Arrays.asList(part3.split("&"));
            for(int i = 1; i < result3.size(); i++) {

                System.out.println(part2 + " " + result3.get(i)); }

            try {

                double numer = Double.parseDouble(val);
                alert(numer);

            } catch (Exception e) {alert(val);}

        }

        else {

            String [] resul = name.split("[?=]");

           String part2 = resul[1];
           String part3 = resul[2];

            System.out.print(part2 + " " );

            List<String> result3 = Arrays.asList(part3.split("&"));
            for(int i = 1; i < result3.size(); i++) {
                System.out.print(result3.get(i) + " " ); }

        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
