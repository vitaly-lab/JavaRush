package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        String newWords = null;

            try {
                string = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));

                String[] words = string.split("\t");
                newWords = words[0];

            } catch (Exception e) {throw new TooShortStringException();}



        return newWords;

    }

    public static class TooShortStringException extends Exception {
    }
    public static void main(String[] args) throws TooShortStringException {

            System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));



    }
}
