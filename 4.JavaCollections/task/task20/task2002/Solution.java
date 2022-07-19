package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("c:/arc/444.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();

            user.setFirstName("Jonh");
            user.setLastName("Smith");
            user.setCountry(User.Country.OTHER);
            user.setMale(true);
            Date date = new Date(1978,12,11);
            user.setBirthDate(date);


            //  Добавляем пользователей в список
            javaRush.users.add(user);
            //javaRush.users.add(user1);

         //   JavaRush users;
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

          //  javaRush.equals(loadedObject);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
           //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
           // String isPresent = users != null ? "уes" : "now";

          //  writer.print(isPresent);
          //  writer.flush();

            if (users.size() != 0){
                for (User str : users){

                    writer.println(str.getFirstName());
                    writer.println(str.getLastName());
                    writer.println(str.getBirthDate().getTime());
                    writer.println(str.isMale());
                    writer.println(str.getCountry());

                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

           // String isPresent = reader.readLine();
            if (users.size() == 0)  {

                String line;
                while ((line = reader.readLine()) != null) {
                    String firstName = line;
                    String secondName = reader.readLine();

                    String date = reader.readLine();
                    long gDate = Long.parseLong(date);
                    Date birthDate = new Date(gDate);

                    String sex = reader.readLine();
                    boolean gend = true;

                    switch (sex) {
                        case "true":
                            gend = true;
                            break;
                        case "false":
                            gend = false;
                            break;
                    }

                    String country = reader.readLine();
                    User.Country valueCountry = null;
                    switch (country) {
                        case "UKRAINE":
                            valueCountry = User.Country.UKRAINE;
                            break;
                        case "RUSSIA":
                            valueCountry = User.Country.RUSSIA;
                            break;
                        case "OTHER":
                            valueCountry = User.Country.OTHER;
                            break;

                    }

                    User userNew = new User();

                    userNew.setFirstName(firstName);
                    userNew.setLastName(secondName);
                    userNew.setBirthDate(birthDate);
                    userNew.setMale(gend);
                    userNew.setCountry(valueCountry);

                    users.add(userNew);

                }
            }

            reader.close();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
