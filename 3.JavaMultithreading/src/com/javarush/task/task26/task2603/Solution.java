package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class TestClass {
        public String name;
        public String surname;
        public String patronymic;

        public TestClass(String name, String surname, String patronymic) {
            this.name = name;
            this.surname = surname;
            this.patronymic = patronymic;
        }
        public void consoleout(){
            System.out.println(name + " " + surname + " " + patronymic);

        }
    }

    static public class CustomizedComparator<T> implements Comparator <T> {

        private Comparator <T> []  comparators;

        public CustomizedComparator(Comparator... comparator) {
            this.comparators = comparator;  }

        @Override
        public int compare(T o1, T o2) {
            int res = 0;
            for (Comparator comp : comparators) {
                res = comp.compare(o1, o2);
                if(res != 0) break;}

                return res;  }
    }

    public static void main(String[] args) {

        TestClass first = new TestClass("Борис","Иванов","Иванович");
        TestClass second = new TestClass("Пётр","Петров","Петрович");
        TestClass third = new TestClass("Борис","Авдовин","Сергеевич");
        ArrayList<TestClass> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        Collections.sort (list, new CustomizedComparator <TestClass> ( new Comparator <TestClass>() {

            @Override
            public int compare (TestClass o1, TestClass o2) { return o1.name.compareTo(o2.name); } }, new Comparator <TestClass>() {

            @Override
            public int compare (TestClass o1, TestClass o2) { return o1.surname.compareTo(o2.surname); } }, new Comparator <TestClass>() {

            @Override
            public int compare (TestClass o1, TestClass o2) { return o1.patronymic.compareTo(o2.patronymic); }  }));

        for (TestClass test:list) {
            test.consoleout();
        }

    }
}
