package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;
/*
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null) return false;

        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

        if (first != null ? !(n.first.equals(first)) : n.first != null) return false;

        return last != null ? n.last.equals(last) : n.last == null;
        //return n.first.equals(first) && n.last.equals(last);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((last == null) ? 0 : last.hashCode());

        return result;
    }


    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));

        Solution test = new Solution("Din", "Jeck");
        Solution test1 = new Solution("Don", "Jeck");

        System.out.print(test.equals(test1));
    }
}
