package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {

    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averGrade) {
        Student student = null;
        for (Student averageStudent : students) {
        if  (averageStudent.getAverageGrade() == averGrade){
             student = averageStudent;} }
        return student;    }

    public Student getStudentWithMaxAverageGrade () {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (Student averageStudent : students) {
            arrayList.add(averageStudent.getAverageGrade());}
        Collections.sort(arrayList);
        double averGradeMax = arrayList.get(arrayList.size() -1);

        Student studentMax = null;
        for (Student averageStudent : students) {
            if  (averageStudent.getAverageGrade() == averGradeMax){
                studentMax = averageStudent;}
        }
        return studentMax;    }


    public Student getStudentWithMinAverageGrade () {
        ArrayList<Double> arrayList = new ArrayList<>();
        for (Student averageStudent : students) {
            arrayList.add(averageStudent.getAverageGrade());}
        Collections.sort(arrayList);
        double averGradeMax = arrayList.get(0);

        Student studentMin = null;
        for (Student averageStudent : students) {
            if  (averageStudent.getAverageGrade() == averGradeMax){
                studentMin = averageStudent;}
        }
        return studentMin;    }

    public void expel (Student student){
      //  for (Student averageStudent : students) {
          //  if (averageStudent == student) {
           /* if (averageStudent.equals( student)) {
            students.remove(averageStudent); }*/
           // else System.out.println("Такого студента нет");
            students.remove(student);
        }
    }


