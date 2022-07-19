package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public void recurse(int n) {
        int p = 2;

        while (p <= n) {

            if (p > n / p) {
                System.out.print(n + " ");
                return;
            }
            if (n % p == 0) {
                if (p != n) {
                    System.out.print(p + " ");
                    recurse(n / p);
                }
                else {
                    System.out.println(p);
                }
                return;
            }
            p++;
        }
    }
}
