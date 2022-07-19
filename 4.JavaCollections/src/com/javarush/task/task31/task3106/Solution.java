package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0]; // название распакованного файла
        List<String> arrayList = new ArrayList<>(); // коллекция названий архивированных файлов

        arrayList.addAll(Arrays.asList(args).subList(1, args.length)); // добавление в колекцию имён файлов кроме первого
        Collections.sort(arrayList); // сортироваь колеекцию

        List<FileInputStream>  fileInputStreams = new ArrayList<>(); // колеекция чтения байтов из файла

        for (int i = 0; i < arrayList.size(); i++) { // цикл проходит коллекцию имён и заполняет коллекцию потоков байт
            try {
                fileInputStreams.add(new FileInputStream(arrayList.get(i)));
            } catch (FileNotFoundException e) { e.printStackTrace();  }
        }
        // читает несколько файлов по байтово с автомат. переходом от одного к другому
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreams));

        ZipInputStream zipInStream = new ZipInputStream(sequenceInputStream); // этот класс читает архивы, в конструкторе принимает поток
        FileOutputStream fileOutStream = new FileOutputStream(fileName); // предназначен для записи байт в файл
        byte[] buf = new byte[1024 * 1024]; // необходимо буферизировать поток байт

        while (zipInStream.getNextEntry() != null) { // считывает поток данных пока не кончатся данные , возврощает ZipEntry

            int count;
            while ((count = zipInStream.read(buf)) != -1) { // читает поток и сохраняет в буфере
                fileOutStream.write(buf, 0, count); // читает из буфера и сохраняет в файл
            }
        }

        sequenceInputStream.close();
        zipInStream.close();
        fileOutStream.close();
    }

    }



