package com.javarush.task.task30.task3008.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGuiView {
    private final ClientGuiController controller;

    private JFrame frame = new JFrame("Чат"); //создания оконного интерфейса JFrame.
    private JTextField textField = new JTextField(50); // JTextField поле является однострочным и служит для ввода текста.
    private JTextArea messages = new JTextArea(10, 50); //Многострочное текстовое поле JTextArea
    private JTextArea users = new JTextArea(10, 10); // предназначено для ввода простого неразмеченного различными атрибутами текста.

    public ClientGuiView (ClientGuiController controller) {
        this.controller = controller;
        initView();
    }

    private void initView() {
        textField.setEditable(false); // setEditable Включение или выключение возможности редактирования текста
        messages.setEditable(false);
        users.setEditable(false);

        frame.getContentPane().add(textField, BorderLayout.NORTH); //Метод getContentPane() извлекает слой панели содержимого,
        // чтобы вы могли добавить к нему объект. Область содержимого - это объект, созданный средой времени выполнения Java.
        frame.getContentPane().add(new JScrollPane(messages), BorderLayout.WEST);
        frame.getContentPane().add(new JScrollPane(users), BorderLayout.EAST);
        frame.pack(); // метод pack() устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // метод setDefaultCloseOperation для задания действий по умолчанию , когда пользователь нажмет на кнопку закрытия.
        frame.setVisible(true); // Отображение окна на экране. После вызова этого метода компоненты переходят в «видимое» состояние и начинают обслуживаться очередью событий.

        // Передаваемый источником блоку прослушивания объект-событие является аргументом обработчика события.
        // Объект класса – блока прослушивания события необходимо зарегистрировать в источнике методом
        //источник.addСобытиеListener(объект_прослушиватель);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // ИнтерфейсActionListener содержит единственный метод actionPerformed(),
                // который нужно реализовать в блоке обработки в соответствии с поставленной задачей
                controller.sendTextMessage(textField.getText());  // sendTextMessage отправляет сообщения
                textField.setText("");
            }
        });
    }
//JOptionPane, работа с которым связана с вызовом одного из многочисленных статических методов,
// создающих и выводящих на экран модальное диалоговое окно стандартного вида.
    //showInputDialog Диалоговое окно с выбором
    public String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите адрес сервера:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE); // QUESTION_MESSAGE - стандартное диалоговое окно для вывода информации. Как правило, не используется для информационных сообщений;
    }

    public int getServerPort() {
        while (true) {
            String port = JOptionPane.showInputDialog(
                    frame,
                    "Введите порт сервера:",
                    "Конфигурация клиента",
                    JOptionPane.QUESTION_MESSAGE);
            try {
                return Integer.parseInt(port.trim());
            } catch (Exception e) {
                JOptionPane.showMessageDialog( //showMessageDialog Диалоговое окно вывода сообщения
                        frame,
                        "Был введен некорректный порт сервера. Попробуйте еще раз.",
                        "Конфигурация клиента",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public String getUserName() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите ваше имя:",
                "Конфигурация клиента",
                JOptionPane.QUESTION_MESSAGE);
    }

    public void notifyConnectionStatusChanged(boolean clientConnected) {
        textField.setEditable(clientConnected); // setEditable Включение или выключение возможности редактирования текста
        if (clientConnected) {
            JOptionPane.showMessageDialog(
                    frame,
                    "Соединение с сервером установлено",
                    "Чат",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    frame,
                    "Клиент не подключен к серверу",
                    "Чат",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void refreshMessages() {
        messages.append(controller.getModel().getNewMessage() + "\n");
    }

    public void refreshUsers() {
        ClientGuiModel model = controller.getModel();
        StringBuilder sb = new StringBuilder();
        for (String userName : model.getAllUserNames()) {
            sb.append(userName).append("\n");
        }
        users.setText(sb.toString());
    }
}
