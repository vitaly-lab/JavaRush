package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;

public class ClientGuiController extends Client{

  private ClientGuiModel model = new ClientGuiModel();
  private ClientGuiView view = new ClientGuiView(this );

     protected SocketThread getSocketThread(){return new GuiSocketThread();}


     public void run() {
        getSocketThread().run();
    }

 public String getServerAddress() throws IOException, ClassNotFoundException {
     return view.getServerAddress(); }

     public int getServerPort() throws IOException {
        return view.getServerPort();
     }
     public String getUserName() throws IOException {
        return view.getUserName();
         }

    public ClientGuiModel getModel(){return model; }


//---------------- internal class
    public class GuiSocketThread extends SocketThread {


       public void processIncomingMessage(String message) {
           model.setNewMessage(message);
           view.refreshMessages();
           ConsoleHelper.writeMessage(message);}

        public void informAboutAddingNewUser(String userName) {
           model.addUser(userName);
           view.refreshUsers();
           ConsoleHelper.writeMessage(userName + " присоединится к чату");}

       public void informAboutDeletingNewUser(String userName) {
           model.deleteUser(userName);
           view.refreshUsers();
           ConsoleHelper.writeMessage(userName + "покинул чат");}

         public void notifyConnectionStatusChanged(boolean clientConnected) {
             super.notifyConnectionStatusChanged(clientConnected);
       view.notifyConnectionStatusChanged(clientConnected);}

    }

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

}

