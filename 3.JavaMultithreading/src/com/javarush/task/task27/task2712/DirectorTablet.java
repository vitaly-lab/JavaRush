package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.io.IOException;
import java.util.*;

public class DirectorTablet {

     void printAdvertisementProfit (){
            Map<String, Double> map = StatisticManager.getInstance().allDateStorage(EventType.SELECTED_VIDEOS);
        double amountTotal = 0;
        try {
            for (Map.Entry<String, Double> entry : map.entrySet()){
                amountTotal += entry.getValue();
                ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", entry.getKey(), entry.getValue()));;
            }
            if (amountTotal > 0 ) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", amountTotal)); }
        } catch (IOException e) {
        e.printStackTrace();
    }
     }
    void printCookWorkloading (){
        Map <String, Map<String, Integer>> map = new TreeMap<>( StatisticManager.getInstance().loadCooks(EventType.COOKED_ORDER));

        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()){
            try {
                ConsoleHelper.writeMessage(entry.getKey());
                for (Map.Entry<String, Integer> entryCook : entry.getValue().entrySet())
                    ConsoleHelper.writeMessage(String.format("%s - %s" + " min", entryCook.getKey(), entryCook.getValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    void printActiveVideoSet (){
//         Map <String, Integer> map = StatisticAdvertisementManager.getInstance().getMovieOn();
//
//         for (Map.Entry <String, Integer> entry : map.entrySet()) {
//             if(entry.getValue() > 0) {
//                 try {
//                     ConsoleHelper.writeMessage(String.format("%s - %s", entry.getKey(), entry.getValue()));
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }
//    }
//    void printArchivedVideoSet (){
//        Map <String, Integer> map = StatisticAdvertisementManager.getInstance().getMovieOn();
//
//        for (Map.Entry <String, Integer> entry : map.entrySet()) {
//            if(entry.getValue() == 0) {
//                try {
//                    ConsoleHelper.writeMessage(String.format("%s", entry.getKey()));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
public void printActiveVideoSet(){
    Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getActiveVideos();
    List<String> list = new ArrayList<>(videos.keySet());
    list.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareToIgnoreCase(o2);
        }
    });
    for(String s : list)
    {
        try {
            ConsoleHelper.writeMessage(String.format("%s - %d", s, videos.get(s)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    public void printArchivedVideoSet(){
        Map<String, Integer> videos = StatisticAdvertisementManager.getInstance().getArchivedVideos();
        List<String> list = new ArrayList<>(videos.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for(String s : list)
        {
            try {
                ConsoleHelper.writeMessage(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
