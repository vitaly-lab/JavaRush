package com.javarush.task.task14.task1417;

public class USD extends Money{

//USD usd = new USD ();

    public USD(double x) {
        super(x);
    }

    @Override
    public String getCurrencyName(){
        return "USD";}
}

