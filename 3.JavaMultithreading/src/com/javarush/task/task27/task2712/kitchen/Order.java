package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

      public Tablet getTablet() {
        return tablet;
    }

    public boolean isEmpty(){
        if (dishes != null && !dishes.isEmpty()) {return false; }
        else
        { return true; }
    }

    public Order (Tablet tablet) throws IOException { //В классе должна быть информация, относящаяся к списку выбранных пользователем блюд.
        this.tablet = tablet;
        initDishes();
      }

    public int getTotalCookingTime(){ // суммарное время приготовления всех блюд в заказе
        int b = 0;
        for (Dish dish : dishes) {
            b = b + dish.getDuration();
        }
        return b;
    }
       @Override
       // возвращает пустую строку, если нет блюд в заказе, иначе результат должен быть таким,
       // как в примере (исполь-зуй toString объекта tablet):
       //Your order: [JUICE, FISH] of Tablet{number=5}
    public String toString() {

        if (!isEmpty()) {

            if (dishes == null) {
                return null;
            } else {
                final StringBuffer sb = new StringBuffer("You order: ");
                sb.append(dishes);
                sb.append(" of ");
                sb.append(tablet.toString() + ", cooking time " + getTotalCookingTime() + "min");

                return sb.toString();
            }
        }
        else return "Заказ пуст";
    }
    public List<Dish> getDishes() {
        return dishes;
    }
    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}