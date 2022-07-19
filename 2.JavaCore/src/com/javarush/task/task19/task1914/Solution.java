package com.javarush.task.task19.task1914;
/*
Решаем пример
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        String result = outputStream.toString();
        String[]arr = result.split(" ");
        int a = Integer.parseInt(arr[0]);
        String str3 = arr[1];
        int b = Integer.parseInt(arr[2]);


        System.setOut(consoleStream);

        switch (str3) {

            case ("+"): {
                int c = a + b;
                System.out.print(a + " " + "+" + " " + b + " " + "=" + " " + c);}
                break;
            case ("-"): {
                int c = a - b;
                System.out.print(a + " " + "-" + " " + b + " " + "=" + " " + c);}
                break;
            case ("*"):{
                int c = a * b;
                System.out.print(a + " " + "*" + " " + b + " " + "=" + " " + c);}
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
            }


        }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

