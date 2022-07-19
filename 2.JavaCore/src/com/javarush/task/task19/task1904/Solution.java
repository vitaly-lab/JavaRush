package com.javarush.task.task19.task1904;

import javax.print.DocFlavor;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



/*
И еще один адаптер
*/
public class Solution {


    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        FileReader reader = new FileReader(str);
        Scanner bufreader = new Scanner (reader);

    }
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter (Scanner fileScanner){
            this.fileScanner = fileScanner;  }

        @Override
        public Person read() throws IOException {

            Date date1 = null;

            String line = fileScanner.nextLine();
            String[] x = line.split(" ");

            String surName = x[0];
            String name = x[1];
            String secondName = x[2];
            String day = x[3];
            String month = x[4];
            String year = x[5];
            String date = day + "-" + month + "-" + year;

            DateFormat formatter;
            formatter = new SimpleDateFormat("dd-MM-yyyy");
            try {
                date1 = (Date) formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();}
                  Person person = new Person(name, secondName, surName, date1);
         //   System.out.println(surName + " " + name + " " + secondName + " " + date1);

            return person;   }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}