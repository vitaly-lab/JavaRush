package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client{

    protected Connection connection;
    //В дальнейшем оно будет устанавливаться в true, если клиент подсоединен к серверу или в false в противном случае.
    private volatile boolean clientConnected = false;
    // private volatile boolean clientConnected;
    //должен запросить ввод адреса сервера у пользователя и вернуть введенное значение.
    protected String getServerAddress() throws IOException, ClassNotFoundException {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        String adress = ConsoleHelper.readString();
        return adress;
    }
    //должен запрашивать ввод порта сервера и возвращать его.
    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int adress = ConsoleHelper.readInt();
        return adress;
    }
    //должен запрашивать и возвращать имя пользователя.
    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String name = ConsoleHelper.readString();
        return name;
    }
    //в данной реализации клиента всегда должен возвращать true (мы всегда отправляем текст введенный в консоль).
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    //должен создавать и возвращать новый объект класса SocketThread.

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    //создает новое текстовое сообщение, используя переданный текст и отправляет его серверу через соединение connection.
    protected void sendTextMessage(String text)  {
        try {
            connection.send(new Message(MessageType.TEXT, text));
          //   } catch (IOException | NullPointerException e) {
        } catch (IOException e) {
            clientConnected = false;
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
        synchronized (this){
                this.wait(); }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Программа прерванна"); return;
            }

        // if (clientConnected = true) {ConsoleHelper.writeMessage("Соединение установлено.\n" +
        if (clientConnected) {ConsoleHelper.writeMessage("Соединение установлено.\n" +
                "Для выхода наберите команду 'exit'.");}
        else {ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");}

        while (clientConnected){
            String line = null;
            try {
                line = ConsoleHelper.readString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line.equals("exit")) {
               // break;
              try {
                    connection.close();
                  } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (shouldSendTextFromConsole()) { sendTextMessage(line); }
        }
    }

    //Это класс отвечаут за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);  }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединится к чату"); }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + "покинул чат"); }

        // Этот метод будет представлять клиента серверу.
        protected void clientHandshake() throws IOException, ClassNotFoundException{

            while (true){
                Message mss = connection.receive();

                if (mss.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName())); }

                else if (mss.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return; }

                else throw  new IOException("Unexpected MessageType 1");
            }
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();}
        }

        //Этот метод будет реализовывать главный цикл обработки сообщений сервера
        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while (true) {
                Message mss = connection.receive();

                if (mss.getType() == MessageType.TEXT) {
                    processIncomingMessage(mss.getData());
                }

                else if (mss.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(mss.getData());
                }

                else if (mss.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(mss.getData());
                }
                else { throw  new IOException("Unexpected MessageType"); }
            }
        }
        @Override
        public void run() {
            Socket socket = null;
            try {
                socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection (socket);
                clientHandshake();
                clientMainLoop();
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }


    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}
