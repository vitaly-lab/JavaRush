package com.javarush.task.task15.task1529;

public class Plane implements CanFly{
    int a;

    public void fly(){
        System.out.println("Самолёт");
    }

    public Plane (int a){

        this.a = a;
    }

}
