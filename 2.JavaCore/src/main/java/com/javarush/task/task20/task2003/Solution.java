package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap () throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);

        bufferedReader.close();
        fileInputStream.close();

    }

    public void save (OutputStream outputStream) throws Exception {

        Properties pFile = new Properties();

            for (Map.Entry<String, String> pair : properties.entrySet()) {
                pFile.setProperty(pair.getKey(), pair.getValue());
            }
        pFile.store(outputStream,null);


            outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
            Properties pFile = new Properties();

            pFile.load(inputStream);

        for(Map.Entry<Object, Object> entry: pFile.entrySet()) {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
        inputStream.close();
    }

    public static void main(String[] args) throws IOException {


    }
}
