package com.javarush.task.task15.task1502;

/* 
ООП - Наследование животных
*/
public class Solution {

    static class Goose extends SmallAnimal {

        SmallAnimal smallAnimal = new SmallAnimal();
       public String getSize() {
            return  "Гусь маленький, " + smallAnimal.getSize();
        } }

    static class Dragon extends BigAnimal{

        BigAnimal bigAnimal = new BigAnimal();
        public String getSize() {
            return "Дракон большой, " + bigAnimal.getSize();
        }}

    public static void main(String[] args) {

    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }
}
