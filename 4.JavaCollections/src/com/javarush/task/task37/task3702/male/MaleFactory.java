package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson (int age){

        Human human = null;

        if (age <= KidBoy.MAX_AGE) {human = new KidBoy();}
        if (KidBoy.MAX_AGE < age && age <= TeenBoy.MAX_AGE ) {human = new TeenBoy();}
        if (TeenBoy.MAX_AGE < age) {human = new Man();}

        return human;
    }
}
