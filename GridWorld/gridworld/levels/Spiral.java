package gridworld.levels;
import gridworld.Level;
import gridworld.Grid;
import gridworld.GridWorld;
import gridworld.gui.GameConsole;
import gridworld.objects.Wall;
import gridworld.objects.StartSquare;
import gridworld.objects.GoalSquare;
import gridworld.updates.ReachedGoalUpdate;

public class Spiral extends Level{
    public Spiral(GameConsole console){
        super("Spiral", console);
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
        int[][] directions = new int[][]{
            new int[]{1,0},
            new int[]{0,-1},
            new int[]{-1,0},
            new int[]{0,1}
        };
        int x = 14, y = 10;
        int d = 0;
        for(int w = 0; w<11; w++){
            for(int i = 0; i < w+1; i++){
                grid.addObject(new Wall(x,y));
                x+=directions[d][0];
                y+=directions[d][1];
            }
            d = (d+1)%4;
        }
        //start and goal
        grid.addObject(new StartSquare(9,5));
        GoalSquare goal = new GoalSquare(14,9);
        grid.addObject(goal);
        //set the initial grid state
        world.setGrid(grid);
        //register gridwide updates
        world.addUpdate(new ReachedGoalUpdate(console, goal));
    }
}
