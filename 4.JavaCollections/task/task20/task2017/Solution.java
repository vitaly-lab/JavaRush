package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution {

    public A getOriginalObject (ObjectInputStream objectStream) {

       A aaa = new A();
       try {

            aaa = (A) objectStream.readObject();

        } catch (Exception e) {
            System.out.println("Серилизация не прошла");
            aaa = null;
        }

      //  catch (ClassNotFoundException e) {
       //    System.out.println("Серилизация не прошла");
       //    aaa = null;
     //  }
     //  catch (ClassCastException e) {
      //     System.out.println("Серилизация не прошла");
      //     aaa = null;
     //  }

        return aaa;
    }

    public class A implements Serializable {

       private static final long serialVersionUID = 1L;
    //   public A(){}

    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
