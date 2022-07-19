package com.javarush.task.task14.task1410;

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {

        Wine wine1 = new Wine();
        return wine1;
    }

    public static Wine getWine() {
        Wine wine2 = new Wine();
        return wine2;
    }

    public static Wine getBubblyWine() {

        BubblyWine bubblywine = new BubblyWine();

        return bubblywine;
    }

}
