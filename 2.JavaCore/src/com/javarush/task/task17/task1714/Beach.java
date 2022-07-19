package com.javarush.task.task17.task1714;
import java.util.ArrayList;
import java.util.Collections;
/* 
Comparable
*/
public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized String toString() {
        final StringBuffer sb = new StringBuffer("Beach");
        sb.append(", name = '").append(name).append('\'');
        sb.append(", distance = ").append(distance);
        sb.append(", quality = ").append(quality);
        // sb.append('}');
        return sb.toString();
    }

    @Override
    public synchronized int compareTo(Beach p) {
        float result = (this.quality - this.distance) - (p.quality - p.distance);
        System.out.println("Разница пляжей по качеству " + getName() + " " + " " + p.getName() +" " + result) ;
        return (int)result;
    }


    public static void main(String[] args) {
        ArrayList<Beach> result = new ArrayList<>();
        result.add(new Beach("Ilga", 50.0f, 10));
        result.add(new Beach("Kipsala", 10.0f, 7));
        result.add(new Beach("Jugla", 100.0f, 9));
        result.add(new Beach("Agla", 10.0f, 9));
        result.add(new Beach("Agla", 15.0f, 9));

        Collections.sort(result);
        for (Beach h : result) {


            // System.out.println(h);}


        }
    }
}