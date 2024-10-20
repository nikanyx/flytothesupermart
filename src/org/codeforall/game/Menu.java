package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {


    private Picture menu;
    private Rectangle blackBG;
    private Picture youLost;


    public Menu() {
        blackBG = new Rectangle(0,0, Game.MAXX *2 + 10, Game.MAXY * 2 + 10);
        menu = new Picture(250, 30, Game.IMGPREFIX + "Menu-Image.png");
        youLost = new Picture(250, 30, Game.IMGPREFIX + "Lost.png");
    }

    public void showMenu(){
        blackBG.draw();
        blackBG.fill();
        menu.draw();
    }


    public void hide() {
        menu.delete();
        blackBG.delete();
    }

    public void showLose(){
        youLost.draw();
    }

    public void hideLose(){
        youLost.delete();
    }

}






