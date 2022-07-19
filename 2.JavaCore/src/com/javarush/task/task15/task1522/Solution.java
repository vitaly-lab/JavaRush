package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;



/*
Закрепляем паттерн Singleton
*/

public class Solution  {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    static {

       try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException ex) {
          //  Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String name = reader.readLine();

        if (name.equals(Planet.SUN)) thePlanet = Sun.getInstance();
       else if (name.equals(Planet.EARTH)) thePlanet =  Earth.getInstance();
       else if (name.equals(Planet.MOON)) thePlanet = Moon.getInstance();
       else  thePlanet = null;


    }
}
