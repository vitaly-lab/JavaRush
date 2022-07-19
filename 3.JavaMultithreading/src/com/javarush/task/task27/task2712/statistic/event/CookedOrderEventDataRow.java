package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;
// повар приготовил заказ
public class CookedOrderEventDataRow implements EventDataRow {

    String tabletName; //имя планшета
    String cookName; //  имя повара
    int cookingTimeSeconds; // время приготовления заказа в секундах
    List<Dish> cookingDishes; // список блюд для приготовления
    Date currentDate;

    public String getCookName() { return cookName; }

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        currentDate = new Date(); }

    @Override
    public EventType getType() {
        return  EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return currentDate;
    } // реализация которого вернет дату создания записи;

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    } // реализация которого вернет время или продолжительность.

 //   public int getCookingTimeSeconds () {return cookingTimeSeconds;}

}
