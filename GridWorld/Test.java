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
        SimpleController controller = new SimpleController();
        controller.setLevel("example level");
        controller.waitForPlayer();
        for(int i = 0; i < 10; i++)
            controller.moveRight();
        for(int i = 0; i < 10; i++)
            controller.moveDown();
    }
}
