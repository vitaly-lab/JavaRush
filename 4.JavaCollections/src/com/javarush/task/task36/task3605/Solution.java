package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
        TreeSet<Character> treeSet = new TreeSet<>();
            while ((line = reader.readLine()) != null) {
                String output = line.replaceAll("[^a-zA-Z]", "");
                String str1 = new String (output.toLowerCase());
                char[] array = str1.toCharArray();
                for(char l : array) {
                     treeSet.add(l);}
            }
        while(treeSet.size() > 5) {
            treeSet.remove(treeSet.last());
        }
        for (char c : treeSet) {
            System.out.print(c);
        }
        }
}
