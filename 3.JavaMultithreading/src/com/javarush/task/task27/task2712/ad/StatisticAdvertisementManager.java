package com.javarush.task.task27.task2712.ad;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {

    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private StatisticAdvertisementManager () {}
    public static StatisticAdvertisementManager getInstance() { // синглтон,
        if (instance == null){
            instance = new StatisticAdvertisementManager();  }
        return instance; }

    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

//        public Map<String, Integer> getMovieOn () {
//            Map<String, Integer> map = new TreeMap<>();
//        for (Advertisement a : advertisementStorage.list()) {
//
//            if (a.getHits() > 0) {map.put(a.getName(), a.getHits()); }
//            if (a.getHits() <= 0) {map.put(a.getName(), 0);}
//        }
//            return map;
//        }
public Map<String, Integer> getActiveVideos()
{
    Map<String, Integer> result = new HashMap<>();
    List<Advertisement> videos = advertisementStorage.list();

    for(Advertisement a : videos)
    {
        if(a.getHits() > 0)
            result.put(a.getName(), a.getHits());
    }

    return result;
}

    public Map<String, Integer> getArchivedVideos()
    {
        Map<String, Integer> result = new HashMap<>();
        List<Advertisement> videos = advertisementStorage.list();

        for(Advertisement a : videos)
        {
            if(a.getHits() <= 0)
                result.put(a.getName(), a.getHits());
        }

        return result;
    }
}
