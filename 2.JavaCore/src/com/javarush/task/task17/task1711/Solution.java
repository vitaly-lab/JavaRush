package com.javarush.task.task17.task1711;

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
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]){

            case ("-c"): {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        Date date = dateFormat.parse(args[i + 2]);

                        if (args[i + 1].equals("м")) {
                            allPeople.add(Person.createMale(args[i], date));
                        }
                        if (args[i + 1].equals("ж")) {
                            allPeople.add(Person.createFemale(args[i], date));

                        }
                        System.out.println(allPeople.size()- 1);
                    }
                }
                break;
            }


            case ("-u"): {

                synchronized(allPeople){
                    for (int i = 1; i < args.length; i = i + 4) {
                        Date y = dateFormat.parse(args[i + 3]);
                        int b = Integer.parseInt(args[i]);
                        if (args[i + 2].equals("м")){allPeople.set(b, Person.createMale(args[i + 1], y));}
                        if (args[i + 2].equals("ж")){allPeople.set(b, Person.createFemale(args[i + 1], y));}


                    } break;

                }   }

            case ("-d"): {

                synchronized(allPeople){
                    for (int i = 1; i < args.length; i = i + 1) {
                        int b = Integer.parseInt(args[i]);
                        Person cPerson = allPeople.get(b);
                        cPerson.setName(null);
                        cPerson.setSex(null);
                        cPerson.setBirthDate(null);
                        System.out.println(allPeople);
                    }  break;

                }

            }

            case("-i"): {

                synchronized(allPeople){
                    for (int i = 1; i < args.length; i = i + 1) {
                        int b = Integer.parseInt(args[i]);
                        Person cPerson = allPeople.get(b);
                        SimpleDateFormat dateF = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                        String gString = cPerson.getSex().equals(Sex.FEMALE) ? "ж" : "м";
                        System.out.println(cPerson.getName() + " " + gString + " " + dateF.format(cPerson.getBirthDate()));
                    } break;
                }
            }
        }}}

