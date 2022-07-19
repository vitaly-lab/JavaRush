package com.javarush.task.task31.task3107;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/*
Null Object Pattern
*/
public class Solution {

    private FileData fileData;

    public Solution(String pathToFile) throws IOException {

        Path file = Paths.get(pathToFile);

        try {
             fileData = new ConcreteFileData(Files.isHidden(file), Files.isExecutable(file),
                    Files.isDirectory(file),  Files.isWritable(file));
        } catch (Exception e) {
            fileData = new NullFileData(new Exception());
        }
    }
    public FileData getFileData() {
        return fileData;
    }
}
