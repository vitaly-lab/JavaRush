package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();


    static {
                countries.put("UA", "Ukraine");
                countries.put("RU", "Russia");
                countries.put("CA", "Canada");
    }

    public static void main(String[] args) {  }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return countries.get(data.getCompany());
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {

            int phoneFmt = data.getPhoneNumber(); //For example: 501234567

            //10 цифр в строке, заполнение слева '0' (по префиксу)
            DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000000");
            String phoneRawString = phoneDecimalFmt.format(phoneFmt);

            //example (050)123-45-67
            MessageFormat phoneMsgFmt = new MessageFormat("({0}){1}-{2}-{3}");
            //С учетом группировки 3-3-2-2
            String[] phoneNumArr = {
                    phoneRawString.substring(0, 3),
                    phoneRawString.substring(3, 6),
                    phoneRawString.substring(6, 8),
                    phoneRawString.substring(8)
            };

            return String.format("+%d%s", data.getCountryPhoneCode(), phoneMsgFmt.format(phoneNumArr));
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}