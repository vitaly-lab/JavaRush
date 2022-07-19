package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
   private View view;
   private   HTMLDocument document;
   private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

   public void init(){createNewDocument();};
   public void exit(){
        System.exit(0);    }

    public HTMLDocument getDocument() {
        return document;
    }

   public void resetDocument() {
       UndoListener listener = view.getUndoListener();

       if (document != null) {
           document.removeUndoableEditListener(listener);
       }

       document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
       document.addUndoableEditListener(listener);
       view.update();
   }
   public void setPlainText(String text) {
       resetDocument();
       StringReader stringReader = new StringReader(text);

      try {
         new HTMLEditorKit().read(stringReader,  document,  0);
       } catch (IOException | BadLocationException e) {
          ExceptionHandler.log(e);
      }
   }
   public String getPlainText() {
       StringWriter stringWriter = new StringWriter();
       try {
           if (document != null)
               new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
            } catch (Exception e) {
           ExceptionHandler.log(e);
       }
          return stringWriter.toString();
   }
   ////----------------------------------------
    public static void main(String[] args) {

        View view = new View();
        view.getController();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
    ///----------------------------------------------
    public void createNewDocument(){
       view.selectHtmlTab();
       resetDocument();
       view.setTitle("HTML редактор");
       currentFile = null;
       init();
    }
    public void openDocument(){
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(htmlFileFilter);
        int i = jFileChooser.showOpenDialog(view);

        if(i == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            FileReader fileReader = null;

            try {
                fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, i);
                view.resetUndo();
                fileReader.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }
    }

    public void saveDocument() {
        view.selectHtmlTab();

        if (currentFile != null) {
            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
                fileWriter.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
        else {saveDocumentAs();}
    }
    public void saveDocumentAs(){
       view.selectHtmlTab();
       JFileChooser jFileChooser = new JFileChooser();
       HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
       jFileChooser.setFileFilter(htmlFileFilter);
       int i = jFileChooser.showSaveDialog(view);

        if(i == JFileChooser.APPROVE_OPTION){
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(currentFile);
            new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            fileWriter.close();
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }}

    }

}
