import gridworld.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class Test{
    public static void main(String[] args) throws Throwable{
        Grid grid = new Grid(10,10);
        grid.addObject(new Wall(1,0));
        grid.addObject(new Wall(1,1));
        grid.addObject(new Wall(1,2));
        grid.addObject(new GoalSquare(8,8));
        grid.addObject(new Player(0,0));

        BufferedImage img = new BufferedImage(20*10,20*10,BufferedImage.TYPE_INT_RGB);
        grid.draw(img.getGraphics());
        ImageIO.write(img, "PNG", new File("test.png"));
    }
}
