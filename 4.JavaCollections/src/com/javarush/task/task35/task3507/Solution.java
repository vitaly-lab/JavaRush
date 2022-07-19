package com.javarush.task.task35.task3507;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {

        Set<? extends Animal> allAnimals = getAllAnimals(
                Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                        + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");


        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {

        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/")) // проверяем что строка на конце не иммет стмволов "\\" и "/"
            pathToAnimals = pathToAnimals + "/"; // и если не имеет то добовляем "/"

        Set<Animal> set = new HashSet<>();
        File[] dir = new File(pathToAnimals).listFiles();

        for (File f : dir) {
            try {
                if (f.isFile() && f.getName().contains(".class")) {
                    MyClassLoader loader = new MyClassLoader();
                    Class<?> clazz = loader.loadClass(f.getAbsolutePath());

                    if (Animal.class.isAssignableFrom(clazz)) {
                        Constructor<?> constructor = clazz.getConstructor();
                        set.add((Animal) constructor.newInstance());
                    }
                }
            } catch (Exception e) {
            }
        }
        return set;







    }
}
