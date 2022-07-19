package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country {
    String country = BELARUS;

    @Override
    public int getCountOfEggsPerMonth(){
        return 8;}
    @Override
    public String getDescription (){
        return super.getDescription() + " Моя страна - " +  Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц." ;}

}
