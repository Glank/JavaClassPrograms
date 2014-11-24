package gridworld.gui;
import gridworld.GridWorld;
import gridworld.Grid;
import gridworld.levels.LevelRegistry;
import gridworld.com.ControllerServer;
import gridworld.com.MoveRequestHandler;
import gridworld.com.LevelChangeRequestHandler;
import gridworld.com.SpawnRequestHandler;
import gridworld.com.WaitRequestHandler;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameConsole extends JFrame{
    private GridWorld world;
    private GridWorldDisplay display;
    private LevelRegistry levels;
    private ControllerServer server;
    public GameConsole(){
        super("Grid World");
        world = new GridWorld();
        display = new GridWorldDisplay(world);
        levels = new LevelRegistry(this);
        server = new ControllerServer(this);
        server.addHandler(new MoveRequestHandler());
        server.addHandler(new LevelChangeRequestHandler());
        server.addHandler(new SpawnRequestHandler());
        server.addHandler(new WaitRequestHandler());
        server.start();
        add(display);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener( new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                server.close();
            }
        });
    }
    public void alert(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    public GridWorld getWorld(){
        return world;
    }
    public LevelRegistry getLevelRegistry(){
        return levels;
    }
    public void forceUpdate(){
        display.render();
        display.repaint();
    }
}
