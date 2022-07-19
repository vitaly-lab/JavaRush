package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();

    public void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock){
        doSomething();
        synchronized (this){}
    } }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}