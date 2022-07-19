package com.javarush.task.task22.task2208;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) throws IOException {

       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new LinkedHashMap<>();

       // String word = bufferedReader.readLine();
        String word = "{name=Ivanov, country=Ukraine, city=Kiev, age=null}";

        for (String words : word.split("[^A-Za-zА-Яа-я0-9]\\s*")) {
            list.add(words);
        }
        for (int i = 1; i < list.size(); i = i + 2) {
            String a = list.get(i);
            String b = list.get(i + 1);
            map.put(a, b);    }

             System.out.println(getQuery(map));
       }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value.equals("null")) continue;
            else sb.append(key + " " + "=" + " " + "'" + value + "'" + " " + "and" + " ");
        }
        return sb.toString().substring(0, sb.toString().length() - 5);
    }
}