package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//public class Tablet extends Observable { // Этот класс создаёт планшет с номером откуда поступил заказ.
public class Tablet {
    private final int number; //это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ
    static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }
    private LinkedBlockingQueue<Order> queue;
    public void setQueue(LinkedBlockingQueue<Order> queue) {this.queue = queue; }

    public Order createOrder() { // метод который будет создавать заказ из тех блюд, которые выберет пользователь.
        Order order = null;
        try {
            order = new Order(this);
        //    setChanged();
        //    notifyObservers(order);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                queue.add(order);
                AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
                advertisementManager.processVideos();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        try {
            AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            advertisementManager.processVideos(); // запуск рекламного ролика
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        }
        return order;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Tablet{number=" + number);
        sb.append('}');
        return sb.toString();
    }

    public void createTestOrder() { // метод который будет создавать заказ из тех блюд, которые выберет пользователь.
        Order order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.INFO, "Console is unavailable.");
        }
    }
}