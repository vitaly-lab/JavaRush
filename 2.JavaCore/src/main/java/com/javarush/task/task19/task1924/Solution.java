package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<Integer> listTextDigital = new ArrayList<>();
        Map<Integer, String> mapDigitText = new HashMap<Integer, String>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] arrayStr = line.split(" ");
            for (String strText : arrayStr) {

                Pattern pattern = Pattern.compile("\\b\\d+\\b");
                Matcher matLine = pattern.matcher(line);
                while (matLine.find()) {
                    listTextDigital.add(Integer.parseInt(line.substring(matLine.start(), matLine.end())));

                }

                for (int digitlText : listTextDigital) {

                    for (Map.Entry<Integer, String> entry : map.entrySet()) {
                        int key = entry.getKey();
                        String value = entry.getValue();

                        if (digitlText == key) {
                            mapDigitText.put(key, value);
                        }
                    }
                }

                for (Map.Entry<Integer, String> entry : mapDigitText.entrySet()) {
                    String keyDigitText = String.valueOf(entry.getKey());
                    String valueDigitText = entry.getValue();

                    if (keyDigitText.equals(strText)){
                    strText = strText.replace(keyDigitText, valueDigitText);}

                }
                System.out.print(strText + " ");
            }}
        bufferedReader.close();
        reader.close();

    }
}
