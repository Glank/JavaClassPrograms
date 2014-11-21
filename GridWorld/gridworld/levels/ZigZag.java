package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.updates.ReachedGoalUpdate;

public class ZigZag extends Level{
    public ZigZag(GameConsole console){
        super("ZigZag", console);
    }

    public void setup(){
        GameConsole console = getConsole();
        GridWorld world = getWorld();
        //reset the world
        world.clearActions();
        world.clearUpdates();
        //create the initial grid state
        Grid grid = new Grid();
        //horrizontal walls
        for(int y = 4; y<15; y+=2){
            for(int x = 8+(y%4==0?1:0); x<21+(y%4==0?1:0); x++)
                grid.addObject(new Wall(x,y));
        }
        //vertical walls
        for(int y = 4; y<15; y++){
            grid.addObject(new Wall(7,y));
            grid.addObject(new Wall(22,y));
        }
        //caps
        grid.addObject(new Wall(8,4));
        grid.addObject(new Wall(21,14));
        //start and goal
        grid.addObject(new StartSquare(8,5));
        GoalSquare goal = new GoalSquare(21,13);
        grid.addObject(goal);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
    }
}
