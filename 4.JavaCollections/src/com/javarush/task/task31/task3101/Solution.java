package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Проход по дереву файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        ArrayList<File> listWithFileNames = new ArrayList<>();

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }
        FileUtils.deleteFile(resultFileAbsolutePath);
        Comparator<File> comparator = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());

        Files.walk(Paths.get(args[0]))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .forEach(path1 -> listWithFileNames.add(path1));

        listWithFileNames.sort(comparator);

        FileWriter writer = new FileWriter(allFilesContent);

        listWithFileNames.remove(allFilesContent);
        for (File fil : listWithFileNames) {

            BufferedReader reader = new BufferedReader(new FileReader(fil));
            if (fil.length() <= 50) {

                while (reader.ready()) {
                    String date = reader.readLine();
                    writer.write(date + "\n");
                }
                reader.close();
            }
            writer.close();
        }
    }
}