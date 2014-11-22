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
import gridworld.updates.ReachedGoalUpdate;
import gridworld.updates.PlayerKilled;

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
        Killer killer = new Killer(14,9);
        int[][] killer_moves = new int[][]{
            {-1,0},{-1,0},{-1,0},{-1,0},{1,0},{1,0},{1,0},{1,0}
        };
        killer.setAI(new MoveLoopAI(killer_moves));
        grid.addObject(killer);
        GoalSquare goal = new GoalSquare(12,12);
        grid.addObject(goal);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
        world.addUpdate(new PlayerKilled(console));
    }
}
