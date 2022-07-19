package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
   private StatisticStorage statisticStorage = new StatisticStorage();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
      private Set <Cook> cooks = new HashSet();
    private static StatisticManager instance;

    public StatisticManager(){}

    public static StatisticManager getInstance() { // синглтон, так-как у нас должно быть одно хранилище с одной точкой входа.
        if (instance ==null){
            instance = new StatisticManager();  }
        return instance; }

    public void register (EventDataRow data) { // регистрировать события в хранилище
        statisticStorage.put(data);}

   // public void register (Cook cook) {cooks.add(cook); }

   public String data;
// 4. Чтобы получить список всех поваров, в классе StatisticManager добавь геттер для поля, которое заполняется в мето-де register(Cook cook).
  //  public Set<Cook> getCooks() { return cooks; } //

    // метод который из хранилища достанет все данные, относящиеся к отображению рекламы, и посчитает общую прибыль за каждый день.
    public Map<String, Double> allDateStorage (EventType type) {
        List<EventDataRow> array = statisticStorage.get(type);
        Map<String, Double> map = new TreeMap<>(Collections.reverseOrder());
        Double amount;
        for (EventDataRow eventDataRow : array ){
           VideoSelectedEventDataRow vsed = (VideoSelectedEventDataRow) eventDataRow;
                data = df.format(eventDataRow.getDate());
                amount = (double) vsed.getAmount() / 100;
            if (!map.containsKey(data)) { map.put(data, amount);}
            else map.put(data, map.get(data) + amount);
            }
        return  map;
        }
//загрузка (рабочее время) повара, сгруппировать по дням.
    public Map <String, Map<String, Integer>> loadCooks(EventType type) {
        List<EventDataRow> array = statisticStorage.get(type);
        Map <String, Integer> map = new TreeMap<>();
        Map <String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
        String name;
        Integer load;
        String data;
        for (EventDataRow eventDataRow : array) {
            name = ((CookedOrderEventDataRow)eventDataRow).getCookName();
            load = eventDataRow.getTime();
            data = df.format(eventDataRow.getDate());
            if (!map.containsKey(name)) map.put(name, load);
            else {
                map.put(name, map.get(name) + load);
            }
            result.put(data, map);
        }
        return result;
    }

private class StatisticStorage{
    Map <EventType, List<EventDataRow>> storage;

        StatisticStorage(){
            this.storage = new HashMap<>();

            this.storage.put(EventType.COOKED_ORDER, new ArrayList<>());
            this.storage.put(EventType.SELECTED_VIDEOS, new ArrayList<>());
            this.storage.put(EventType.NO_AVAILABLE_VIDEO, new ArrayList<>());
        }
    private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
          // List <EventDataRow> a = storage.get(data.getType());
         //  a.add(data);
    }
    public List<EventDataRow> get (EventType type){
            List<EventDataRow> a = storage.get(type); /// взять значение по ключу
        return a;
    }
}
}
