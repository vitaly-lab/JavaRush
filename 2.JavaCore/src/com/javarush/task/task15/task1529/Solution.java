package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            //add your code here - добавьте код тут
            reset();
        } catch (IOException ex) {
            Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String value = reader.readLine();

        if (value.equals("helicopter")) result = (CanFly) new Helicopter();
        else if (value.equals("plane")) result = new Plane(154);

    }
}
