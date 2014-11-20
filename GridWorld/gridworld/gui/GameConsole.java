package gridworld.gui;
import gridworld.GridWorld;
import gridworld.Grid;
import javax.swing.*;

public class GameConsole extends JFrame{
    private GridWorld world;
    private GridWorldDisplay display;
    public GameConsole(){
        super("Grid World");
        world = new GridWorld();
        display = new GridWorldDisplay(world);
        add(display);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public GridWorld getWorld(){
        return world;
    }
    public void forceUpdate(){
        display.render();
        display.repaint();
    }
}
