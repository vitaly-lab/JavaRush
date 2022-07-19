package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        ArrayList <Object> arr = new ArrayList<>();
        for (String s : args)
            arr.add(s);


        String c = "-c";
        String u = "-u";
        String d = "-d";
        String i = "-i";

        if (c.equals((String) arr.get(0))) {
            String a1 = (String) arr.get(1);
            String a2 = (String) arr.get(2);
            String a3 = (String) arr.get(3);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date y = dateFormat.parse(a3);

            if (a2.equals("м")){allPeople.add(Person.createMale(a1, y));}
            if (a2.equals("ж")){ allPeople.add(Person.createFemale(a1, y));}
            System.out.println(allPeople.size()-1); }

        if (u.equals((String) arr.get(0))) {
            String a1 = (String) arr.get(1);
            int b = Integer.parseInt(a1);
            String a2 = (String) arr.get(2);
            String a3 = (String) arr.get(3);
            String a4 = (String) arr.get(4);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date y = dateFormat.parse(a4);

            if (a3.equals("м")){allPeople.set(b, Person.createMale(a2, y));}
            if (a3.equals("ж")){allPeople.set(b, Person.createFemale(a2, y));} }

        if (d.equals((String) arr.get(0))) {
            String a1 = (String) arr.get(1);
            int b = Integer.parseInt(a1);

            Person cPerson = allPeople.get(b);
            cPerson.setName(null);
            cPerson.setSex(null);
            cPerson.setBirthDate(null);


        }

        if (i.equals((String) arr.get(0))) {
            String a1 = (String) arr.get(1);
            int b = Integer.parseInt(a1);

            Person cPerson = allPeople.get(b);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
            String gString = cPerson.getSex().equals(Sex.FEMALE) ? "ж" : "м";
            System.out.println(cPerson.getName() + " " + gString + " " + dateFormat.format(cPerson.getBirthDate()));


        }

    }
}
