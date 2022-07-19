package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.io.IOException;
import java.util.*;
//  у каждого планшета будет свой объект менеджера, который будет подбирать оптимальный набор роликов
//  и их последовательность для каждого заказа.
//Он также будет взаимодействовать с плеером и отображать ролики.
public class AdvertisementManager {
    public int timeSeconds; //- это время выполнения заказа поваром в секундах.
    final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    List<Advertisement> list = new ArrayList<>(storage.videos);  // копия списка из хранилища
    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
//--------------------------------------------------------------------------------------------------------
    public List<Advertisement> bestItems = new ArrayList<>(); // лучший набор предметов для рюкзака
    public double bestInitialAmount; // общая стоимость предметов лучшего набора bestItems

    //вычисляет общее время в секундах
    private int calcDuration (List<Advertisement> items) {
        int sumDuration = 0;
        for (Advertisement i : items) {
            sumDuration += i.getDuration(); }
        return sumDuration;  }

    // вычисляет общую  стоимость одного показа рекламного объявления в копейках
    private int calcSumAmount (List<Advertisement> items) {
        int sumAmount = 0;
        for (Advertisement i : items) {
            sumAmount += i.getAmountPerOneDisplaying();}
        return sumAmount; }
//---------------------------------------------------------------------------------------------------
    //проверка, является ли данный набор лучшим решением задачи
    public void check (List<Advertisement> items) {
        int durationCheck = calcDuration(items);
        if (durationCheck > timeSeconds) {return;} // если время роликов больше времени приготовления блюда, это нужно для метода setsRevers

        if (bestItems == null) {bestItems = items;}
        else {
            long sumItems = calcSumAmount(items);
            long sumBestitems = calcSumAmount(bestItems);

            if (sumItems > sumBestitems) {bestItems = items;} // если новая сумма больше
            else if (sumItems == sumBestitems) { // если суммы равны тогда выбираем с максимальным временем
                int durationNew = calcDuration(bestItems);
                if (durationNew < durationCheck) {
                    bestItems = items;
                } else if (durationNew == durationCheck) { // тогда выбираем минимум роликов
                    if (items.size() < bestItems.size()) {
                        bestItems = items;
                    }
                }
            }
        }
    }
    //создание всех наборов перестановок значений
    public void setsRevers(List<Advertisement> items) {
        if (items.size() > 0)
            check(items);

        for (int i = 0; i < items.size(); i++) {
            List<Advertisement> newSet = new ArrayList<>(items);
            newSet.remove(i);
            if (calcSumAmount(newSet) >= calcSumAmount(bestItems))
            {
                setsRevers(newSet);
            }
        }
    }
    private void cleanVideo(List<Advertisement> items) {
        // удалим те видео, в которые количество оплаченных показов уже нулевое
        int i = 0;
        while (i < items.size()) {
            if (items.get(i).getHits() == 0)  items.remove(i);
            else i++;
        }
    }
//-------------------------------------------------------------------------------------------------------------
    public void processVideos() { // обрабатывает рекламное видео.

        int totalDuration = 0;
        int totalAmount = 0;

        if (storage.videos.isEmpty()) // Если нет рекламных видео, которые можно показать посетителю,
        // то бросить NoVideoAvailableException, которое перехватить в оптимальном месте
        {
            throw new NoVideoAvailableException();
        }
//        cleanVideo(storage.videos);
//        setsRevers(storage.videos);

        cleanVideo(list);
        Collections.reverse(list);  // "разворот" списка перед передачей в обработку
        setsRevers(list);

        for (Advertisement advertisement : bestItems) {
            totalDuration += advertisement.getDuration();
            totalAmount += advertisement.getAmountPerOneDisplaying();
        }

        // сортировки по условию задач (9 и 10)
        Collections.sort(bestItems, Comparator.comparingLong(Advertisement::getAmountPerOneDisplaying).reversed());
        // Зарегистрируй событие "видео выбрано" перед отображением рекламы пользователю.
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(bestItems, totalAmount, totalDuration));

        for (Advertisement ad : bestItems) {
            String adName = ad.getName();
            long adAmount = ad.getAmountPerOneDisplaying(); // стоимость показа одного рекламного ролика в копейках
            long adUnitCost = adAmount * 1000 / ad.getDuration(); // стоимость показа одной секунды рекламного ролика в тысячных частях копейки

            try {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", adName, adAmount, adUnitCost));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ad.revalidate();
        }
    }
        // проверка на наличие "бесполезных" видео (у которых закончились просмотры) и при необходимости
        //// удаления их
     //   items.removeIf(item -> item.getHits() <= 0); // вроде нужно удалить, вместо следующая строка.
        //    items = items.stream().filter(item -> item.getHits() > 0).collect(Collectors.toList())
    }
