package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
/*
Глубокое клонирование карты
*/
public class Solution implements Cloneable{

    public Solution clone () throws CloneNotSupportedException {
    Solution clone = (Solution) super.clone();
        clone.users = new LinkedHashMap<>();
        clone.users.putAll(users);
        return clone;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));

        Solution clone;

        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    public Object clone () {

        User user = new User(age, name);
        user.age = this.age;
        user.name = this.name;
        return user;

    }


    }
}
