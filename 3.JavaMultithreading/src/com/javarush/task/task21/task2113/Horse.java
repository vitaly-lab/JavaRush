package com.javarush.task.task21.task2113;

public class Horse {

    String name;
    double speed;
    double distance;

    public Horse(){}

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public void move(){

              double k =  (Math.random() * speed);
              distance += k;
      //  return distance;

    }
    public void print(){

        int m = (int) distance;
        String p = ".";
        for (int i = 0; i < m; i++){
            System.out.print(p);
        }
        System.out.println(name);

    }
}
