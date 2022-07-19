package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }
    public void fill (double numberOfLiters) throws Exception {
       if (numberOfLiters < 0)

        throw new Exception();
        fuel += numberOfLiters;
    }
    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
          if (!isSummer(date, SummerStart, SummerEnd)) {
          return getWinterConsumption(length);
        } else {
         return getSummerConsumption(length);}
    }

    public boolean isSummer (Date date, Date summerStart, Date summerEnd){
      if (date.after(summerStart)&&date.before(summerEnd)){
            return true;
        }else
        return false;
    }
   public double getWinterConsumption (int length) {
      return length * winterFuelConsumption + winterWarmingUp;
    }
   public double getSummerConsumption(int length) {
       return length * summerFuelConsumption;
    }

    private boolean canPassengersBeTransferred() {
        if (isDriverAvailable() && fuel > 0) {return true; }
        else  { return false; }
    }
    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred() && fuel <= 0)
            return 0;
       /* if (fuel <= 0)
            return 0;*/
        return numberOfPassengers;
    }
       public boolean isDriverAvailable() {
        return driverAvailable;
    }
    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
       /* if (numberOfPassengers >= 1 ) {
            fastenPassengersBelts();
            fastenDriverBelt();
         if  (numberOfPassengers == 0 )
             fastenDriverBelt();
        *//*} else {
            fastenDriverBelt();*//*
        }*/
        fastenDriverBelt();
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
    }
    
    public void fastenPassengersBelts() {
    }
    public void fastenDriverBelt() {
    }
    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers){
        Car car = null;
        if(type == TRUCK){
            car =  new Truck( numberOfPassengers);
        } else if(type == CABRIOLET){
            car =  new Cabriolet(numberOfPassengers);
        } else if(type == SEDAN){
            car = new Sedan( numberOfPassengers);
        }
        return car;
    }

}