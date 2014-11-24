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
    public static void main(String[] args) throws Throwable{
        GameConsole console = new GameConsole();
        console.setVisible(true);

        SimpleController ctl = new SimpleController();
        ctl.setLevel("badguys");
        ctl.waitForPlayer();
        ctl.waitTurns(3);
        for(int i = 0; i < 10; i++)
            ctl.moveRight();
        for(int i = 0; i < 4; i++)
            ctl.moveDown();
        ctl.waitTurns(2);
        for(int i = 0; i < 7; i++)
            ctl.moveDown();
        for(int i = 0; i < 10 ;i++)
            ctl.moveLeft();
        int d = 0;
        for(int dist = 6; dist>=1; dist--){
            for(int i = 0; i < dist; i++){
                if(d==0) ctl.moveUp();
                if(d==1) ctl.moveRight();
                if(d==2) ctl.moveDown();
                if(d==3) ctl.moveLeft();
            }
            d = (d+1)%4;
        }
        d = 0;
        for(int dist = 1; dist<=6; dist++){
            for(int i = 0; i < dist; i++){
                if(d==0) ctl.moveLeft();
                if(d==1) ctl.moveDown();
                if(d==2) ctl.moveRight();
                if(d==3) ctl.moveUp();
            }
            d = (d+1)%4;
        }
        for(int i = 0; i < 17; i++)
            ctl.moveRight();
        d = 0;
        for(int i = 0; i < 5; i++){
            ctl.moveUp();
            ctl.moveUp();
            for(int j = 0; j < 3; j++){
                if(d==0) ctl.moveLeft();
                if(d==1) ctl.moveRight();
            }
            d = (d+1)%2;
        }
    }
}
