package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
// duration - приготовления каждого блюда в минутах
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    public int getDuration() {return duration;}

    public static String allDishesToString () {return "FISH, STEAK, SOUP, JUICE, WATER"; } //динамически формирующий строку из всех блюд.

    Dish(int duration) {this.duration = duration; }
}
