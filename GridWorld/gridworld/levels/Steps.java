package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.updates.ReachedGoalUpdate;

public class Steps extends Level{
    public Steps(GameConsole console){
        super("Steps", console);
    }

    public void setup(){
        GameConsole console = getConsole();
        GridWorld world = getWorld();
        //reset the world
        world.clearActions();
        world.clearUpdates();
        //create the initial grid state
        Grid grid = new Grid();
        //diagonal walls
        for(int i=0; i<10; i++){
            grid.addObject(new Wall(i+1,i));
            grid.addObject(new Wall(i,i+2));
        }
        //start and goal
        grid.addObject(new StartSquare(0,0));
        GoalSquare goal = new GoalSquare(10,11);
        grid.addObject(goal);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
    }
}
