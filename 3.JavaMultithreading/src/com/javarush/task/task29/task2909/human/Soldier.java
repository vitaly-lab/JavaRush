package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {

    String name;
    int age;

    public Soldier(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }

    public void fight() { }

    public void live() {
        fight();
    }
}