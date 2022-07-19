package com.javarush.task.task18.task1827;
import java.io.*;

/*
Прайсы
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        BufferedWriter stream = new BufferedWriter (new FileWriter(fileName, true));

        try {

    String str;
    int maxID = 0;
    while ((str = reader1.readLine()) != null) {
        str = str.substring(0, 8).trim();
        if (maxID < Integer.parseInt(str)) {
            maxID = Integer.parseInt(str);
        }
    }
    maxID++;

    String bbb = maxID + "";
    for (int i = bbb.length(); i < 8; i++) {
        bbb = bbb + " ";
    }

    bbb = bbb + args[1];
    for (int i = bbb.length(); i < 38; i++) {
        bbb = bbb + " ";
    }
    bbb = bbb + args[2];
    for (int i = bbb.length(); i < 46; i++) {
        bbb = bbb + " ";
    }
    bbb = bbb + args[3];
    for (int i = bbb.length(); i < 50; i++) {
        bbb = bbb + " ";
    }

    stream.write('\n' + bbb);

    //System.out.println(id);
}catch (ArrayIndexOutOfBoundsException e){
    System.out.println("Аргументы не установленны");
}
        reader.close();
        reader1.close();
        stream.close();


    }
}
