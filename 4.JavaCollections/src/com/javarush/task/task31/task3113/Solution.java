package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/* 
Что внутри папки?
*/
public class Solution {
    public static class Count extends SimpleFileVisitor<Path> {
            int countMap = 0;
            int countFiles = 0;
            long size = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            countFiles ++;

//            File dir = new File(String.valueOf(file));
//            size  += dir.length();
           size += Files.readAllBytes(file).length;
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            countMap ++;
            return FileVisitResult.CONTINUE;
        }
    }
    public static void main(String[] args) throws IOException {

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        Path pathFile = Paths.get(path);

        if (!Files.isDirectory(pathFile)) {
           System.out.println(pathFile.toAbsolutePath().toString() + " - не папка");
          // System.out.println(pathFile.toString() + " — не папка");
            return; }

        else {
            Count count = new Count();
            Files.walkFileTree (pathFile, count );

        System.out.println("Всего папок - " + (count.countMap - 1));
        System.out.println("Всего файлов - " + count.countFiles);
        System.out.println("Общий размер - " + count.size);

        }
       // reader.close();
    }
   }