package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

        } catch (IOException ex) {  }        }

    public static void main(String[] args) throws InterruptedException {

        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {

        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();

        System.out.println(f.getFileContent()); }
    public interface ReadFileInterface {

        void setFileName(String fullFileName);
        String getFileContent();
        void start();
        void join() throws InterruptedException;    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String aaa = "";
        private String fullName;

        public void run() {

            StringBuilder ccc =new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(fullName)))){

                while(reader.ready())ccc.append(reader.readLine()).append(" ");

            } catch ( IOException ex) {   }
            aaa = ccc.toString();

        }

        public String getFileContent(){

            return aaa;   }

        public void setFileName(String fullFileName){
            this.fullName = fullFileName;   }


    } }