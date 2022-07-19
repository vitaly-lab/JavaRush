package com.javarush.task.task25.task2502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel{
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT    }


    public static class Car {
        protected List <Wheel> wheels ;

        public Car() {
            //init wheels here
            wheels = new LinkedList<>();
            String [] str = loadWheelNamesFromDB();
            Wheel [] wp = Wheel.values();

            if (Wheel.values().length != str.length) {throw new IllegalArgumentException();}
            else
                       for (int i = 0; i < Wheel.values().length; i++) {

                       if  ( !Arrays.asList(str).contains(wp[i].toString())) {throw new IllegalArgumentException();}

                           else
                           wheels.add(wp[i] = Wheel.valueOf(str[i]));

                       }
            }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
       Car car = new Car();

      //  System.out.println(Arrays.toString(car.wheels.toArray()));

    }
}
