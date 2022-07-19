package com.javarush.task.task14.task1417;

public class Ruble extends Money {

    public Ruble(double x) {
        super(x);
    }
    @Override
    public String getCurrencyName(){
        return "RUB";}

}
