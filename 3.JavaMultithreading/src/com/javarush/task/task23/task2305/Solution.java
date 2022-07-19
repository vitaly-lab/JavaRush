package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {  }

    public static Solution[] getTwoSolutions() {

        Solution solutions = new Solution();
        Solution [] solution = new Solution[2];

        solution[0] = new Solution();
        solution[1] = new Solution();

      solution[0].innerClasses[0] = solutions.new InnerClass();
      solution[0].innerClasses[1] = solutions.new InnerClass();
      solution[1].innerClasses[0] = solutions.new InnerClass();
      solution[1].innerClasses[1] = solutions.new InnerClass();

        return solution;
    }

    public static void main(String[] args) {

    }
}
