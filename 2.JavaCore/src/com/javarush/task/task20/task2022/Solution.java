package com.javarush.task.task20.task2022;

import java.io.*;

public class Solution implements Serializable, AutoCloseable{
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
       try {
            stream = new FileOutputStream(fileName, true);
        }
        catch (NullPointerException e){ //System.out.println("Ошибка NullPointerException ===");
       }
        in.defaultReadObject();
        //  in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NullPointerException {

        FileOutputStream outputStream = new FileOutputStream("c:/arc/save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Solution solution = new Solution("c:/arc/sss.ser");

        objectOutputStream.writeObject(solution);


        FileInputStream inputStream = new FileInputStream("c:/arc/save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        //  Solution solution1 = new Solution("c:/arc/sss.ser");

        Solution solution1 = (Solution) objectInputStream.readObject();

        System.out.println(solution1);

    }
}
