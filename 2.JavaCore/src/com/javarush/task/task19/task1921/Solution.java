package com.javarush.task.task19.task1921;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        while ((line = reader.readLine()) != null){
        String[] arr = line.split("\n");
                     for (String str : arr) {
                    String dig = str.replaceAll("\\D+"," ");
                    String let = str.replaceAll("\\d+","");
                    String let1 = let.trim();

                         DateFormat format = new SimpleDateFormat("dd MM yyyy");
                         Date date = format.parse(dig);


                ///   System.out.println(dig + " ");
                //   System.out.println(date);

            //  Person person;
            //  PEOPLE.add (new Person (let, date));
                Person person = new Person(let1, date);
                PEOPLE.add(person);

            }

        }
              reader.close();
             // for (Person person : PEOPLE) {
             //System.out.println(person.getName() + person.getBirthDate());
             //     System.out.print(person.getName());
  //    }


    }



}
