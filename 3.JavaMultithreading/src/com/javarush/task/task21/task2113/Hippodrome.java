package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private static List<Horse> horses = new ArrayList<>();

   public Hippodrome (List<Horse> horses){

       this.horses = horses;
   }

  static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    void run () throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);

        }
    }
    void move () {
        Horse horse = new Horse();
      for (int i = 0; i < horses.size(); i++){
           horses.get(i).move();
      }
    }
    void print () {
        Horse horse = new Horse();
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print(); }
        for (int i = 0; i < 10; i++) {

                System.out.println("");
        }
    }

    public Horse getWinner () {

   double max = 0;
   int i;
   int p = 0;

        for ( i = 0; i < horses.size(); i++){
              if (horses.get(i).distance > max){
               max = horses.get(i).distance;
               p = i;
           }
        }
        return horses.get(p);
    }

    public void printWinner () {

        System.out.print("Winner is " + getWinner().name + "!");
    }


    public static void main(String[] args) throws InterruptedException {

     horses.add(new Horse("Jeck", 3, 0));
     horses.add(new Horse("Jonh", 3, 0));
     horses.add(new Horse("Linda", 3, 0));

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();

    }
}
