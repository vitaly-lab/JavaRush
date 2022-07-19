package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static <Document> void main(String[] ards) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        //ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder lineBil = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null ){
            {
                lineBil.append(line);
            }
        }

        Document pirmFile = (Document) Jsoup.parse(String.valueOf(lineBil), "", Parser.xmlParser());

        Elements elem = pirmFile.select(ards[0]);
        for (Element elements : elem){
            System.out.println(elements);
        }

            bufferedReader.close();
            reader.close();




    }
}
