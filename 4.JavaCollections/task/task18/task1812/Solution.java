package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

AmigoOutputStream amigoOutputStream = new AmigoOutputStream() {
    @Override
    public void flush() throws IOException {   }

    @Override
    public void write(int b) throws IOException {  }

    @Override
    public void write(byte[] b) throws IOException { }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {  }

    @Override
    public void close() throws IOException {   }
};
   amigoOutputStream.write(6);
   amigoOutputStream.write(new byte[]{});
   amigoOutputStream.write(new  byte[]{}, 45, 67);
   amigoOutputStream.flush();

   AmigoOutputStream questionFileOutputStream = new QuestionFileOutputStream(amigoOutputStream);

amigoOutputStream.close();
    }
}