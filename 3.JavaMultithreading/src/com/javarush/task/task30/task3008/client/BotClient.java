package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public String getUserName() {
        int a = 0;
        int b = 100;
        int x = a + (int) (Math.random() * b);

        String s = "date_bot_" + x;
        return s;
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

    /*    @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if ( message == null && !message.contains(":")) {return;}

            String[] words = message.split(":");
            if (words.length != 2) { return;}
            String n = words[0];
            String name = n.trim();
            String command = words[1];
            String date = command.trim();
            SimpleDateFormat formater = null;

            try {

                switch (date)  {

                    case "дата":
                        formater = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        formater = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        formater = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        formater = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        formater = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        formater = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        formater = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        formater = new SimpleDateFormat("s");
                        break;


// скобка SWITCH
                }

            } catch (Exception e) { sendTextMessage(message);}

            Date dat = new GregorianCalendar().getTime();
            sendTextMessage("Информация для " + name + ": " + formater.format(dat));
        }*/
    @Override
    protected void processIncomingMessage(String message){
        ConsoleHelper.writeMessage(message);
        if(message == null || !(message.contains(":"))) return;
        String[] builder = message.split(":");
        if (builder.length != 2){
            return;
        }
        String userName = builder[0];
        String text = builder[1].trim();
        SimpleDateFormat simpleDateFormat = null;
        if (text.equals("дата")){
            simpleDateFormat = new SimpleDateFormat( "d.MM.YYYY");
        }else if (text.equals("день")){
            simpleDateFormat = new SimpleDateFormat( "d");
        }else if (text.equals("месяц")){
            simpleDateFormat = new SimpleDateFormat( "MMMM");
        }else if (text.equals("год")){
            simpleDateFormat = new SimpleDateFormat( "YYYY");
        }else if (text.equals("время")){
            simpleDateFormat = new SimpleDateFormat( "H:mm:ss");
        }else if (text.equals("час" )){
            simpleDateFormat = new SimpleDateFormat( "H");
        }else if (text.equals("минуты")){
            simpleDateFormat = new SimpleDateFormat( "m");
        }else if (text.equals("секунды")){
            simpleDateFormat = new SimpleDateFormat( "s");
        } else {
            return;
        }
        sendTextMessage(String.format("Информация для %s: %s", userName, simpleDateFormat.format(Calendar.getInstance().getTime())));
    }
    }




    public static void main(String[] args) {
      BotClient botClient = new BotClient();
      botClient.run();

    }
        }

