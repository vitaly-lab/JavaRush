package com.javarush.task.task14.task1417;

public abstract class Money {

    private double amount;

    public Money(double x) {

        amount = x;
    }

    public double getAmount(){
        return amount;}

    public abstract String getCurrencyName();

}
