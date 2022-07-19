package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);

//        int a = 74 % 3;
//        int b = 75 % 3;
//        int c = 76 % 3;
//        int d = 77 % 3;
//        int g = 78 % 3;
//
//
//        System.out.println( a + " "  +  b + " " + c +" "+ d + " " + g);

    }

    public void createExpression(int number) {

        int[] array = {1, 3, 9, 27, 81, 243, 729, 2187};
        StringBuilder sB = new StringBuilder(number + " =");

        for (int i = 0; i < 8; i++) {
            if (number % 3 == 1) {
                sB.append(" + ").append(array[i]); }

            else if (number % 3 == 2) {
                sB.append(" - ").append(array[i]);
                number++; }

            number = number / 3;
        }

        System.out.println(sB);
    }
}