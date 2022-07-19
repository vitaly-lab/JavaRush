package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            key = reader.readLine();
            if (!key.equals("user") && !key.equals("loser") && !key.equals("coder") && !key.equals("proger"))
                break;
            list.add(key);}
        //тут цикл по чтению ключей, пункт 1
        {
            Set<String> set = new HashSet<String>(list);
            if (set.contains("user")){
                person = new Person.User();
                doWork(person);}
            if (set.contains("loser")){
                person = new Person.Loser();
                doWork(person);}
            if (set.contains("coder")){
                person = new Person.Coder();
                doWork(person);}
            if (set.contains("proger")){
                person = new Person.Proger();
//создаем объект, пункт 2

                doWork(person); //вызываем doWork
            }
        }
    }

    public static void doWork(Person person) {

        if (person instanceof Person.User)
            ((Person.User)person).live();
        if (person instanceof Person.Coder)
            ((Person.Coder)person).writeCode();
        if (person instanceof Person.Loser)
            ((Person.Loser)person).doNothing();
        if (person instanceof Person.Proger)
            ((Person.Proger)person).enjoy();
        // пункт 3
    }
}
