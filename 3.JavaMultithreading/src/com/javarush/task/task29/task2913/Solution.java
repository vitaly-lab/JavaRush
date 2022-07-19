package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

   /* public static String getAllNumbersBetween(int a, int b) {
        if (a > b) {
            return a + " " +  getAllNumbersBetween(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + getAllNumbersBetween(a + 1, b);
        }
    }*/
   /* public static String getAllNumbersBetween(int a, int b) {
     //   System.out.println(a + " " + b);
        List<Integer> list = new ArrayList<>();
        String str = null;
        if (a > b) {
            for (int i = a; i > b; i--){list.add(i);
            }
            return   list.toString()
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .trim();
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            for (int i = a; i < b; i++){list.add(i);}
            return   list.toString()
                    .replace(",", "")
                    .replace("[", "")
                    .replace("]", "")
                    .trim();
        }
    }*/
public static String getAllNumbersBetween(int a, int b) {
    StringBuilder builder = new StringBuilder();
        if (a > b) {
            for (int i = a; i >= b; i--){builder.append(i + " ");}
        } else {
            if (a == b) {
                return Integer.toString(a).trim();
            }
            for (int i = a; i <= b; i++){builder.append(i + " ");}
        }
        return builder.toString().trim();
    }


//-------------------------------------------------------
    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));

    }
}