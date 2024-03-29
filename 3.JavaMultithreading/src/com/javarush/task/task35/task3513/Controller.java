package com.javarush.task.task35.task3513;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {
private static final int WINNING_TILE = 2048;
    Model model;
  //  Controller controller = new Controller(model);
    View view;
    public Tile[][] getGameTiles() { return model.getGameTiles(); }

    public int getScore () { return model.score;}

    public Controller(Model model) {
        this.model = model;
        view = new View(this); }

    public void resetGame (){
        model.resetGameTiles();
        model.score = 0;
        view.isGameWon = false;
        view.isGameLost=false;}

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {resetGame();}
        if (!view.isGameLost && !view.isGameWon){
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {model.left();}
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {model.right();}
            if (e.getKeyCode() == KeyEvent.VK_UP) {model.up();}
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {model.down();}
        }

        if (model.maxTile == WINNING_TILE){view.isGameWon = true;}
        else view.isGameLost = true;
        view.repaint();
        if (e.getKeyCode() == KeyEvent.VK_Z) {model.rollback();}
        if (e.getKeyCode() == KeyEvent.VK_R) {model.randomMove();}
    }

    public View getView() {
        return view;
    }
}