package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException  {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader1.readLine();
        BufferedReader bud1 = new BufferedReader(new FileReader(fileName1));
        String line1;
        while ((line1 = bud1.readLine()) != null) {
            allLines.add(line1);   }

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String fileName2 = reader2.readLine();
        BufferedReader bud2 = new BufferedReader(new FileReader(fileName2));
        String line2;
        while ((line2 = bud2.readLine()) != null) {
            forRemoveLines.add(line2);   }

        Solution sss = new Solution();
        sss.joinData();


    }

    public void joinData() throws CorruptedDataException {

        boolean aaa =  allLines.containsAll(forRemoveLines);

        if (aaa){
            allLines.removeAll(forRemoveLines);
        }
        if (!aaa){
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}

