package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {

    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public int getCourse() {
        return course;
    }

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() { }

    public String getPosition() {return "Студент"; }

    public void incAverageGrade (double delta) {
     averageGrade += delta;
     setAverageGrade(averageGrade);
     getAverageGrade();
       }

    public void setCourse (int value) {
            course = value;
            return;
    }

    public void setAverageGrade (double value) {
                 averageGrade = value;
            return;
        }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}