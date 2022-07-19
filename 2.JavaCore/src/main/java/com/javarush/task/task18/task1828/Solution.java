package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
/*
Прайсы 2
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        BufferedWriter stream = new BufferedWriter (new FileWriter(fileName, true));

       // ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        try {

            String idstr, str;
            int id = 0;
            int keyID = 0;

            while ((str = reader1.readLine()) != null) {
                  idstr = str.substring(0, 8).trim();
                  id = Integer.parseInt(idstr);
                  map.put(id, str);
                  keyID = Integer.parseInt(args[1]);}

            PrintWriter writer = new PrintWriter(fileName); writer.print(""); writer.close();

            switch (args[0]) {

                case ("-d"): {

                    Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().getKey().equals(keyID)) {
                            iterator.remove();
                        }
                    }
                    for (String aaa : map.values()){stream.write(aaa + '\n');}

                }break;

                case ("-u"): {

                    String bbb = args[1] + "";
                    for (int i = bbb.length(); i < 8; i++) {
                        bbb = bbb + " ";   }
                    bbb = bbb + args[2];
                    for (int i = bbb.length(); i < 38; i++) {
                        bbb = bbb + " ";   }
                    bbb = bbb + args[3];
                    for (int i = bbb.length(); i < 46; i++) {
                        bbb = bbb + " ";    }
                    bbb = bbb + args[4];
                    for (int i = bbb.length(); i < 50; i++) {
                        bbb = bbb + " ";    }

                    for (int kkk : map.keySet()) {
                        if (kkk == keyID) {
                            map.replace(kkk, bbb);  } }

                        for (String aaa : map.values()){stream.write(aaa + '\n');
                    } break;
                }
            }
           //map.forEach((key, value) -> System.out.println(key + ", " + value));




            //for (String aaa : map.values()){stream.write(String.valueOf(map.values()));}
       //     map.forEach((key, value) -> {
         //       try {
           //         stream.write(value + "/n"); } catch (IOException e) { e.printStackTrace(); } });

        } catch (ArrayIndexOutOfBoundsException e) {System.out.println("Аргументы не установлены");}

        reader.close();
        reader1.close();
        stream.close();

    }
}
