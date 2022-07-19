package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//  вспомогательный класс, для чтения или записи в консоль.
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws IOException {
           try {
                 return reader.readLine();
               } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз." );
                return readString();
            }
        }
    public static int readInt() throws IOException {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
           return readInt();
        }
            }

    public static void writeMessage(String message) {
        System.out.println(message); }


}
