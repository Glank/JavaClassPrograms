package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.updates.ReachedGoalUpdate;

public class ExampleLevel extends Level{
    public ExampleLevel(GameConsole console){
        super("Example Level", console);
    }

    public void setup(){
        GameConsole console = getConsole();
        GridWorld world = getWorld();
        //reset the world
        world.clearActions();
        world.clearUpdates();
        //create the initial grid state
        Grid grid = new Grid();
        grid.addObject(new Wall(1,2));
        grid.addObject(new Wall(2,1));
        for(int x = 2; x<12; x++)
            grid.addObject(new Wall(x,3));
        grid.addObject(new StartSquare(2,2));
        GoalSquare goal = new GoalSquare(12,12);
        grid.addObject(goal);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
    }
}
