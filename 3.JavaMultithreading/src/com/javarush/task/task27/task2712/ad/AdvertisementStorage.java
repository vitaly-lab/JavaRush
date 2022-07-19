package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

//хранилище рекламных роликов
public class AdvertisementStorage {

    private static AdvertisementStorage instance;
    public static AdvertisementStorage getInstance() { // синглтон, так как хранилище рекламных роликов AdvertisementStorage
        // единственное для всего ресторана
        if (instance ==null){
            instance = new AdvertisementStorage();
        }
        return instance; }

    final List <Advertisement> videos = new ArrayList<>(); // хранение видео

    public List <Advertisement> list() {return videos;}

    public void add(Advertisement advertisement){videos.add(advertisement);}

    public AdvertisementStorage() {

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

        add(new Advertisement(someContent, "первое видео", 1500, 10, 15 * 60));  // 15 min
        add(new Advertisement(someContent, "второе видео", 700, 10, 7 * 60));    // 7 min
        add(new Advertisement(someContent, "третье видео", 500, 1, 5 * 60));    // 5 min
        add(new Advertisement(someContent, "четвёртое видео", 500, 1, 5 * 60));    // 5 min
        add(new Advertisement(someContent, "пятое видео", 700, 1, 7 * 60));    // 7 min
        add(new Advertisement(someContent, "шестое видео", 100, 10, 1 * 60));    // 1 min

    }

}
