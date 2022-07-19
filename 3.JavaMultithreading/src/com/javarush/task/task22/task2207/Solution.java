package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        HashSet<String> map = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        String str;
        while ((str = read.readLine()) != null) {
          //  String[] arr = str.split(" ");
          //  for (int i = 0; i < arr.length; ++i) {
          //      list.add(arr[i]);
           for (String word : str.split(" "))
               list.add(word);
            }

            for (int i = 0; i < list.size(); i++) {
                for (int i2 = i + 1; i2 < list.size(); i2++) {
                    if (i == i2) continue;

                    StringBuilder str2 = new StringBuilder(list.get(i2));
                    str2 = str2.reverse();

                     if (list.get(i).equals(str2.toString())) {
                                 map.add(list.get(i));
                }
            }}
            for (String wmap : map) {
                StringBuilder stgb = new StringBuilder(wmap);
                stgb = stgb.reverse();

                result.add(new Pair(wmap, stgb.toString()));
                System.out.println(wmap + " " + stgb.toString());
            }
        }
    public static class Pair {

        String first;
        String second;

        public Pair() {}

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
