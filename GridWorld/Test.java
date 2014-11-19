import gridworld.*;
import gridworld.gui.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.*;

public class Test{
    public static void main(String[] args) throws Throwable{
        System.out.println(Configs.getKWConfig("controller_port"));
        Grid grid = new Grid(10,10);
        grid.addObject(new Wall(1,0));
        grid.addObject(new Wall(1,1));
        grid.addObject(new Wall(1,2));
        grid.addObject(new GoalSquare(8,8));
        Player player = new Player(0,0);
        grid.addObject(player);

        GridWorld world = new GridWorld(grid);

        JFrame frame = new JFrame();
        frame.add(new GridWorldDisplay(world));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        Thread.sleep(2000);
        System.out.println("Enqueing actions...");
        for(int i = 0; i < 5; i++){
            world.doAction(new TurnAction(player){
                public void performTurn(){
                    GridObject obj = getObject();
                    obj.moveTo(obj.getX(), obj.getY()+1);
                }
            });
        }
    }
}
