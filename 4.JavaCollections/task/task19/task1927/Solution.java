package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();
   //public static ArrayList <String> arrayList = new ArrayList<>();

    public static void main(String[] args) {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

       testString.printSomething();

       String result = outputStream.toString();

       System.setOut(consoleStream);
       // arrayList.add(result);

        String[] arrayTekst = outputStream.toString().split("\n");
       // System.setOut(consoleStream);
        int count=0;
        for(int i=0; i< arrayTekst.length; i++){
            System.out.println(arrayTekst[i]);
            count++;
            if((count%2==0)) System.out.println("JavaRush - курсы Java онлайн");
        }

            consoleStream.close();

        // System.out.print(reversString);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
