package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Слова с цифрами
*/
public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

                String line;
                while ((line = reader.readLine()) != null){

                    Pattern p = Pattern.compile("\\b\\S+\\.*\\d+\\D*?\\b");
                        Matcher m = p.matcher(line);
                        while(m.find()) {
                           // System.out.println(line.substring(m.start(), m.end()));
                            writer.write(line.substring(m.start(), m.end()) + " ");

                        }
               //    }

                }
                reader.close();
                writer.close();

    }
}
