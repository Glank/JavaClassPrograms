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
        ctl.setLevel("example level");
        ctl.waitForPlayer();
        ctl.moveDown();
        ctl.moveDown();
        for(int i = 0; i < 10; i++)
            ctl.moveRight();
        for(int i = 0; i < 10; i++)
            ctl.moveDown();
        
        System.out.println("Done.");
    }
}
