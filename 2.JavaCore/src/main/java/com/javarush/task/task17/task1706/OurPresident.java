package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;

    private OurPresident() {
    }

    static {
        try {


            synchronized(OurPresident.class){

                president = new OurPresident();
            }

        } catch (Exception e) {
        }

    }


    public static OurPresident getOurPresident() {

        return president;
    }


}
