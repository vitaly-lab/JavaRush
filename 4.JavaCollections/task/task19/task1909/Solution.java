package com.javarush.task.task19.task1909;

import java.io.*;

/*
Замена знаков
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        String fileName1 = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1));

        String line;
        while ((line = reader.readLine()) != null){
            String[] str = line.split("");

            for (String aaa : str){
                String bbb = aaa.replace('.', '!');
                writer.write(bbb);
            }

        }
        bufferedReader.close();
        reader.close();
        writer.close();
    }
}
