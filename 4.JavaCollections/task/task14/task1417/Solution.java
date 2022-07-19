package com.javarush.task.task14.task1417;

import java.awt.AWTEventMulticaster;
import java.util.ArrayList;
import java.util.List;

/*
Валюты
*/
public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());} }


    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();

            this.allMoney.add(new Hrivna(150));
            this.allMoney.add(new Ruble(180));
            this.allMoney.add(new USD(300));
//напишите тут ваш код
        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
