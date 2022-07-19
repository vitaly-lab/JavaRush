package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
     // T p =  (T)mapper.readValue(Paths.get(fileName).toFile(), clazz);
     //  return mapper.readValue(Paths.get(fileName).toFile(), clazz);
        return mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) throws IOException {
//        Cat cat = convertFromJsonToNormal("C:allFilesContent.txt",Cat.class);
//        System.out.println(cat.age);
    }
//    @JsonAutoDetect
//    public static class Cat{
//        public int age;
//
//        public Cat() {
//        }
//    }
}
