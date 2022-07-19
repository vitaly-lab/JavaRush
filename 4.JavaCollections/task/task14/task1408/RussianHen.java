package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country {

    String country = RUSSIA;

    @Override
    public int getCountOfEggsPerMonth(){
        return 3;}
    @Override
    public String getDescription (){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц." ;}
}
