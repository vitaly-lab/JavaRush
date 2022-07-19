package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Самый богатый
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(fileReader);
        Map<String, Double> map = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(" ");
        }
        String aaa = sb.toString();
        String[] arr = aaa.split(" ");

        //  for (String sss : keyValue){System.out.print(sss + " ");}

        for (int i = 0; i < arr.length;  i = i + 2) {

            // System.out.println(arr[i] + " ");

            map.merge(arr[i], Double.valueOf(arr[i + 1]), Double::sum);

        }

        double maxValueInMap=(Collections.max(map.values()));  // This will return max value in the Hashmap
        for (Map.Entry<String, Double> entry : map.entrySet()) {  // Itrate through hashmap
            if (entry.getValue() == maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        }


      // System.out.println();


     //   map.forEach((key, value) -> System.out.println(key + " " + value));

        fileReader.close();
        reader.close();

    }

}