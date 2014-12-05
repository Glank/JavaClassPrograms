import gridworld.*;
import gridworld.gui.*;
import gridworld.com.*;
import gridworld.actions.*;
import gridworld.levels.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.util.Random;

public class Test{
    static SimpleController ctl;

    public static void main(String[] args) throws Throwable{
        GameConsole console = new GameConsole();
        console.setVisible(true);

        ctl = new SimpleController();
        ctl.setLevel("methods2");
        ctl.waitForPlayer();
        
        //go to the first button
        for(int i = 0; i < 5; i++)
            ctl.moveUp();
        for(int i = 0; i < 11; i++)
            ctl.moveLeft();
        ctl.moveDown();
        ctl.moveDown();

        touchButton();

        //goto the second button
        ctl.moveUp();
        ctl.moveUp();
        for(int i = 0; i < 16; i++)
            ctl.moveRight();

        touchButton();

        //goto the thrid button
        for(int i = 0; i < 9; i++){
            ctl.moveDown();
            ctl.moveLeft();
        }
        for(int i = 0; i < 5; i++)
            ctl.moveLeft();
        ctl.moveDown();
        ctl.moveDown();

        touchButton();

        //goto the exit
        ctl.moveUp();
        ctl.moveUp();
        for(int i = 0; i < 12; i++)
            ctl.moveRight();
        ctl.moveDown();
        
        touchButton();
    }

    public static void touchButton(){
        for(int i = 0; i < 5; i++)
            ctl.moveRight();
        ctl.moveDown();
        ctl.moveDown();
        ctl.moveDown();
        ctl.moveLeft();
        ctl.moveLeft();
        ctl.moveUp();
        ctl.moveLeft();
        ctl.moveRight();
        ctl.moveDown();
        ctl.moveRight();
        ctl.moveRight();
        ctl.moveUp();
        ctl.moveUp();
        ctl.moveUp();
        for(int i = 0; i < 5; i++)
            ctl.moveLeft();
    }
}
