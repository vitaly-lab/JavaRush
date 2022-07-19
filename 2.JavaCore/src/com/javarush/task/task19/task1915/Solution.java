package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);

        byte[] array = result.getBytes();
        for (int i = 0; i< array.length; i++){
        fileOutputStream.write(array[i]); }

     System.out.print(result);

        //   FileInputStream fileInputStream = new FileInputStream("c:/arc/333.txt");
     //   while (fileInputStream.available() > 0){
     //   int date = fileInputStream.read();
     //   System.out.print((char)date);
      //  }

        bufferedReader.close();
        //fileInputStream.close();
        fileOutputStream.close();
        outputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

