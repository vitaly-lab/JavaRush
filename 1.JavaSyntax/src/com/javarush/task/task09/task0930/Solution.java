package com.javarush.task.task09.task0930;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        for (int a = array.length; a > 0; a--)
        {
            for (int b = 0; b < array.length; b++)
            {
                if (isNumber(array[b]))
                {
                    for (int c = b+1; c < array.length; c++)
                    {
                        if (isNumber(array[c]))
                        {   int one = Integer.parseInt(array[b]);
                            int two = Integer.parseInt(array[c]);
                            if (one < two)
                            {
                                String tmp;
                                tmp = array[c];
                                array[c] = array[b];
                                array[b] = tmp;
                            }
                        }
                    }
                }
            }
        }
            for (int f = 0; f < array.length; f++)
            {
                if (!isNumber(array[f]))
                {
                    for (int j = f+1; j < array.length; j++)
                    {
                        if (!isNumber(array[j]))
                        {
                      if (isGreaterThan(array[f], array[j]))           // СОРТИРОКА СЛОВ
                           {
                                String elm = array[j];
                                array[j] = array[f];
                                array[f] = elm;

                            }

                        }
                    }
                }
            }
        }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {

        //return a.compareTo(b);
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
