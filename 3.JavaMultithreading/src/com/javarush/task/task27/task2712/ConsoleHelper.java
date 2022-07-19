package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task27.task2712.kitchen.Dish.allDishesToString;

public class ConsoleHelper {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static public void writeMessage(String message) throws IOException {
        System.out.println(message);
    }
    static public String readString() throws IOException {
    return reader.readLine();
    }
    static public List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> lDish = new ArrayList<>();
       String dishMenu = allDishesToString();
        writeMessage("Веедите следующие блюда " + dishMenu);

        String dishName;
        while (!(dishName = readString()).equals("exit")) {
            for (Dish dish : Dish.values()) {
                if (dishName.equals(dish.toString())) {
                  lDish.add(Dish.valueOf(dishName));
                  writeMessage("Блюдо принято"); break;
                }
            }
        }
            return lDish;
        }


    }
