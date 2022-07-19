package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override

    public void update(Observable observable, Object arg) {
     // Tablet tablet = new Tablet(observable.countObservers());
     // Order order = new Order(tablet);
    //    Cook cook = new Cook( observable.toString());

        try {
            ConsoleHelper.writeMessage( arg + " was cooked by " + "was cooked by " + observable);
            // observable.setChanged();
            // observable.notifyObservers(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
