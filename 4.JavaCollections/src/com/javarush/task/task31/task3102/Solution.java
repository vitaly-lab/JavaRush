package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        ArrayList<String> arrayList = new ArrayList<>();

        Files.walk(Paths.get(root))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(path1 -> arrayList.add(String.valueOf(path1)));

        return arrayList;
    }

    public static void main(String[] args) {

    }
}
