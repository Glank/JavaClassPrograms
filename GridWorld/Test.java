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

        SimpleController controller = new SimpleController();
        controller.setLevel("zigzag");
        controller.waitForPlayer();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 13; j++) controller.moveRight();
            for(int j = 0; j < 2; j++) controller.moveDown();
            for(int j = 0; j < 13; j++) controller.moveLeft();
            for(int j = 0; j < 2; j++) controller.moveDown();
        }
        System.out.println("Done.");
    }
}
