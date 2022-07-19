package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content; // видео
    private String name; // название видео
    private long initialAmount; // начальная сумма, стоимость рекламы в копейках
    private int hits; //  количество оплаченных показов
    private int duration; // продолжительность в секундах
    private long amountPerOneDisplaying; // стоимость одного показа рекламного объявления в копейках

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public Advertisement () {} // пустой конструктор что достать getHits

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0; // стоимость одного показа рекламного объявления в копейках
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
    }
    public void revalidate() {
        if (hits <= 0) {throw new UnsupportedOperationException();}
        hits--;
    }
    public int getHits() {
        return hits;
    }
}
