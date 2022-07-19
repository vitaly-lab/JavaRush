package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals (Object o) {

        if (o == null)  return false;

        if (this == o)  return true;

       if (!(o instanceof Solution))
            return false;

      // if (o.getClass() == this.getClass())  return true;

        Solution other = (Solution) o;
     //   return true;

      //  return first != null && last != null && other.first.equals(first) && other.last.equals(last);
        if (first != null ? !first.equals(other.first) : other.first != null) return false;
        return last != null? last.equals(other.last) : other.last == null;
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
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        Solution test = new Solution("Don", "Jeck");
        Solution test1 = new Solution("Don", "Jeck");

        System.out.print(test.equals(test1));
    }
}
