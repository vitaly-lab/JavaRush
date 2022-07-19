package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) return false;
        int tel = telNumber.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]")) {return false;}

        if (tel == 12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        else if (tel == 10) {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }


          return false;
    }




    public static void main(String[] args) {

        String  telNumber = "";
        System.out.println(checkTelNumber(telNumber));
    }
}
