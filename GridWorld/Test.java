import gridworld.*;
import gridworld.gui.*;
import gridworld.com.*;
import gridworld.actions.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;
import java.util.Random;

public class Test{
    public static void main(String[] args) throws Throwable{
        GameConsole console = new GameConsole();
        Grid grid = console.getWorld().getGrid();
        grid.addObject(new Wall(1,0));
        grid.addObject(new Wall(1,1));
        grid.addObject(new Wall(1,2));
        grid.addObject(new StartSquare(2,2));
        grid.addObject(new GoalSquare(12,12));
        console.setVisible(true);
        console.forceUpdate();

        ControllerServer server = new ControllerServer(console);
        server.addHandler(new MoveRequestHandler());
        server.start();
        
        ControllerClient client = new ControllerClient();
        Thread.sleep(1033);
        for(int i = 0; i < 10; i++){
            client.sendRequest(new ControllerRequest("move",1,1));
        }
    }
}
