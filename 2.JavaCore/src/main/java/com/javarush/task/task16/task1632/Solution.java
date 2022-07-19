package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {

        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();
    }

    static class Thread1 extends Thread{
        public void run () { while(true){}  }}

    static class Thread2 extends Thread{
        public void run () { while (true) {
            try {
                Thread1.sleep(1500);
            } catch (InterruptedException ex) { }
            System.out.println("InterruptedException");
        }  }}

    static class Thread3 extends Thread{
        public void run ()
        { while (true) {
            try {
                System.out.println("Ура");
                Thread3.sleep(500);
            } catch (InterruptedException ex) { }

        }  }}

    static class Thread4 extends Thread implements Message{

        volatile boolean isActive;
        public void showWarning() {
            isActive = false; }

        Thread4(){
            isActive = true; }

        public void run ()
        { while(isActive){}

            showWarning();
        }}

    static class Thread5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static int i = 0;
        static String name;

        public void run () {

            while (true) {
                try {
                    name = reader.readLine();
                } catch (IOException ex) { }

                if (!name.equals("N")){
                    int a = Integer.parseInt(name);
                    i += a;
                }
                else break;
            }
            System.out.println(i);
        }

    }   }

