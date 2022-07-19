package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/arc/111.txt"));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:/arc/222.txt"));
        FileReader read = new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);

        ArrayList<String> arrayList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(read);

        String line;
        while ((line = reader.readLine()) != null) {

        String[] arrayText = line.split(" ");
             for (String strArrayText : arrayText) {

            if (strArrayText.length() > 6) {
               // System.out.print(strArrayText + ",");
            arrayList.add(strArrayText); }}}

          for (int i = 0; i < arrayList.size() - 1; i++){

             arrayList.set(i,  arrayList.get(i) + ","); }

            for (String strArrayList : arrayList){
                writer.write(strArrayList);}

            reader.close();
            reader.close();
            writer.close();

    }
}