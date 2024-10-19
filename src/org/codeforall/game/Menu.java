package org.codeforall.game;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {


    private Picture menu;
    private Player player;
    private Rectangle blackBG;
    private Picture youLost;


    public Menu(Player player) {
        this.player=player;

        blackBG = new Rectangle(0,0, Game.MAXX + 10, Game.MAXY + 10);
        menu = new Picture(270, 150, "resources/Menu-Image.png");
        youLost = new Picture(270, 150, "resources/You died Loser! Try again.png");



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
        SoundHandler.playBackgroundMusic("babylost.wav");
        youLost.draw();


        }






}






