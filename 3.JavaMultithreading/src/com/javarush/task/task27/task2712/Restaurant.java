package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    //1. Перенеси поле-очередь из OrderManager в Restaurant, сделай ее приватной константой.
    private final static LinkedBlockingQueue <Order> ORDER_QUEUE = new LinkedBlockingQueue<>();;
    private static final LinkedBlockingQueue <Order> orderQueue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {

     //   OrderManager orderManager = new OrderManager();
        Tablet tablet = null;
        List <Tablet> tabletList = new ArrayList<>();
// 5. Создай список объектов-планшетов 5 штук, инициализируй его в цикле.
        for (int i = 0; i <= 4; i++){
        tablet = new Tablet(i);
        tablet.setQueue(orderQueue);
        tabletList.add(tablet);}

        Waiter waiter = new Waiter();
//-----------------------------------------------------------------------------------------------------------
        StatisticManager statisticManager = new StatisticManager();
        List<Cook> cooks = new LinkedList<>();
        // 2. Создай второго повара.
        //3. Зарегистрируй поваров используя класс StatisticManager.
        //4. Для обоих поваров и всех планшетов расставь зависимость Observer-Observable
        for (int i = 1; i < 3; i++) {
          Cook cook = new Cook("Повар" + i);
          //  StatisticManager.getInstance().register(cook);
            cook.addObserver(waiter);
            cooks.add(cook);
          //  statisticManager.register(cook);
          }
//        for (Tablet t : tabletList){ // Создай список объектов-планшетов 5 штук, инициализируй его в цикле.
//         //  for (Cook c : cooks){
//            // t.addObserver(c);
//                tablet.addObserver(orderManager);
//            }
      //  }
    // ----------------------------------------------------------------------------------------------------------
        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();
        try { Thread.sleep(1000); }
        catch (InterruptedException e) { return; }
        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
