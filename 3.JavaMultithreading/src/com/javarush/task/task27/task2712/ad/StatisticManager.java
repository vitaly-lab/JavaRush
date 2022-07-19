package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.kitchen.Cook;

import java.util.ArrayList;
import java.util.List;

//хранилище рекламных роликов
public class StatisticManager {

    private static StatisticManager instance;
    public static StatisticManager getInstance() { // синглтон, так как хранилище рекламных роликов AdvertisementStorage
        // единственное для всего ресторана
        if (instance ==null){
            instance = new StatisticManager();
        }
        return instance; }

    final List <Advertisement> videos = new ArrayList<>(); // хранение видео

    public List <Advertisement> list() {return videos;}

    public void add(Advertisement advertisement){videos.add(advertisement);}

    public StatisticManager() {

        Object someContent = new Object();

        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min

//        add(new Advertisement(someContent, "4 Video", 200, 6, 20 * 60)); //2 min
//        add(new Advertisement(someContent, "4 Video", 400, 21, 1 * 60)); //1 min
//        add(new Advertisement(someContent, "5 Video", 600, 7, 1 * 60)); //1 min
//        add(new Advertisement(someContent, "6 Video", 1400, 12, 15 * 60)); //5 min
//        add(new Advertisement(someContent, "7 Video", 800, 4, 26 * 60)); //6 min
//        add(new Advertisement(someContent, "8 Video", 500, 11, 12 * 60)); //10 min
//        add(new Advertisement(someContent, "9 Video", 400, 3, 20 * 60)); //10 min

        add(new Advertisement(someContent, "Video 001", 1500, 10, 15 * 60));  // 15 min
        add(new Advertisement(someContent, "Video 002", 700, 10, 7 * 60));    // 7 min
        add(new Advertisement(someContent, "Video 003", 500, 10, 5 * 60));    // 5 min
        add(new Advertisement(someContent, "Video 004", 500, 10, 5 * 60));    // 5 min
        add(new Advertisement(someContent, "Video 005", 700, 10, 7 * 60));    // 7 min
        add(new Advertisement(someContent, "Video 006", 100, 10, 1 * 60));    // 1 min

    }

//    List<Cook> cooks = new ArrayList<>();
//
//    public List<Cook> getCooks() { return cooks; }
//
//    public void addCooks (Cook cook){cooks.add(cook);}
}
