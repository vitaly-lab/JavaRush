package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
   private Controller controller;
   private JTabbedPane tabbedPane = new JTabbedPane();
   private JTextPane htmlTextPane = new JTextPane();
   private JEditorPane plainTextPane = new JEditorPane();

   public boolean canUndo(){return undoManager.canUndo();}
   public boolean canRedo(){return undoManager.canRedo();}

   private UndoManager undoManager = new UndoManager();
   private UndoListener undoListener = new UndoListener(undoManager);
   public void undo(){
       try {
           undoManager.undo();
       } catch (Exception e) {
           ExceptionHandler.log(e);
       }
          }
    public void redo(){
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
   public void resetUndo() {
    undoManager.discardAllEdits();
   }
    public View ()  {
       try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
    public UndoListener getUndoListener() {
        return undoListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        switch (actionEvent.getActionCommand()) {
            case "Новый": controller.createNewDocument();
            case "Открыть": controller.openDocument();
            case "Сохранить": controller.saveDocument();
            case "Сохранить как...": controller.saveDocumentAs();
            case "Выход": controller.exit();
            case "О программе": showAbout();
        }
    }
    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init(){
        initGui();
        FrameListener frameListener = new FrameListener( View.this);
        addWindowListener( frameListener);
         setVisible(true);
    };
    public void exit(){ controller.exit(); }
    public void initMenuBar(){

        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper menuHelper = new MenuHelper();
        menuHelper.initFileMenu(this, jMenuBar);
        menuHelper.initEditMenu(this, jMenuBar);
        menuHelper.initStyleMenu(this, jMenuBar);
        menuHelper.initAlignMenu(this, jMenuBar);
        menuHelper.initColorMenu(this, jMenuBar);
        menuHelper.initFontMenu(this, jMenuBar);
        menuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }
    public void initEditor() {

        htmlTextPane.setContentType( "text/html" );
        JScrollPane scrollableTextArea = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollableTextArea);
        JScrollPane jScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", jScrollPane);
        tabbedPane.setPreferredSize(jScrollPane.getSize());
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(View.this));
        getContentPane().add(tabbedPane,  BorderLayout.CENTER);
    }
    public void initGui(){
        initMenuBar();
        initEditor();
        pack(); // метод устанавливает такой минимальный размер контейнера, который достаточен для отображения всех компонентов.
    }
    public void selectedTabChanged(){
        if (tabbedPane.getSelectedIndex() == 0) {controller.setPlainText(plainTextPane.getText());}

        else if (tabbedPane.getSelectedIndex() == 1) plainTextPane.setText(controller.getPlainText());

        resetUndo();
    }
   public boolean isHtmlTabSelected() {
      if (tabbedPane.getSelectedIndex() == 0){return true;}
         else return false;
    }
    public void selectHtmlTab(){
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }
    public void update() {
          htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout() {
      //  JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, "Message", "Title", JOptionPane.INFORMATION_MESSAGE);
    }
}
