package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Externalizable {
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) throws IOException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

   public Solution(String string) throws IOException {this.string = string;}

    @Override
    public String toString() {
        return this.string;
   }

    Solution savedSolution = new Solution("Привет");
    Solution savedSolution1 = new Solution("Ку-Ку");

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(savedSolution);
        out.writeObject(savedSolution1);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        savedSolution = (Solution) in.readObject();
        savedSolution1 = (Solution) in.readObject();
    }

   // if ()

    //  Solution newSaved = (Solution) object;
  //  Solution newSaved1 = (Solution) object;

}
