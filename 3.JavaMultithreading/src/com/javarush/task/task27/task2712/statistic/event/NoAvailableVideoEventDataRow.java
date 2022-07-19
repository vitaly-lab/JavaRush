package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;
// нет ни одного видео-ролика, который можно показать во время приготовления заказа
public class NoAvailableVideoEventDataRow  implements EventDataRow {

    int totalDuration; // время приготовления заказа в секундах
    Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration) {
        this.totalDuration = totalDuration;
        currentDate = new Date(); }

    @Override
    public EventType getType() { return EventType.NO_AVAILABLE_VIDEO; }

    @Override
    public Date getDate() { return currentDate; } // реализация которого вернет дату создания записи;

    @Override
    public int getTime() {
        return totalDuration;
    } // реализация которого вернет время или продолжительность.
}
