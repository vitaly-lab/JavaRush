package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

//Tablet создает заказы, а Cook их обрабатывает
// public class Cook extends Observable implements Observer {
 public class Cook extends Observable implements Runnable{
   String name;
   boolean busy;
   boolean a = false;
    private boolean caught = false;
// 2. Добавь поле-очередь LinkedBlockingQueue queue и сеттер в класс Cook, сразу после создания повара,
// используя со-зданный сеттер, установи ему константу из п.1 в качестве значения для созданного поля.
    private LinkedBlockingQueue<Order> queue;
    public void setQueue(LinkedBlockingQueue queue) {this.queue = queue; }

    public boolean isBusy() { return busy; }
    public Cook(String name) {this.name = name; }
    @Override
    public String toString() {return name; }

   public void startCookingOrder(Order order) {
        busy = true;
        try {
            setChanged();
            notifyObservers(order);
            ConsoleHelper.writeMessage( "Start cooking - " + order + "was cooked by " + name);
              // Регистрируем событие "COOKED_ORDER"
               StatisticManager.getInstance().register(
                    new CookedOrderEventDataRow(
                            order.getTablet().toString(), //имя планшета
                           //  o.toString(),
                            name, //  имя повара
                            order.getTotalCookingTime() * 60, // время приготовления заказа в секундах
                            order.getDishes() // список блюд для приготовления
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
       try {
           Thread.sleep((order.getTotalCookingTime()  * 10));
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       busy = false;
    }
    @Override
    public void run() {
//       // Set<Cook> cooks = StatisticManager.getInstance().getCooks();
//        Set<Cook> cooks = StatisticManager.getInstance().loadCooks();
//        while (!a) {
//            while (!queue.isEmpty()) {
//                for (Cook cook : cooks) {
//                    if (!cook.isBusy()) {
//                        cook.startCookingOrder(queue.poll());
//                    }
//                }
//            }
//            try
//            {
//                Thread.sleep(10);
//            }
//            catch (InterruptedException e) {}
//        }
//        if (queue.isEmpty()) a = true;
        while (!a){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                try {
                    ConsoleHelper.writeMessage(e.getMessage());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (queue.peek()!=null){

                if (!this.isBusy()) {
                    try{
                        //final Cook cookFinal = cook;
                        Order order = queue.take();
                        if (order!=null){
                            //Thread tr = new Thread(()->
                            startCookingOrder(order);
                            //tr.start();
                        }
                    }
                    catch (InterruptedException e){caught = true;}
                }
            }
            if (caught && queue.isEmpty()) a = true;
        }
    }

}
