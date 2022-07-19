package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    //где ключом будет имя клиента,
    // а значением - соединение с ним.
    // должен отправлять сообщение message всем соединениям из connectionMap.
    static private Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
        // Внутрений класс
    private static class Handler extends Thread {
        Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;  }

            //знакомства сервера с клиентом, первый этап
            private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
                Message answer;
                do {
                    connection.send(new Message(MessageType.NAME_REQUEST));
                    answer = connection.receive();
                    if (answer.getType() == MessageType.USER_NAME) {
                        if (answer.getData().trim().length() != 0) {
                            if (!connectionMap.containsKey(answer.getData())) {
                                connectionMap.put(answer.getData(), connection);
                                connection.send(new Message(MessageType.NAME_ACCEPTED));
                                return answer.getData();
                            }
                        }
                    }
                }
                while (true);
            }


            //Этап второй метод, но не менее важный - отправка клиенту (новому участнику)
// информации об остальных клиентах (участниках) чата.
            private void notifyUsers(Connection connection, String userName) throws IOException {
                for (String key : connectionMap.keySet()) {
                    try {
                        if (!key.equals(userName)) {
                            connection.send(new Message(MessageType.USER_ADDED, key));   }
                    } catch (Exception e) {
                    }
                }
            }

        //Этап третий метод - главный цикл обработки сообщений сервером.
        //Метод serverMainLoop() должен в бесконечном цикле получать сообщения от клиента
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message mem = connection.receive();
                if (mem != null && mem.getType() == MessageType.TEXT) {
                    String text = userName + ": " + mem.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("Error!");
                }
            }
        }

               // Главный метод класса Handler
        public void run () {
            socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress().toString());

            try {
                Connection  connectionNew = new Connection(socket);
                String userName = serverHandshake(connectionNew);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connectionNew, userName);
                serverMainLoop(connectionNew, userName);

                if (userName != null) {connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));}

                connectionNew.close();

            } catch (IOException | ClassNotFoundException e) { e.printStackTrace();  }
        }
    }
//Метод который должен отправлять сообщение message всем соединениям из connectionMap.
//Если при отправке сообщение произойдет исключение IOException, нужно отловить его и сообщить пользователю, что не смогли отправить сообщение.
    public static void sendBroadcastMessage(Message message) {
        for (Connection conClient : connectionMap.values()) {
            try {
                conClient.send(message);
            } catch (IOException e) {
                e.printStackTrace();
                ConsoleHelper.writeMessage("сообщение не было отправленно");
            }
        }
    }


    // -----------------------
    public static void main(String[] args) throws IOException {
        ConsoleHelper consoleHelper = new ConsoleHelper(); //создаём объект для чтения с консоли
        System.out.println("Введите номер порта");
        int p = consoleHelper.readInt(); // читаем с консоли

        Socket client = null; //класс реализует клиентский сокет.

        try (ServerSocket serverSocket = new ServerSocket(p)) { //класс реализует серверный сокет,
            // который ожидает запросы, приходящие от клиентов по сети, и может отправлять ответ.
            //  System.out.print("Connection accepted.");
            ConsoleHelper.writeMessage("Connection accepted.");

            while (true) {

                client = serverSocket.accept(); //Ожидание подключения клиента
                Handler handler = new Handler(client); //Handler может использоваться для планирования выполнения
                // кода в некоторый момент в будущем. Также класс может использоваться для передачи кода,
                // который должен выполняться в другом программном потоке.
                handler.start();

            }
        } catch (Exception e) {
            // System.out.println(e.getMessage());
            ConsoleHelper.writeMessage(e.getMessage());
            client.close();
        }
    }
}


