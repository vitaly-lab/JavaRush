package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;
// выбрали набор видео-роликов для заказа
public class VideoSelectedEventDataRow implements EventDataRow {

    List<Advertisement> optimalVideoSet; // список видео-роликов, отобранных для показа
    long amount; // сумма денег в копейках
    int totalDuration; // общая продолжительность показа отобранных рекламных роликов
    Date currentDate;

    public long getAmount() { return amount; }

  //  public VideoSelectedEventDataRow(){}

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date(); }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    } // реализация которого вернет дату создания записи;

    @Override
    public int getTime() {
        return totalDuration;
    } // реализация которого вернет время или продолжительность.


}
