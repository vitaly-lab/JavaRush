package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }


    public static String getPartOfString(String string) {
        String newWords = null;
    try {
        string = string.substring(string.indexOf(" "));

        String[] words = string.split(" ");

            newWords = words[1] + " " + words[2] + " " + words[3] + " " + words[4];
                    //+ " " +  wo
        // rds[1] + " " + words[2];

    } catch (Exception  e) { throw new TooShortStringException();}

        return newWords;
    }


    public static class TooShortStringException extends RuntimeException{

    }
}
