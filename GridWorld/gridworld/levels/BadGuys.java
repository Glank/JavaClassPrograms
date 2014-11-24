package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.objects.Killer;
import gridworld.objects.ai.MoveLoopAI;
import gridworld.objects.GridButton;
import gridworld.objects.Gate;
import gridworld.updates.ReachedGoalUpdate;
import gridworld.updates.PlayerKilled;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BadGuys extends Level{
    public static final int WHITE_ARGB = 0xFFFFFFFF;
    public static final int BLACK_ARGB = 0xFF000000;
    public static final int BLUE_ARGB = 0xFF0000FF;
    public static final int YELLOW_ARGB = 0xFFFFFF00;
    public static final int GREEN_ARGB = 0xFF00FF00;
    public static final int RED_ARGB = 0xFFFF0000;

    public BadGuys(GameConsole console){
        super("BadGuys", console);
    }

    public void setup(){
        GameConsole console = getConsole();
        GridWorld world = getWorld();
        //reset the world
        world.clearActions();
        world.clearUpdates();
        //create the initial grid state
        Grid grid = new Grid();
        //add static data
        GoalSquare goal = null;
        try{
            BufferedImage data = ImageIO.read(
                BadGuys.class.getResourceAsStream("/gridworld/levels/data/badguys")
            );
            int argb;
            for(int x = 0; x < data.getWidth(); x++){
                for(int y = 0; y < data.getHeight(); y++){
                    argb = data.getRGB(x,y);
                    if(argb==BLACK_ARGB)
                        grid.addObject(new Wall(x,y));
                    else if(argb==BLUE_ARGB)
                        grid.addObject(new StartSquare(x,y));
                    else if(argb==GREEN_ARGB)
                        grid.addObject(goal=new GoalSquare(x,y));
                    else if(argb==RED_ARGB)
                        grid.addObject(new Killer(x,y));
                }
            }
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        //load dynamic data
        Killer killer;
        int[][] killer_moves;
        //cycle killer
        killer = new Killer(11,4);
        killer_moves = new int[][]{
            {-1,0},{-1,0},{-1,0},{0,1},{0,1},{0,1},
            {1,0},{1,0},{1,0},{0,-1},{0,-1},{0,-1}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        //left-right killers
        killer = new Killer(14,6);
        killer_moves = new int[][]{
            {1,0},{1,0},{1,0},{1,0},{-1,0},{-1,0},{-1,0},{-1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        killer = new Killer(16,9);
        killer_moves = new int[][]{
            {1,0},{1,0},{-1,0},{-1,0},{-1,0},{-1,0},{1,0},{1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        killer = new Killer(18,12);
        killer_moves = new int[][]{
            {-1,0},{-1,0},{-1,0},{-1,0},{1,0},{1,0},{1,0},{1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        //add a grid button and gate
        GridButton button = new GridButton(9,11);
        Gate gate = new Gate(21,5,false,false);
        gate.bindTo(button);
        grid.addObject(button);
        grid.addObject(gate);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
        world.addUpdate(new PlayerKilled(console));
    }
}
