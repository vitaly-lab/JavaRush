package com.javarush.task.task18.task1810;

import java.io.*;

/*
DownloadException
*/
public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = read.readLine();
            FileInputStream inputStream = new FileInputStream(fileName);

            if (inputStream.available() < 1000) {
               // read.close();
                inputStream.close();
                throw new DownloadException();
            }
        }


}




    public static class DownloadException extends Exception {


     }
}
