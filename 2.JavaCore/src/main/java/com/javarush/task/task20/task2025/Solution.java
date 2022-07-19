package com.javarush.task.task20.task2025;
import java.math.BigInteger;
import java.util.*;
/*
Алгоритмы-числа
*/
public class Solution {
    private static long [][] array;
    private static int [] inArray;
    private static long maxNumber;
    private static int index;
    private static Set<Long> treeSet;

    public static long[] getNumbers(long N) {
        long[] result = null;

        if(N < 0) return result; // отсекаем отрицательные числа
        treeSet = new TreeSet<>();

        maxNumber = N;
        int maxDegree = String.valueOf(N).length(); // размер регистров массива входного числа или максимальная степень
        genPows(maxDegree);
        generateNums(maxDegree);

        result = new long[treeSet.size()];
        int i = 0;
        for(Long l : treeSet){ result[i] = l; i++;  }
        return result;
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void generateNums(int maxPow){ // метод реализует массив чисел которые мы будем использовать как этолон
        inArray = new int[maxPow];
        Arrays.fill(inArray, 9); // заполняем массив 9.

        while (index < inArray.length && inArray[inArray.length - 1] > 0){ // сначала бежит по первому значению и.т.д.
            while (inArray[index] == 0){ index++; } // в первый раз сработает когда столкнётся с нулем в первом значении массива inArray

            if(inArray[index] > 0) {
                Arrays.fill(inArray, 0, index, --inArray[index]); // вычитает 1 сначало в первом значение пока не будет ноль и.т.д.
                index = 0; }
            checkArmstrong();
        }
    }
    //----------------------------------------------------------------------------------------------------------------------
    private static void checkArmstrong(){
        long summ = 0L;
        long summ2 = 0L;
        int minDegree = inArray.length;
        //определяем минимальную степень
        while (minDegree > 0 && (inArray [inArray.length - minDegree] == 0)) { minDegree--; }

        for (int j = inArray.length; j >= minDegree ; j--) {
            for (int i = 0; i < inArray.length; i++) {
                summ += array [inArray[i]][j];
            }
            int tempLength = String.valueOf(summ).length();
            if(tempLength == j) {
                long dupl = summ;

                while (dupl > 0) {
                    summ2 += array[(int) (dupl % 10)][j];
                    dupl /= 10;
                }
                if ((summ > 0) && (summ == summ2) && (summ < maxNumber)) treeSet.add(summ);
            }
            summ = 0l;
            summ2 = 0l;
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    private static void genPows(int maxPow){ // заполняем массив array  эталлоными значениями (цифра в степени)
        array = new long[10][maxPow + 1];  // For comfortable reading numbers starts with 1

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                //  pows[i][j] = (long) Math.pow(i, j); // так было раньше
                array[i][j] = BigInteger.valueOf(i).pow(j).longValue();
            }
        }
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
