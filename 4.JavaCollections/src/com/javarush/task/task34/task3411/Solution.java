package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }
    ///                          'A'     'B'     'C'
    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if(numRings <= 0)                                                    // (0) дисков нет - конец
            return;
        //      'A' 'B' 'C'
        moveRing(a, c, b, numRings - 1);                        //   перекладываем n-1 дисков с a на c
        System.out.println("from " + a + " to " + b);                   // (1) переносим     1 диск     c a на b
        //      'A' 'B' 'C'
        moveRing(c, b, a, numRings - 1);                     //     перекладываем n-1 дисков с c на b

        return;                                                     // (2) конец (для наглядности листинга moveRing)

    }
}