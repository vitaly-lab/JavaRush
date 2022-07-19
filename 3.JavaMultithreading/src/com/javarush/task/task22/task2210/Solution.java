package com.javarush.task.task22.task2210;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) throws IOException {

      //  BufferedReader reader = new BufferedReader(new FileReader("C:/ARC/222.TXT"));
      //  String str = "level22.lesson13.task01", ".";
      //  String delim = null;
     //   while ((str = reader.readLine()) != null){
          //  String [] words = str.split(" ");
       //     delim = " (,) /\"/g ";
        //    getTokens(str, delim);
      //  }
        String[] mass = getTokens("level22.lesson13.task01", ".");

      for (String s : mass){
           System.out.print(s);
       }

    }
    public static String [] getTokens(String query, String delimiter) {
       ArrayList <String> list1 = new ArrayList<>();

              StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
                  while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                   // list.add(token);  }

                //  for (String test : list) {
                  //    System.out.println(test);
                //  }
            //    for (String word : list.get(1).split(" ")){

                 //   StringBuilder sb = new StringBuilder(token);
                 //   sb.insert(0, "\"");
                 //   sb.insert(token.length() + 1, "\"");
                 //   list1.add(sb.toString());
                      list1.add(token);
                }

        String[] arr = list1.toArray(new String[list1.size()]);

             //  for (String s : arr) {
             //       System.out.println(s);
             //   }
                return arr;
    }
}