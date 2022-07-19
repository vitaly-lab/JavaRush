package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {

       super(fileName);

       if (!".txt".equals(fileName.substring(fileName.length()-4)))

        {super.close();
        throw new UnsupportedFileNameException();}

       else return;

   }

    public static void main(String[] args) {
    }
}

